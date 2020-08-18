package controllers;
import entity.State;

public class StateHolder {
	//members
	private State[] country;
	private int count;
	//if a member is final - indicates that it can only be initialized once 
	//static - it belongs to class and there is only one copy of the variable
	//instance - it belongs to the object of the class and there is a copy of the variable for every object
	private static final int MAX_STATES =29;
	private static StateHolder sh = null;
	
	//private no-parameter constructor is to initialize the members especially when the members are reference type
	private StateHolder() {
		country= new State[MAX_STATES];
		this.count=0;
	}
	
	//do other classes create objects of this class?
	//assumptions in the project - one country
	//my code should let me create objects but should not allow me to create more than one object
	//alternate ways to create objects other than using public constructors
	
	//creational design pattern - singleton pattern (lazy instantiation and early instantiation)
	public static StateHolder createCountry() {
		if(sh==null) sh=new StateHolder();
		return sh;
	}
	
	//functional methods
	//search data
	//add data
	//update data
	
	private State searchState(String n) {
		State s = null;
		//logic
		for(int i=0;i<count;i++) {
			if(country[i].getName().equalsIgnoreCase(n)) s=country[i];
		}
		return s;
	}
	
	public boolean addState(String n,long p) {
		//logic
		//conditions - n should not already exists, data structure is not full, n is not null, n is not empty,
		if(n!=null && !(n.isEmpty()) && searchState(n)==null && count<MAX_STATES) {
			//logic to add state
			country[count++]= new State(n,p);
			return true;
		}
		return false;
	}
	
	public boolean updateState(String n,int nc,int nd) {
		//logic
		State s=this.searchState(n);
		if(s!=null) {
			//logic to update
			s.setNumCases(nc);
			s.setNumDeaths(nd);
			s.setZone();
			return true;
		}
		return false;
	}
	
	public String displayStateDetails(String n) {
		State s=this.searchState(n);
		if(s!=null) return s.toString();
		else return "State with name "+n+" doesn't exist";
	}
}
