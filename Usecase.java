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
	 * due to createTemporaryDatabaseFile there is always an empty database at every run
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
			
			db.store(new Club("Handball Brugg"));
			db.store(new Club("SV Lägern Wettingen"));
			db.store(new Club("TV Brittnau Handball"));
			db.store(new Club("STV Baden"));
			
			db.store(new Team("Handball Brugg 2"));
			db.store(new Team("SV Lägern Wettingen 2"));
			db.store(new Team("TV Brittnau 1"));
			db.store(new Team("STV Baden 2"));
			
			db.store(new Coach("Oretha","Hendrie",5));
			db.store(new Coach("Jennie","Rollison",2));
			db.store(new Coach("Jolyn","Fenstermaker",2));
			db.store(new Coach("Lucinda","Peet",4));
			
			db.store(new Fan("Marylin", "Kellar"));
			db.store(new Fan("Clayton", "Segers"));
			db.store(new Fan("Loise", "Herd"));
			db.store(new Fan("Adria", "Shimek"));
			db.store(new Fan("Carole", "Farias"));
			db.store(new Fan("Hyo", "Southerland"));
			db.store(new Fan("Brent", "Sheets"));
			db.store(new Fan("Dianne", "Gilligan"));
			db.store(new Fan("Zaida", "Begin"));
			db.store(new Fan("Jc", "Calcote"));
			
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
}
