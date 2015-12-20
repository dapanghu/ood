package model.strategy;

import model.Ball;
import util.IDispatcher;
import util.Randomizer;

/**
 * this strategy changes the color of a ball
 */
public class ColorChangingStrategy<TDispMsg> extends AUpdateStrategy<TDispMsg>{

	@Override
	/**
	 * Initializes the strategy.   Should be called every time the Ball sets a new strategy.
	 * @param context  The ball using this strategy.
	 */
	public void init(Ball context){}
	
	@Override
	/**
	 * Update the state of the context Ball.
	 * @param context  The context (host) Ball whose state is to be updated
	 * @param dispatcher  The Dispatcher who sent the command that is calling through to here.
	 */
	public void updateState(Ball context, IDispatcher<TDispMsg> dispatcher){
		
		Randomizer rd = Randomizer.Singleton;
		
		/** set color */
		context.setColor(rd.randomColor());
	}
}