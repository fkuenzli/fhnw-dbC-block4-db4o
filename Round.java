/*
 * Written by Fabian Kuenzli
 * University of Applied Sciences of Northwestern Switzerland, FHNW
 * Computer Science, Software Engineering & Design
 * fabian.kuenzli@gmail.com
 * (c) 2014
 */

import java.util.GregorianCalendar;

public class Round {
	private int id;
	private String name;
	private GregorianCalendar startdate;
	private GregorianCalendar enddate;
	private String mode;
	
	public Round() {
		
	}
	
	public Round (String name, GregorianCalendar startdate, GregorianCalendar enddate, String mode) {
		this.name = name;
		this.startdate = startdate;
		this.enddate = enddate;
		this.mode = mode;		
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

	public GregorianCalendar getStartdate() {
		return startdate;
	}

	public void setStartdate(GregorianCalendar startdate) {
		this.startdate = startdate;
	}

	public GregorianCalendar getEnddate() {
		return enddate;
	}

	public void setEnddate(GregorianCalendar enddate) {
		this.enddate = enddate;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

}
