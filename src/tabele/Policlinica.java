/**
 * 
 */
package tabele;
import java.sql.*;
import coloane.Program;
import lant_policlinici.Database;
import lant_policlinici.ErrorLog;

/**
 * @author Vali
 *
 */
public class Policlinica {
	public static final String table = "policlinici";
	
	private int id;
	private String denumire;
	private String adresa;
	private String descriere;
	private String telefon;
	private String email;
	private Program program;

	public Policlinica(Database db, int id) {
		this.id = id;
		this.extractFormDatabase(db);
	}
	
	public Policlinica(int id, String denumire, String adresa, String descriere, String telefon, String email, Program program) {
		this.id = id;
		this.denumire = denumire;
		this.adresa = adresa;
		this.descriere = descriere;
		this.telefon = telefon;
		this.email = email;
		this.program = program;
	}
	
	public int getID() {
		return id;
	}

	/** 
	 * @return denumirea
	 */
	public String getDenumire() {
		return denumire;
	}


	/**
	 * @param denumirea ce se doreste setata
	 */
	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}


	/**
	 * @return numarul de telefon
	 */
	public String getTelefon() {
		return telefon;
	}


	/**
	 * @param numarul de telefon ce se doreste setat
	 */
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}


	/**
	 * @return descriere
	 */
	public String getDescriere() {
		return descriere;
	}


	/**
	 * @param descrierea ce se doreste setata
	 */
	public void setDescriere(String descriere) {
		this.descriere = descriere;
	}


	/**
	 * @return adresa
	 */
	public String getAdresa() {
		return adresa;
	}


	/**
	 * @param adresa ce se doreste setata
	 */
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}


	/**
	 * @return e-mail-ul
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param e-mail-ul ce se doreste setat
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return program-ul
	 */
	public Program getProgram() {
		return program;
	}

	/**
	 * @param programul ce trebuie setat dupa formatul: "L: 0-24; M: 0-24; Mi: 0-24; J: 0-24; V: 0-24; S: 0-24; D: 0-24"
	 */
	public void setProgram(Program program) {
		this.program = program;
	}
	
	public void extractFormDatabase(Database db) {
		try (
			Connection conn = db.getConnection();
			Statement stmt = conn.createStatement();
		) {		 
			String query = "SELECT * FROM `" + table + "` WHERE id = '" + this.id + "' LIMIT 1";
			ResultSet rset = stmt.executeQuery(query);
			int rowCount = 0;
			while (rset.next()) {
				this.denumire = rset.getString("denumire");
				this.adresa = rset.getString("adresa");
				this.descriere = rset.getString("descriere");
				this.telefon = rset.getString("telefon");
				this.email = rset.getString("email");
				this.program = new Program(rset.getString("program"));
				++rowCount;
			}
			
			if (rowCount == 0) {
				ErrorLog.printError("Nu a fost gasita nicio policlinica cu id-ul " + id);
			} else if (rowCount > 1) {
				ErrorLog.printError("Au fost gasite mai multe policlinici cu id-ul " + id);
			}
		} catch(ClassNotFoundException e) {
			ErrorLog.printError("Nu am gasit driver-ul pentru MySQL.");
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void updateOnDatabase(Database db) {
		try (
			Connection conn = db.getConnection();
			Statement stmt = conn.createStatement();	 
		) {
			String query = "UPDATE `" + table + "` "
					+ "SET denumire = '" + this.getDenumire() 
					+ "', adresa = '" + this.getAdresa() 
					+ "', descriere = '" + this.getDescriere() 
					+ "', email = '" + this.getEmail() 
					+ "', telefon = '" + this.getTelefon() 
					+ "', program = '" + this.getProgram().compressProgram() + "' "
					+ "WHERE id = '" + this.id + "'";
			
			int rowCount = stmt.executeUpdate(query);
			
			if (rowCount == 0) {
				ErrorLog.printError("Nu a fost gasita nicio policlinica cu id-ul " + id);
			} else if (rowCount > 1) {
				ErrorLog.printError("Au fost gasite mai multe policlinici cu id-ul " + id);
			}
		} catch(ClassNotFoundException e) {
			ErrorLog.printError("Nu am gasit driver-ul pentru MySQL.");
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
	}

	public String toString() {
		String str = new String("");
		
		str += this.getDenumire() + " " + this.getAdresa() + " " + this.getDescriere() + " " + this.getEmail() + " ";
		str += this.getTelefon() + " " + this.getProgram().compressProgram();
		
		return str;
	}
	
}
