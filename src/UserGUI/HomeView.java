package UserGUI;


import Login.User;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HomeView {
	public User cusers;
	
	public HomeView(){
		
	}
	public HomeView (User users){
		this.cusers = users;
		
	}
	
	
	public Scene showView(Stage stage){
		GridPane root = new GridPane();
		
///////////////////////////   MENUBAR       /////////////////////////////////////////////////////////
		MenuBar menubar = new MenuBar();
		Menu userMenu = new Menu("File");
		MenuItem One = new MenuItem("DataFile");
		One.setOnAction(e->{
			Alert info = new Alert(AlertType.INFORMATION);
			
			info.setHeaderText("There is no Data File sorry :(");
			info.show();
		});
		MenuItem Two = new MenuItem("Refresh");
		Two.setOnAction(e->{
			Alert info = new Alert(AlertType.INFORMATION);
			
			info.setHeaderText("Cant refresh :(");
			info.show();
		});
		MenuItem Three = new MenuItem("Exit");
		userMenu.getItems().addAll(One, Two, Three);
	
		
		Menu help = new Menu("Help");
		MenuItem info1 = new MenuItem("About");
		info1.setOnAction(e->{

			Alert info = new Alert(AlertType.INFORMATION);
			info.setHeaderText("This project was developet by Esmeraldo Shtaro using Java and JavaFX");
			info.show();
		});
		help.getItems().add(info1);
		
		
		Label logoutLabel= new Label("Logout"); 
		Menu logout = new Menu("",logoutLabel);
		logoutLabel.setOnMouseClicked(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				Alert info = new Alert(AlertType.INFORMATION);
				info.setHeaderText("You are logged out");
				info.show();
				LoginView lv = new LoginView();
				stage.setScene(lv.showScene(stage));
			}
			
		});
		menubar.getMenus().addAll(userMenu,help,logout);
		root.add(menubar,1,1);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
	
		
		HBox hb = new HBox();
		Button getallUsers = new Button("Users Table");
		getallUsers.setAlignment(Pos.BOTTOM_LEFT);
		getallUsers.setOnAction(e->{
			AllUsersView allUsers = new AllUsersView();
			stage.setScene(allUsers.showView(stage));
		});
	

		Button producttable = new Button("Product Table");
		producttable.setAlignment(Pos.BOTTOM_LEFT);
		producttable.setOnAction(e->{
			ProductTableView product = new ProductTableView();
			stage.setScene(product.showView(stage));
		});
		
		hb.getChildren().addAll(getallUsers,producttable);
        hb.setSpacing(3);
        root.add(hb, 1, 2);
		
	
		Scene sc = new Scene(root, 450, 450);
		stage.setTitle("Home");
		return sc;
	}

}
