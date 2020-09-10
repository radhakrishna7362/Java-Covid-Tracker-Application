package controllers;

import entity.Citizen;

public class CitizenHolder {
	private Citizen[] people;
	private int count;
	private static final int MAX_PEOPLE=10000;
	private static final CitizenHolder ch=new CitizenHolder();
	public CitizenHolder()
	{
		this.people=new Citizen[MAX_PEOPLE];
		this.count=0;
	}
	public static CitizenHolder fetchPeople()
	{
		return ch;
	}
	private Citizen searchCitizen(long a)
	{
		for(int i=0;i<count;i++)
		{
			if(people[i].getAadhar()==a) 
				return people[i];
		}
		return null;
	}
	public boolean addCitizen(String n,long a)
	{
		Citizen c=this.searchCitizen(a);
		if(c==null && count<MAX_PEOPLE)
		{
			this.people[count++]=new Citizen(n,a);
			return true;
		}
		return false;
	}
	public boolean validateGovtOfficial(long a,String Pswd)
	{
		return (this.searchCitizen(a)!=null && Pswd.equals(Citizen.getPswd()));
	}
	public boolean getStateDetails(long a)
	{
		Citizen c=this.searchCitizen(a);
		if(c!=null)
		{
			System.out.println(c.getState());
		}
		return false;
	}
}