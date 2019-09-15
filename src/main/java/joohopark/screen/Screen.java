package main.java.joohopark.screen;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;

public class Screen {

    Stage screen;
    Canvas canvas;
    GraphicsContext gc;

    public Screen(Stage stage) throws Exception {

        this.screen = stage;

        canvas = new Canvas(800, 450);
        gc = canvas.getGraphicsContext2D();
        Group root = new Group();
//        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        root.getChildren().add(canvas);
        stage.setTitle("Tester");
        stage.setScene(new Scene(root, 800, 450));

        stage.show();

    }

    public GraphicsContext getGraphicsContext(){
        return gc;
    }

}
