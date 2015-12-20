package model.strategy;

import java.awt.Point;

import model.Ball;
import util.IDispatcher;
import util.Randomizer;

/** generate a ball moving at random velocity */ 
public class WanderingStrategy<TDispMsg> extends AUpdateStrategy<TDispMsg>{

	private Ball myball;

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
	public void updateState(Ball context, IDispatcher<TDispMsg> dispatcher) {
		
		myball = context;
		Randomizer rd = Randomizer.Singleton;
		Point location = myball.getLocation();
		Point velocity = myball.getVelocity();
		location.x += velocity.x * rd.randomInt(-3, 3);
		location.y += velocity.y * rd.randomInt(-3, 3);
		
		myball.setLocation(location.x, location.y);
	}
}
