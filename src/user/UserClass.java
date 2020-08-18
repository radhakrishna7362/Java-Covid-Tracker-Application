package user;
import entity.State;

public class UserClass {

	public static void main(String[] args) {
		State s1 = new State("AP",15000);
		s1.setNumCases(10000);
		s1.setNumDeaths(100);
		System.out.println(s1);
		
		State s2=new State("TS",20000);
		s2.setNumCases(2500);
		s2.setNumDeaths(200);
		System.out.println(s2);
	}

}
