import java.io.*;
import java.util.*;

/**
 * @author Helen
 * only used in cmp files
 */
public class Dictionary 
{
	private ArrayList<String> Dictionary;
	
	public Dictionary()
	{
		Dictionary = new ArrayList<String>();
	}
	
	/**
	 * @param addedLine
	 * @return
	 * runs through dict and checks for word before adding
	 * calls on other method in class
	 */
	public ArrayList<String> addToDict(String addedLine)
	{
		String [] line = addedLine.split(" ");
		for (int x = 1; x<= line.length; x++)
		{
			if(!Dictionary.contains(line[x-1]))
			{
			String add = line[x-1];	
			Dictionary.add(add);
			}
		}
		return Dictionary;
	}
	
	/**
	 * @param checkFor
	 * @return
	 * called on by addToDict
	 */
	public int checkDict(String checkFor)
	{
		return Dictionary.indexOf(checkFor);
	}
	
	/**
	 * @return
	 * when printing to a file
	 */
	public String printDict()
	{
		String printedDict = "";
		for(int x =1; x<=Dictionary.size();x++)
		{
			printedDict += Dictionary.get(x-1)+" ";
		}
		return printedDict;
	}
	
	/**
	 * @param dict
	 * @return
	 * for when a file already has one
	 */
	public String printDict(ArrayList dict)
	{
		String printedDict = "";
		for(int x =1; x<=dict.size();x++)
		{
			printedDict += dict.get(x-1)+" ";
		}
		return printedDict;
	}
	
	/**
	 * @param line
	 * @return
	 * retrieves dictionary from cmp file and puts in separate array list than the data
	 */
	public ArrayList<String> getDictFromFile(String line)
	{
		String [] words = line.split(" ");
		for(int x =0; x<words.length; x++)
		{
			Dictionary.add(words[x]);
		}
		return Dictionary;
	}
}
