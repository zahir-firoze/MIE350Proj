package courseSystem.model;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Methods and fields required to output data to a file
 * <p>
 * <tt> fileDir </tt> - <tt>String</tt> containing location of the file to be output to
 * <br>
 * <tt> isOpen </tt> - <tt>boolean</tt> indicating if the file has been successfully opened
 * <br>
 * <tt> oFile </tt> - <tt>PrintWriter</tt> used to print text in the output file
 * <br>
 */
public class Output {
	private String fileDir;
	private boolean isOpen;
	protected PrintWriter oFile;
	
	/**
	 * 
	 * @param fileDir - <tt>String</tt> containing location of the output file
	 */
	public Output (String fileDir) {
		this.fileDir = fileDir;
	}
	
	/**
	 * Opens file for output
	 * 
	 * @throws <tt>IOException</tt> for error opening file
	 */
	public void open () {
		try {
			FileWriter oTemp = new FileWriter (fileDir);
			oFile = new PrintWriter(oTemp);
			isOpen = true;
		}
		catch(IOException e) {
			throw new CMSError("Error opening file " + fileDir + " for output:" + e.getMessage());
		}
	}
	
	/**
	 * Closes output file
	 */
	public void close () {
		if (isOpen) {
			oFile.close();
			isOpen = false;
			}
		else 
			throw new CMSError("Error: Attempted to close output file " + fileDir + " that was not open");
			
	}
	
	/**
	 * Writes new line to output file
	 * 
	 * @param msg - <tt>String</tt> containing message to write
	 */
	public void write (String msg) {
		if (isOpen)	{
			oFile.println(msg);
		}
		else
			throw new CMSError("Error: Attempted to write output to file " + fileDir + " that was not open");
	}
	
	public boolean isOpen () {
		return isOpen;
	}
}
