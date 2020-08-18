package entity;

public class State {
	//members;
	String name;
	long numCases;
	long numDeaths;
	long pop;
	String zone;
	
	//methods
	//constructors
	//accessors and mutators
	//functional methods
	//display methods
	
	private State() {
		this.name="no name";
		this.numCases=0;
		this.numDeaths=0;
		this.pop=0;
		this.zone="no zone set";
	}
	
	public State(String name, long pop) {
		this(); //chaining this constructor with no parameter constructor
		this.setName(name);
		this.setPop(pop);
	}
	
	//mutator method
	public boolean setName(String name) {
		if(name!=null) {
			this.name=name;
			return true;
		}
		return false;
	}
	public boolean setNumCases(long n) {
		if(n>=0) {
			this.numCases=n;
			return true;
		}
		return false;
	}
	public boolean setNumDeaths(long n) {
		if(n>=0) {
			this.numDeaths=n;
			return true;
		}
		return false;
	}
	public boolean setPop(long p) {
		if(p>10000) {
			this.pop=p;
			return true;
		}
		return false;
	}
	//no mutator for zone - zone is calculated or determined, it is not set
	//accessor methods
	public String getName() {
		return this.name.toUpperCase();
	}
	public long getCases() {
		return this.numCases;
	}
	public long getDeaths() {
		return this.numDeaths;
	}
	public long getPop() {
		return this.pop;
	}
	public String getZone() {
		this.setZone();
		return this.zone.toUpperCase();
	}
	
	//functional methods
	public void setZone() {
		if (this.getCases()*100/this.getPop()>30) this.zone="RED";
		else if (this.getCases()*100/this.getPop()>20) this.zone="YELLOW";
		else this.zone="GREEN";
	}
	
	//display method
	public String toString() {
		String output = "";
		output= String.format("State Name: %S%nNumber of +ve Cases: %d%nNumber of  Deaths=%d%nYour State is in %s zone%n", this.getName() , this.getCases(), this.getDeaths() , this.getZone());
		return output;
	}
}