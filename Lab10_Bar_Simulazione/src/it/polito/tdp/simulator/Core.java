package it.polito.tdp.simulator;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;

import it.polito.tdp.simulator.Event.EventType;
import it.polito.tdp.simulator.Group.GroupState;
import it.polito.tdp.simulator.Table.TableState;

public class Core {

	Queue<Event> eventList = new PriorityQueue<Event>();
	Map<Integer, Group> groups = new HashMap<Integer, Group>();
	Map<Integer, Table> tables = new HashMap<Integer, Table>();
	
	//Variabili per statistiche
	private int nCustomers = 0;
	private int nSatisfied = 0;
	private int nUnsatisfied = 0;
	
	public int getnCustomers() {
		return nCustomers;
	}

	public int getnSatisfied() {
		return nSatisfied;
	}

	public int getnUnsatisifed() {
		return nUnsatisfied;
	}

	//Aggiungo i tavoli alla creazione del simulatore, in quanto sono sempre quelli
	public Core(){
		tables.put(1, new Table(1, 4, TableState.TABLE_UNOCCUPIED));
		tables.put(2, new Table(2, 4, TableState.TABLE_UNOCCUPIED));
		tables.put(3, new Table(3, 4, TableState.TABLE_UNOCCUPIED));
		tables.put(4, new Table(4, 4, TableState.TABLE_UNOCCUPIED));
		tables.put(5, new Table(5, 4, TableState.TABLE_UNOCCUPIED));
		tables.put(6, new Table(6, 6, TableState.TABLE_UNOCCUPIED));
		tables.put(7, new Table(7, 6, TableState.TABLE_UNOCCUPIED));
		tables.put(8, new Table(8, 6, TableState.TABLE_UNOCCUPIED));
		tables.put(9, new Table(9, 6, TableState.TABLE_UNOCCUPIED));
		tables.put(10, new Table(10, 8, TableState.TABLE_UNOCCUPIED));
		tables.put(11, new Table(11, 8, TableState.TABLE_UNOCCUPIED));
		tables.put(12, new Table(12, 8, TableState.TABLE_UNOCCUPIED));
		tables.put(13, new Table(13, 8, TableState.TABLE_UNOCCUPIED));
		tables.put(14, new Table(14, 10, TableState.TABLE_UNOCCUPIED));
		tables.put(15, new Table(15, 10, TableState.TABLE_UNOCCUPIED));
	}
	
	public void addEvent(Event e){
		eventList.add(e);
	}
	
	public void addGroup(Group g){
		groups.put(g.getIdGroup(), g);
	}
	
	//Passo() -> Prendo il primo evento e faccio lo switch
	public void step(){
		Event e = eventList.remove();
		switch(e.getType()){
		case GROUP_ARRIVES:
			//Arriva un gruppo di clienti. Cerco di piazzarli nel tavolo più piccolo che li possa accogliere
			//Se però occupano meno del 50% li invito ad andare al bancone
			Group g = groups.get(e.getId());
			System.out.println("[T = "+e.getTime()+"] Arrivato gruppo "+g.getIdGroup()+" ("+g.getPeople()+" persone)");
			nCustomers++;
			//Cerco il tavolo libero più piccolo
			for(Table t : tables.values()){
				//Se il tavolo attuale è libero e il gruppo non è ancora seduto
				if(t.getState() == TableState.TABLE_UNOCCUPIED && g.getState() == GroupState.GROUP_WAITING){
					//Se la capienza del tavolo è sufficiente a contenere le persone e queste sono più del 50%
					if((t.getCapacity()>=g.getPeople()) && (g.getPeople()>=t.getCapacity()/2)){
						//Faccio sedere il gruppo ed imposto il momento in cui lasceranno il tavolo
						g.setState(GroupState.GROUP_SIT);
						t.setState(TableState.TABLE_OCCUPIED);
						g.setTable(t);
						System.out.println("[T = "+e.getTime()+"] Gruppo "+g.getIdGroup()+" seduto al tavolo "+t.getId_table()+" ("+t.getCapacity()+" posti)");
						this.addEvent(new Event(e.getTime()+g.getDuration(), EventType.GROUP_LEAVES, g.getIdGroup()));
						nSatisfied++;
					}
				}
			}
			//Se dopo aver controllato tutti i tavoli non ne ho trovato nessuno per il gruppo provo a farli andare al bancone
			if(g.getState() == GroupState.GROUP_WAITING){
				if(g.getTolerance()<=ThreadLocalRandom.current().nextDouble()){
					nSatisfied++;
					g.setState(GroupState.GROUP_GONE);
					System.out.println("[T = "+e.getTime()+"] Gruppo "+g.getIdGroup()+" servito al bancone");
				}
				else{
					g.setState(GroupState.GROUP_GONE);
					nUnsatisfied++;
					System.out.println("[T = "+e.getTime()+"] Gruppo "+g.getIdGroup()+" esce senza aspettare");
				}
			}
			break;
			
		case GROUP_LEAVES:
			//Il gruppo lascia il tavolo
			Group gr = groups.get(e.getId());
			Table t = gr.getTable();
			gr.setState(GroupState.GROUP_GONE);
			t.setState(TableState.TABLE_UNOCCUPIED);
			System.out.println("[T = "+e.getTime()+"] Il gruppo "+gr.getIdGroup()+" ha liberato il tavolo "+t.getId_table()+" ("+t.getCapacity()+" posti)");
			break;
			
		default:
			System.err.println("Evento non gestito!");
			break;
		}
	}
	
	//Simula() -> finché lista non vuota fai passo
	public void simulate(){
		while(!eventList.isEmpty()){
			step();
		}
	}
}
