package controller;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;

import model.Ball;
import model.BallModel;
import model.strategy.IStrategyFac;
import view.IModelControlAdapter;
import view.IModelUpdateAdapter;
import view.View;

/**
 * MVC Controller for the system Instantiate the model and view, then start them
 * @author JacobChen, Li Shen
 * 
 */
public class Controller<TDropListItem> {

	/** Model object that contains all business logic for balls */
	private BallModel model;

	/** View object for ballWorld */
	@SuppressWarnings("rawtypes")
	private View view;

	/**
	 * Controller constructor builds the system
	 */
	public Controller() {

		/**
		 * Instantiate new models for balls
		 */
		model = new BallModel(new model.IViewControlAdapter() {
			/**
			 * gets the canvas of the view
			 * @return canvas of the view
			 */
			@Override
			public Component getCanvas() {
				return view.getCanvas();
			}
		}, new model.IViewUpdateAdapter() {
			/**
			 * Pass the update request to the view.
			 */
			@Override
			public void update() {
				view.update();
			}
		});

		/**
		 * Instantiate a new view for ballWorld
		 */
		view = new View<IStrategyFac>(new IModelControlAdapter<IStrategyFac>() {

			/* (non-Javadoc)
			 * @see view.IModelControlAdapter#addStrategy(java.lang.String)
			 * Returns an IStrategyFac that can instantiate the strategy
			 * specified by classname. Returns null if classname is null. The
			 * toString() of the returned factory is the classname.
			 * @param classname Shortened name of desired strategy
			 * @return A factory to make that strategy
			 */
			public IStrategyFac addStrategy(String classname) {
				return model.makeStrategyFac(classname);
			}

			/* (non-Javadoc)
			 * @see view.IModelControlAdapter#makeBall(java.lang.Object) Make a
			 * ball with the selected short strategy name
			 * @param selectedItem A shorten class name for the desired strategy
			 */
			public void makeBall(IStrategyFac selectedItem) {
				Ball _ball = model.loadBall(selectedItem.make());
				if (_ball != null) {
					model.addToDispatcher(_ball);
				}
			}

			/* (non-Javadoc)
			 * @see
			 * view.IModelControlAdapter#combineStrategies(java.lang.Object,
			 * java.lang.Object) Returns an IStrategyFac that can instantiate a
			 * MultiStrategy with the two strategies made by the two given
			 * IStrategyFac objects. Returns null if either supplied factory is
			 * null. The toString() of the returned factory is the toString()'s
			 * of the two given factories, concatenated with "-".
			 * @param selectedItem1 An IStrategyFac for a strategy
			 * @param selectedItem2 An IStrategyFac for a strategy
			 * @return An IStrategyFac for the composition of the two strategies
			 */
			public IStrategyFac combineStrategies(IStrategyFac selectedItem1, IStrategyFac selectedItem2) {
				return model.combineStrategyFacs(selectedItem1, selectedItem2);
			}

			/* (non-Javadoc)
			 * @see view.IModelControlAdapter#switchStrategy(java.lang.Object)
			 * @param selectedItem the new strategy the ball switches to.
			 * switch ball's strategy to the new one.
			 */
			@Override
			public void switchStrategy(IStrategyFac selectedItem) {
				model.switchSwitcherStrategy(selectedItem.make());
			}

			/* (non-Javadoc)
			 * @see view.IModelControlAdapter#makeSwitcherBall()
			 * Make a new ball whose strategy is initialized to straightStrategy
			 */
			@Override
			public void makeSwitcherBall() {
				Ball ball = model.loadBall(model.getSwitcherStrategy());
				model.addToDispatcher(ball);
			}

			/* (non-Javadoc)
			 * @see view.IModelControlAdapter#clearBalls()
			 * Clear all balls from the screen.
			 */
			@Override
			public void clearBalls() {
				model.clearBalls();
			}

		}, new IModelUpdateAdapter<TDropListItem>() {
			/**
			 * Pass the update request to the model.
			 * @param g The Graphics object the balls use to draw themselves.
			 */
			public void update(Graphics g) {
				model.update(g);
			}
		});

	}

	/**
	 * Start the system
	 */
	public void start() {
		model.start();
		view.start();
	}

	/**
	 * Launch the application.
	 * @param args Arguments given by the system or command line.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() { // Java specs say that the
												// system must be constructed on
												// the GUI event thread.
			public void run() {
				try {
					/** instantiate the system */
					@SuppressWarnings("rawtypes")
					Controller controller = new Controller();
					/** start the system */
					controller.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}