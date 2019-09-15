package main.java.joohopark.element;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import main.java.joohopark.util.Clock;
import main.java.joohopark.util.Position;
import main.java.joohopark.util.Values;

import java.util.ArrayList;

public class Trace extends Element {

    Element target;
    ArrayList<Position> positions;
    long timeSinceLastRecord;

    public Trace(Element target){

        super();

        this.target = target;
        positions = new ArrayList<>();

        timeSinceLastRecord = 0;

        positions.add(new Position(target.x, target.y));

    }

    public void clear(){

        positions.clear();

    }

    @Override
    public void tick() {

        updateTime();
        if(timeSinceLastRecord >= 1000000000){
            positions.add(new Position(target.x, target.y));
            timeSinceLastRecord = 0;
        }

    }

    @Override
    void updateTime() {

        long now = Clock.getTime();
        if(!Clock.isPaused()) {
            deltaT = now - time;
            timeSinceLastRecord += deltaT;
        }
        time = now;


    }

    @Override
    public void draw(GraphicsContext gc) {

        gc.setFill(Color.RED);
        positions.forEach(pos -> gc.fillOval(Values.Coordinates.CENTER_X + pos.getX()- 3, Values.Coordinates.CENTER_Y - pos.getY() - 3, 6, 6));

    }
}
