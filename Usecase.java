/*
 * Written by Fabian Kuenzli
 * University of Applied Sciences of Northwestern Switzerland, FHNW
 * Computer Science, Software Engineering & Design
 * fabian.kuenzli@gmail.com
 * (c) 2014
 */

import java.io.File;
import java.io.IOException;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class Usecase {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ObjectContainer db = null;
		db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), createTemporaryDatabaseFile().getAbsolutePath());
		try {
			
			createTestData(db);
			usecase1(db);
			
		} catch(Exception e) {
			
			e.printStackTrace();
		} finally {
			if(db != null) {
				db.close();
			}			
		}
		
	}
	
	/**
	 * due to createTemporaryDatabaseFile() there is always an empty database at every run
	 * 
	 * @return
	 */
	public static File createTemporaryDatabaseFile() {
		File database = null;
		
		try {
			database = File.createTempFile("dbC_Projekt_4", "db");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return database;
	}
	
	/**
	 * 
	 * @param db
	 */
	public static void createTestData(ObjectContainer db) {
		try {
			Team team = new Team("Handball Brugg 2");
			team.getFans().add(new Fan("Marylin", "Kellar"));
			team.getFans().add(new Fan("Clayton", "Segers"));
			team.getFans().add(new Fan("Loise", "Herd"));
			db.store(team);
			
			team = new Team ("SV Lägern Wettingen 2");
			team.getFans().add(new Fan("Adria", "Shimek"));
			team.getFans().add(new Fan("Carole", "Farias"));
			db.store(team);
			
			team = new Team ("TV Brittnau 1");
			team.getFans().add(new Fan("Hyo", "Southerland"));
			team.getFans().add(new Fan("Brent", "Sheets"));
			db.store(team);
			
			team = new Team ("STV Baden 2");
			team.getFans().add(new Fan("Zaida", "Begin"));
			team.getFans().add(new Fan("Jc", "Calcote"));
			team.getFans().add(new Fan("Dianne", "Gilligan"));
			db.store(team);
			
			
			Club club = new Club("Handball Brugg");
			club.addTeam(getTeamByName(db,"Handball Brugg 2"));
			db.store(club);
			
			club = new Club("SV Lägern Wettingen");
			club.addTeam(getTeamByName(db,"SV Lägern Wettingen 2"));
			db.store(club);
			
			club = new Club("TV Brittnau Handball");
			club.addTeam(getTeamByName(db,"TV Brittnau 1"));
			db.store(club);
			
			club = new Club("STV Baden");
			club.addTeam(getTeamByName(db,"STV Baden 2"));
			
			
			/*			
			db.store(new Coach("Oretha","Hendrie",5));
			db.store(new Coach("Jennie","Rollison",2));
			db.store(new Coach("Jolyn","Fenstermaker",2));
			db.store(new Coach("Lucinda","Peet",4));
			
			db.store(new Player("Steven", "Hunter", 395067, 1.81, 78, "Flügel links"));
			db.store(new Player("Larry", "Zimmerman", 532373, 1.98, 101, "Rückraum links"));
			db.store(new Player("Darnell", "Garza", 712573, 1.71, 70, "Hinten mitte"));
			db.store(new Player("Noah", "Cole", 143280, 1.88, 93, "Rückraum rechts"));
			db.store(new Player("Floyd", "Mckinney", 487733, 1.91, 95, "Kreis"));
			db.store(new Player("Peter", "Estrada", 360103, 1.77, 65, "Rückraum links"));
			db.store(new Player("Woodrow", "Cross", 613561, 1.73, 63, "Flügel rechts"));
			db.store(new Player("Kelly", "Jensen", 386101, 1.98, 92, "Rückraum rechts"));
			db.store(new Player("Shawn", "Cook", 136187, 1.92, 90, "Rückraum links"));
			db.store(new Player("Cedric", "Soto", 334343, 1.69, 69, "Flügel links"));
			*/
								
			db.commit();
			
		} catch(Exception e) {
			db.rollback();
			e.printStackTrace();
		} finally {
			
		}
		
	}
	
	/**
	 * 
	 * @param db
	 */
	public static void usecase1(ObjectContainer db) {
		try {
			
			/*
			 * do some database manipulations
			 * ...
			 * 
			 * 
			 * db.store(OBJECT);
			 * 
			*/
			
			db.commit();
			
		} catch(Exception e) {
			db.rollback();
			e.printStackTrace();
		} finally {
			
		}
	}
	
	/**
	 * 
	 * @param db
	 * @param name
	 * @return
	 */
	public static Team getTeamByName(ObjectContainer db, String name) {
		Team team = new Team(name);
		ObjectSet<Team> teams = db.queryByExample(team);
		
		for(Team teamIter: teams) {
			team = teamIter;
		}
		return team;
	}
}
