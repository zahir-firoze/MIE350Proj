Log Format: MM/DD/YYYY,Name,description of changes;
please put this line for each day of changes
=======================================================================================================================================
10/18/2019,Ciel, created basic structure of object classes  and List classes under videoGame.model package; created the eclipse project;
=======================================================================================================================================
10/31/2019,Ciel, created new dynamic web project in eclipse for this project; All back end code is in Java resources; images for front end is in web content; created and updated the web.xml accordingly with the servlet information for this project;
=======================================================================================================================================
11/11/2019,Ciel, added filter functionality in the accessories; made a new database called "GameCheck.mdb" and put it in the db.properties; modified AccessoryController, Accessory and AccessoryDao; added a test jsp called "TEST_displayFilterResults"; copied all contents from the lib folder in sample web app into videoGameWebApp; added jars to webcontent lib folder
=======================================================================================================================================
11/12/2019,Ciel, added filter functionality in the videgame classes (VideoGame, VideoGameDao, VideoGame); removed consoleCompatability member from product; added getters and setters for VideoGame attributes; added dynamic table for videogame filter results in TEST_displayFilterResults.jsp and added a line that shows the filters applied for both videogames and accessories
=======================================================================================================================================
11/16/2019,Ciel; made jsp file for the homepage; made the welcoming page the hompage.jsp in the web.xml file; added some content into the doPost method in VideoGameController to test getting parameter values from JSP files;
=======================================================================================================================================
11/18/2019,Ciel; Added a new package called tuple which holds objects used for filters that require bounds;
created an accessory page that will be accessed from the navbar;
NavBar was changed, "All Products" -> Video Games;
In HomePage.jsp, imported NavBar.jsp, removed the accessories section, fixed image references by adding "img/";
In VideoGameDAO, getFilterVideoGames() had many if statements to deal with the different type of objects stored to perform the filter funtion and formatting the SQL query correctly;
In VideoGameController, the inputs from the VideoGameFilter form were processed and saved into appropriate objects from the package vgi.com.tuples and packaged into a nice hashmap;
Added the new package "constants" to store the price ranges from the dropdown filters on the VideoGame Page;
======================================================================================================================================
11/18/2019,Ciel; GameCheck.mdb: changed the imageFileName in VideoGames table and added imageFileName column in accessories; deleted FilterResults and replaced it with FilterResults_VideoGame.jsp and FilterResults_Accessory.jsp; Made jsp files for the filter bars for both Accessory and Videogame; changed PriceRange output for oneSidedLimit;
======================================================================================================================================
11/18/2019; Ciel; made alot of jsp files for the two different filters (accessory and videogame), formatted the filter results pages too; new accessories can be filtered
