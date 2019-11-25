package videoGame.model;

import java.util.NoSuchElementException;

public class VideoGame extends Product{

	//numerical variables
	private int maxPlayers;
	private double consumerRating;
	
	//String variables
	private String title;
	private String developer;
	
	private String genre;
	
	
	/*
	 * TODO 
	 * Decide what object releaseDate should be
	 */
	private String releaseDate;
	
	/**
	 * Obtains values for VideoGame object
	 * respectively, contained in <tt>Main.dataInput</tt> 
	 *
	 * @param args - <tt>Iterator</tt> containing arguments from data files
	 * TODO fix error thrown
	 * @throws <tt>CMSError</tt> for error converting ID number to 
	 * <tt>int</tt> from <tt>String</tt> 
	 */
	public void readData (int vUpcNumber, int vMaxPlayers,  double vPrice, double vConsumerRating,String vTitle,String vDeveloper, String vConsoleCompatability, String vGenre,String vDescription,String vReleaseDate) {
		try {
			super.readData(vUpcNumber, vPrice, vConsoleCompatability,vDescription);
			
			this.maxPlayers = vMaxPlayers;
			this.consumerRating = vConsumerRating;
			this.title = vTitle;
			this.developer = vDeveloper; 
			this.genre = vGenre;
			
			
			/*
			 * TODO 
			 * Decide what object releaseDate should be
			 */
			this.releaseDate = vReleaseDate;
		}
		catch (NoSuchElementException e) {
			throw new CMSError("Not enough attributes for Video Game");
		}
	}
	
	//TODO: Rewrite the getOutputLine() and displayInfo() methods
//
//	/**
//	 * 
//	 * @return <tt>String</tt> with person's ID number, last name, first name, and email, 
//	 * in the same format as the input file
//	 */
//	public String getOutputLine () {
	
//		return super.getOutputLine() + ;
//	}
//	
//	/** 
//	 * Prints person's name and email to the log file
//	 *
//	 */
//	public void displayInfo () {
//		super.displayInfo();
//		Main.logFile.write(" - Last Name: " + lastName);
//		Main.logFile.write(" - First Name: " + firstName);
//		Main.logFile.write(" - Email: " + email);
//	}
//	
	
	public int getMaxPlayers(){
		return maxPlayers;
	}
	

	public double getConsumerRating(){
		return consumerRating;
	}
	
	public String getTitle(){
		return title;
	}
	
	public String getDeveloper(){
		return developer;
	}
	
	
	
	public String getGenre(){
		return genre;
	}
	
	
	
	
}
