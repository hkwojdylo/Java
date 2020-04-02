import java.io.*;
import java.util.*;

/**
 * @author Helen
 * pipeline that takes the TSVfilter and uses its information stored there to format a file given the choices made, whether that be a sekection of a feild or a computation done to it
 *
 */
public class TSVPipeline 
{
	private int fields = 0;
	private String order = null;
	private TSVFilter myTSVFilter;
	private Computation myComp = new Computation();
	
	/**
	 * @param inTSVFilter
	 * requires a TSVFilter in the constructor
	 */
	public TSVPipeline(TSVFilter inTSVFilter)
	{
		myTSVFilter = inTSVFilter;
	}
	
	/**
	 * actually writes the new file into anew output file so that the original stays intact
	 */
	public void formatFile()
	{
		try
		{
			File outputFile = new File("C:/FilteredOutput"+myTSVFilter.getReqName());
			PrintWriter myPW = new PrintWriter(outputFile);
			Scanner reader = new Scanner(new File("C:/"+myTSVFilter.getReqName()));
			String firstLine = reader.nextLine();
			checkFirstLine(firstLine, "noFlieldYet");
			myPW.println(firstLine);// done on all files no matter if select or compute 
			
			if(myTSVFilter.getSelectedField()!=null)// yes to select
			{
				if(myTSVFilter.getComputedField()!=null)// yes to select, yes to compute
				{
					select(myPW, reader, firstLine);
					Scanner myScanner = new Scanner(new File("C:/FilteredOutput"+myTSVFilter.getReqName()));// new scanner onto the selected file to get data to compute with
					compute(myPW, myScanner, firstLine);
				}else// yes to select, no to compute
					select(myPW, reader, firstLine);
			}else//no to select
			{
				if(myTSVFilter.getComputedField()!= null)//no to select, yes to compute
				{
					fullFile(myPW, reader, firstLine);
					Scanner myScanner = new Scanner(new File("C:/FilteredOutput"+myTSVFilter.getReqName()));// get formatted file to get data to compute with
					compute(myPW, myScanner, firstLine);
				}else//no to select,no to compute, simply formats the file
					fullFile(myPW, reader, firstLine);
			}
		}catch(FileNotFoundException e){
			System.out.println("File Not Found");
		}catch (IOException e) {
			System.out.println("There was an IOException");
		}
	}
	
	/**
	 * @param myPW
	 * @param reader
	 * @param firstLine
	 * prints full file with no select or compute, only formatted
	 * if file has no lines then cannot be formatted, if line has 2 or more tabs then line is deleted 
	 */
	public void fullFile(PrintWriter myPW, Scanner reader, String firstLine)
	{	
		String secondLine = reader.nextLine();
		while (checkSecondLine(secondLine)==false)
			secondLine = reader.nextLine();
		myPW.println(secondLine);
		while (reader.hasNext())
		{
			String line = reader.nextLine();
			if(checkLine(line))
				myPW.println(line);
		}
		myPW.close();
	}
	
	/**
	 * @param myPW
	 * @param reader
	 * @param firstLine
	 * writes file that has been formatted and had a selection done
	 */
	public void select(PrintWriter myPW, Scanner reader, String firstLine)
	{
		int fieldExists = checkFirstLine(firstLine, myTSVFilter.getSelectedField());
		if (fieldExists == -1)
		{
			fullFile(myPW, reader, firstLine);
			System.out.println("That field did not exist in the file, the full file was printed instead");// what happens if field is not in file
		}else
		{
			String secondLine = reader.nextLine();
			try{
				while (checkSecondLine(secondLine)==false)
					secondLine = reader.nextLine();
			while (checkForSelect(secondLine, fieldExists) == false)
				secondLine = reader.nextLine();
			myPW.println(secondLine);
			}catch(NoSuchElementException i){
				System.out.println("Value was not found in file");}
			while(reader.hasNext())
			{
				String line = reader.nextLine();
				if(checkForSelect(line, fieldExists))
					myPW.println(line);
			}
		}
		myPW.close();
	}
	
	/**
	 * @param myPW
	 * @param myScanner
	 * @param firstLine
	 * compute occurs on an already formatted file, so no unnecessary scanning of a line done if it isn't in correct format, result printed directly to the console.
	 */
	public void compute(PrintWriter myPW, Scanner myScanner, String firstLine)
	{
		int fieldExists = checkFirstLine(firstLine, myTSVFilter.getComputedField());
		if (fieldExists == -1)
		{
			fullFile(myPW, myScanner, firstLine);
			System.out.println("That field did not exist to compute on");// if field not in file,this is printed
		}else
		{
			switch(myTSVFilter.getTerminal())
			{
				case MAX: 
					System.out.println("The largest "+myTSVFilter.getComputedField()+" was "+myComp.findMax(myScanner, fieldExists));
					break;
				case MIN:
					System.out.println("The smallest "+myTSVFilter.getComputedField()+" was "+myComp.findMin(myScanner, fieldExists));
					break;
				case ALLSAME:
					System.out.println("All the same "+myTSVFilter.getComputedField()+": "+myComp.isAllSame(myScanner, fieldExists));
					break;
				case COUNT:
						System.out.println("There were "+myComp.findCount(myScanner)+" record/s selected.");
					break;
				case SUM:
					System.out.println("The sum of the "+myTSVFilter.getComputedField()+"s was "+myComp.findSum(myScanner, fieldExists));
					break;
				case MOSTLYSAME:
					System.out.println("Mostly the same "+myTSVFilter.getComputedField()+": "+myComp.isMostlySame(myScanner, fieldExists));
					break;	
			}
		}
		myPW.close();
	}
	
	/**
	 * @param line
	 * @param field
	 * @return
	 * records the number of fields in the header line, checks if selected or computed field exists in that file
	 */
	public int checkFirstLine(String line, String field)
	{
		int checkFor = -1;
		String [] fields = line.split("\t");
		this.fields = fields.length;
		for(int x = 0; x< fields.length; x++)
		{
			if(field == null)
				return checkFor;
			if (fields[x].equals(field))
				checkFor = x;
		}
		return checkFor;
	}
	
	/**
	 * @param line
	 * @return
	 * establishes the order of strings and longs needed in the file and makes sure the line has correct number of fields
	 */
	public boolean checkSecondLine(String line)
	{
		String [] records = line.split("\t");
		String found = "System found a ";
		if(records.length!=fields)
			return false;
		else
		{
			for (int x = 0; x<records.length; x++)
			{
				if(isNumber(records[x])){
					order+=0;// stored in a string to allow easy comparison for later lines
					found+="long, ";}
				else{
					order+=1;
					found+="String, ";}
			}
			return true;
		}
	}
	
	/**
	 * @param record
	 * @return
	 * checks if the String is a number or not to establish order
	 * code found on sackoverflow at the link below
	 */
	public boolean isNumber(String record)//https://stackoverflow.com/questions/1102891/how-to-check-if-a-string-is-numeric-in-java
	{
		try{
			double d = Double.parseDouble(record);}
		catch(NumberFormatException x){
			return false;}
		return true;
	}
	
	/**
	 * @param line
	 * @return
	 * checks if line has correct number of fields and then correct order
	 */
	public boolean checkLine(String line)
	{
		String [] checked = line.split("\t");
		String lineOrder = null;
		if (checked.length != fields)
			return false;
		for (int x = 0; x<checked.length; x++)
		{
			if(isNumber(checked[x]))
				lineOrder+=0;
			else
				lineOrder+=1;
		}
		if (lineOrder.equals(order))
			return true;
		else
			return false;
	}
	
	/**
	 * @param line
	 * @param position
	 * @return
	 * sees if selected value exists in the line using the position of the field in the header
	 */
	public boolean checkForSelect(String line, int position)
	{
		if(checkLine(line) == false)
			return false;
		String [] check = line.split("\t");
		if (((String)check[position]).equals(myTSVFilter.getSelectedValue()))
			return true;
		else
			return false;
	}
}
