package it.polito.tdp.simulator;

public class Event implements Comparable<Event>{
	
	public enum EventType {GROUP_ARRIVES, GROUP_LEAVES };
	
	private long time;
	private EventType type;
	private int id;

	public Event(long time, EventType type, int id) {
		this.time = time;
		this.type = type;
		this.id = id;
	}

	public EventType getType() {
		return type;
	}

	public void setType(EventType type) {
		this.type = type;
	}

	public long getTime() {
		return time;
	}

	public int getId() {
		return id;
	}

	@Override
	public int compareTo(Event arg0) {
		return Long.compare(this.time, arg0.time);
	}

	@Override
	public String toString() {
		return "Event [time=" + time + ", type=" + type + ", id=" + id + "]";
	}

	
}
