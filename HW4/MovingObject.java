import java.awt.Graphics2D;

/**
 * 
 * @author jrk based on cay horstmann
 * 		parameters changed for translate from example because of unnecessary x change
 *
 */
public interface MovingObject{
	void draw(Graphics2D g2D);
	void translate(int yChange);
}
