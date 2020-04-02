import java.io.*;
import java.util.*;
import java.lang.*;

/**
 * @author Helen
 *
 */
public class Editor extends Dictionary
{
	private int line;
	private ArrayList<String> tempDictionary;
	
	public Editor ()
	{
		line = 0;
		tempDictionary = new ArrayList<String>();
	}
	
	/**
	 * @param dict
	 * for when a cmp file is already created to store the dictionary
	 */
	public Editor (ArrayList<String> dict)
	{
		line = 0;
		tempDictionary = dict;
	}
	
	/**
	 * @return private variable line
	 */
	public int getLineIndex()
	{
		return line;
	}
	
	/**
	 * @param answer
	 * @param file
	 * @param addedLine
	 */
	public void insertLine(String answer, ArrayList file, String addedLine)
	{
		if(answer.equals("txt"))
		{
			file.add(addedLine);
		}else// cmp handling to add line by searching array list for word.
		{
			tempDictionary = addToDict(addedLine);
			String [] newLine = addedLine.split(" ");
			String add = "";
			for (int x =1; x<= newLine.length; x++)
			{
				String check = newLine[x-1];
				int index = checkDict(check);
				add += index+" ";
			}
			file.add(add);
		}
	}
	
	
	/**
	 * @param answer
	 * @param file
	 */
	public void deleteLine(String answer, ArrayList file)
	{
		if(answer.equals("txt"))
		{
			file.remove(line);
			line--;
		}else
		{
			String deleteLine = (String)file.remove(line);
			String[] deletedLine = deleteLine.split(" ");
			for( int y =0; y<file.size(); y++)
			{
				String checkLine = (String)file.get(y);
				String [] checkedLine = checkLine.split(" ");
				for (int x =deletedLine.length-1; x>=0; x--)
				{
					String dWord = deletedLine[x];
					if(!Arrays.asList(checkedLine).contains(dWord))
					{
						tempDictionary.remove(Integer.parseInt(dWord));
					}
				}
			}line --;
		}	
	}
	
	
	/**
	 * @param answer
	 * @param file
	 * @param replaceWithLine
	 */
	public void replaceLine(String answer, ArrayList file, String replaceWithLine)
	{
		if(answer.equals("txt"))
		{
			line--;
			file.set(line, replaceWithLine);
			line++;
		}else// can't just use set because of the dictionary, have to delete and insert
		{
			deleteLine("cmp", file);
			insertLine("cmp", file,replaceWithLine);
			line++;
		}
		
	}
	
	/**
	 * @param answer
	 * @param original
	 * @param newOne
	 * @param file
	 */
	public void replaceWord(String answer, String original, String newOne, ArrayList file)
	{
		if(answer.equals("txt"))
		{
			int max = file.size();
			for(int x = 0; x<max; x++)
			{
				String text = "";
				String line = (String)file.get(x);
				String [] lineArray = line.split(" ");
				for(int y =0; y<lineArray.length; y++)
				{
					if (lineArray[y].equals(original))
					{
						text += newOne+" ";
					}else
					{
						text+= lineArray[y]+" ";
					}
				}
				replaceLine(answer, file, text);
			}
		}else // much easier in cmp file
		{
			int index = tempDictionary.indexOf(original);
			tempDictionary.set(index, newOne);
		}
	}
	
	public void goToTop()
	{
		line = 0;
	}
	
	public void goDownLine()
	{
		line++;
	}
	
	/**
	 * @return
	 * put here because it only worked by being in the editor file, not dictionary
	 */
	public ArrayList getDict()
	{
		return tempDictionary;
	}
}
