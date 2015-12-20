package model.strategy;

import java.awt.Point;

import model.Ball;
import util.IDispatcher;

/**
 * this strategy changes the diameter of a ball
 * @author ls53@rice.edu
 *
 * @param <TDispMsg> The generic message type
 */
public class BreathingStrategy<TDispMsg> extends AUpdateStrategy<TDispMsg>{

	/** change in ball diameter*/
	private int incrementD = 1;
		
	@Override
	/**
	 * Initializes the strategy.   Should be called every time the Ball sets a new strategy.
	 * @param context  The ball using this strategy.
	 */
	public void init(Ball context){}
	
	
	@Override
	/**
	 * change the diameter of the ball by 1 each time
	 * if it reaches the threshold, reverse the change direction
	 * @param <IDispMsg>
	 */
	public void updateState(Ball context, IDispatcher<TDispMsg> dispatcher){
		
		Point size = context.getDimension();
		
		size.x += incrementD;
		size.y += incrementD;
		
		if (size.x > 25) {
			incrementD = -incrementD;
		} else if (size.x < 5) {
			incrementD = -incrementD;
		}
		
		/** set the ball diameter to new value */
		context.setDimension(size.x, size.y);
	}
		
}