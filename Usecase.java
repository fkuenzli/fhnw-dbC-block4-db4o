/*
 * Written by Fabian Kuenzli
 * University of Applied Sciences of Northwestern Switzerland, FHNW
 * Computer Science, Software Engineering & Design
 * fabian.kuenzli@gmail.com
 * (c) 2014
 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class Usecase {
	
	private static ObjectContainer db = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		/**
		 * creates new database file
		 *  
		 */
		db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), createTemporaryDatabaseFile().getAbsolutePath());
		
		
		try {
			usecase1();
			usecase2();
			usecase3();
			usecase4();
			
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
	
	public static void usecase1() {
		try {
			System.out.println();
			System.out.println("Usecase 1: Erstelle ein neues Team inkl. Coaches, Spielern und Fans und teile es einem bestehenden Club zu.");
			System.out.println("************************************");
			System.out.println();
			
			Team team = new Team("Handball Brugg 2");
			team.getFans().add(addFan("Marylin", "Kellar"));
			team.getFans().add(addFan("Clayton", "Segers"));
			team.getFans().add(addFan("Loise", "Herd"));
			team.getCoaches().add(addCoach("Oretha","Hendrie",5));
			addPlayer("Steven", "Hunter", 395067, 1.81, 78, "Flügel links",team);
			addPlayer("Larry", "Zimmerman", 532373, 1.98, 101, "Rückraum links",team);
			addPlayer("Darnell", "Garza", 712573, 1.71, 70, "Hinten mitte",team);
			
			db.store(team);
			System.out.println("Added team: " + team.getName());
			System.out.println();
			
			team = new Team ("SV Lägern Wettingen 2");
			team.getFans().add(addFan("Adria", "Shimek"));
			team.getFans().add(addFan("Carole", "Farias"));
			team.getCoaches().add(addCoach("Jennie","Rollison",2));
			addPlayer("Noah", "Cole", 143280, 1.88, 93, "Rückraum rechts",team);
			addPlayer("Floyd", "Mckinney", 487733, 1.91, 95, "Kreis",team);
			
			db.store(team);
			System.out.println("Added team: " + team.getName());
			System.out.println();
			
			team = new Team ("TV Brittnau 1");
			team.getFans().add(addFan("Hyo", "Southerland"));
			team.getFans().add(addFan("Brent", "Sheets"));
			team.getCoaches().add(addCoach("Jolyn","Fenstermaker",2));
			addPlayer("Peter", "Estrada", 360103, 1.77, 65, "Rückraum links",team);
			addPlayer("Woodrow", "Cross", 613561, 1.73, 63, "Flügel rechts",team);
			addPlayer("Kelly", "Jensen", 386101, 1.98, 92, "Rückraum rechts",team);
			
			db.store(team);
			System.out.println("Added team: " + team.getName());
			System.out.println();
			
			team = new Team ("STV Baden 2");
			team.getFans().add(addFan("Zaida", "Begin"));
			team.getFans().add(addFan("Jc", "Calcote"));
			team.getFans().add(addFan("Dianne", "Gilligan"));
			team.getCoaches().add(addCoach("Lucinda","Peet",4));
			addPlayer("Shawn", "Cook", 136187, 1.92, 90, "Rückraum links",team);
			addPlayer("Cedric", "Soto", 334343, 1.69, 69, "Flügel links",team);
			
			db.store(team);
			System.out.println("Added team: " + team.getName());
			System.out.println();
			
			
			Club club = new Club("Handball Brugg");
			club.addTeam(getTeamByName("Handball Brugg 2"));
			db.store(club);
			System.out.println("Added club: " + club.getName());
			
			club = new Club("SV Lägern Wettingen");
			club.addTeam(getTeamByName("SV Lägern Wettingen 2"));
			db.store(club);
			System.out.println("Added club: " + club.getName());
			
			club = new Club("TV Brittnau Handball");
			club.addTeam(getTeamByName("TV Brittnau 1"));
			db.store(club);
			System.out.println("Added club: " + club.getName());
			
			club = new Club("STV Baden");
			club.addTeam(getTeamByName("STV Baden 2"));
			db.store(club);
			System.out.println("Added club: " + club.getName());
			
			db.commit();
			
		} catch(Exception e) {
			db.rollback();
			e.printStackTrace();
		} finally {
			
		}
	}
	
	public static void usecase2() {
		try {
			System.out.println();
			System.out.println("Usecase 2: Lösche einen Coach von einem Team und weise einen neuen zu.");
			System.out.println("************************************");
			System.out.println();
			
			Team team = getTeamByName("Handball Brugg 2");
			Coach coach = getCoachByName("Oretha","Hendrie");
			team.getCoaches().remove(coach);
			System.out.println("Removed coach " + coach.getFirstname() + " " + coach.getLastname() + " from team " + team.getName());
			
			coach = new Coach("Eric","Morales",7);
			team.getCoaches().add(coach);
			System.out.println("Added coach " + coach.getFirstname() + " " + coach.getLastname() + " to team " + team.getName());
			
			db.store(team);
			
			db.commit();
			
		} catch(Exception e) {
			db.rollback();
			e.printStackTrace();
		} finally {
			
		}
	}
	
	
	public static void usecase3() {
		try {
			System.out.println();
			System.out.println("Usecase 3: Liste alle Spieler von [team] auf.");
			System.out.println("************************************");
			System.out.println();
			
			Team team = getTeamByName("TV Brittnau 1");
			
			
			ObjectSet<Player> players = db.query(Player.class);
			ArrayList<Player> playersOfTeam = new ArrayList<Player>();
			
			for(Player player: players) {
				if(player.getTeam() == team) {
					playersOfTeam.add(player);
				}
			}
			
			for(Player player: playersOfTeam) {
				System.out.println(player.getFirstname() + " " + player.getLastname() + " (License ID: " + player.getLicenceID() + "): " + player.getHeight() + "m, " + player.getWeight() + "kg, " + player.getMainPosition());;
			}
			
			db.commit();
			
		} catch(Exception e) {
			db.rollback();
			e.printStackTrace();
		} finally {
			
		}
	}
	
	public static void usecase4() {
		try {
			System.out.println();
			System.out.println("Usecase 4: Change the name of a club");
			System.out.println("************************************");
			System.out.println();
			
			Club club = getClubByName("STV Baden");
			System.out.println("Old name: " + club.getName());
			club.setName("Handballverein Baden");
			System.out.println("New name: " + club.getName());
			
			db.store(club);
			db.commit();
			
		} catch(Exception e) {
			db.rollback();
			e.printStackTrace();
		} finally {
			
		}
	}
	
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public static Team getTeamByName(String name) {
		Team team = new Team(name);
		ObjectSet<Team> teams = db.queryByExample(team);
		
		for(Team teamIter: teams) {
			team = teamIter;
		}
		return team;
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public static Club getClubByName(String name) {
		Club club = new Club(name);
		ObjectSet<Club> clubs = db.queryByExample(club);
		
		for(Club clubIter: clubs) {
			club = clubIter;
		}
		return club;
	}
	
	/**
	 * 
	 * @param firstname
	 * @param lastname
	 * @return
	 */
	public static Fan addFan(String firstname, String lastname) {
		Fan fan = new Fan(firstname, lastname);
		db.store(fan);
		System.out.println("Added fan: " + fan.getFirstname() + " " + fan.getLastname());
		return fan;
	}
	
	/**
	 * 
	 * @param firstname
	 * @param lastname
	 * @param level
	 * @return
	 */
	public static Coach addCoach(String firstname, String lastname, int level) {
		Coach coach = new Coach(firstname, lastname, level);
		db.store(coach);
		System.out.println("Added coach: " + coach.getFirstname() + " " + coach.getLastname());
		return coach;
	}
	
	/**
	 * 
	 * @param firstname
	 * @param lastname
	 * @return
	 */
	public static Coach getCoachByName(String firstname, String lastname) {
		Coach coach = new Coach(firstname, lastname);
		ObjectSet<Coach> coaches = db.queryByExample(coach);
		
		for(Coach coachIter: coaches) {
			coach = coachIter;
		}
		return coach;
	}
	
	/**
	 * 
	 * @param firstname
	 * @param lastname
	 * @param licenceID
	 * @param height
	 * @param weight
	 * @param position
	 * @param team
	 * @return
	 */
	public static Player addPlayer(String firstname, String lastname, int licenceID, double height, double weight, String position, Team team) {
		Player player = new Player(firstname, lastname, licenceID, height, weight, position);
		player.setTeam(team);
		db.store(player);
		System.out.println("Added player: " + player.getFirstname() + " " + player.getLastname());
		return player;
	}
	
	
}
