package it.polito.tdp.simulator;

public class Group {
	
	private int idGroup;
	private int people;
	private int duration;
	private double tolerance;
	
	public Group(int idGroup, int people, int duration, double tolerance) {
		this.idGroup = idGroup;
		this.people = people;
		this.duration = duration;
		this.tolerance = tolerance;
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
				+ tolerance + "]";
	}
	
	

}
