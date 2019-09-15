package main.java.joohopark.screen;

import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import main.java.joohopark.Main;
import main.java.joohopark.element.Element;
import main.java.joohopark.util.Clock;
import main.java.joohopark.util.Values;
import main.java.joohopark.util.Vector;

public class EditRectVal {

    private Element rectangle;
    private Stage stage;

    public EditRectVal(Element rectangle){

        this.rectangle = rectangle;

        stage = new Stage();
        VBox root = new VBox();

        Slider x = new Slider(Values.Screen.MAIN_SCREEN_WIDTH / -2.0, Values.Screen.MAIN_SCREEN_WIDTH / 2.0, 10);
        Slider y = new Slider(Values.Screen.MAIN_SCREEN_HEIGHT / -2.0, Values.Screen.MAIN_SCREEN_HEIGHT / 2.0, 20);
        Slider v = new Slider(-200, 200, 10);
        Slider accel = new Slider(-200, 200, 10);

        Button change = new Button("change");
        change.setOnAction(e -> {
            rectangle.setX(x.getValue());
            rectangle.setY(y.getValue());
            rectangle.setA(new Vector(accel.getValue(), 0));
            rectangle.setV(new Vector(v.getValue(), 0));
            stage.close();
        });

        root.getChildren().add(x);
        root.getChildren().add(y);
        root.getChildren().add(v);
        root.getChildren().add(accel);
        root.getChildren().add(change);

        stage.setTitle("Edit Rectangle Values");
        stage.setScene(new Scene(root, Values.Screen.EDIT_MENU_WIDTH, Values.Screen.EDIT_MENU_HEIGHT));

        stage.show();

    }


}
