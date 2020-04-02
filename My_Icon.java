import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author jrk based on cay horstmann
 * creates an icon of the painted objects
 *
 */

public class My_Icon implements Icon {
	/**
	 * @param obj
	 * @param w
	 * @param h
	 * 
	 * creates an icon using the Moving object interface
	 */
	public My_Icon(MovingObject obj, int w, int h) {
		this.obj = obj;
		this.w = w;
		this.h = h;
	}
	
	/**
	 * @param fly
	 * @param w
	 * @param h
	 * creates an object with the flying object interface
	 */
	public My_Icon(FlyingObject fly, int w, int h) {
		this.fly = fly;
		this.w = w;
		this.h = h;
	}


	/** 
	 * @see javax.swing.Icon#getIconWidth()
	 * required method for Icon interface
	 */
	public int getIconWidth() {
		return w;
	}

	/**
	 * @see javax.swing.Icon#getIconHeight()
	 * required method for Icon interface
	 */
	public int getIconHeight() {
		return h;
	}

	/**
	 * @see javax.swing.Icon#paintIcon(java.awt.Component, java.awt.Graphics, int, int)
	 * required method for Icon interface
	 * checks which constructor was used by seeing if null object in the Moving object parameter and then draws 
	 * according to which was created
	 */
	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2D = (Graphics2D) g;
		if (obj==null)
			fly.draw(g2D);
		else
			obj.draw(g2D);
	}

	private int w;
	private int h;
	private MovingObject obj;
	private FlyingObject fly;
}
