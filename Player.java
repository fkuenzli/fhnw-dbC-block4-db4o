/*
 * Written by Fabian Kuenzli
 * University of Applied Sciences of Northwestern Switzerland, FHNW
 * Computer Science, Software Engineering & Design
 * fabian.kuenzli@gmail.com
 * (c) 2014
 */

public class Player extends Person {
	
	private int personID;
	private int licenceID;
	private double height;
	private double weight;
	private String mainPosition;
	private Team team;
	
	public Player() {
		
	}
	
	public Player(String firstname, String lastname) {
		super(firstname, lastname);
	}
	
	public Player(String firstname, String lastname, int licenceID, double height, double weight, String mainPosition) {
		super(firstname, lastname);
		this.licenceID = licenceID;
		this.height = height;
		this.weight = weight;
		this.mainPosition = mainPosition;
	}
	
	public int getPersonID() {
		return personID;
	}

	public void setPersonID(int personID) {
		this.personID = personID;
	}
	
	public int getLicenceID() {
		return licenceID;
	}

	public void setLicenceID(int licenceID) {
		this.licenceID = licenceID;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getMainPosition() {
		return mainPosition;
	}

	public void setMainPosition(String mainPosition) {
		this.mainPosition = mainPosition;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
}
