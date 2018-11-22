/**
 * 
 */
package tabele;

import coloane.DateTime;
import lant_policlinici.Database;

/**
 * @author Vali
 *
 */
public class Angajati {
	public static final String table = "angajati";
	
	private int id;
	private String username;
	private String password;
	private String nume;
	private String prenume;
	private String cnp;
	private String adresa;
	private String telefon;
	private String email;
	private String iban;
	private int nr_contract;
	private DateTime data_angajarii;
	private int functie;
	private int admin_type;
	private int salariu;
	private int nr_ore;
	
	public Angajati(Database db, int id) {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public String getPrenume() {
		return prenume;
	}
	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}
	public String getCnp() {
		return cnp;
	}
	public void setCnp(String cnp) {
		this.cnp = cnp;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIban() {
		return iban;
	}
	public void setIban(String iban) {
		this.iban = iban;
	}
	public int getNr_contract() {
		return nr_contract;
	}
	public void setNr_contract(int nr_contract) {
		this.nr_contract = nr_contract;
	}
	public DateTime getData_angajarii() {
		return data_angajarii;
	}
	public void setData_angajarii(DateTime data_angajarii) {
		this.data_angajarii = data_angajarii;
	}
	public int getFunctie() {
		return functie;
	}
	public void setFunctie(int functie) {
		this.functie = functie;
	}
	public int getAdmin_type() {
		return admin_type;
	}
	public void setAdmin_type(int admin_type) {
		this.admin_type = admin_type;
	}
	public int getSalariu() {
		return salariu;
	}
	public void setSalariu(int salariu) {
		this.salariu = salariu;
	}
	public int getNr_ore() {
		return nr_ore;
	}
	public void setNr_ore(int nr_ore) {
		this.nr_ore = nr_ore;
	}
	
}
