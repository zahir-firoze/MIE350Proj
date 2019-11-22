package com.vgi.model;

import java.sql.Date;



public class VideoGame extends Product{
		//numerical variables
		private int maxPlayers;
		private double consumerRating;
		
		//String variables
		private String title;
		private String developer;
		private String console;
		
		private String genre;
		private String esrbRating;
		
		//date variable
		private Date releaseDate;
		
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
		
		public String getConsole(){
			return console;
		}
		
		
		public String getGenre(){
			return genre;
		}
		
		public String getEsrbRating(){
			return esrbRating;
		}
		

		public Date getReleaseDate(){
			return releaseDate;
		}
		//**Setter methods
		public void setMaxPlayers(int maxPlayers){
			this.maxPlayers = maxPlayers;
		}
		

		public void setConsumerRating(double consumerRating){
			this.consumerRating = consumerRating;
		}
		
		public void setTitle(String title){
			this.title = title;
		}
		
		public void setDeveloper(String developer){
			this.developer = developer;
		}
		
		public void setConsole(String console ){
			this.console = console;
		}
		
		
		public void setGenre(String genre){
			this.genre = genre;
		}
		
		public void setEsrbRating(String esrbRating){
			this.esrbRating = esrbRating;
		}
		

		
		public void setReleaseDate(Date releaseDate){
			this.releaseDate = releaseDate;
		}

		@Override
		public String toString() {
			return "Video Game [" + super.toString() +", console=" + console +", maxPlayers=" + maxPlayers + ", consumerRating="+ consumerRating+ ", title="+ title + ", developer=" + developer + ",  genre="+ genre+ ", releaseDate="+ releaseDate+ ", esrbRating="+ esrbRating +"]";
		}
}
