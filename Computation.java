import java.util.*;
/**
 * @author Helen
 *computation methods to work with the compute option in pipeline
 */
public class Computation {
	public Computation()
	{
		
	}

	/**
	 * @param myScanner
	 * @param fieldExists
	 * @return
	 * runs through AL of the values of a certain field and checks if they are all the same
	 */
	public boolean isAllSame(Scanner myScanner, int fieldExists)
	{
		ArrayList<String> checkForSame= new ArrayList<String>();
		myScanner.nextLine();
		while(myScanner.hasNext())
		{
			String [] line = myScanner.nextLine().split("\t");
			checkForSame.add(line[fieldExists]);
		}
		String check = checkForSame.get(0);
		for(int x =0; x<checkForSame.size(); x++)
		{
			if(!checkForSame.get(x).equals(check))
				return false;
		}
		return true;
	}
	
	/**
	 * @param myScanner
	 * @return
	 * counts the number of records in a file
	 */
	public int findCount(Scanner myScanner)
	{
		myScanner.nextLine();
		int count = 0;
		while(myScanner.hasNext())
		{
			count++;
			myScanner.nextLine();
		}
		return count;
	}
	
	/**
	 * @param myScanner
	 * @param fieldExists
	 * @return
	 * runs through AL of values and return the largest one
	 */
	public String findMax(Scanner myScanner, int fieldExists)
	{
		ArrayList<String> findMax= new ArrayList<String>();
		myScanner.nextLine();
		while(myScanner.hasNext())
		{
			String [] line = myScanner.nextLine().split("\t");
			findMax.add((line[fieldExists]));
		}
		String max = null;
		for(int x =0; x<findMax.size()-1; x++)
		{
			String a = findMax.get(x);
			String b = findMax.get(x+1);
			System.out.println(a+""+b);
			if(a.compareTo(b)<0)
			{
				System.out.println("HERE");
				max = findMax.get(x+1);
			}
				
		}
		return max;
	}
	
	/**
	 * @param myScanner
	 * @param fieldExists
	 * @return
	 * runs through AL of values and returns the smallest one
	 */
	public String findMin(Scanner myScanner, int fieldExists)
	{
		ArrayList<String> findMax= new ArrayList<String>();
		myScanner.nextLine();
		while(myScanner.hasNext())
		{
			String [] line = myScanner.nextLine().split("\t");
			findMax.add((line[fieldExists]));
		}
		String min = null;
		for(int x =0; x<findMax.size()-1; x++)
		{
			String a = findMax.get(x);
			String b = findMax.get(x+1);
			System.out.println(a+""+b);
			if(a.compareTo(b)>0)
			{
				System.out.println("HERE");
				min = findMax.get(x+1);
			}
				
		}
		return min;
	}
	
	/**
	 * @param myScanner
	 * @param fieldExists
	 * @return
	 * adds up all the values in an ArrayList
	 */
	public int findSum(Scanner myScanner, int fieldExists)
	{
		ArrayList<Integer> findSum= new ArrayList<Integer>();
		myScanner.nextLine();
		while(myScanner.hasNext())
		{
			String [] line = myScanner.nextLine().split("\t");
			findSum.add(Integer.parseInt(line[fieldExists]));
		}
		int sum = 0;
		for(int x =0; x<findSum.size(); x++)
		{
			sum+=findSum.get(x);
		}
		return sum;
	}
	
	/**
	 * @param myScanner
	 * @param fieldExists
	 * @return
	 * decides if a file has mostly the same values in selected field. cannot exceed more than 3 values
	 */
	public boolean isMostlySame(Scanner myScanner, int fieldExists)
	{
		ArrayList<String> checkForSameness= new ArrayList<String>();
		myScanner.nextLine();
		while(myScanner.hasNext())
		{
			String [] line = myScanner.nextLine().split("\t");
			checkForSameness.add(line[fieldExists]);
		}
		String checks = checkForSameness.get(0);
		int checker = 0;
		for(int x =0; x<checkForSameness.size(); x++)
			if(!checkForSameness.get(x).equals(checks))
			{	checker++;
				checks = checkForSameness.get(x);
			}
		
		if(checker>3)
			return false;
		else
			return true;
	}
}
