import java.util.*;
import java.io.*;

/**
 * @author Helen Wojdylo
 *
 */
public class HW2Runner 
{
	
	private static Scanner myScanner;

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main (String [] args) throws IOException
	{
		myScanner = new Scanner(System.in);
		Choice myChoice = new Choice();
		System.out.println("Would you like to work with txt files or cmp files?");
		String answer = myScanner.nextLine();
		
		System.out.println("Start editing!");
		String choice = myScanner.nextLine();
		do
		{
			myChoice.makeChoice(answer, choice);
			choice = myScanner.nextLine();
		}while (!choice.equals("q"));

		
	}
}
