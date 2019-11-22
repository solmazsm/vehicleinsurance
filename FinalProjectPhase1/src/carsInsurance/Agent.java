package carsInsurance;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Agent {
	
	private String usernameAgent;
	private String passwordAgent;
	  @FXML
	    private TextField username1 ;

	    @FXML
	    private PasswordField password1;

	    @FXML
	    
	private String username;
	/**
		 * @return the username1
		 */
		public TextField getUsername1() {
			return username1;
		}


		/**
		 * @param username1 the username1 to set
		 */
		public void setUsername1(TextField username1) {
			this.username1 = username1;
		}


		/**
		 * @return the password1
		 */
		public PasswordField getPassword1() {
			return password1;
		}


		/**
		 * @param password1 the password1 to set
		 */
		public void setPassword1(PasswordField password1) {
			this.password1 = password1;
		}


		/**
		 * @return the username
		 */
		public String getUsername() {
			return username;
		}


		/**
		 * @param username the username to set
		 */
		public void setUsername(String username) {
			this.username = username;
		}


		/**
		 * @return the password
		 */
		public String getPassword() {
			return passwordAgent;
		}


		/**
		 * @param password the password to set
		 */
		public void setPassword(String password) {
			this.passwordAgent = password;
		}


}