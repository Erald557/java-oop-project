package UserGUI;

import Controller.UserController;
import Login.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class LoginView {

	public Scene showScene(Stage primaryStage){
		GridPane root = new GridPane();
		root.setHgap(10);
		root.setVgap(10);
		root.setPadding(new Insets(10,10,10,10));
		root.setAlignment(Pos.BASELINE_CENTER);
		
		Label userLabel = new Label("User");
		TextField userField = new TextField();
		root.add(userLabel,1,1);
		root.add(userField,2,1);
		
		Label passwordLabel = new Label("Password");
		PasswordField passwordField = new PasswordField();
		root.add(passwordLabel,1,2);
		root.add(passwordField,2,2);
		
		CheckBox box = new CheckBox("Remember Me?");
		root.add(box, 2, 4);
		
		Button login = new Button("Login");
		Button signup = new Button("SignUp");
		HBox h = new HBox();
		h.getChildren().addAll(login,signup);
		root.add(h, 2, 6);
		
		login.setOnAction(e->{
			String email =  userField.getText();
			String password = passwordField.getText();
			
			UserController uc2 = new UserController();
			User user = uc2.login(email, password);
			if(user!=null){
				Alert successAlert = new Alert(AlertType.CONFIRMATION);
				successAlert.setHeaderText("You have loged in successfully");
				successAlert.showAndWait();
				
				///HomeView///
				
				HomeView hv= new HomeView(user);
				primaryStage.setScene(hv.showView(primaryStage));
				
			}else{
				Alert failAlert = new Alert(AlertType.ERROR);
				failAlert.setHeaderText("Something Went wrong");
				failAlert.showAndWait();
			}
		});
		
		signup.setOnAction(e->{
			SignUpView sp = new SignUpView();
			primaryStage.setScene(sp.showScene(primaryStage));
		});
	
		
		
		primaryStage.setTitle("LogIn");
		Scene scene = new Scene(root, 350, 200);
		return scene;
	}
}
