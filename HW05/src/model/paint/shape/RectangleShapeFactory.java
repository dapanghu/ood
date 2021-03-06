package model.paint.shape;

import java.awt.Shape;
import java.awt.geom.Rectangle2D;

/**
 * Concrete IShapeFactory that instantiates Rectangle2d.Double shapes.
 * @author caojian
 *
 */
public class RectangleShapeFactory implements IShapeFactory{

	public static final RectangleShapeFactory Singleton = new RectangleShapeFactory();

	@Override
	/**Instantiates a Rectangle2D.Double object at the specified orign and size.*/
	public Shape makeShape(double x, double y, double xScale, double yScale) {
		return new Rectangle2D.Double(x, y, xScale, yScale);
	}
}
