package models;

/**
 * @author (Solmaz Seyed Monir) Sunday, April 21,2018 ClaimViewView.java Fianl Project
 *         package views  To write a program that to implement phase1 idea into 
 *         an MVC format.
 */
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import application.InsuranceMainController;
import carsInsurance.InsuranceCompany;
import java.sql.PreparedStatement;
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
import java.util.Date;
/* DB objects
 /*
 * ClaimView is a class that as a logic and functionality
 * and has a relationship with Claim view class that has claim
 * table. After users(customers)  login the appliction can shows claim table 
 * , therefore, users(customers) can insert, update, and delete records.
 * 

 */

public class ClaimModel extends InsuranceMainController {

	DBConnect connection = null;
	Statement statement = null;

	public ClaimModel() {
		connection = new DBConnect();

	}

	/*
	 * Create tables solmaz_vehicle,solmaz_policy,solmaz_claim,solmaz_AgentLogin
	 */
	public void createTable() {
		try {
			System.out.println("Connection to a selected database to creat Table");
			System.out.println("Connected database successfully.......");
			System.out.println("Creating table in given database");

			String sql3 = "CREATE TABLE solmaz_vehicle " + "(vin varchar(20) NOT NULL, "
					+ "carmake varchar(20) DEFAULT NULL, " + "carmodle varchar(20) DEFAULT NULL, "
					+ "caryear varchar(20) DEFAULT NULL, " + "cartype varchar(20) DEFAULT NULL, "
					+ "PRIMARY KEY (vin))";

			String sql2 = "CREATE TABLE solmaz_policy " + "(policyNumber varchar(20) NOT NULL, "
					+ "username varchar(20), " + "password varchar(20), " + "state varchar(10) DEFAULT NULL, "
					+ "zipcode varchar(20) DEFAULT NULL, " + "insuredName varchar(20) DEFAULT NULL, "
					+ "vin varchar(20) DEFAULT NULL, " + "PRIMARY KEY (policyNumber), " + "KEY vin_idx (vin), "
					+ "CONSTRAINT vin FOREIGN KEY (vin), " + "REFERENCES solmaz_vehicle (vin)) ";

			String sql = "create table solmaz_claim " + "(ClaimId String not NULL, " +

					"policyNumber VARCHAR(20) ," + "claimDate VARCHAR(20) ," + "claimAirbag BOOLEAN DEFAULT NULL, "
					+ "pointOfImpact VARCHAR(10) DEFAULT NULL, " + "fileAmount DOUBLE(7,2) DEFAULT NULL, "
					+ "isConfirmed BOOLEAN DEFAULT NULL, " + " PRIMARY KEY (ClaimId) ,"
					+ " KEY policy_number (policyNumber), " + "CONSTRAINT policy FOREIGN KEY (policyNumber), "
					+ "REFERENCES solmaz_policy (policyNumber))";

			String sql4 = "CREATE TABLE `solmaz_AgentLogin" + "usernameAgent` varchar(20) NOT NULL,"
					+ "passwordAgent` varchar(10) DEFAULT NULL," + "PRIMARY KEY (`usernameAgent`)";

			// statement.executeUpdate(sql4);
			// statement.executeUpdate(sql3);
			// statement.executeUpdate(sql2);
			statement.executeUpdate(sql);

			System.out.println("Created table in given database");

			connection.connect().close();

		} catch (SQLException se) {
			/*
			 * Handle errors for JDBC
			 * 
			 */
			se.printStackTrace();
		}
	}
	/*
	 * Insert into tables
	 * 
	 * solmaz_vehicle,solmaz_policy,solmaz_claim,solmaz_AgentLogin tables
	 * 
	 */

	public void insertRecords(ArrayList<InsuranceCompany> array2) {/*
																	 * insert records into a table
																	 */
		try {
			// Execute a query

			String sql = " ";
			String sql2 = " ";
			String sql3 = " ";
			System.out.println("Inserting records into the table...");

			/*
			 * Include all object data to the database ta ble
			 * 
			 */
			for (int i = 0; i < array2.size(); ++i) {

				String sql4 = "INSERT INTO solmaz_AgentLogin (usernameAgent, passwordAgent\r\n" + ")" + "VALUES(?, ?)";

				sql3 = "INSERT INTO solmaz_vehicle (carmake, carmodel, caryear, cartype, carplate\r\n" + ")"
						+ "VALUES(?, ?, ?, ?, ?)";
				sql2 = "INSERT INTO solmaz_policy(policyNumber,username, password, state, zipcode, insuredName, vin\r\n)"
						+ "VALUES(?, ?, ?, ?, ?, ?,?)";
				sql = "INSERT INTO solmaz_claim(claimId, policyNumber , claimDate, claimAirbag, pointOfImpact, fileAmount, isConfirmed\r\n"
						+

						")" + "VALUES (?, ?, ?, ?, ?, ?, ? )\")";

				PreparedStatement preparedStatement = connection.connect().prepareStatement(sql);
				/*
				 * execute the preparedstatement
				 * 
				 */
				long isConfirmed = (Long) null;
				double fileAmount = 0;
				preparedStatement.setString(1, ClaimId);
				preparedStatement.setString(2, policyNumber);
				preparedStatement.setString(3, claimDate);
				preparedStatement.setString(4, claimAirbag);
				preparedStatement.setString(5, pointOfImpact);
				preparedStatement.setDouble(6, fileAmount);
				preparedStatement.setLong(7, isConfirmed);

				preparedStatement.executeUpdate();
			}
			connection.connect().close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	public ResultSet retrieveRecords() throws SQLException {
		ResultSet resultset = null;
		ResultSet resultset4 = null;
		ResultSet resultset3 = null;
		ResultSet resultset2 = null;
		statement = connection.connect().createStatement();
		String sql3 = "select carmake, carmodel, caryear, cartype, carplate from solmaz_vehicle  ";
		String sql2 = "select policyNumber, username, password, state, zipcode, insuredName, vin from solmaz_policy  ";
		String sql = "select claimId, policyNumber,  claimDate, claimAirbag, pointOfImpact, fileAmount, IsConfirmed from solmaz_claim ";
		String sql4 = "select usernameAgent, passwordAgent";

		// String sql = "SELECT * test_tab";
		// resultset4 = statement.executeQuery(sql4);
		// resultset3 = statement.executeQuery(sql3);
		// resultset2 = statement.executeQuery(sql2);
		resultset = statement.executeQuery(sql);

		connection.connect().close();

		return resultset;
	}

	public void actionform(ActionEvent event) throws Exception, SQLException {

		String sql2, sql4;
		ResultSet resultset2 = null;
		ResultSet resultset4 = null;
		try {

			statement = connection.connect().createStatement();
			sql4 = "SELECT * from solmaz_AgentLogin where usernameAgent = '" + name.getText()
					+ "' and passwordAgent = '" + password.getText().toString() + "' ";
			resultset4 = statement.executeQuery(sql4);
			sql2 = "SELECT * from solmaz_policy where username = '" + name.getText() + "' and password = '"
					+ password.getText().toString() + "' ";
			resultset2 = statement.executeQuery(sql2);
			if (resultset4.next()) {
				JOptionPane.showMessageDialog(null, "Welcome Agent Login  successfully..");
			}
			if (resultset2.next()) {
				JOptionPane.showMessageDialog(null, "Welcome User Login  successfully..");
			} else
				JOptionPane.showMessageDialog(null, "Please Try again for Login.... Invalid UserName or Password");
			connection.connect().close();
		} catch (Exception e) {
			System.out.print(e);
		}
	}

	String ClaimId, claimDate, claimAirbag, pointOfImpact, policyNumber, fileAmount, isConfirmed;

	/*
	 * Action for insert, update, and delet after users push that button.
	 */
	public void insertClaim(String ClaimId, String policyNumber, String claimDate, String claimAirbag,
			String pointOfImpact, String fileAmount, String isConfirmed) throws SQLException {

		String sqlClaim = "INSERT INTO solmaz_claim (ClaimId, policyNumber, "
				+ "claimDate, claimAirbag, pointOfImpact, fileAmount, isConfirmed)" + " VALUES ('" + ClaimId + "', '"
				+ policyNumber + "', '" + claimDate + "', '" + claimAirbag + "', '" + pointOfImpact + "', " + fileAmount
				+ "," + isConfirmed + ")";
		System.out.println(sqlClaim);
		statement = connection.connect().createStatement();
		statement.execute(sqlClaim);
		connection.connect().close();
	}

	public void deleteClaim(String ClaimId) throws SQLException {

		System.out.println("Creating statement...");

		statement = connection.connect().createStatement();
		String sqlClaim = "DELETE FROM solmaz_claim " + "WHERE ClaimId = '" + ClaimId + "'";
		statement.execute(sqlClaim);

		JPanel p3 = new JPanel(new GridLayout(2, 2));
		// JOptionPane.showMessageDialog(p3,"Record is deleted successfully.");

		/*
		 * Now you can extract all the records to see the remaining records
		 */

		// sqlClaim = "select
		// ClaimId,policyNumber,claimDate,claimAirbag,pointOfImpact,fileAmount,isConfirmed
		// from solmaz_claim ";
		// ResultSet resultset = statement.executeQuery(sqlClaim);

		// resultset.close();
		connection.connect().close();

	}

	public void updateClaim(String ClaimId, String policyNumber, String claimDate, String claimAirbag,
			String pointOfImpact, String fileAmount, String isConfirmed) throws SQLException {
		// statement = connection.connect().createStatement();
		String sqlClaim = "update solmaz_claim set  ClaimId='" + ClaimId + "', policyNumber='" + policyNumber
				+ "', claimDate='" + claimDate + "', claimAirbag='" + claimAirbag + "', pointOfImpact='" + pointOfImpact
				+ "', fileAmount=" + fileAmount + ", isConfirmed=" + isConfirmed + " where ClaimId='" + ClaimId + "'";
		System.out.println(sqlClaim);
		statement = connection.connect().createStatement();
		statement.executeUpdate(sqlClaim);
		connection.connect().close();
	}

}
