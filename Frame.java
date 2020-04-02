import java.awt.*;
import java.awt.event.*;
import java.util.Hashtable;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * @author Helen
 * extends JFrame to set all idioms and instantiate all objects adding them to the JFrame
 * removed from Runner
 */
public class Frame extends JFrame {
	
	private int speed;
	
	/**
	 * actual creation of JFrame
	 */
	public Frame()
	{
		setLayout(new BorderLayout());// idiom
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// idiom

		final MovingObject myObj = new HotAirBalloon(500, 500, 20, 0.4);// creation of flying object 
		final My_Icon balloonIcon = new My_Icon(myObj, ICON_W, ICON_H);//and adding it to an Icon
		final JLabel balloonLabel = new JLabel(balloonIcon);//which is then added to a JLabel 
		add(balloonLabel, BorderLayout.WEST);//to be put on frame
		
		final FlyingObject flyObj = new Birds(10.0);// same with the birds as Hot Air Balloon
		final My_Icon birdIcon = new My_Icon(flyObj, ICON_W, ICON_H);
		final JLabel birdLabel = new JLabel(birdIcon);
		add(birdLabel, BorderLayout.CENTER);
		
		final JSlider speedSlide = new Slider();// creation of JSLider to set speed of rising balloons
		speedSlide.addChangeListener(new ChangeListener() {
		      public void stateChanged(ChangeEvent event) {
		    	  speed = speedSlide.getValue();
		      }
		    });
		add(speedSlide, BorderLayout.EAST);
		
		pack();//idiom
		setVisible(true);//idiom

		final int DELAY = 100;// timer kept with the Frame setting to avoid messing up of it because I still don't 100% understand how to use it correctly
		// Milliseconds between timer ticks
		Timer myTimer = new Timer(DELAY, new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				myObj.translate(speed);
				flyObj.approach(1);
				balloonLabel.repaint();
				birdLabel.repaint();
			}
		});
		myTimer.start();
	}
	private static final int ICON_W = 800;
	private static final int ICON_H = 600;

}
