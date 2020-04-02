
/**
 * @author Helen hkw2116
 * Sim human versus computer class, cycles through shots in certain order and plays the actual sim game that appears on screen
 * calls on Thrower and Reporter class
 */
public class Simulator 
{
	private String simShoot;
	
	public Simulator ()
	{
		simShoot = null;
	}
	
	public String getSimShot(double shotNumber)// retrieves shotNumber from playSim, cycles through the throws in order r/p/s/l/k according to that number
	{
		if (shotNumber/1 == 1.0)
		{
			simShoot = "Rock";
		}else if (shotNumber/2 == 1.0)
		{
			simShoot = "Paper";
		}else if (shotNumber/3 == 1.0)
		{
			simShoot = "Scissors";
		}else if (shotNumber/4 == 1.0)
		{
			simShoot = "Lizard";
		}else if (shotNumber/5 == 1.0)
		{
			simShoot = "Spock";
		}
		return simShoot;
	}
	
	public void playSim()// simHuman plays AI computer calls on Thrower and Reporter class
	{
		double roundNum = 1.0;	
		Thrower computer = new Thrower();
		Reporter reporter = new Reporter();
			for (int x = 0; x<=49; x++)// went with 50 rounds because diminishes random chance and isn't so large its overwhelming
			{
				String compShot = computer.getRandomShot();
				if (x%5!=0)
				{
					compShot = computer.getThoughtfulShot(simShoot);
				}
				String simShot = getSimShot(roundNum);
				System.out.println("Here is round " +(x+1)+ ":\nSimHum shot:" +simShot+"\nThe computer threw: "+compShot);
				System.out.println(reporter.getResult(simShot, compShot)+"\n");
				if (roundNum == 5.0)
				{
					roundNum =0;
				}
				roundNum ++;
			}
			
			System.out.println("Here are the total results:");
			System.out.println("Your Wins:    "+reporter.getHumanWins());
			System.out.println("ComputerWins: "+reporter.getComputerWins());
			System.out.println(reporter.getPercentages());
	}
}
