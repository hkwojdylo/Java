import java.awt.*;
import java.awt.geom.*;

/**
 * @author Helen
 * draws the hot air balloons using 2d graphics, also moves them up the page by decreasing the y value of initial.
 *
 */
public class HotAirBalloon implements MovingObject{
	
	private int x, y;
	private double unit, angle;
	private final double DIAMETER = 4.0;
	private final double CABLELENGTH = 2.0;
	private final double BASKETWIDTH = 2.0;
	private final double BASKETHEIGTH = 1.0;
	
	/**
	 * @param x
	 * @param y
	 * @param unit
	 * @param angle
	 * basic constructor for first main balloon, necessary for part one of assignment when only creating one balloon
	 */
	public HotAirBalloon (int x, int y, double unit, double angle){
		this.x = x;
		this.y = y;
		this.unit = unit;
		this.angle = angle;
	}

	/**
	 * @see MovingObject#draw(java.awt.Graphics2D)
	 * required method from moving object interface
	 * draws 5 balloons of varying sizes and starting positions
	 * 	5 chosen because nice number between 3 and 7
	 * 	all drawn strictly by programmer, no sense of randomness because that gets sloppy and hard to control. Rather have set 
	 *  positions because then under my control easier
	 */
	public void draw(Graphics2D g2d){
		
		double lineOff = CABLELENGTH*unit*Math.sin(angle);
		g2d.setColor(Color.BLACK);
		double inflate = DIAMETER*unit;
		Ellipse2D.Double balloon1 = new Ellipse2D.Double(x, y, inflate, inflate);
		Line2D.Double cableL1 = new Line2D.Double(x, y+inflate/2, x+inflate/4+lineOff, y+inflate+CABLELENGTH*unit);
		Line2D.Double cableR1 = new Line2D.Double(x+inflate, y+inflate/2, x+inflate*3/4-lineOff, y+inflate+CABLELENGTH*unit);
		Rectangle2D.Double basket1 = new Rectangle2D.Double(x+inflate/4, y+inflate+CABLELENGTH*unit, BASKETWIDTH*unit, BASKETHEIGTH*unit);
		
		GeneralPath myBalloon1 = new GeneralPath();
		myBalloon1.append(balloon1, false);
		myBalloon1.append(cableL1, false);
		myBalloon1.append(cableR1, false);
		myBalloon1.append(basket1, false);
		
		g2d.fill(basket1);
		g2d.fill(balloon1);
		g2d.draw(myBalloon1);
		
		double resize = 0.5;
		inflate = DIAMETER*unit*resize;
		x =0;
		Ellipse2D.Double balloon2 = new Ellipse2D.Double(x, y, inflate, inflate);
		Line2D.Double cableL2 = new Line2D.Double(x, y+inflate/2, x+inflate/4+lineOff, y+inflate+CABLELENGTH*unit*resize);
		Line2D.Double cableR2 = new Line2D.Double(x+inflate, y+inflate/2, x+inflate*3/4-lineOff, y+inflate+CABLELENGTH*unit*resize);
		Rectangle2D.Double basket2 = new Rectangle2D.Double(x+inflate/4, y+inflate+CABLELENGTH*unit*resize,
				BASKETWIDTH*unit*resize, BASKETHEIGTH*unit*resize);
		
		GeneralPath myBalloon2 = new GeneralPath();
		myBalloon2.append(balloon2, false);
		myBalloon2.append(cableL2, false);
		myBalloon2.append(cableR2, false);
		myBalloon2.append(basket2, false);
		
		g2d.fill(basket2);
		g2d.fill(balloon2);
		g2d.draw(myBalloon2);
		
		resize = 1.5;
		inflate = DIAMETER*unit*resize;
		x =350;
		Ellipse2D.Double balloon3 = new Ellipse2D.Double(x, y, inflate, inflate);
		Line2D.Double cableL3 = new Line2D.Double(x, y+inflate/2, x+inflate/4+lineOff, y+inflate+CABLELENGTH*unit*resize);
		Line2D.Double cableR3 = new Line2D.Double(x+inflate, y+inflate/2, x+inflate*3/4-lineOff, y+inflate+CABLELENGTH*unit*resize);
		Rectangle2D.Double basket3 = new Rectangle2D.Double(x+inflate/4, y+inflate+CABLELENGTH*unit*resize,
				BASKETWIDTH*unit*resize, BASKETHEIGTH*unit*resize);
		
		GeneralPath myBalloon3 = new GeneralPath();
		myBalloon3.append(balloon3, false);
		myBalloon3.append(cableL3, false);
		myBalloon3.append(cableR3, false);
		myBalloon3.append(basket3, false);
		
		g2d.fill(basket3);
		g2d.fill(balloon3);
		g2d.draw(myBalloon3);
		
		resize = 0.86;
		inflate = DIAMETER*unit*resize;
		x =450;
		Ellipse2D.Double balloon4 = new Ellipse2D.Double(x, y, inflate, inflate);
		Line2D.Double cableL4 = new Line2D.Double(x, y+inflate/2, x+inflate/4+lineOff, y+inflate+CABLELENGTH*unit*resize);
		Line2D.Double cableR4 = new Line2D.Double(x+inflate, y+inflate/2, x+inflate*3/4-lineOff, y+inflate+CABLELENGTH*unit*resize);
		Rectangle2D.Double basket4 = new Rectangle2D.Double(x+inflate/4, y+inflate+CABLELENGTH*unit*resize,
				BASKETWIDTH*unit*resize, BASKETHEIGTH*unit*resize);
		
		GeneralPath myBalloon4 = new GeneralPath();
		myBalloon4.append(balloon4, false);
		myBalloon4.append(cableL4, false);
		myBalloon4.append(cableR4, false);
		myBalloon4.append(basket4, false);
		
		g2d.fill(basket4);
		g2d.fill(balloon4);
		g2d.draw(myBalloon4);
		
		resize = 0.75;
		inflate = DIAMETER*unit*resize;
		x=100;
		Ellipse2D.Double balloon5 = new Ellipse2D.Double(x, y, inflate, inflate);
		Line2D.Double cableL5 = new Line2D.Double(x, y+inflate/2, x+inflate/4+lineOff, y+inflate+CABLELENGTH*unit*resize);
		Line2D.Double cableR5 = new Line2D.Double(x+inflate, y+inflate/2, x+inflate*3/4-lineOff, y+inflate+CABLELENGTH*unit*resize);
		Rectangle2D.Double basket5 = new Rectangle2D.Double(x+inflate/4, y+inflate+CABLELENGTH*unit*resize,
				BASKETWIDTH*unit*resize, BASKETHEIGTH*unit*resize);
		
		GeneralPath myBalloon5 = new GeneralPath();
		myBalloon5.append(balloon5, false);
		myBalloon5.append(cableL5, false);
		myBalloon5.append(cableR5, false);
		myBalloon5.append(basket5, false);
		
		g2d.fill(basket5);
		g2d.fill(balloon5);
		g2d.draw(myBalloon5);
	}

	/**
	 * @author jrk based on cay horstmann
	 * 		taken from given example
	 * 			slight change to method parameters because x was not necessary to change in this form of use
	 * @see MovingObject#translate(int, int)
	 */
	public void translate(int yChange) {
		y -= yChange;
	}
	

}
