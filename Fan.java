/*
 * Written by Fabian Kuenzli
 * University of Applied Sciences of Northwestern Switzerland, FHNW
 * Computer Science, Software Engineering & Design
 * fabian.kuenzli@gmail.com
 * (c) 2014
 */


import java.util.List;
import java.util.ArrayList;

public class Fan extends Person {
	
	private int personID;
	private List<Team> teams = new ArrayList<Team>();

	public Fan() {
		super();
	}
	
	public Fan(String firstname, String lastname) {
		super(firstname, lastname);
		// TODO Auto-generated constructor stub
	}

	public int getPersonID() {
		return personID;
	}

	public void setPersonID(int personID) {
		this.personID = personID;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
	
}
