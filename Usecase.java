import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

/*
 * Written by Fabian Kuenzli
 * University of Applied Sciences of Northwestern Switzerland, FHNW
 * Computer Science, Software Engineering & Design
 * fabian.kuenzli@gmail.com
 * (c) 2014
 */


public class Usecase {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ObjectContainer db = null;
		db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "dbC_Projekt_4.db");
		try {
			
			createTestData(db);
			
			/*
			 * usecases
			 * 
			 * 
			*/
			
		} catch(Exception e) {
			
			e.printStackTrace();
		} finally {
			if(db != null) {
				db.close();
			}			
		}
		
	}
	
	/**
	 * 
	 * @param db
	 */
	public static void createTestData(ObjectContainer db) {
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
