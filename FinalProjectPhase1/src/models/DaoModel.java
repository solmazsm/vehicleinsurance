package models;
/**
 * @author (Solmaz Seyed Monir) Sunday, April 21,2018 DaoModelView.java Fianl Project
 *         package views  To write a program that to implement phase1 idea into 
 *         an MVC format.
 */
import java.awt.GridLayout;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import application.InsuranceMainController;
import carsInsurance.InsuranceCompany;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.PreparedStatement;

/*
 * DaoModel is a class that as a logic and functionality
 * and has a relationship with Insurance view that has policy
 * table. After agent Agent login the appliction can shows Policy table 
 * , therefore, agebt can insert, update, and delete records.
 * 
 */
/* DB objects
 * 
 */


public class DaoModel extends InsuranceMainController {
	
	DBConnect connection = null;
	Statement statement = null;
	public DaoModel() {
connection = new DBConnect();

}
	public void createTable() {
	try { 
		System.out.println("Connection to a selected database to creat Table");
		System.out.println("Connected database successfully.......");
	System.out.println("Creating table in given database");
	/*
	 * create tables solmaz_vehicle,solmaz_policy,solmaz_claim,solmaz_AgentLogin
	 */
	String sql3 = "CREATE TABLE solmaz_vehicle " +"(vin varchar(20) NOT NULL, " +
			  "carmake varchar(20) DEFAULT NULL, " +
			  "carmodle varchar(20) DEFAULT NULL, " +
			  "caryear varchar(20) DEFAULT NULL, " +
			  "cartype varchar(20) DEFAULT NULL, " +
			  "PRIMARY KEY (vin))";
	
	String sql2 = "CREATE TABLE solmaz_policy " + "(policyNumber varchar(20) NOT NULL, " +
			"username varchar(20), " + "password varchar(20), " +
					  "state varchar(10) DEFAULT NULL, " +
					  "zipcode varchar(20) DEFAULT NULL, " +
					  "insuredName varchar(20) DEFAULT NULL, " +
					  "vin varchar(20) DEFAULT NULL, " +
					  "PRIMARY KEY (policyNumber), " +
					 "KEY vin_idx (vin), " +
					  "CONSTRAINT vin FOREIGN KEY (vin), " + "REFERENCES solmaz_vehicle (vin)) ";
			
	String sql = "create table solmaz_claim " + "(ClaimId String not NULL, " +
			 
			    "policyNumber VARCHAR(20) ," + "claimDate VARCHAR(20) ," +
			  			    "claimAirbag BOOLEAN DEFAULT NULL, "+
			    "pointOfImpact VARCHAR(10) DEFAULT NULL, "+ "fileAmount DOUBLE DEFAULT NULL, "+ "isConfirmed BOOLEAN DEFAULT NULL, "+
			   " PRIMARY KEY (ClaimId) ,"+
			   " KEY policy_number (policyNumber), " +
			    "CONSTRAINT policy FOREIGN KEY (policyNumber), " +
			      			    "REFERENCES solmaz_policy (policyNumber))";
	
	
	
	String sql4 = "CREATE TABLE `solmaz_AgentLogin" +
			  "usernameAgent` varchar(20) NOT NULL," +
			  "passwordAgent` varchar(10) DEFAULT NULL," +
			  "PRIMARY KEY (`usernameAgent`)";
			

//	statement.executeUpdate(sql4);
//	statement.executeUpdate(sql3);
//	statement.executeUpdate(sql2);
	statement.executeUpdate(sql);

	
	System.out.println("Created table in given database");
	
		connection.connect().close();
		
	}catch (SQLException se) {
		/*Handle errors for JDBC
		 * 
		 */
		se.printStackTrace();
	}
	}
	/*Insert into table
	 * solmaz_vehicle,solmaz_policy,solmaz_claim,solmaz_AgentLogin
	 * 
	 */

	public void insertRecords(ArrayList<InsuranceCompany> array2)
	{/* insert records into a table
		 */
		try {
			//Execute a query
			
			String sql = " ";
			String sql2 = " ";
			String sql3 = " ";
			System.out.println("Inserting records into the table...");
			java.sql.PreparedStatement preparedStatement = connection.connect().prepareStatement(sql);
			
			/*Include all object data to the database table
			 * 
			 * 
			 */
		for (int i=0 ; i<array2.size() ;++i) {
			
			
			String		sql4 = "INSERT INTO solmaz_AgentLogin (usernameAgent, passwordAgent\r\n" + 	")" + "VALUES(?, ?)";
			
			sql3 = "INSERT INTO solmaz_vehicle (carmake, carmodel, caryear, cartype, carplate\r\n" + 
					")" + "VALUES(?, ?, ?, ?, ?)";
			sql2 = "INSERT INTO solmaz_policy(policyNumber,username, password, state, zipcode, insuredName vin\r\n)" + 
					"VALUES(?, ?, ?, ?, ?, ?)";
			sql = "INSERT INTO solmaz_claim(policyNumber, claimId, claimDate, claimAirbag, pointOfImapact, fileAmount, isConfiremed\r\n" + 
					 
					")" + "VALUES (?, ?, ?, ?, ?, ?, ? )\")";
			
			
		/* execute the preparedstatement
			 * 
			 */
			preparedStatement.executeUpdate();
			}
		connection.connect().close();
		}catch (SQLException se) {
			se.printStackTrace();
		}
}
public ResultSet retrieveRecords() throws SQLException {
	ResultSet resultset = null;
	ResultSet resultset4 = null;
	ResultSet resultset3 = null;
	ResultSet resultset2 = null;
	statement = connection.connect().createStatement();
	String sql3 = "select carmake, carmodel, caryear, cartype, carplate from test_tab  ";
	String sql2 = "select policyNumber, username, password, state, zipcode, insuredName, vin from solmaz_policy  ";
	String sql = "select policyNumber, claimId, claimDate, claimAirbag, pointOfImapact, fileAmount, isConfiremed from solmaz_claim  ";
	String sql4 = "select usernameAgent, passwordAgent";

	//String sql = "SELECT * test_tab";
	//resultset4 = statement.executeQuery(sql4);
	//resultset3 = statement.executeQuery(sql3);
	resultset2 = statement.executeQuery(sql2);
	//resultset = statement.executeQuery(sql);
	
	
	
	connection.connect().close();
	
	return resultset2;
}
public void actionform(ActionEvent event) throws Exception,SQLException {
	  
		String sql2,sql4 ;
		ResultSet resultset2 = null;
		ResultSet resultset4 = null;
	  try {
		  
			statement = connection.connect().createStatement();
			sql4 = "SELECT * from solmaz_AgentLogin where usernameAgent = '" + name.getText() + "' and passwordAgent = '" 
					+ password.getText().toString() + "' ";
			resultset4 = statement.executeQuery(sql4);
			 sql2 = "SELECT * from solmaz_policy where username = '" + name.getText() + "' and password = '" 
					+ password.getText().toString() + "' ";
			resultset2 = statement.executeQuery(sql2);
			if (resultset4.next()) 
			{	 	JOptionPane.showMessageDialog(null, "Welcome Agent Login  successfully..");}
			if (resultset2.next()) {
				JOptionPane.showMessageDialog(null, "Welcome User Login  successfully..");
			}else
				JOptionPane.showMessageDialog(null, "Please Try again for Login.... Invalid UserName or Password");
			connection.connect().close();
	  }catch (Exception e)
	  {System.out.print(e);}
}
		/*
		 * Action for insert,update,delete
		 */
	 public void insertPolicy (String PolicyNumber, String username, String password,String state, String zipcode,String insuredName,String vin) throws SQLException {
		 
		 
		 String		sqlPolicy = "INSERT INTO solmaz_policy (username, password, "
		 		+ "state, zipcode, insuredName, vin, policyNumber)" + 
				" VALUES ('"+ username + "', '"+ password + "', '" + 
		 		state + "', '" + zipcode + "', '" + insuredName + "', '" + 
				vin + "', '" + PolicyNumber + "')";
		 System.out.println(sqlPolicy);
		 statement = connection.connect().createStatement();
		 statement.execute(sqlPolicy);
		 connection.connect().close();
	 }
		 public void deletePolicy(String policyNumber) throws SQLException {
		
			 System.out.println("Creating statement...");
			 statement = connection.connect().createStatement();
		      String sqlPolicy = "DELETE FROM solmaz_policy " +
		                  "WHERE policyNumber = '" + policyNumber+ "'";
		      statement.execute(sqlPolicy);

			     JPanel p3=new JPanel(new GridLayout(2,2));
		      //PreparedStatement statement=connection.prepareStatement("DELETE FROM solmaz_policy where policyNumber=?");
		    
		    // statement.setString(1,policyNumber);
		    // statement.executeUpdate();
		     //JPanel p3=new JPanel(new GridLayout(2,2));
		      //JOptionPane.showMessageDialog(p3,"Record is deleted successfully."); 
		      

		      // Now you can extract all the records
		      // to see the remaining records
		     //sqlPolicy = "select policyNumber username, password, state, zipcode, insuredName, vin from solmaz_policy  ";
		      //ResultSet resultset =  statement.executeQuery(sqlPolicy);
		     
		       
		     //resultset.close();
		      connection.connect().close();
		    
		      }
		 public void updatePolicy(String PolicyNumber, String username, String password,String state, String zipcode,String insuredName,String vin) throws SQLException {
			// statement = connection.connect().createStatement();
			 String sqlPolicy = "update solmaz_policy set  username='"+username+"', password='"+password+"', state='"+state+"', zipcode='"+zipcode+"', insuredName='"+insuredName +"', vin='"+vin +"' where policyNumber='"+ PolicyNumber +"'";
			 System.out.println(sqlPolicy);
			 statement = connection.connect().createStatement();
			 statement.executeUpdate(sqlPolicy);
			   connection.connect().close();
		 }
		
}
