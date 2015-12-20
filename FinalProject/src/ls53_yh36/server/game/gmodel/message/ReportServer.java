package ls53_yh36.server.game.gmodel.message;

import java.util.UUID;

import common.IChatUser;
import common.message.IChatMessage;
import provided.datapacket.DataPacket;

/**
 * The report server
 * @author ls53@rice.edu
 */
public class ReportServer implements IChatMessage {

    /**
     * The generated serial version UID
     */
	private static final long serialVersionUID = 2334838917682443956L;

	/**
	 * Game, chatroom or team's UUID
	 */
	public UUID gameID;
	
	/**
	 * Time used by the player
	 */
	public long time;
	
	/**
	 * Player's IChatUser stub
	 */
	public IChatUser player;
	
	/**
	 * Constructor
	 * @param id UUID of the game
	 * @param t Time taken for the game
	 * @param pStub player's IChatUser stub
	 */
	public ReportServer(UUID id, long t, IChatUser pStub) {
		gameID = id;
		time = t;
		player = pStub;
	}
	
	/**
	 * Get id
	 * @return The id
	 */
	@Override
	public UUID getID() {
		return gameID;
	}
	
	/**
	 * Get data packet
	 * @return The data packet
	 */
	@Override
	public DataPacket<? extends IChatMessage> getDataPacket() {
		return new DataPacket<ReportServer>(ReportServer.class, this);
	}

}
