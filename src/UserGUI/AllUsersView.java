package UserGUI;

import Controller.UserController;
import Login.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.geometry.Pos;

public class AllUsersView {
	
	public Scene showView(Stage primaryStage){
		UserController uc = new UserController();
		
		 Label label = new Label("Table of Users View");
	       label.setFont(new Font("Arial", 20));
		ObservableList<User> users = FXCollections.observableArrayList( uc.getUsers());
		
	
		 VBox vbox = new VBox();
		TableView<User> table = new TableView();
		table.setEditable(true);
		table.setItems(users);
	
		TableColumn nameColumn = new TableColumn("First Name");
		nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		nameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("Name"));
		nameColumn.setOnEditCommit(new EventHandler<CellEditEvent<User, String>>(){

			@Override
			public void handle(CellEditEvent<User, String> tc) {
				// TODO Auto-generated method stub
				User currentUser = (User) tc.getTableView().getItems().get(tc.getTablePosition().getRow());
				
				int pos = uc.positionOfUser(currentUser);
				currentUser.setName(tc.getNewValue());
				uc.editUser(currentUser,pos);
			}
			
		});
		
		TableColumn surnameColumn = new TableColumn("Surname");
		surnameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		surnameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("Surname"));
		
		TableColumn emailColumn = new TableColumn("Email");
		emailColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		emailColumn.setCellValueFactory(new PropertyValueFactory<User, String>("Email"));
		
		TableColumn genderColumn = new TableColumn("Gender");
		genderColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		genderColumn.setCellValueFactory(new PropertyValueFactory<User, String>("Gender"));
		
		TableColumn professionColumn = new TableColumn("Profession");
		professionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		professionColumn.setCellValueFactory(new PropertyValueFactory<User, String>("Profession"));
		
		TableColumn descriptionColumn = new TableColumn("Description");
		descriptionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		descriptionColumn.setCellValueFactory(new PropertyValueFactory<User, String>("Description"));
		
		table.getColumns().addAll(nameColumn,surnameColumn,genderColumn,professionColumn,descriptionColumn);
		
		
		HBox hb = new HBox();
		
		Button addUser = new Button("Add New User");
		addUser.setAlignment(Pos.TOP_LEFT);
		addUser.setOnAction(e->{
			SignUpView sp = new SignUpView();
			primaryStage.setScene(sp.showScene(primaryStage));
		});
		Button save = new Button("Save");
		save.setAlignment(Pos.TOP_LEFT);
		save.setOnAction(e->{
		    HomeView hv = new HomeView();
			primaryStage.setScene(hv.showView(primaryStage));
		});
		hb.getChildren().addAll(addUser,save);
		vbox.getChildren().addAll(label,table,hb);
        
		Scene sc = new Scene(vbox, 370, 450);
		primaryStage.setTitle("Users Table"); 
		return sc;
	}
}
