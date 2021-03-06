package controller;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JPanel;

import model.BallWorldModel;
import model.IBallCmd;
import model.IPaintStrategyFac;
import model.IUpdateStrategyFac;
import model.IViewCtrlAdapter;
import model.IViewUpdateAdapter;
import view.BallWorldGUI;
import view.IModelCtrlAdapter;
import view.IModelUpdateAdapter;
/**
 * The "Controller" in a Model-View-Controller architecture 
 * Sets up the appropriate wiring between the model and the view. 
 * Uses adapters to respond to user input and notifies the model and the view to update accordingly. 
 * @author caojian
 */
public class BallWorldController {

	/**
	 * The Ball World Model
	 */
	private BallWorldModel model;
	
	/**
	 * The GUI for ball world
	 */
	private BallWorldGUI<IUpdateStrategyFac<IBallCmd>, IPaintStrategyFac> view;

	/**
	 * constructor
	 * instantiate a model and a view
	 */
	public BallWorldController() {

		
		model = new BallWorldModel(new IViewCtrlAdapter(){
			
			@Override
			/** return the painting panel */ 
			public JPanel getPanel(){
				return view.getCenterPanel();
			}
		},
		    new IViewUpdateAdapter(){
				
				/** repaint the screen */
				public void updatePaint(){
					view.updatePaint();
				}
		    }
		);

			
		view = new BallWorldGUI<IUpdateStrategyFac<IBallCmd>, IPaintStrategyFac>(
		    new IModelCtrlAdapter<IUpdateStrategyFac<IBallCmd>, IPaintStrategyFac>(){
		
			@Override
				/**
			    * Returns an IStrategyFac that can instantiate the strategy specified
			    * by classname. Returns null if classname is null. The toString() of
			    * the returned factory is the classname.
			    * @param classname  Shortened name of desired strategy 
			    * @return A factory to make that strategy
			    */
			public IUpdateStrategyFac<IBallCmd> addUpdateStrategy(String classname) {
				return model.makeStrategyFac(classname);
			}
			
			@Override
		       /**
		        * Returns an IStrategyFac that can instantiate a MultiStrategy with the
		        * two strategies made by the two given IStrategyFac objects. Returns
		        * null if either supplied factory is null. The toString() of the
		        * returned factory is the toString()'s of the two given factories,
		        * concatenated with "-".             * 
		        * @param selectedItem1 An IStrategyFac for a strategy
		        * @param selectedItem2 An IStrategyFac for a strategy
		        * @return An IStrategyFac for the composition of the two strategies
		        */
			public IUpdateStrategyFac<IBallCmd>  combineUpdateStrategies(IUpdateStrategyFac<IBallCmd> stratFac1, IUpdateStrategyFac<IBallCmd> stratFac2) {
				return model.combineStrategyFacs(stratFac1, stratFac2);
			}
			
			/**
			 * switch the strategy of the switcher when clicking the button
			 * @param 
			 */
			@Override
			public void switchUpdateStrategy(IUpdateStrategyFac<IBallCmd> stratFac) {
				model.switchStrategy(stratFac.make());
			}

			@Override
			public IPaintStrategyFac addPaintStrategy(String classname) {
				return model.makePaintStrategyFac(classname);
			}
			
			@Override
				/**
			    * Add a ball to the system with a strategy as given by the given IStrategyFac
			    * @param tDropListItem The fully qualified name of the desired strategy.
			    */	    
			public void makeBall(IUpdateStrategyFac<IBallCmd> selectedItem1, IPaintStrategyFac selectedItem2) {
				model.makeSprite(selectedItem1.make(), selectedItem2.make());
			}		
			
			@Override
				/**
			    * Add a swicher ball to the system with a strategy as given by the given IStrategyFac
			    * @param selectedItem The fully qualified name of the desired strategy.
			    */
			public void makeSwitcher(IPaintStrategyFac selectedItem) {
				model.makeSwitcher(selectedItem.make());
			}
						
			@Override
			/** remove all balls from screen */
			public void clearAllBalls() {
				model.deleteSprites();
			}
		},
        new IModelUpdateAdapter(){

			/**
		     * Pass the update request to the model.
		     * @param g The Graphics object the balls use to draw themselves.
		     */
		    @Override
				public void updatePaint(Graphics g){
					model.updatePaint(g);
				}
		    }
		);
	}
	
	/**
	 * start the model and view instance
	 */
	public void start() {
		model.start();
		view.start();
	}
	
	/**
	 * The main function for ball world
	 * @param args useless arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BallWorldController controller = new BallWorldController();
					controller.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
