package ls53_yh36.server.game.gview;

import java.io.Serializable;

/**
 * The run view adapter
 * @author ls53@rice.edu
 */
public interface RunViewAdpt extends Serializable {

	/**
	 * Move the specified position
	 * @param lat latitude value
	 * @param lng longitude value
	 * @return Status information
	 */
	public String goPlace(double lat, double lng);
	
	
	/**
	 * Enter into the game
	 */
	public void startGame();
	
	
	/**
	 * Run out of avaliable time
	 */
	public void runOutTime();
	
	
	/**
	 * Inform model to update
	 */
	public void update();
}
