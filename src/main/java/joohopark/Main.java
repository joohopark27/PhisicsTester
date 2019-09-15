package main.java.joohopark;

import javafx.scene.paint.Color;
import main.java.joohopark.element.Element;
import main.java.joohopark.element.ObjectRectangle;
import main.java.joohopark.element.Trace;
import main.java.joohopark.screen.Screen;
import javafx.application.Application;
import javafx.stage.Stage;
import main.java.joohopark.util.Clock;

import java.util.ArrayList;

public class Main extends Application implements Runnable{

    private static boolean isRunning;

    public static Clock clock;
    static Screen screen;
    ArrayList<Element> elements;
    Thread thread;

    public static void main(String[] args) {

        new Main().start(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        screen = new Screen(primaryStage);

    }

    private void initialize(){

        try{
            thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }

        clock = new Clock();
        elements = new ArrayList<>();

        Element rect = new ObjectRectangle();
        Element rectTrace = new Trace(rect);
        elements.add(rect);
        elements.add(rectTrace);

    }

    @Override
    public void run() {

        initialize();

        while(isRunning){
            if(clock.timer()) {
                tick();
                render();
            }
        }

        stop();

    }

    private void tick(){

        elements.forEach(element -> element.tick());

    }

    private void render(){

        screen.getGraphicsContext().clearRect(0, 0, 800, 450);

        elements.forEach(element -> element.draw(screen.getGraphicsContext()));

    }

    public synchronized void start(String[] args){

        if(isRunning){
            return;
        }
        isRunning = true;

        thread = new Thread(new Main());
        thread.start();
        launch(args);

    }

    public synchronized void stop(){
        if(!isRunning){
            return;
        }
        isRunning = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
