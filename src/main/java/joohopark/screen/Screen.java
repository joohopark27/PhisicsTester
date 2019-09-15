package main.java.joohopark.screen;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

public class Screen {

    Stage screen;
    Canvas canvas;
    GraphicsContext gc;

    public Screen(Stage stage) throws Exception {

        this.screen = stage;

        canvas = new Canvas(800, 450);
        gc = canvas.getGraphicsContext2D();


        Pane root = new Pane();
        root.setPrefSize(800, 450);
//        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        root.getChildren().addAll(canvas);

        stage.setTitle("Tester");
        stage.setScene(new Scene(root, 800, 450));

        stage.show();

    }

    public void update(){
        screen.show();
    }

    public GraphicsContext getGraphicsContext(){
        return gc;
    }

}
