
import java.util.*;
/**
 * @author Helen hkw2116
 * this is the main runner of the system. calls only on Talker and Simulator class to play either with the human, or a simulated human and AI computer
 * allows user to decide if they wish to plau against the computer or have a simulated human play against an AI computer system
 */
public class HW1Runner 
{
	public static void main (String [] args)
	{
		Scanner reader = new Scanner (System.in);
		
		System.out.println("Would you like to play, or have a simulated human play? Pick 1 for you, 2 for simulated");
		int choice = reader.nextInt();
		while (choice != 1 && choice !=2)
		{
			System.out.println("Must enter a 1 for you or 2 for simulated"); // sanity statement to make sure of valid number
			choice = reader.nextInt();
		}
		if (choice == 1)
		{
			Talker human = new Talker();
			human.playLive();
		}
		if (choice == 2)
		{
			Simulator simHum = new Simulator();
			simHum.playSim();
		}
	
	}

}
