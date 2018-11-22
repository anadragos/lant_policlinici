package lant_policlinici;
import coloane.*;
import tabele. *;

public class TestApp {

	public static void main(String[] args) {
		Database db = new Database("localhost", "3306", "lant_policlinici", "adminLantPoli", "KbKtB6pw#5SVJ8hH");
		
		Policlinica p1 = new Policlinica(db, 1);
		Policlinica p2 = new Policlinica(db, 2);
		//Policlinica p3 = new Policlinica(db, 3);

		System.out.println(p1);
		System.out.println(p2);
	
		Program pro = p1.getProgram();
		System.out.println(pro.compressProgram());

		pro.setMarti(new OraProgram(8, 20));
		

		System.out.println(pro.compressProgram());
		
		p1.setProgram(pro);
		
		p1.updateOnDatabase(db);
	}

}
