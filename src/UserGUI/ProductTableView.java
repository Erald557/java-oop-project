package UserGUI;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
 
public class ProductTableView extends Application {
	
	
    private TableView<Product> table = new TableView<Product>();
    private final ObservableList<Product> data =
            FXCollections.observableArrayList();
           
    final HBox hb = new HBox();
 
    public static void main(String[] args) {
        launch(args);
    }
 
    public Scene showView(Stage primaryStage) {
        Scene scene = new Scene(new Group());
        primaryStage.setTitle("Product Table");
        primaryStage.setWidth(450);
        primaryStage.setHeight(550);
 
        final Label label = new Label("Table of Product View");
        label.setFont(new Font("Arial", 20));
 
        table.setEditable(true);
 
        TableColumn nameCol = new TableColumn("Product Name");
        nameCol.setMinWidth(100);
        nameCol.setCellValueFactory(
                new PropertyValueFactory<Product, String>("productname"));
 
        TableColumn priceCol = new TableColumn("Product Price");
        priceCol.setMinWidth(100);
        priceCol.setCellValueFactory(
                new PropertyValueFactory<Product, String>("productPrice"));
 
        TableColumn supplierCol = new TableColumn("Supplier");
        supplierCol.setMinWidth(100);
        supplierCol.setCellValueFactory(
                new PropertyValueFactory<Product, String>("supplier"));
        
        TableColumn sellCol = new TableColumn("Sell Price");
        sellCol.setMinWidth(100);
        sellCol.setCellValueFactory(
                new PropertyValueFactory<Product, String>("supplier"));
 
        table.setItems(data);
        table.getColumns().addAll(nameCol, priceCol, supplierCol,sellCol);
 
        final TextField addname = new TextField();
        addname.setPromptText("Product Name");
        addname.setMaxWidth(nameCol.getPrefWidth());
       
        final TextField addPrice = new TextField();
        addPrice.setMaxWidth(priceCol.getPrefWidth());
        addPrice.setPromptText("Product Price");
        
        final TextField addSupplier = new TextField();
        addSupplier.setMaxWidth(supplierCol.getPrefWidth());
        addSupplier.setPromptText("Supplier");
       
        final TextField addSell = new TextField();
        addSell.setMaxWidth(supplierCol.getPrefWidth());
        addSell.setPromptText("Sell Price");
       
        final Button addButton = new Button("Add");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                data.add(new Product(
                        addname.getText(),
                        addPrice.getText(),
                        addSupplier.getText(),
                        addSell.getText()));
                addname.clear();
                addPrice.clear();
                addSupplier.clear();
                addSell.clear();
            }
        });
 
        Button back = new Button("Save");
        back.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				  HomeView hv = new HomeView();
					primaryStage.setScene(hv.showView(primaryStage));
				
			}
        	
        	
        });
        hb.getChildren().addAll(addname, addPrice, addSupplier,addSell, addButton,back);
        hb.setSpacing(3);
 
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, hb);
 
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
 
        primaryStage.setScene(scene);
        primaryStage.show();
		return scene;
    }
 
    public static class Product {
 
       private final String productname,productPrice,supplier,Sell;

	public Product(String productname, String productPrice, String supplier, String seller) {
		super();
		this.productname = productname;
		this.productPrice = productPrice;
		this.supplier = supplier;
		Sell = seller;
	}

	@Override
	public String toString() {
		return "Product [productname=" + productname + ", productPrice=" + productPrice + ", supplier=" + supplier
				+ ", Seller=" + Sell + "]";
	}

	public String getProductname() {
		return productname;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public String getSupplier() {
		return supplier;
	}

	public String getSell() {
		return Sell;
	}
 
        
    }

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

	
} 