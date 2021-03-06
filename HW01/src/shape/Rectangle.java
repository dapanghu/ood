package shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * @author ls53@rice.edu
 * The concrete class rectangle that extends from AShape
 */
public class Rectangle extends AShape {

    /*
     * The width of a rectangle
     */
    private int width;

    /**
     * The height of a rectangle
     */
    private int height;

    /**
     * The constructor for a rectangle
     * @param location The upper left corner of a rectangle
     * @param color The color of a rectangle
     * @param width The width of a rectangle
     * @param height The height of a rectangle
     */
    public Rectangle(Point location, Color color, int width, int height) {
        this.location = location;
        this.color = color;
        this.width = width;
        this.height = height;
    }

    /**
     * The painting method for a rectangle
     * @param g The Graphics object to paint a rectangle
     */
    @Override
    public void paint(Graphics g) {
        g.setColor(color);
        g.fillRect(location.x, location.y, width, height);
    }
}
