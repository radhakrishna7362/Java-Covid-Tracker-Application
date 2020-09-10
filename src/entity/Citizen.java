package entity;

public class Citizen {
	//members
	long aadhar;
	String name;
	private State s;
	boolean govtOfficial;
	private static final String govtPswd="Govt@123";
			
	//methods
	//constructor
			
	private Citizen() {
		this.aadhar=-1;
		this.name="no name";
		this.govtOfficial=false;
	}
	
	public Citizen(String name, long aadhar) {
		this();
		if(name!=null && !(name.isEmpty())) this.name=name;
		if(aadhar>0) this.aadhar =aadhar;
	}
	
	//mutator
	public boolean setName(String n) {
		if(n!=null && !(n.isEmpty())) {
			this.name=n;
			return true;
		}
		return false;
	}
	public void setAadhar(long n) {
//		if(n>100000000000 && n<1000000000000) {
			this.aadhar=n;
//			return true;
//		}
//		return false;
	}
	public void setGovtOfficial(boolean b) {
		this.govtOfficial=b;
	}
	
	//accessor
	public String getName() {
		return this.name.toUpperCase();
	}
	public boolean isGovtOfficial() {
		return this.govtOfficial;
	}
	
	public long getAadhar() {
		return this.aadhar;
	}
	public static String getPswd() {
		return govtPswd;
	}
	public State getState() {
		return this.s;
	} 

}