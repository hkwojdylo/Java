import java.io.*;
import java.util.*;

/**
 * @author Helen
 *
 */
public class Directory
{
	private File txtDirectory = new File("C:/TxtDirectory");
	private File cmpDirectory = new File("C:/CmpDirectory");
	private Editor myEditor = new Editor();
	private Dictionary myDict = new Dictionary();
	public Directory ()
	{
		cmpDirectory.setWritable(true);
		cmpDirectory.setExecutable(true);
		cmpDirectory.setReadable(true);
		txtDirectory.setWritable(true);
		txtDirectory.setExecutable(true);
		txtDirectory.setReadable(true);
		txtDirectory.mkdir();
		cmpDirectory.mkdir();
	}
	
	/**
	 * @return
	 * creates an empty unused file represented by an ArrayList of Strings
	 * 	reason for AL of Strings: it was easiest to visualize and maneuver. Had good methods I could use that applied to the use case
	 */
	public ArrayList<String> getFile()
	{
		ArrayList<String> unNamedFile = new ArrayList<String>();
		return unNamedFile;
	}
	
	/**
	 * @param answer
	 * @param name
	 * @return file created with specific directory and fills an array list with the data
	 * @throws IOException
	 */
	public ArrayList<String> getFile(String answer, String name) throws IOException
	{
		if (answer.equals("txt"))
		{
			Scanner reader = new Scanner(new File("C:/TxtDirectory"+name+".txt"));
			ArrayList<String> retrieved = new ArrayList<String>();
			while(reader.hasNextLine())
			{
				retrieved.add(reader.nextLine());
			}
			reader.close();
			return retrieved;
		}else
		{
			Scanner reader = new Scanner(new File("C:/CmpDirectory"+name+".cmp"));
			ArrayList<String> retrieved = new ArrayList<String>();
			reader.nextLine();// skips line of the dictionary
			while(reader.hasNextLine())
			{
				retrieved.add(reader.nextLine());
			}
			reader.close();
			return retrieved;
		}
	}
	
	/**
	 * @param name
	 * @return
	 * @throws IOException
	 */
	public String getFirstLine(String name)throws IOException
	{
		Scanner reader = new Scanner(new File("C:/CmpDirectory"+name+".cmp"));
		return (String)reader.nextLine();
	}
	
	/**
	 * @param name
	 * @param file
	 * @throws IOException
	 * sends file to C drive
	 */
	public void setTxtFile(String name, ArrayList file) throws IOException
	{
		File FileName = new File("C:/TxtDirectory"+name+".txt");
		FileName.createNewFile();
		PrintWriter pw = new PrintWriter(FileName);
		for (int y = 0; y<file.size(); y++)
		{
			String text = null;
			text = ""+file.get(y);
			pw.println(text);
		}
		pw.close();
	}
	
	/**
	 * @param name
	 * @param file
	 * @param dict
	 * @throws IOException
	 * sends file to C drive
	 */
	public void setCmpFile(String name, ArrayList file, ArrayList dict) throws IOException 
	{
		File FileName = new File("C:/CmpDirectory"+name+".cmp");
		FileName.createNewFile();
		PrintWriter pw = new PrintWriter(FileName);
		String fileDict= myDict.printDict(dict);
		pw.println(fileDict);
		for (int y = 0; y<file.size(); y++)
		{
			String text = null;
			text = ""+file.get(y);
			pw.println(text);
		}
		pw.close();
	}
	//files created: txt: RunTrial1-57 bytes, RunTrial2-79 bytes, RunTrial3-55 bytes, RunTrial4-36 bytes, RunTrial5-154 bytes
		//files created: cmp: cmpTrial1-62 bytes, cmpTrial2-26 bytes, cmpTrial3-56 bytes, cmpTrial4-57 bytes, cmpTrial6-128 bytes
		//files (pairs: run2 with cmp1, run4 with cmp4, run5 with cmp6)
	
}
