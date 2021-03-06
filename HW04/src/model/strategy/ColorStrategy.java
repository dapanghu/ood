package model.strategy;

import java.awt.Color;

import model.Ball;
import util.Dispatcher;

/**
 * A IUpdateStrategy implementation that updates the color of a ball.
 *
 */
public class ColorStrategy implements IUpdateStrategy {

	@Override
	public void updateState(Ball context, Dispatcher dispatcher) {
		int b = (context.getColor().getBlue() + 5) % 256;
		int r = (context.getColor().getRed() + 5) % 256;
		int g = (context.getColor().getGreen() + 5) % 256;
		context.setColor(new Color(r, g, b));
	}

}
