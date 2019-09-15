package element;

import javafx.scene.canvas.GraphicsContext;

public abstract class Element {

    double x, y;
    double mass;

    Element(double x, double y, double mass){

        this.x = x;
        this.y = y;
        this.mass = mass;

    }

    abstract void tick();
    abstract void draw(GraphicsContext gc);

}
