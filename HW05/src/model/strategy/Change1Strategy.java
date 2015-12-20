package model.strategy;

import java.awt.Point;

import model.Ball;
import util.IDispatcher;
import util.Randomizer;

/** a ball that changes from colorStrategy to breathingStrategy after 4seconds*/
public class Change1Strategy<TDispMsg> extends AUpdateStrategy<TDispMsg> {

	private int i = 0;
	private int incrementD = 1;
	
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
		
		if(i <= 80){ 
			/** set color */
			context.setColor(rd.randomColor());
		}
		else{
			Point dimension = context.getDimension();
			
			dimension.x += incrementD;
			dimension.y += incrementD;
			
			if (dimension.x > 15) {
				incrementD = -incrementD;
			} else if (dimension.x < 5) {
				incrementD = -incrementD;
			}
			
			/** set the ball diameter to new value */
			context.setDimension(dimension.x,dimension.y);
		}
		
		i++;
	}
}