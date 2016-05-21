package it.polito.tdp.simulator;

public class Group {
	
	public enum GroupState {GROUP_SIT, GROUP_WAITING, GROUP_GONE}
	
	private int idGroup;
	private int people;
	private int duration;
	private double tolerance;
	private GroupState state;
	private Table table;
	
	public Group(int idGroup, int people, int duration, double tolerance, GroupState state) {
		this.idGroup = idGroup;
		this.people = people;
		this.duration = duration;
		this.tolerance = tolerance;
		this.state = state;
	}

	public int getIdGroup() {
		return idGroup;
	}

	public int getPeople() {
		return people;
	}

	public int getDuration() {
		return duration;
	}

	public double getTolerance() {
		return tolerance;
	}

	public GroupState getState() {
		return state;
	}

	public void setState(GroupState state) {
		this.state = state;
	}

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idGroup;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Group other = (Group) obj;
		if (idGroup != other.idGroup)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Group [idGroup=" + idGroup + ", people=" + people + ", duration=" + duration + ", tolerance="
				+ tolerance + ", state=" + state + "]";
	}

	
	
	

}
