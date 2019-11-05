package com.vgi.model;

public class VideoGame extends Product{
		//numerical variables
		private int maxPlayers;
		private double consumerRating;
		
		//String variables
		private String title;
		private String developer;
		
		private String genre;
		
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
		 
		@Override
		public String toString() {
			return "Video Game [" + super.toString() +", maxPlayers=" + maxPlayers + ", consumerRating="+ consumerRating+ ", title="+ title + ", developer=" + developer + ",  genre="+ genre+ "]";
		}
}
