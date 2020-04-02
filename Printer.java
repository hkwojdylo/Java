import java.util.*;


/**
 * @author Helen
 *
 */
public class Printer 
{
	public Printer(){
	}
	
	/**
	 * @param file
	 * easy to print txt file
	 */
	public void printTxtFile(ArrayList file)
	{
		for(int x = 0; x<file.size(); x++)
		{
			System.out.println(file.get(x));
		}
			
	}
	
	/**
	 * @param file
	 * @param dict
	 * have to call dictionary and run through it to print, harder that txt
	 */
	public void printCmpFile(ArrayList file, ArrayList dict)
	{
		for(int x = 0; x<file.size(); x++)
		{
			String printedLine = "";
			String toPrint = (String)file.get(x);
			String [] print = toPrint.split(" ");
			for (int y =0; y<print.length; y++)
			{
				int index = Integer.parseInt(print[y]);
				printedLine += dict.get(index)+" ";
			}
			System.out.println(printedLine);
		}		
	}
	
	/**
	 * @param file
	 * @param line
	 * easy in txt
	 */
	public void printTxtLine (ArrayList file, int line)
	{
		System.out.println(file.get(line));
	}
	
	/**
	 * @param file
	 * @param line
	 * @param dict
	 * harder in cmp because have to call on dictionary
	 */
	public void printCmpLine (ArrayList file, int line, ArrayList dict)
	{
		String printedLine ="";
		String toPrint = (String)(file.get(line));
		String [] print = toPrint.split(" ");
		for (int y =0; y<print.length; y++)
		{
			int index = Integer.parseInt(print[y]);
			printedLine += dict.get(index)+" ";
		}
		System.out.println(printedLine);
	}
	
}
