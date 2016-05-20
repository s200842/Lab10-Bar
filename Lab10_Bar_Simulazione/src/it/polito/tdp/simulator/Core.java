package it.polito.tdp.simulator;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Core {

	Queue<Event> eventList = new PriorityQueue<Event>();
	Map<Integer, Group> groups = new HashMap<Integer, Group>();
	
	public void addEvent(Event e){
		eventList.add(e);
	}
	
	public void addGroup(Group g){
		groups.put(g.getIdGroup(), g);
	}
	
	//Passo() -> Prendo il primo evento e faccio lo switch
	
	//Simula() -> finché lista non vuota fai passo
	public void simulate(){
		
	}
}
