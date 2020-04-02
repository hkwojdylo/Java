import java.awt.*;
import java.awt.geom.*;

/**
 * @author Helen
 * creates, draws, and moves a flock of birds according to a change in an size
 *
 */
public class Birds implements FlyingObject{
	
	private int s = 100;
	private double x, y; 
	private double size;
	private final double WINGLENGTH = 2.0;
	private final double ANGLE = 0.4;
	
	/**
	 * @param size
	 * constructor that allows set of size of birds initially
	 * does not allow set in position or direction because user should not be allowed to 
	 */
	public Birds (double size)
	{
		this.size = size;
	}

	/**
	 * @see FlyingObject#draw(java.awt.Graphics2D)
	 * draws flock of 6 birds in fixed positions and all same size.
	 * 		6 seemed like a flock without it being unreasonably cluttered in the screen
	 */
	public void draw(Graphics2D g2d) {
		
		x = s;
		y = s;
		double center = x+size/2;
		double head = y+WINGLENGTH*size*Math.sin(ANGLE);
		Line2D.Double wingL1 = new Line2D.Double(center,head, x, y);
		Line2D.Double wingR1 = new Line2D.Double(center, head, x+size, y );
		
		x = 2*s;
		y = s;
		center = x+size/2;
		head = y+WINGLENGTH*size*Math.sin(ANGLE);
		Line2D.Double wingL2 = new Line2D.Double(center,head, x, y);
		Line2D.Double wingR2 = new Line2D.Double(center, head, x+size, y );
		
		x = 1.25*s;
		y = 1.5*s;
		center = x+size/2;
		head = y+WINGLENGTH*size*Math.sin(ANGLE);
		Line2D.Double wingL3 = new Line2D.Double(center,head, x, y);
		Line2D.Double wingR3 = new Line2D.Double(center, head, x+size, y );
		
		x = 2.5*s;
		y = 2*s;
		center = x+size/2;
		head = y+WINGLENGTH*size*Math.sin(ANGLE);
		Line2D.Double wingL4 = new Line2D.Double(center,head, x, y);
		Line2D.Double wingR4 = new Line2D.Double(center, head, x+size, y );
		
		x = 2.25*s;
		y = 1.5*s;
		center = x+size/2;
		head = y+WINGLENGTH*size*Math.sin(ANGLE);
		Line2D.Double wingL5 = new Line2D.Double(center,head, x, y);
		Line2D.Double wingR5 = new Line2D.Double(center, head, x+size, y );
		
		x = 2.75*s;
		y = 1.5*s;
		center = x+size/2;
		head = y+WINGLENGTH*size*Math.sin(ANGLE);
		Line2D.Double wingL6 = new Line2D.Double(center,head, x, y);
		Line2D.Double wingR6 = new Line2D.Double(center, head, x+size, y );
		
		GeneralPath flock = new GeneralPath();
		flock.append(wingL1, false);
		flock.append(wingR1, false);
		flock.append(wingL2, false);
		flock.append(wingR2, false);
		flock.append(wingL3, false);
		flock.append(wingR3, false);
		flock.append(wingL4, false);
		flock.append(wingR4, false);
		flock.append(wingL5, false);
		flock.append(wingR5, false);
		flock.append(wingL6, false);
		flock.append(wingR6, false);
		
		g2d.draw(flock);
	}

	/**
	 * @see FlyingObject#approach(int)
	 * changes size of birds and position s according to a formula based n=on one point perspective
	 */
	public void approach(int t) {
		double inflate = 1/(1-0.0001*t);
		size +=inflate;
		s += inflate;
	}

}
