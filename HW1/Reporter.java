
/**
 * @author Helen hkw2116
 * reporter class that calculates wins for computer and human and reports results of each round and total Games
 */
public class Reporter 
{
	private int humanWins, computerWins, ties, totalGamesPlayed;
	private String result, percentages;
	
	public Reporter()
	{
		humanWins = 0;
		computerWins = 0;
		ties = 0;
		totalGamesPlayed = 0;
		result = null;
		percentages = null;
	}
	public String getResult(String humShoot, String compShoot)// gets result by comparing two deals, long yes, but easier to visualize and navigate and make sense of by just reading
	{
		if (humShoot.equals("r")|| humShoot.equals("Rock"))
		{
			if(compShoot.equals("Rock"))
			{
				ties++;// also keeps track of wins for who, ties and total games played
				result = "You both threw rock, it's a Tie";
			}else if(compShoot.equals("Paper"))
			{
				computerWins++;
				result = "Paper covers rock, Computer Wins";
			}else if(compShoot.equals("Scissors"))
			{
				humanWins++;
				result = "Rock crushes scissors, Human Wins";
			}else if(compShoot.equals("Lizard"))
			{
				humanWins++;
				result = "Rock crushes lizard, Human Wins";
			}else if(compShoot.equals("Spock"))
			{
				computerWins++;
				result = "Spock vaporizes rock, Computer Wins";
			}
		}
		if (humShoot.equals("p")|| humShoot.equals("Paper"))
		{
			if(compShoot.equals("Rock"))
			{
				humanWins++;
				result = "Paper covers rock, Human Wins";
			}else if(compShoot.equals("Paper"))
			{
				ties++;
				result = "You both threw paper, it's a Tie";
			}else if(compShoot.equals("Scissors"))
			{
				computerWins++;
				result = "Scissors cuts paper, Computer Wins";
			}else if(compShoot.equals("Lizard"))
			{
				computerWins++;
				result = "Lizard eats paper, Computer Wins";
			}else if(compShoot.equals("Spock"))
			{
				humanWins++;
				result = "Paper disproves Spock, Human Wins";
			}
		}
		if (humShoot.equals("s")|| humShoot.equals("Scissors"))
		{
			if(compShoot.equals("Rock"))
			{
				computerWins++;
				result = "Rock crushes scissors, Computer Wins";
			}else if (compShoot.equals("Paper"))
			{
				humanWins++;
				result = "Scissors cuts paper, Human Wins";
			}else if(compShoot.equals("Scissors"))
			{
				ties++;
				result = "You both threw scissors, it's a Tie";
			}else if(compShoot.equals("Lizard"))
			{
				humanWins++;
				result = "Scissors decapitates lizard, Human Wins";
			}else if(compShoot.equals("Spock"))
			{
				computerWins++;
				result = "Spock crushes scissors, Computer Wins";
			}
		}
		if (humShoot.equals("l")|| humShoot.equals("Lizard"))
		{
			if(compShoot.equals("Rock"))
			{
				computerWins++;
				result = "Rock crushes lizard, Computer Wins";
			}else if (compShoot.equals("Paper"))
			{
				humanWins++;
				result = "Lizard eats paper, Human Wins";
			}else if(compShoot.equals("Scissors"))
			{
				computerWins++;
				result = "Scissors decapitates lizard, Computer Wins";
			}else if(compShoot.equals("Lizard"))
			{
				ties++;
				result = "You both threw lizard, it's a Tie";
			}else if(compShoot.equals("Spock"))
			{
				humanWins++;
				result = "Lizard poisons Spock, Human Wins";
			}
		}
		if (humShoot.equals("k")|| humShoot.equals("Spock"))
		{
			if(compShoot.equals("Rock"))
			{
				humanWins++;
				result = "Spock vaporizes rock, Human Wins";
			}else if (compShoot.equals("Paper"))
			{
				computerWins++;
				result = "Paper disproves Spock, Computer Wins";
			}else if(compShoot.equals("Scissors"))
			{
				humanWins++;
				result = "Spock smashes scissors, Human Wins";
			}else if(compShoot.equals("Lizard"))
			{
				computerWins++;
				result = "Lizard poisons Spock, Computer Wins";
			}else if(compShoot.equals("Spock"))
			{
				ties++;
				result = "You both threw Spock, it's a Tie";
			}
		}
		totalGamesPlayed++;
		return result;
	}
	
	public int getHumanWins()// retrieves private int of times the humShooter (human) won
	{
		return humanWins;
	}
	
	public int getComputerWins()// retrieves private int of times the thrower (computer) won
	{
		return computerWins;
	}
	
	public int getGamesPlayed()// total games played
	{
		return totalGamesPlayed;
	}
	
	public String getPercentages()// calculates percentages for wins by humShooter (human), thrower (computer), ties and the total number of games played is displayed as well
	{
		double humShooterpercent = (humanWins*100)/totalGamesPlayed;
		double compShooterpercent = (computerWins*100)/totalGamesPlayed;
		double tiespercent = (ties*100)/totalGamesPlayed;
		percentages = "Human won "+humShooterpercent+"% of the time compared to "+totalGamesPlayed+" games in total. The computer won "+compShooterpercent+"% of the time and ties made for remaining "+ tiespercent+"%";
		return percentages;
	}
}
