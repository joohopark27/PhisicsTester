package main.java.joohopark.element;

import javafx.scene.canvas.GraphicsContext;
import main.java.joohopark.Main;
import main.java.joohopark.util.Clock;
import main.java.joohopark.util.Vector;

public abstract class Element {

    double x, y;
    double mass;
    long time, deltaT;

    Vector v;
    Vector a;

    Element(){

        this(0, 0, 0, new Vector(0, 0), new Vector(0, 0));

    }

    Element(double x, double y, double mass, Vector v, Vector a){

        this.x = x;
        this.y = y;
        this.mass = mass;
        this.v = v;
        this.a = a;

        time = Clock.getTime();

    }

    final void update(){

        move();
        accel();
        updateTime();

    }

    final void move(){

        Vector v = new Vector(this.v);
        v.multiply(deltaT / 1000000000D);
        x += v.getX();
        y += v.getY();

    }

    final void accel(){

        Vector a = new Vector(this.a);
        a.multiply(deltaT / 1000000000D);
        v.add(a);

    }

    void updateTime(){

        long now = Clock.getTime();
        deltaT = (!Clock.isPaused()) ? now - time : 0;
        time = now;

    }

    public abstract void tick();
    public abstract void draw(GraphicsContext gc);

}
