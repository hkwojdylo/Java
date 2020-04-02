import java.util.*;
import java.io.*;

/**
 * @author Helen
 * sets up and builds the TSVFilter by asking the user for all the individual parts, one at a time. 
 * allows for user to do select or not, and compute or not. can compute even if there is no select
 */
public class HW3Runner 
{
	public static void main (String [] args)
	{
		Scanner reader = new Scanner(System.in);
		TSVFilter myTSVFilter = null;
		TSVFilter.Terminal myTerminal = null;
		
		System.out.println("Welcome to Steaming!\nWhich file would you like to work with?");
		String fileName = reader.nextLine();
		System.out.println("Would you like to process your file? Process means to select a field and value of it in the file and only print to a new file the lines that have that selected value in that selected field"
				+ "\nEnter 'Y' to select or 'N' to simply format the file");
		String answer = reader.nextLine();
		if (answer.equals("Y")||answer.equals("y"))
		{
			System.out.println("Which field would you like to select?");
			String sfield = reader.nextLine();
			System.out.println("What value would you like to use?");
			String svalue = reader.nextLine();
			System.out.println("Would you like to compute on the file?\nEnter 'Y' for yes or 'n' for no");
			answer = reader.nextLine();
			if (answer.equals("Y")||answer.equals("y"))
			{
				System.out.println("What field would you like to compute on?");
				String cfield = reader.nextLine();
				System.out.println("What computation would you like? \nOptions: AllSame, Count, Max, Min, Sum, MostlySame");
				String cvalue = reader.nextLine().toUpperCase();
					if(cvalue.equals("MAX"))
						myTSVFilter = new TSVFilter.WorkingFile(fileName).select(sfield, svalue).compute(cfield, myTerminal.MAX).done();
					if(cvalue.equals("MIN"))
						myTSVFilter = new TSVFilter.WorkingFile(fileName).select(sfield, svalue).compute(cfield, myTerminal.MIN).done();
					if(cvalue.equals("ALLSAME"))
						myTSVFilter = new TSVFilter.WorkingFile(fileName).select(sfield, svalue).compute(cfield, myTerminal.ALLSAME).done();
					if(cvalue.equals("COUNT"))
						myTSVFilter = new TSVFilter.WorkingFile(fileName).select(sfield, svalue).compute(cfield, myTerminal.COUNT).done();
					if(cvalue.equals("SUM"))
						myTSVFilter = new TSVFilter.WorkingFile(fileName).select(sfield, svalue).compute(cfield, myTerminal.SUM).done();
					if(cvalue.equals("MOSTLYSAME"))
						myTSVFilter = new TSVFilter.WorkingFile(fileName).select(sfield, svalue).compute(cfield, myTerminal.MOSTLYSAME).done();
			}else
				myTSVFilter = new TSVFilter.WorkingFile(fileName).select(sfield, svalue).done();
		}else
		{
			System.out.println("Would you like to compute on the file?\nEnter 'Y' for yes or 'n' for no");
			answer = reader.nextLine();
			if (answer.equals("Y")||answer.equals("y"))
			{
				System.out.println("What field would you like to compute on?");
				String cfield = reader.nextLine();
				System.out.println("What computation would you like? \nOptions: AllSame, Count, Max, Min, Sum, MostlySame");
				String cvalue = reader.nextLine().toUpperCase();
					if(cvalue.equals("MAX"))
						myTSVFilter = new TSVFilter.WorkingFile(fileName).compute(cfield, myTerminal.MAX).done();
					if(cvalue.equals("MIN"))
						myTSVFilter = new TSVFilter.WorkingFile(fileName).compute(cfield, myTerminal.MIN).done();
					if(cvalue.equals("ALLSAME"))
						myTSVFilter = new TSVFilter.WorkingFile(fileName).compute(cfield, myTerminal.ALLSAME).done();
					if(cvalue.equals("COUNT"))
						myTSVFilter = new TSVFilter.WorkingFile(fileName).compute(cfield, myTerminal.COUNT).done();
					if(cvalue.equals("SUM"))
						myTSVFilter = new TSVFilter.WorkingFile(fileName).compute(cfield, myTerminal.SUM).done();
					if(cvalue.equals("MOSTLYSAME"))
						myTSVFilter = new TSVFilter.WorkingFile(fileName).compute(cfield, myTerminal.MOSTLYSAME).done();
			}else
				myTSVFilter = new TSVFilter.WorkingFile(fileName).done();
		}
		
		System.out.println(myTSVFilter);
		new TSVPipeline(myTSVFilter).formatFile();
	}
		
}
