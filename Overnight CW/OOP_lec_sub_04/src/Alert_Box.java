import javafx.stage.*;
        import javafx.scene.*;
        import javafx.scene.layout.*;
        import javafx.scene.control.*;
        import javafx.geometry.*;

public class Alert_Box {

    public static void display(String title, String message) {
        Stage window = new Stage();

        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(500);
        window.setMinHeight(200);


        Label label = new Label();
        label.setText(message);
        Button yesButton = new Button("Yes");
        yesButton.setOnAction(e -> window.close());
        Button noButton = new Button("No");
        noButton.setOnAction(e -> Alert_Box2.display("Library Management System", "Thank You For Using Westminster Library Management System"));


        VBox layout = new VBox(50);
        layout.getChildren().addAll(label, yesButton,noButton);
        layout.setAlignment(Pos.CENTER);

        //Display window and wait for it to be closed before returning
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }

}
