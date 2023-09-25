package UserGUI;

import Controller.UserController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SignUpView {

	public Scene showScene(Stage primaryStage){
		GridPane root = new GridPane();
		root.setHgap(10);
		root.setVgap(10);
		root.setPadding(new Insets(10,10,10,10));
		
		Label nameLabel = new Label("Name");
		TextField nameField = new TextField();
		root.add(nameLabel,1,1);
		root.add(nameField,2,1);
		
		Label lastnameLabel = new Label("LastName");
		TextField  lastnameField = new TextField();
		root.add( lastnameLabel,1,2);
		root.add( lastnameField,2,2);
		
		Label emailLabel = new Label("Email");
		TextField  emailField = new TextField();
		root.add( emailLabel,1,3);
		root.add( emailField,2,3);
		
		Label passwordLabel = new Label("Password");
		PasswordField passwordField = new PasswordField();
		root.add(passwordLabel,1,4);
		root.add(passwordField,2,4);
		
		Label verifypasswordLabel = new Label("Verify Password");
		PasswordField verifypasswordField = new PasswordField();
		root.add(verifypasswordLabel,1,5);
		root.add(verifypasswordField,2,5);
		
		Label genderLabel = new Label("Gender");
		root.add( genderLabel,1,6);
		RadioButton male = new RadioButton("Male");
		RadioButton female = new RadioButton("Female");
		RadioButton other = new RadioButton("Other");
		VBox v = new VBox();
		v.getChildren().addAll(other);
		root.add(other, 2, 7);
		HBox h = new HBox();
		h.getChildren().addAll(male,female);
		root.add(h, 2, 6);
		
		Label descriptionLabel = new Label("Description");
		root.add( descriptionLabel,1,8);
		TextArea descriptionArea = new TextArea();
		root.add(descriptionArea,2,8);
		
		Label professionLabel = new Label("Profession");
		root.add(professionLabel,1,9);
		ComboBox prefession =new ComboBox();
		prefession.getItems().add("Cashier");
		prefession.getItems().add("Manager");
		prefession.getItems().add("Administator");
		root.add(prefession, 2, 9);
		
		CheckBox box = new CheckBox("Remember Me?");
		root.add(box, 2, 10);
		
		Button signup = new Button("Sign Up");
		Button back = new Button("Back");
		HBox R = new HBox();
		R.getChildren().addAll(signup,back);
		root.add(R, 2, 11);
		
		signup.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String name = nameField.getText();
				String surname = lastnameField.getText();
				String email = emailField.getText();
				String password = passwordField.getText();
				String verifypassword = verifypasswordField.getText();
				String description = descriptionArea.getText();
				String gender = "";
				if(male.isSelected()){
					gender = male.getText();
				}else {
					if(female.isSelected()){
						gender = female.getText();
					}else{
						gender = other.getText();
					}
				}
				String proffession = (String) prefession.getValue();
				boolean isRememberme = box.isSelected();
                UserController uc = new UserController();			
				boolean isRegistered = uc.SignedUp(name, surname, email, password, verifypassword, gender, description, proffession, isRememberme);
			if(isRegistered){
				Alert successAlert = new Alert(AlertType.CONFIRMATION);
				successAlert.setHeaderText("The User is created succesfully");
				successAlert.showAndWait();
			///////////////////////////////////////////
				
				LoginView lv = new LoginView();
				primaryStage.setScene(lv.showScene(primaryStage));
				
			}else{
				Alert failAlert = new Alert(AlertType.ERROR);
				failAlert.setHeaderText("Something Went wrong");
				failAlert.showAndWait();
			}
			}
			});
		        
		back.setOnAction(e->{
			AllUsersView lv = new AllUsersView();
			primaryStage.setScene(lv.showView(primaryStage));
			
		});
		
		Scene scene = new Scene(root, 650, 600);
		primaryStage.setTitle("Register Here");
		return scene;
	}
}
