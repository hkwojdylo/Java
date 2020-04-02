import java.io.*;
import java.util.*;


/**
 * @author Helen
 *
 */
public class Choice {
	
	private Scanner myScanner;
	private ArrayList<String> File;
	private Directory myDirectory;
	private Editor myEditor;
	private Printer myPrinter;
	private String fileName;
	
	public Choice()
	{
		myScanner = new Scanner(System.in);
		File = new ArrayList<String>();
		myDirectory = new Directory();
		myEditor = new Editor();
		myPrinter = new Printer();
		fileName = null;
	}
	
	/**
	 * @param answer
	 * @param choice
	 * @throws IOException
	 */
	public void makeChoice(String answer, String choice) throws IOException // simply calls on needed mehtods to edit fil
	{
		String command = choice.substring(0,1);
		if (command.equals("g"))
		{
			if(answer.equals("txt"))
			{
				if(choice.length()>1)
				{
					File = myDirectory.getFile(answer, choice.substring(2));
				}else
				{
					File = myDirectory.getFile();
				}
			}else
			{
				if(choice.length()>1)
				{	
				fileName = choice.substring(2);
				File = myDirectory.getFile(answer, fileName);
				ArrayList<String> dict = myEditor.getDictFromFile(myDirectory.getFirstLine(fileName));
				myEditor = new Editor(dict);
				myEditor.goDownLine();
				}else
				{
					File = myDirectory.getFile();
				}
			}
		}
		if (command.equals("p"))
		{
			if(answer.equals("txt"))
			{
				myPrinter.printTxtFile(File);
			}else
			{
				myPrinter.printCmpFile(File, myEditor.getDict());
			}
		}
		if (command.equals("c"))
		{
			if(answer.equals("txt"))
			{
				myPrinter.printTxtLine(File, myEditor.getLineIndex());
			}else
			{
				myPrinter.printCmpLine(File, myEditor.getLineIndex(), myEditor.getDict());
			}
		}
		if (command.equals("i"))
		{
			myEditor.insertLine(answer, File, choice.substring(2));
		}
		if (command.equals("d"))
		{
			myEditor.deleteLine(answer, File);
		}
		if (command.equals("r"))
		{
			myEditor.replaceLine(answer, File, choice.substring(2));
		}
		if (command.equals("w"))
		{
			System.out.println("What word would you like to replace?");
			String original = myScanner.nextLine();
			System.out.println("Replace it with what?");
			String newOne = myScanner.nextLine();
			myEditor.replaceWord(answer, original, newOne, File);
		}
		if (command.equals("t"))
		{
			myEditor.goToTop();
		}
		if (command.equals("v"))
		{
			myEditor.goDownLine();
		}
		if (command.equals("s"))
		{
			if(answer.equals("txt"))
			{
				if (choice.length()>1)
				{
					myDirectory.setTxtFile(choice.substring(2), File);
				}else
				{
					myDirectory.setTxtFile(fileName, File);
				}
			}else
			{
				if (choice.length()>1)
				{
					myDirectory.setCmpFile(choice.substring(2), File, myEditor.getDict());
					myEditor = new Editor();
				}else
				{
					myDirectory.setCmpFile(fileName, File, myEditor.getDict());
					myEditor = new Editor();
				}
			}
		}
	}

}
