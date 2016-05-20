package it.polito.tdp.bar.model;

import java.util.concurrent.ThreadLocalRandom;

import it.polito.tdp.simulator.Core;
import it.polito.tdp.simulator.Event;
import it.polito.tdp.simulator.Event.EventType;
import it.polito.tdp.simulator.Group;

public class BarModel {

	private Core simulator = new Core();
	
	public void simulate(){
		//Generazione coda di 2000 eventi casuali
		for(int i=0; i<2000; i++){
			int dimension = ThreadLocalRandom.current().nextInt(1, 11);
			int duration = ThreadLocalRandom.current().nextInt(60, 121);
			double tolerance = ThreadLocalRandom.current().nextDouble();
			Group g = new Group(i+1, dimension, duration, tolerance);
			simulator.addGroup(g);
			long interval = ThreadLocalRandom.current().nextInt(1, 11);
			simulator.addEvent(new Event(interval, EventType.GROUP_ARRIVES, i+1));
		}
		simulator.simulate();
	}
	
}
