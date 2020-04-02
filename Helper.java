import java.util.ArrayList;


/**
 * @author Helen Wojdylo hkw2116
 * Helper class to reduce code in Playground
 * calculates the results of intersections of the game
 * helps convert the parameters in html code into ArrayLists to be used in PLayground
 * checks for consistency in the parameters to make sure everything has necessary values to run
 *
 */
public class Helper {
	
	public Helper(){
		
	}
	
	/**
	 * @param shoot1
	 * @param shoot2
	 * @return depends on game rules
	 * 
	 * returns results of the intersections detected in Playground
	 */
	public int getResult(String shoot1, String shoot2)
	{
		String shot1 = shoot1.toUpperCase();
		String shot2 = shoot2.toUpperCase();
		
		if(shot1.equals("BLACKHOLE") || shot2.equals("BLACKHOLE"))
			return 3;
		if (shot1.equals("ROCK"))
		{
			if(shot2.equals("ROCK"))
				return 0;
			else if(shot2.equals("PAPER"))
				return 2;
			else if(shot2.equals("SCISSORS"))
				return 1;
			else if(shot2.equals("LIZARD"))
				return 1;
			else if(shot2.equals("SPOCK"))
				return 2;
		}
		if (shot1.equals("PAPER"))
		{
			if(shot2.equals("ROCK"))
				return 1;
			else if(shot2.equals("PAPER"))
				return 0;
			else if(shot2.equals("SCISSORS"))
				return 2;
			else if(shot2.equals("LIZARD"))
				return 2;
			else if(shot2.equals("SPOCK"))
				return 1;
		}
		if (shot1.equals("SCISSORS"))
		{
			if(shot2.equals("ROCK"))
				return 2;
			else if (shot2.equals("PAPER"))
				return 1;
			else if(shot2.equals("SCISSORS"))
				return 0;
			else if(shot2.equals("LIZARD"))
				return 1;
			else if(shot2.equals("SPOCK"))
				return 2;
		}
		if (shot1.equals("LIZARD"))
		{
			if(shot2.equals("ROCK"))
				return 2;
			else if (shot2.equals("PAPER"))
				return 1;
			else if(shot2.equals("SCISSORS"))
				return 2;
			else if(shot2.equals("LIZARD"))
				return 0;
			else if(shot2.equals("SPOCK"))
				return 1;
		}
		if (shot1.equals("SPOCK"))
		{
			if(shot2.equals("ROCK"))
				return 1;
			else if (shot2.equals("PAPER"))
				return 2;
			else if(shot2.equals("SCISSORS"))
				return 1;
			else if(shot2.equals("LIZARD"))
				return 2;
			else if(shot2.equals("SPOCK"))
				return 0;
		}
		return 0;
	}
	
	/**
	 * @param data
	 * @return
	 * converts parameters split into an array to an ArrayList to work with code in Playground
	 * moved to reduce length of Playground
	 */
	public ArrayList<String> convert(String[] data){
		ArrayList<String> stats = new ArrayList<String>();
		for (int x = 0; x< data.length; x++)
				stats.add(data[x]);
		return stats;
	}
	
	/**
	 * @param throwX
	 * @param throwY
	 * @param htmlThrowName
	 * @param verticals
	 * @param horizs
	 * @param throwRectangle
	 * 
	 * takes all the ArrayLists and checks for same length to concur that every throw has corresponding x, y start coordinates and 
	 * vertical and horizontal velocities
	 */
	public void check(ArrayList throwX, ArrayList throwY, ArrayList htmlThrowName, 
			ArrayList verticals, ArrayList horizs, ArrayList throwRectangle){
		if(throwX.size() != htmlThrowName.size() || throwX.size() != throwRectangle.size() || 
				throwX.size() != throwY.size() || throwX.size() != verticals.size() || throwX.size() != horizs.size()){
			System.out.println("You did not enter the correct number of values in all your parameters,\n please re enter and try again");
			System.exit(0);
		}
	}

}

