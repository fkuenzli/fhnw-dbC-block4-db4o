/*
 * Written by Fabian Kuenzli
 * University of Applied Sciences of Northwestern Switzerland, FHNW
 * Computer Science, Software Engineering & Design
 * fabian.kuenzli@gmail.com
 * (c) 2014
 */

import java.util.GregorianCalendar;


public class Game {
	private int id;
	private GregorianCalendar starttime;
	private String location;
	private Team teamHome;
	private Team teamAway;
	private Round round;
	
	public Game() {
		
	}
	
	public Game(GregorianCalendar starttime, String location) {
		this.starttime = starttime;
		this.location = location;
	}
	
	public Game(GregorianCalendar starttime, String location, Team teamHome, Team teamAway) {
		this.starttime = starttime;
		this.location = location;
		this.teamHome = teamHome;
		this.teamAway = teamAway;
	}

	public GregorianCalendar getStarttime() {
		return starttime;
	}

	public void setStarttime(GregorianCalendar starttime) {
		this.starttime = starttime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Team getTeamHomeId() {
		return teamHome;
	}

	public void setTeamHomeId(Team teamHome) {
		this.teamHome = teamHome;
	}

	public Team getTeamAwayId() {
		return teamAway;
	}

	public void setTeamAwayId(Team teamAway) {
		this.teamAway = teamAway;
	}

	public Round getRoundID() {
		return round;
	}

	public void setRoundID(Round round) {
		this.round = round;
	}
	
	
}
