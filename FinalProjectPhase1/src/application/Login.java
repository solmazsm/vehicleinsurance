package application;
/**
 * @author (Solmaz Seyed Monir) Sunday, April 21,2018 Login.java Fianl Project
 *         package views  To write a program that to implement phase1 idea into 
 *         an MVC format.
 */

	import javafx.application.Application;
    import javafx.fxml.FXMLLoader;
    import javafx.stage.Stage;
    import javafx.scene.Parent;
    import javafx.scene.Scene;
/*
 * Create login for users 
 */
    public class Login extends Application{
        @Override
        public void start(Stage stage) throws Exception {
            Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
            Scene scene = new Scene(root);
          //  scene.getStylesheets().add("sseye.css");
            stage.setScene(scene);
            
            stage.setTitle("Login To Insurance Company");
            stage.show();
        }

    }

