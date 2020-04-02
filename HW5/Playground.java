import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Timer;
/**  
 * @author jrk based on cay horstmann
 * @author Helen Wojdylo hkw2116
 * 
 *  needs an html file that looks like:
 *  <applet code="Playground.class" width="500" height="500">
	<param name="throws" value="all possible throws in one line separated by a space" />
				game characters allowed are Rock, Paper, Scissors, Lizard, Spock, and BlackHole
	<param name="fontname" value="value" />
	<param name="fontsize" value="value" />

	<param name="xstarts" value="all starting positions in same line separated by a space"/>
	<param name="ystarts" value="all starting positions in same line separated by a space"/>
	<param name="verticals" value="all direction values in same line separated by a space"/>
				North (-1) and South (1)
	<param name="horizs" value ="all direction values in same line separated by a space"/>
				East(1) and West(-1)

	<param name="delay" value="100" />
	</applet>
 *  
 *  
 *  all necessary methods to run applet, 
 *  
 *  game rules: 
 *  	Rock beats Scissors and Lizard
 *  	Paper beats Rock and Spock
 *  	Scissors beats Paper and Lizard
 *  	Lizard beats Paper and Spock
 *  	Spock beats Rock and Scissors
 *  	BlackHole beats everything
 **/
public class Playground extends Applet {
	/**
	 * @see java.applet.Applet#init()
	 * actual acquiring of HTML data with given parameter names, required to be exact same as code to run
	 * 		all values in each parameter seperated by space and all in one line 
	 */
	public void init() {
		String possThrows =getParameter("throws"); 
		htmlThrowName = helper.convert(possThrows.split(" "));
		htmlFontName = getParameter("fontname");
		htmlFontSize = Integer.parseInt(getParameter("fontsize"));
		throwFont = new Font(htmlFontName, Font.BOLD, htmlFontSize);
		
		Graphics2D g2D = (Graphics2D) getGraphics();

		FontRenderContext throwContext = g2D.getFontRenderContext();
		
		throwRectangle = new ArrayList<Rectangle2D>(htmlThrowName.size());
		for (int a =0; a<htmlThrowName.size(); a++)
			throwRectangle.add(a, throwFont.getStringBounds(htmlThrowName.get(a), throwContext));
		String ypos = getParameter("ystarts");
		throwY = helper.convert(ypos.split(" "));

		String xpos = getParameter("xstarts");
		throwX = helper.convert(xpos.split(" "));
		
		String v = getParameter("verticals");
		verticals = helper.convert(v.split(" "));
		
		String h = getParameter("horizs");
		horizs = helper.convert(h.split(" "));
		
		helper.check(throwX, throwY, htmlThrowName, verticals, horizs, throwRectangle);
		
		//for North, value assigned -1, for South value assigned 1, for West value assigned -1, for East value assigned 1
		//timer controls movement and intersection with game play
		
		htmlDelay = Integer.parseInt(getParameter("delay"));
		appletTimer = new Timer(htmlDelay, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int z =0; z<throwX.size(); z++){
					if(verticals.get(z).equals("-1")){
						int y = Integer.parseInt(throwY.get(z));
						y--;
						throwY.set(z,Integer.toString(y));
					}
					if(verticals.get(z).equals("1")){
						int y = Integer.parseInt(throwY.get(z));
						y++;
						throwY.set(z, Integer.toString(y));
					}
					if(horizs.get(z).equals("-1")){
						int x = Integer.parseInt(throwX.get(z));
						x--;
						throwX.set(z, Integer.toString(x));
					}
					if(horizs.get(z).equals("1")){
						int x = Integer.parseInt(throwX.get(z));
						x++;
						throwX.set(z, Integer.toString(x));
					}
				}
				for(int b = 0; b<htmlThrowName.size(); b++){
					if (Integer.parseInt(throwX.get(b)) + throwRectangle.get(b).getWidth() < 0 || Integer.parseInt(throwX.get(b)) > getWidth())
					{
						if(horizs.get(b).equals("-1"))
							throwX.set(b, Integer.toString(getWidth()));
						if(horizs.get(b).equals("1"))
							throwX.set(b, Integer.toString(-(int)throwRectangle.get(b).getWidth()));
					}
					if (Integer.parseInt(throwY.get(b)) + (int)throwRectangle.get(b).getHeight() < 0 || Integer.parseInt(throwY.get(b)) >getHeight()+15)
					{
						if(verticals.get(b).equals("-1"))
							throwY.set(b, Integer.toString(getHeight()+15));
						if(verticals.get(b).equals("1"))
							throwY.set(b, Integer.toString(-(int)throwRectangle.get(b).getHeight()));
					}
				}
				
				//collisions detected below, if more than one connects happen at once, first one to occur happens first
				// can handle any number of throws, will continue running until user closes out.
				
				for(int i = 0; i < throwRectangle.size(); i++){
					for (int j = i+1; j < throwRectangle.size(); j++){
						int x1 = Integer.parseInt(throwX.get(i));
						int y1 = Integer.parseInt(throwY.get(i));
						int width1 =(int)throwRectangle.get(i).getWidth();
						int height1 = (int) throwRectangle.get(i).getHeight();
						Rectangle r1 = new Rectangle(x1, y1, width1, height1);
						
						int x2 = Integer.parseInt(throwX.get(j));
						int y2 = Integer.parseInt(throwY.get(j));
						int width2 =(int)throwRectangle.get(j).getWidth();
						int height2 = (int) throwRectangle.get(j).getHeight();
						Rectangle r2 = new Rectangle(x2, y2, width2, height2);
						if (r1.intersects(r2)){
							int winner = helper.getResult(htmlThrowName.get(i), htmlThrowName.get(j));
							if( winner == 1){
									removed = htmlThrowName.get(j);
									htmlThrowName.remove(j);
									throwRectangle.remove(j);
									throwX.remove(j);
									throwY.remove(j);
									verticals.remove(j);
									horizs.remove(j);
									j+=-1;
									detection = 10;
							}else if( winner == 2){
								removed = htmlThrowName.get(i);
								htmlThrowName.remove(i);
								throwRectangle.remove(i);
								throwX.remove(i);
								throwY.remove(i);
								verticals.remove(i);
								horizs.remove(i);
								detection = 10;
							}else if( winner == 3){
								if (htmlThrowName.get(i).equals("BlackHole")){
									if(htmlThrowName.get(j).equals("BlackHole"))
										size = 2*size;
									removed = htmlThrowName.get(j);
									htmlThrowName.remove(j);
									throwRectangle.remove(j);
									throwX.remove(j);
									throwY.remove(j);
									verticals.remove(j);
									horizs.remove(j);
									j -=1;
									detection = 10;
								}else{
									removed = htmlThrowName.get(i);
									htmlThrowName.remove(i);
									throwRectangle.remove(i);
									throwX.remove(i);
									throwY.remove(i);
									verticals.remove(i);
									horizs.remove(i);
									detection = 10;
								}
							}
						}
					}
				}
				repaint();
					}
			});
		}
	
	/** 
	 * @see java.applet.Applet#start()
	 * starts the timer
	 * @author jrk based on cay horstmann
	 */
	public void start() {
		appletTimer.start();
		}
	
	/**
	 * @see java.awt.Container#paint(java.awt.Graphics)
	 * actual painting on the applet
	 */
	public void paint(Graphics g) {
		if(detection >0){
			g.setFont(new Font("Stencil", Font.BOLD, 100));
			g.setColor(Color.YELLOW);
			g.fillOval(50, 100, 400, 250);
			g.setColor(Color.RED);
			g.drawString("BOOM!", 75, 250);
			g.setFont(new Font("Arial", Font.BOLD, 20));
			g.setColor(Color.BLACK);
			g.drawString("There was a collision! "+ removed + " got destroyed!", 50, 400);
			detection--;
		}else{
			for(int t = 0; t<htmlThrowName.size(); t++)
			{
				if(htmlThrowName.get(t).equals("Rock")){
					throwFont = new Font(htmlFontName, Font.BOLD, htmlFontSize);
					g.setFont(throwFont);
					g.setColor(Color.BLACK);
				}
				if(htmlThrowName.get(t).equals("Paper")){
					throwFont = new Font(htmlFontName, Font.PLAIN, htmlFontSize);
					g.setFont(throwFont);
					g.setColor(Color.GRAY);
				}
				if(htmlThrowName.get(t).equals("Scissors")){
					throwFont = new Font(htmlFontName, Font.PLAIN, htmlFontSize);
					g.setFont(throwFont);
					g.setColor(Color.MAGENTA);
				}
				if(htmlThrowName.get(t).equals("Lizard")){
					throwFont = new Font(htmlFontName, Font.ITALIC, htmlFontSize);
					g.setFont(throwFont);
					g.setColor(Color.GREEN);
				}
				if(htmlThrowName.get(t).equals("Spock")){
					throwFont = new Font(htmlFontName, Font.BOLD+Font.ITALIC, htmlFontSize);
					g.setFont(throwFont);
					g.setColor(Color.BLUE);
				}
				if(htmlThrowName.get(t).equals("BlackHole")){
					throwFont = new Font("Arial", Font.BOLD, size);
					g.setFont(throwFont);
					g.setColor(Color.BLACK);
				}
				g.drawString(htmlThrowName.get(t), Integer.parseInt(throwX.get(t)), Integer.parseInt(throwY.get(t)));
			}
		}
	}
	
	/**
	 * @author jrk based on cay horstmann
	 * @see java.applet.Applet#stop()
	 *  stops the timer
	 */
	public void stop() {
		appletTimer.stop();
		}
	
	/**
	 * @see java.applet.Applet#destroy()
	 * does nothing
	 * necessary for applet extension
	 */
	public void destroy() {
		}
	private ArrayList<String> htmlThrowName, throwX, throwY, verticals, horizs;
	private String htmlFontName, removed;
	private int htmlFontSize, htmlDelay, size = 15, detection = 0;
	private Font throwFont;
	private ArrayList<Rectangle2D> throwRectangle;
	private Timer appletTimer;
	private Helper helper= new Helper();

}
