package main.java.joohopark.element;

import javafx.scene.canvas.GraphicsContext;
import main.java.joohopark.util.Vector;

import static main.java.joohopark.Main.clock;

public abstract class Element {

    double x, y;
    double mass;
    Vector v;
    Vector a;

    long time, deltaT;

    Element(double x, double y, double mass, Vector v, Vector a){

        this.x = x;
        this.y = y;
        this.mass = mass;
        this.v = v;
        this.a = a;

        time = clock.getTime();

    }

    final void update(){

        move();
        accel();
        updateTime();

    }

    private final void move(){

        Vector v = new Vector(this.v);
        v.multiply(deltaT / 1000000000D);
        x += v.getX();
        y += v.getY();

    }

    private final void accel(){

        Vector a = new Vector(this.a);
        a.multiply(deltaT / 1000000000D);
        v.add(a);

    }

    private final void updateTime(){

        long now = clock.getTime();
        deltaT = now - time;
        time = now;

    }

    public abstract void tick();
    public abstract void draw(GraphicsContext gc);

}
