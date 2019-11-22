package application;

/**
 * @author (Solmaz Seyed Monir) Sunday, April 21,2018 InsuranceMainController.java Fianl Project
 *         package views  To write a program that to implement phase1 idea into 
 *         an MVC format.
 */
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import controllers.InsuranceProcessing;
import controllers.PolicyLoginControlProcessing;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import models.DBConnect;

import javafx.scene.control.ComboBox;

/*
 * Create Login Scene for Agents and users
 */
public class InsuranceMainController implements Initializable {

	@FXML

	ObservableList<String> user = FXCollections.observableArrayList("User", "Agent");

	@FXML
	protected TextField name;
	@FXML
	private Label label;

	@FXML
	protected PasswordField password;

	@FXML
	private Button login;

	@FXML
	private Button cancel;
	@FXML

	public ComboBox<String> combobox;

	public void initialize() {
		combobox.setItems(user);
		combobox.setVisibleRowCount(3);

	}

	// @FXML
	// private void choise() throws Exception {
	// if(combobox.getValue().equals("Manager")) {
	// changeScreenButton(ActionEvent event);
	// }}

	// }
	// }
	@FXML
	public void Login(ActionEvent event) throws Exception {
		// Parent parent =
		// FXMLLoader.load(getClass().getResource("/application/Login.fxml"));

		Stage primaryStage = new Stage();
		// Scene scene = new Scene(parent, 400, 400);
		// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		// primaryStage.setTitle("Login to Insurance Company");
		// primaryStage.setScene(scene);
		// primaryStage.hide();
		primaryStage.getOnHidden();
		primaryStage.close();
		// primaryStage.show();
		primaryStage.fullScreenExitHintProperty();
		return;

	}

	public void handle(ActionEvent event) {
		Platform.exit();
	}

	public void handle1(ActionEvent event) throws IOException {
		Parent parent = FXMLLoader.load(getClass().getResource("SetupRegister.fxml"));

		Stage primaryStage = new Stage();
		Scene scene = new Scene(parent, 500, 500);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setTitle("Get Email Adrress: for update a password that forgot by users");
		primaryStage.setScene(scene);

		primaryStage.show();
	}

	public void changeScreenButton(ActionEvent event) throws Exception {

		if (combobox.getValue().equals("Agent")) {
			label.setText("Welcome");
			Parent parent = FXMLLoader.load(getClass().getResource("Main.fxml"));

			Stage primaryStage = new Stage();
			Scene scene = new Scene(parent, 500, 500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Register page for Car_Insurance");
			primaryStage.setScene(scene);

			primaryStage.show();

		} else {
			// MessageForLogin.showMessage(Alert.AlertType.ERROR, owner, "Error!",
			// "Please try again");
			label.setText("Please Try again ");
			Stage primaryStage = new Stage();
			BorderPane parent = new BorderPane();
			Scene scene = new Scene(parent, 200, 200);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Error");
			primaryStage.setScene(scene);

			primaryStage.show();
			return;
		}
	}

	public void actionform(ActionEvent event) throws Exception, SQLException {
		DBConnect connection = null;
		Statement statement = null;

		ResultSet resultset2 = null;

		ResultSet resultset4 = null;
		connection = new DBConnect();
		try {

			statement = connection.connect().createStatement();
		if (name.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Please Try again for Login .... Invalid UserName or Password");
		} else {
				if (combobox.getValue().equals("User")) {
					String sql = "SELECT * from solmaz_policy where username = '" + name.getText()
						+ "' and password = '" + password.getText().toString() + "' ";
				if (statement.executeQuery(sql).next())

					{// label.setText("Welcome");
						JOptionPane.showMessageDialog(null, "Welcome  User Login  successfully..");
						// PolicyLoginControlProcessing.openpolicy();
						InsuranceProcessing.open();
					}	}

					// Parent parent = FXMLLoader.load(getClass().getResource("ManagerLogin.fxml"));

					// Stage primaryStage = new Stage();
					// Scene scene = new Scene(parent,500,500);
					// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					// primaryStage.setTitle("Manager Set up page");

					// primaryStage.show();}
		 else {
			String		sql = "SELECT * from solmaz_AgentLogin where usernameAgent = '" + name.getText()
							+ "' and passwordAgent = '" + password.getText().toString() + "' ";
					if (statement.executeQuery(sql).next()) {
						JOptionPane.showMessageDialog(null, "Welcome  Agent Login  successfully..");

						PolicyLoginControlProcessing.openpolicy();
						// InsuranceProcessing.open();
						// Parent parent = FXMLLoader.load(getClass().getResource("Main.fxml"));

						// Stage primaryStage = new Stage();
						// Scene scene = new Scene(parent,500,500);
						// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
						// primaryStage.setTitle("Get Auto Insurance Quotes at BestCarsInsurance.com");
						// primaryStage.setScene(scene);

						// primaryStage.show();
					} else {
						JOptionPane.showMessageDialog(null,
								"Please Try again for Login .... Invalid UserName or Password");
						// MessageForLogin.showMessage(Alert.AlertType.ERROR, owner, "Error!",
						// "Please try again");
						label.setText(" Please Try again for Login ");
						Stage primaryStage = new Stage();
						BorderPane parent = new BorderPane();
						Scene scene = new Scene(parent, 200, 200);
						scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
						primaryStage.setTitle("Error");
						primaryStage.setScene(scene);
						connection.connect().close();
					}	}
				 }
			
				}catch (Exception e) {
			System.out.print(e);
		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}
}
