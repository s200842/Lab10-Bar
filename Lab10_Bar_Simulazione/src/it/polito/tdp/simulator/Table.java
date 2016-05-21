package it.polito.tdp.simulator;

public class Table {
	
	public enum TableState {TABLE_OCCUPIED, TABLE_UNOCCUPIED}
	
	private int id_table;
	private int capacity;
	private TableState state;
	
	public Table(int id, int cap, TableState state){
		id_table = id;
		capacity = cap;
		this.state = state;
	}

	public int getId_table() {
		return id_table;
	}

	public int getCapacity() {
		return capacity;
	}

	public TableState getState() {
		return state;
	}

	public void setState(TableState state) {
		this.state = state;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_table;
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
		Table other = (Table) obj;
		if (id_table != other.id_table)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Table [id_table=" + id_table + ", capacity=" + capacity + ", state=" + state + "]";
	}

	
	
	

}
