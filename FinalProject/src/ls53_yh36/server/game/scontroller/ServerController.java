package ls53_yh36.server.game.scontroller;

import javax.swing.SwingUtilities;

import ls53_yh36.server.game.smodel.ServerModel;
import ls53_yh36.server.game.smodel.ServerModelAdpt;
import ls53_yh36.server.game.sview.ServerView;
import ls53_yh36.server.game.sview.ServerViewAdpt;

/**
 * The server controller
 * @author ls53@rice.edu
 */
public class ServerController {

	/**
	 * Game's view
	 */
	private ServerView<String> sView;
	
	/**
	 * Game's model
	 */
	private ServerModel sModel;
	
	/**
	 * Constructor
	 */
	public ServerController() {
		sView = new ServerView<String>(new ServerViewAdpt() {

			@Override
			public void shutDown() {
				sModel.close();
			}
			
		});
		
		
		sModel = new ServerModel(new ServerModelAdpt() {

			@Override
			public void updateScore(String sco) {
				sView.addEntry(sco);
			}
			
		});
	}
	
	/**
	 * The main method
	 * @param args Useless arguments
	 */
	public static void main(String[] args) {
		final ServerController[] c = new ServerController[1];
		
		
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				c[0] = new ServerController();
				c[0].start();
			}
			
		});
		
	}
	
	/**
	 * Start the server
	 */
	public void start() {
		sView.start();
		sModel.start();
	}
}
