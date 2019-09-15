package main.java.joohopark.screen;

import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main.java.joohopark.Main;
import main.java.joohopark.util.Clock;
import main.java.joohopark.util.Values;

public class Screen {

    Stage screen;
    Canvas canvas;
    GraphicsContext gc;
    MenuBar menuBar;

    public Screen(Stage stage) throws Exception {

        this.screen = stage;

        canvas = new Canvas(Values.Screen.MAIN_SCREEN_WIDTH, Values.Screen.CANVAS_HEIGHT);
        gc = canvas.getGraphicsContext2D();

        menuBar = new MenuBar();
        Menu edit = new Menu("edit");
        MenuItem editRect = new MenuItem("edit rectangle val");
        editRect.setOnAction(e -> {
            Clock.pause();
            new EditRectVal(Main.elements.get(0));
        });
        menuBar.getMenus().add(edit);
        edit.getItems().add(editRect);

        Button pause = new Button("pause/resume");
        pause.setOnAction(e -> Clock.togglePause());
        pause.setPrefWidth(150);
        pause.setPrefHeight(Values.Screen.BUTTON_HEIGHT);

        VBox root = new VBox(menuBar);
        root.setPrefSize(Values.Screen.MAIN_SCREEN_WIDTH, Values.Screen.MAIN_SCREEN_HEIGHT);
        root.getChildren().add(canvas);
        root.getChildren().add(pause);

        stage.setTitle("Tester");
        stage.setScene(new Scene(root, Values.Screen.MAIN_SCREEN_WIDTH, Values.Screen.MAIN_SCREEN_HEIGHT));

        stage.show();

    }

    public GraphicsContext getGraphicsContext(){
        return gc;
    }

}
