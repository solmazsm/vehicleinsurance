package models;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class DBConnect {
	/*database URL
	 * 
	 */
static final String DB_URL = "jdbc:mysql://www.papademas.net:3306/fp510?autoReconnect=true&useSSL=false";
static final String USER = "fpuser" , PASS = "510";
public Connection connect() throws SQLException {
	return DriverManager.getConnection(DB_URL, USER, PASS);
}
}
