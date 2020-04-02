import java.util.*;


/**
 * @author Helen hkw2116
 * the AI system of the computer that calculates the next possible deal and records the past deals
 */
public class Thinker 
{
	private int rockShots, paperShots, scissorsShots, lizardShots, spockShots;
	private String smartCompShot;
	Random dommy = new Random();
	
	
	public Thinker()
	{
		rockShots = 0;
		paperShots = 0;
		scissorsShots = 0;
		lizardShots = 0;
		spockShots = 0;
		smartCompShot = null;
	}
	
	public void catchShot(String shot)// keeps track of throws given by sim human
	{
		if (shot.equals("Rock"))
		{
			rockShots ++;
		}
		if (shot.equals("Paper"))
		{
			paperShots ++;
		}
		if (shot.equals("Scissors"))
		{
			scissorsShots ++;
		}
		if (shot.equals("Lizard"))
		{
			lizardShots ++;
		}
		if (shot.equals("Spock"))
		{
			spockShots ++;
		}
	}
	
	public String calcShot(String shot)// tracks what was just dealt, since known the order of dealing in sim human, can track by simply comparing to the next possible deal in order
	{
		catchShot(shot);
		if (rockShots> paperShots)// simply deals past shot for all options
		{
			smartCompShot = "Rock";
		}
		if (paperShots> scissorsShots)
		{
			smartCompShot = "Paper";
		}
		if (scissorsShots>lizardShots)
		{
			smartCompShot= "Scissors";
		}
		if (lizardShots>spockShots)
		{
			smartCompShot = "Lizard";
		}
		return smartCompShot;
	}
		
}
