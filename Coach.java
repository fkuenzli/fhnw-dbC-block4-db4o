/*
 * Written by Fabian Kuenzli
 * University of Applied Sciences of Northwestern Switzerland, FHNW
 * Computer Science, Software Engineering & Design
 * fabian.kuenzli@gmail.com
 * (c) 2014
 */


import java.util.List;
import java.util.ArrayList;

public class Coach extends Person {
	private int personID;
	private int level;
	private List<Team> teams = new ArrayList<Team>();
	
	public Coach() {
		
	}
	
	public Coach(String firstname, String lastname, int level) {
		super(firstname, lastname);
		this.level = level;
	}

	public int getPersonID() {
		return personID;
	}

	public void setPersonID(int personID) {
		this.personID = personID;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
}
