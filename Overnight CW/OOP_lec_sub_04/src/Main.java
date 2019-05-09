import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main extends Application {

    Stage window;
    TableView<Items> table;
    TextField ISBNInput, bookNameInput, authProNameInput, pubLangInput;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Welcome To Westminster Library Management System");

        //ISBN column
        TableColumn<Items, String> ISBNColumn = new TableColumn<>("ISBN");
        ISBNColumn.setMinWidth(100);
        ISBNColumn.setCellValueFactory(new PropertyValueFactory<>("ISBN"));

        //Item Name column
        TableColumn<Items, String> bookNameColumn = new TableColumn<>("Item Name");
        bookNameColumn.setMinWidth(200);
        bookNameColumn.setCellValueFactory(new PropertyValueFactory<>("bookName"));

        //Author/Producer Name column
        TableColumn<Items, Double> authProNameColumn = new TableColumn<>("Author/Producer Name");
        authProNameColumn.setMinWidth(190);
        authProNameColumn.setCellValueFactory(new PropertyValueFactory<>("authProName"));

        //Publisher/Languages column
        TableColumn<Items, String> pubLangColumn = new TableColumn<>("Publisher/Languages");
        pubLangColumn.setMinWidth(190);
        pubLangColumn.setCellValueFactory(new PropertyValueFactory<>("pubLang"));

        //Number Of Pages column
        TableColumn<Items, String> numOfPagesColumn = new TableColumn<>("Number Of Pages");
        numOfPagesColumn.setMinWidth(140);
        numOfPagesColumn.setCellValueFactory(new PropertyValueFactory<>("numOfPages"));

        //Actors column
        TableColumn<Items, Double> actorsColumn = new TableColumn<>("Actors");
        actorsColumn.setMinWidth(340);
        actorsColumn.setCellValueFactory(new PropertyValueFactory<>("actors"));

        //ISBN input
        ISBNInput = new TextField();
        ISBNInput.setPromptText("ISBN");
        GridPane.setConstraints(ISBNInput, 1, 0);

        //Item Name input
        bookNameInput = new TextField();
        bookNameInput.setPromptText("Item Name");
        bookNameInput.setMinWidth(130);

        //Author/Producer Name input
        authProNameInput = new TextField();
        authProNameInput.setPromptText("Author/Producer Name");

        //ublisher/Languages input
        pubLangInput = new TextField();
        pubLangInput.setPromptText("Publisher/Languages");

        //Add Button
        Button addButton = new Button("Add Item");
        addButton.setOnAction(e -> {
            if (validateISBN() && validate_book_DVD()){
                addButtonClicked();
            }
                });


        //Delete Button
        Button deleteButton = new Button("Delete Item");
        deleteButton.setOnAction(e -> deleteButtonClicked());

        //Borrow Item Button
        Button button = new Button("Borrow Item");
        button.setOnAction(e -> Alert_Box.display("Welcome To Westminister Library Management System", "Do you want to borrow another Item?"));

        //Return Item Button
        Button returnButton = new Button("Return Item");

        //Close Button
        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> closeButtonClicked());

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(13,13,13,13));
        hBox.setSpacing(13);
        hBox.getChildren().addAll(ISBNInput,bookNameInput, authProNameInput, pubLangInput, addButton, deleteButton, button, returnButton,closeButton);

        table = new TableView<>();
        table.setItems(getProduct());
        table.getColumns().addAll(ISBNColumn,bookNameColumn, authProNameColumn, pubLangColumn, numOfPagesColumn, actorsColumn);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(table, hBox);

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }



    //Add button clicked
    public void addButtonClicked(){
        Items product = new Items();
        product.setISBN(Integer.parseInt(ISBNInput.getText()));
        product.setBookName(bookNameInput.getText());
        product.setAuthProName(authProNameInput.getText());
        product.setPubLang(pubLangInput.getText());
        table.getItems().add(product);
        ISBNInput.clear();
        bookNameInput.clear();
        authProNameInput.clear();
        pubLangInput.clear();
    }

    //Delete button clicked
    public void deleteButtonClicked(){
        ObservableList<Items> productSelected, allProducts;
        allProducts = table.getItems();
        productSelected = table.getSelectionModel().getSelectedItems();
        productSelected.forEach(allProducts::remove);
    }

    //Close button clicked
    private void closeButtonClicked() {
        window.close();
    }

    //method to validate valid ISBN
    public boolean validateISBN(){
        Pattern p = Pattern.compile("[0-149]+");
        Matcher m = p.matcher(ISBNInput.getText());
        if (m.find() && m.group().equals(ISBNInput.getText())){
            return true;
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error : Invalid ISBN");
            alert.setHeaderText(null);
            alert.setContentText("You can't add another Book or DVD because their isn't enough space.");
            alert.showAndWait();
            return false;
        }
        }

    //method to validate valid Book/DVD name
    public boolean validate_book_DVD(){
        Pattern p = Pattern.compile("[a-zA-Z]+");
        Matcher m = p.matcher(bookNameInput.getText());
        if (m.find() && m.group().equals(bookNameInput.getText())){
            return true;
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error : Invalid Book/DVD Name");
            alert.setHeaderText(null);
            alert.setContentText("Invalid Book/DVD name. Plese enter valid name.");
            alert.showAndWait();
            return false;
        }
    }

    //Get all of the Items
    public ObservableList<Items> getProduct(){
        ObservableList<Items> products = FXCollections.observableArrayList();
        products.add(new Items(001,"Head First Java", "Kathy Sierra & Bert Bates", "ABC Publishers","2547","            - "));
        products.add(new Items(002,"Big Java", "Cay S. Horstmann", "ABC Publishers","4578","            - "));
        products.add(new Items(003,"Introduction To Java Programming", "Y. Daniel Liang", "KBC Publishers","5451","            - "));
        products.add(new Items(004,"Head First Design Patten", "Kathy Sierra & Bert Bates", "DEF Publishers","3546","            - "));
        products.add(new Items(005,"Thinking in Java", "Bruce Eckel", "USF Publishers","3654", "            - "));

        products.add(new Items(100,"The Nun", "Corin Hardy", "English","   - ","Demián Bichir,Taissa Farmi,Jonas Bloquet,Bonnie Aarons"));
        products.add(new Items(101,"Baaghi 2", "Sajid Nadiadwala", "Hindi","   - ","Tiger Shroff, Ronny Singh,Neha Salgaonkar ,Randeep Hooda"));
        products.add(new Items(102,"Annabelle", "James Wan", "English","   - ","Annabelle Wallis,Mia,Ward Horton,Kerry O'Malley"));
        products.add(new Items(103,"Jurassic Park", "Kathleen Kennedy", "English","   - ","Sam Neill,Jeff Goldblum, Laura Dern,Richard Attenborough"));
        products.add(new Items(104,"Venom", "Avi Arad", "English","   - ","Tom Hardy, Michelle Williams, Anne Weying,Scott Haze"));

        return products;
    }


}