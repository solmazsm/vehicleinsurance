package carsInsurance;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Policy {
	/*
	 * instance fields with appropriate data types
	 */
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
			return password;
		}


		/**
		 * @param password the password to set
		 */
		public void setPassword(String password) {
			this.password = password;
		}


		/**
		 * @return the states
		 */
		public String getStates() {
			return state;
		}


		/**
		 * @param states the states to set
		 */
		public void setStates(String states) {
			this.state = states;
		}


		/**
		 * @return the zipCode
		 */
		public String getZipCode() {
			return zipCode;
		}


		/**
		 * @param zipCode the zipCode to set
		 */
		public void setZipCode(String zipCode) {
			this.zipCode = zipCode;
		}


		/**
		 * @return the insuredName
		 */
		public String getInsuredName() {
			return insuredName;
		}


		/**
		 * @param insuredName the insuredName to set
		 */
		public void setInsuredName(String insuredName) {
			this.insuredName = insuredName;
		}


		/**
		 * @return the policyNumber
		 */
		public String getPolicyNumber() {
			return policyNumber;
		}


		/**
		 * @param policyNumber the policyNumber to set
		 */
		public void setPolicyNumber(String policyNumber) {
			this.policyNumber = policyNumber;
		}


		/**
		 * @return the vin
		 */
		public Vehicle getVin() {
			return vin;
		}


		/**
		 * @param vin the vin to set
		 */
		public void setVin(Vehicle vin) {
			this.vin = vin;
		}


	private String password;
	private String state;
	private String zipCode;
	private String insuredName;
	private String policyNumber;
	private Vehicle vin;


private void login() {
     username = username1.getText();
     password = password1.getText();
}
}