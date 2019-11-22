package controllers;

/**
 * @author (Solmaz Seyed Monir) Sunday, April 21,2018 Agent Login .java Fianl Project
 *         package views  To write a program that to implement phase1 idea into 
 *         an MVC format.
 */
	

	import javafx.fxml.FXML;
	import javafx.scene.control.PasswordField;
	import javafx.scene.control.TextField;
/*
 * Create username and password
 */
	public class AgentLogin {
		
		private String usernameAgent;
		private String passwordAgent;
		  @FXML
		    private TextField usernameAgent1 ;

		    @FXML
		    private PasswordField password1;

		    @FXML
		    
	
		/**
			 * @return the usernameAgent1
			 */
			public TextField getusernameAgent1() {
				return usernameAgent1;
			}


			/**
			 * @param usernameAgent1 the usernameAgent1 to set
			 */
			public void setusernameAgent1(TextField usernameAgent1) {
				this.usernameAgent1 = usernameAgent1;
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
			 * @return the usernameAgent
			 */
			public String getusernameAgent() {
				return usernameAgent;
			}


			/**
			 * @param usernameAgent the usernameAgent to set
			 */
			public void setusernameAgent(String usernameAgent) {
				this.usernameAgent = usernameAgent;
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
