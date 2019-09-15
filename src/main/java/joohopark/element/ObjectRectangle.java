package main.java.joohopark.element;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import main.java.joohopark.util.Values;
import main.java.joohopark.util.Vector;

public class ObjectRectangle extends Element {

    private int w, h;

    public ObjectRectangle(int w, int h){

        super(0, -200, 10, new Vector(200, 150), new Vector(-75, -54));

        this.w = w;
        this.h = h;

    }

    public ObjectRectangle(){
        this(100, 100);
    }

    @Override
    public void tick() {

        update();

    }

    @Override
    public void draw(GraphicsContext gc) {

        gc.setFill(Color.BLACK);
        gc.fillRect(Values.Coordinates.CENTER_X + x - w/2D, Values.Coordinates.CENTER_Y - y - h/2D, w, h);

    }
}
