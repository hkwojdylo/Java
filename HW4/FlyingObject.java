import java.awt.Graphics2D;

/**
 * @author Helen
 * extra interface to control objects that approach the screen instead of translating up it
 * 		honestly very similar to moving object 
 */
public interface FlyingObject{
	
	void draw(Graphics2D g2d);
	void approach(int t);
}
