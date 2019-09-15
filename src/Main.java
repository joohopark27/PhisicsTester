import screen.Screen;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application implements Runnable{

    private boolean isRunning;

    static Thread thread;
    Screen screen;
    Clock clock;

    @Override
    public void start(Stage primaryStage) throws Exception{

        screen = new Screen(primaryStage);
        clock = new Clock();

    }

    public static void main(String[] args) {
        thread = new Thread(new Main());
        thread.start();
    }

    @Override
    public void run() {

        while(isRunning){
            if(clock.timer()) {
//                tick();
//                update();
            }
        }
        stop();

    }

    public synchronized void start(String[] args){

        if(isRunning){
            return;
        }
        isRunning = true;
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
