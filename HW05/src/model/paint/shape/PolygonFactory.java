package model.paint.shape;

import java.awt.Point;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
/**
 * Concrete IShapeFactory that provides the invariant behavior to instantiate a Shape that is a Polygon.
 * @author caojian
 *
 */
public class PolygonFactory implements IShapeFactory{

	/**The AffineTransform used for internal calculations*/
	private AffineTransform at;
	/**Scale factor that scales the integer Point-defined Polygon to a unit size, which requires doubles.*/
	private double scaleFactor;
	/**The Polygon shape to use as the prototype.*/
	private Polygon poly = new Polygon();
	/**coordinate of points in the polygon*/
	private Point[] pts;
	
	/**
	 * constructor
	 * @param at The affine transform
	 * @param scaleFactor The scale facto9r
	 * @param pts Variable Input Argument Lists
	 */
	public PolygonFactory(AffineTransform at, double scaleFactor,  Point... pts){
		this.at = at;
		this.scaleFactor = scaleFactor;
		this.pts = pts;
	}
	
	/**
	 * Instantiates a Shape object that is the prototype Polygon translated 
	 * by the given (x, y) point and scaled by given (xScale, yScale) factor 
	 * times the internal scaleFactor.
	 */
	@Override
	public Shape makeShape(double x, double y, double xScale, double yScale) {
		for (int i = 0; i<pts.length; i++){
			poly.addPoint(pts[i].x, pts[i].y);
		}
		at.setToTranslation(x, y);
		at.scale(xScale*scaleFactor, yScale*scaleFactor);  // optional rotation can be added as well
		return at.createTransformedShape(poly);
	}
}
