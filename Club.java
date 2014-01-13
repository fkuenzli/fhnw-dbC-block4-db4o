/*
 * Written by Fabian Kuenzli
 * University of Applied Sciences of Northwestern Switzerland, FHNW
 * Computer Science, Software Engineering & Design
 * fabian.kuenzli@gmail.com
 * (c) 2014
 */

import java.util.List;
import java.util.ArrayList;

public class Club {
	private int id;
	private String name;
	private List<Team> teams = new ArrayList<Team>();
	
	public Club() {
		super();
	}
	
	public Club(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
	
	public void addTeam(Team team) {
		this.teams.add(team);
	}
	
	

}
