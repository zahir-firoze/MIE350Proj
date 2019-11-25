package courseSystem.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Methods and fields required to input data and interpret arguments from the
 * data files
 * <p>
 * <tt> fileDir </tt> - a <tt>String</tt> containing location of the file to be
 * input from <br>
 * <tt> line </tt> - a <tt>String</tt> containing most recent line read from
 * input file <br>
 * <tt> arguments </tt> - a <tt>String array</tt> containing arguments parsed
 * from most recent line <br>
 * <tt> lineIndex </tt> - a <tt>int</tt> containing the current line in the
 * input file the reader is on <br>
 * <tt> isOpen </tt> - a <tt>boolean</tt> indicating if the file has been
 * successfully opened <br>
 * <tt> iFile </tt> - a <tt>BufferedReader</tt> containing all information in
 * input file
 */
public class Input {
	private String fileDir;
	private String line;
	private String[] arguments;
	private int lineIndex = 1;
	private boolean isOpen;
	protected BufferedReader iFile;

	/**
	 * 
	 * @param fileDir
	 *            - <tt>String</tt> containing location of input file
	 */
	public Input(String fileDir) {
		this.fileDir = fileDir;
	}

	/**
	 * Initiates <tt>iFile</tt> with contents of input file
	 * 
	 * @throws <tt>IOException</tt>
	 *             for error opening file and buffering contents
	 * @throws <tt>NumberFormatException</tt>
	 *             for error converting number of lines to <tt>int</tt> from
	 *             <tt>String</tt>
	 */
	public void open() {
		try {
			FileReader iTemp = new FileReader(fileDir);
			iFile = new BufferedReader(iTemp);
			isOpen = true;
		} catch (IOException e) {
			throw new CMSError("Error opening file " + fileDir + " for input");
		} catch (NumberFormatException e) {
			throw new CMSError("Error converting number of lines in input file " + fileDir + " to int");
		}
	}

	/**
	 * Closes <tt>iFile</tt>
	 * 
	 * @throws <tt>IOException</tt>
	 *             for error closing file
	 */
	public void close() {
		try {
			iFile.close();
			isOpen = false;
		} catch (IOException e) {
			throw new CMSError("Error: Attempted to close input file " + fileDir + " that was not open");
		}
	}

	/**
	 * Retrieves a new line of text from <tt>iFile</tt> and stores in
	 * <tt>line</tt>. Returns <tt>true</tt> if there was a line remaining to
	 * retrieve
	 * 
	 * @throws <tt>IOException</tt>
	 *             for error reading line
	 * 
	 * @return <tt>boolean</tt> indicating success of retrieval attempt
	 */
	public boolean newLine() {
		try {
			if ((line = iFile.readLine()) != null) {
				lineIndex++;
				return true;
			} else
				return false;
		} catch (IOException e) {
			throw new CMSError("Error attempting to read new line from input file " + fileDir + " line " + lineIndex);
		}
	}

	/**
	 * Parses the arguments contained in <tt>line</tt> and stores each one
	 * independently in <tt>arguments</tt>. Arguments are delimited by commas
	 * (",")
	 * 
	 * @return <tt>Iterator</tt> - which iterates over the arguments
	 */
	public Iterator grabArgs() {
		if (isOpen) {
			arguments = line.split(",");
			return Arrays.asList(arguments).iterator();
		} else {
			throw new CMSError("Error: Attempted to retrieve arguments from unopened input file " + fileDir);
		}
	}

	/**
	 * @param pos
	 *            - <tt>int</tt> containing position in <tt>arguments</tt> of
	 *            desired argument
	 * @return <tt>String</tt> containing desired argument if <tt>pos</tt> is
	 *         within <tt>arguments</tt>
	 */
	public String getArg(int pos) {
		if (isOpen) {
			if (pos < arguments.length)
				return arguments[pos];
			else {
				throw new CMSError(
						"Error: Specified index for Input.getArg(int pos) that was out of bounds. For " + fileDir);
			}
		} else {
			throw new CMSError("Error: Attempted to get argument from unopened input file " + fileDir);
		}
	}

	/**
	 * @return <tt>int</tt> containing length of <tt>arguments</tt>
	 */
	public int numArgs() {
		if (isOpen)
			return arguments.length;
		else {
			throw new CMSError("Error: Attempted to get number of arguments from unopened input file " + fileDir);
		}
	}

	/**
	 * @return <tt>int</tt> containing current line in the input file the reader
	 *         is on
	 */
	public int getLineIndex() {
		if (isOpen)
			return lineIndex;
		else {
			throw new CMSError("Error: Attempted to get line index from unopened input file " + fileDir);
		}
	}

	/**
	 * @return <tt>String</tt> containing location of input file
	 */
	public String getFileDir() {
		return fileDir;
	}

	/**
	 * 
	 * @return <tt>String</tt> containing most recent read line from input file
	 */
	public String getLine() {
		return line;
	}
}
