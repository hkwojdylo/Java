
import java.util.*;
/**
 * @author Helen hkw2116
 * computer class that throws randomly or thoughtfully for human or simhuman respectively, variables called throw in reference to computer deal, shot for human or sim human
 * calls on Thinker class
 */
public class Thrower 
{
	private String compShoot;
	Random randy = new Random();
	Thinker helper = new Thinker();
	public Thrower()
	{
		compShoot = null;
	}
	
	public String getRandomShot() // get random throw for playing against live human and in first round of playing sim human
	{
		int callNumber = randy.nextInt(5)+1;
		switch(callNumber)
		{
		case 1: compShoot = "Rock";
				break;
		case 2: compShoot = "Paper";
				break;
		case 3: compShoot = "Scissors";
				break;
		case 4: compShoot = "Lizard";
				break;
		case 5: compShoot = "Spock";
				break;
		}
		return compShoot;
	}

	public String getThoughtfulShot(String shot)// calls on Thinker class for the AI element of sim human versus AI computer
	{
		compShoot = helper.calcShot(shot);// from Sim class
		return compShoot;
	}
}
