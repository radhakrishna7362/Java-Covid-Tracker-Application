package enduser;
import java.util.*;

public class UserClass {
	//Take input
	//use classes and their functionality
	//give output
	private static final Scanner s=new Scanner(System.in);
	public static void main(String[] args) {
		boolean repeat =true;
		while(repeat) {
			switch(displayMainMenu()) {
			case 1: 
				citizen();
				break;
			case 2:
				govtOfficial();
				break;
			default:
				repeat = false;
			}
		}
	}
	
	private static int displayMainMenu() {
		System.out.println("Who are you?");
		System.out.println("1. Government Ofiicial");
		System.out.println("2. Citizen");
		System.out.println("Enter any other number to exit");
		return s.nextInt();
	}
	
	private static void citizen() {
		//write sub-menu for citizen
		boolean repeat=true;
		while(repeat) {
			switch(citizenSubMenu()) {
			case 1: register();
					break;
			case 2: viewStateDetails();
					break;
			default: repeat=false;
			}
		}
	}
	
	private static int citizenSubMenu() {
		System.out.println("1. Registration");
		System.out.println("2. Viewing State Details");
		System.out.println("Enter any other number for exiting the sub-menu");
		return s.nextInt();
	}
	
	private static void register() {
		System.out.println("Enter Name");
		String name=s.next();
		System.out.println("Enter Aadhar Number");
		long a = s.nextLong();
		if(ch.addCitizen(name,a)) System.out.println("Citizen Registered Successfully");
		else System.out.println("Citizen cannot be registered");
	}
	
	private static void viewStateDetails() {
		//logic citizen enters state name, search for state and view details of state
		System.out.println("Enter state name");
		String name=s.next();
		System.out.println(sh.displayStateDetials(name));
	}
	
	private static void govtOfficial() {
		//all operations as govt Official coded here
		//logic - display sub-menu for govt official
		//functionalities - add state, update state
		//functionality - authenticate a govt official
		//functionality - display all citizens details
		boolean repeat=true;
		while(repeat) {
			switch(govtOfficialSubMenu()) {
			case 1: addState();
					break;
			case 2: updateState();
					break;
			case 3: displayAllCitizens();
					break;
			default: repeat=false;
			}
		}	
	}
	
	private static int govtOfficialSubMenu() {
		System.out.println("1. Add new State");
		System.out.println("2. update an existing state");
		System.out.println("3. To view all citizen details");
		System.out.println("Enter any other number to exit");
		return s.nextInt();
	}
	
	private static void addState() {
		//logic - if authenticated then add state by taking name and pop from the console
		if(authenticated()) {
			System.out.println("Enter State Name");
			String sname=s.next();
			System.out.println("Enter State Population");
			long p=s.nextLong();
			if(sh.addState(sname,p)) System.out.println("State added successfully");
			else System.out.println("State cannot be added");
		}
		else System.out.println("User not authenticated");
	}
	
	private static void updateState() {
		//;ogic - authenticate, ask for state name and if state exists then update state
		if(authenticated()) {
			System.out.println("Enter state name");
			String sname=s.next();
			System.out.println("Enter No of Cases");
			int nc=s.nextInt();
			System.out.println("Enter No of Deaths");
			int nd=s.nextInt();
			if(sh.updateState(sname,nc,nd)) System.out.println("State Updated Successfully");
			else System.out.println("State "+sname+" doesn't exist");
		}
		else System.out.println("User not authenticated");
	}
	
	private static void displayAllCitizens() {
		System.out.println(ch);
	}
	
	private static boolean authenticated() {
		//logic need aadhar and password
		//if citizen exists with addhar and if password is matching then return true
		System.out.println("Enter Aadhar Number");
		long a=s.nextLong();
		System.out.println("Enter password");
		String pswd=s.next();
		return ch.validateGovtOfficial(a,pswd);
	}
	
}
