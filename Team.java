/*
 * Written by Fabian Kuenzli
 * University of Applied Sciences of Northwestern Switzerland, FHNW
 * Computer Science, Software Engineering & Design
 * fabian.kuenzli@gmail.com
 * (c) 2014
 */

import java.util.List;
import java.util.ArrayList;

public class Team {
	private int teamid;
	private String name;
	private int clubID;
	private List<Fan> fans = new ArrayList<Fan>();
	private List<Coach> coaches = new ArrayList<Coach>();
	
	public Team() {
		
	};
	
	public Team(String name) {
		this.name = name;
	}
	
	public Team(String name, List<Coach> coaches) {
		this.name = name;
		this.setCoaches(coaches);
	}

	public int getId() {
		return teamid;
	}

	public void setId(int id) {
		this.teamid = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Fan> getFans() {
		return fans;
	}

	public void setFans(List<Fan> fans) {
		this.fans = fans;
	}

	public List<Coach> getCoaches() {
		return coaches;
	}

	public void setCoaches(List<Coach> coaches) {
		this.coaches = coaches;
	}

	public int getClubID() {
		return clubID;
	}

	public void setClubID(int clubID) {
		this.clubID = clubID;
	}
}
