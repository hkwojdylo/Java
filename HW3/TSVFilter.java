import java.util.*;

/**
 * @author Helen
 * implements builder pattern, mainly just a place to store the info given from the user
 */
public class TSVFilter {
	
	private final String reqName;
	private final String selectedField;
	private final String selectedValue;
	private final String computedField;
	private final Terminal myTerminal;
	
	/**
	 * @param inFile
	 * required parameter of the name of the file
	 * constructor
	 */
	private TSVFilter(WorkingFile inFile)
	{
		reqName = inFile.FileName;
		selectedField = inFile.selectField;
		selectedValue = inFile.selectValue;
		computedField = inFile.computeField;
		myTerminal = inFile.myTerminal;
	}
	
	/**
	 * @return
	 * retrieves the private variable reqName
	 */
	public String getReqName()
	{
		return reqName;
	}
	
	/**
	 * @return
	 * retrieves the private variable selectedField
	 */
	public String getSelectedField()
	{
		return selectedField;
	}
	
	/**
	 * @return
	 * retrieves the private variable selectedValue
	 */
	public String getSelectedValue()
	{
		return selectedValue;
	}
	
	/**
	 * @return
	 * retrieves the private variable computedField
	 */
	public String getComputedField()
	{
		return computedField;
	}
	
	/**
	 * @return
	 * retrieves the private variable Terminal
	 */
	public Terminal getTerminal()
	{
		return myTerminal;
	}
	
	/* 
	 * @overrides
	 * prints out the TSVfilter onto the console
	 */
	public String toString()
	{
		return "TSVFilter\nFileName:\t"+reqName+"\nSelected Field:\t"
				+ selectedField+"\nSelected Value:\t"+selectedValue+"\nComputed Field:\t"
				+computedField+"\nComputed Value:\t"+myTerminal;
	}
	
	/**
	 * @author Helen
	 *the acutal builing of the TSVFilter happens here
	 */
	public static class WorkingFile
	{
		private final String FileName;
		private String selectField;
		private String selectValue;
		private String computeField;
		private Terminal myTerminal;
		
		/**
		 * @param name
		 * required information
		 */
		public WorkingFile(String name)
		{
			FileName = name;
		}
		
		/**
		 * @param field
		 * @param value
		 * @return
		 * option 1 allows for a select of a field and assignment of a value to that select
		 * must have two parameters to call this method
		 */
		public WorkingFile select(String field, String value)
		{
			selectField = field;
			selectValue = value;
			return this;
		}
		
		/**
		 * @param field
		 * @param inTerminal
		 * @return
		 * option 2 allows for a selection of a field to compute on and a terminal computaation stored in an enum
		 */
		public WorkingFile compute(String field, Terminal inTerminal)
		{
			computeField = field;
			myTerminal = inTerminal;
			return this;
		}
		
		/**
		 * @return
		 * returns the TSVFilter
		 */
		public TSVFilter done()
		{
			return new TSVFilter(this);
		}
	}
	
	/**
	 * @author Helen
	 *enum holding the computation names
	 */
	public enum Terminal{
		ALLSAME, COUNT, MIN, MAX, SUM, MOSTLYSAME
	}

}
