import java.util.*;
/**
 * @author Helen hkw2116
 * Human player versus computer, changes user inputed character into full string to be displayed and plays the user versus computer game
 * calls on Thrower, Reporter
 */
public class Talker
{
	private String humShoot;
	Scanner reader = new Scanner (System.in);
	
	public Talker()
	{
		humShoot = null;
	}
	
	public String getHumShot(String recieved) //change from character entered to full string for display and other methods parameters, parameter here is recieved from Runner from user
	{
		if (recieved.equals("r"))
		{
			humShoot = "Rock";
		}else if (recieved.equals("p"))
		{
			humShoot = "Paper";
		}else if (recieved.equals("s"))
		{
			humShoot = "Scissors";
		}else if (recieved.equals("l"))
		{
			humShoot = "Lizard";
		}else if (recieved.equals("k"))
		{
			humShoot = "Spock";
		}
		return humShoot;
	}
		
	public void playLive()// play live human method, calls on Thrower and Reporter class
	{
		Thrower computer = new Thrower();
		Reporter reporter = new Reporter();
		
		System.out.println("Welcome to Rock, Paper Scissors, Lizard, Spock!\nPlease pick what to shoot with: r, p, s, l, k or z to end the game.");
		String shoot = reader.nextLine();
		while (!shoot.equals("z"))
		{
			while (!shoot.equals("r") && !shoot.equals("p") && !shoot.equals("s") && !shoot.equals("l") && !shoot.equals("k") && !shoot.equals("z"))
			{
				System.out.println("That is not a valid shoot. Please try again");
				shoot = reader.nextLine();
			}
			String humShot = getHumShot(shoot);
			String compShot = computer.getRandomShot();
			System.out.println("Here is the round:\nYou shoot: "+humShot+"\nThe computer threw: "+compShot);
			System.out.println(reporter.getResult(shoot, compShot)+"\nShoot again (r/p/s/l/k/z)");
			shoot = reader.nextLine();
		}
		System.out.println("\nHere are the total results:\nYour Wins:    "+reporter.getHumanWins()+"\nComputerWins: "+reporter.getComputerWins());
		System.out.println(reporter.getPercentages());
	}
}

