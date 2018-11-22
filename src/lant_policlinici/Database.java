/**
 * 
 */
package lant_policlinici;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Vali
 *
 */
public class Database {
	private String dbhost;
	private String dbport;
	private String dbname;
	private String dbuser;
	private String dbpass;
	
	public Database(String dbhost, String dbport, String dbname,  String dbuser, String dbpass) {
		this.dbhost = dbhost;
		this.dbport = dbport;
		this.dbname = dbname;
		this.dbuser = dbuser;
		this.dbpass = dbpass;
	}
	
	public String getHost() {
		return dbhost;
	}
	
	public String getPort() {
		return dbport;
	}

	public String getDatabase() {
		return dbname;
	}
	
	public String getUsername() {
		return dbuser;
	}
	
	public String getPassword() {
		return dbpass;
	}
	
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://" + this.getHost() + ":" + this.getPort() + "/" + this.getDatabase() + "?useSSL=false", this.getUsername(), this.getPassword());
	
		return conn;
	}
	
}
