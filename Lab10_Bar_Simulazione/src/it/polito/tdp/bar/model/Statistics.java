package it.polito.tdp.bar.model;

import it.polito.tdp.simulator.Core;

public class Statistics {
	
	private Core sim;

	public Statistics(Core sim){
		this.sim = sim;
	}
	
	public int getCustomers(){
		return sim.getnCustomers();
	}
	
	public int getSatisfied(){
		return sim.getnSatisfied();
	}
	
	public int getUnsatisfied(){
		return sim.getnUnsatisifed();
	}

}
