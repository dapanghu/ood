package model;

import provided.abcParser.ABCParser;
import provided.music.IPhrase;
import provided.music.NESeqList;
import provided.player.ISequencePlayerStatus;
import provided.player.SequencePlayer2;
import provided.player.SequencePlayer2.IPlayable;
import provided.util.ABCInstrument;
import provided.util.ABCUtil;
import visitor.PlayMusicAlgo;
import visitor.ToStringAlgo;

/**
 * Construct a player model which contains business logic
 * 
 * @author Li Shen, Ning Zhu
 *
 */
public class PlayerModel {
	/**
	 * Adapter for controlling the view (print to the view)
	 */
    private IViewUpdateAdapter viewUpdateAdapter = IViewUpdateAdapter.NULL_OBJECT;

	/**
	 * Parser to parse the ABC file.
	 */
	private ABCParser parser;
	
	/**
	 * phrase to hold all information from parsed ABC file
	 */
	private IPhrase phrase;
	
	/**
	 * player that plays the music
	 */
	private SequencePlayer2 player;
	
	/**
	 * A interface to represent a playable piece of music 
	 */
	private IPlayable music;

	/**
	 * Construct a player model
	 * @param viewUpdateAdapter A model to view adapter to control the view from the model's perspective
	 */
	public PlayerModel(IViewUpdateAdapter viewUpdateAdapter) {
		this.viewUpdateAdapter = viewUpdateAdapter;
		NESeqList.setToStringAlgo(new ToStringAlgo());
	}
	
	/**
	 * Load a user-specified ABC file from package "songs".
	 * @param fileName A string of the name of an ABC file that a user wants to play.
	 * @return A string of the full content of an ABC file
	 */
	public String loadFile(String fileName) {
	    fileName = "/songs/" + fileName + ".abc";
	    parser = new ABCParser(fileName);
	    phrase = null;
	    return ABCUtil.Singleton.getFileContents(fileName);
	}
	
	/**
	 * @return A string of the parsed content of an ABC file
	 */
	public String parseFile() {
	    phrase = parser.parse();
	    return phrase.toString();
	}
	
	/**
	 * Play a chosen music with a chosen instrument
	 * @param instrument A type of instrument that is chosen by a user
	 */
	public void playMusic(ABCInstrument instrument) {
	    player = new SequencePlayer2(16, instrument.getValue());
	    if (phrase == null) {
	        phrase = parser.parse();
	    }
	    
        phrase.execute(new PlayMusicAlgo(), player, 0);
        music = player.makePlayable(ISequencePlayerStatus.NULL);
		music.start();
	}
	
	/**
	 * Stop a music that's being played.
	 */
	public void stopMusic() {
	    music.stop();
	}
	
	/**
	 * Get the view ready.
	 */
	public void start() {
	    ABCInstrument[] instruments = ABCUtil.Singleton.getInstruments();
	    for (ABCInstrument instrument : instruments) {
	        viewUpdateAdapter.addInstrument(instrument); //should be in controller?
	    }
	}
}
