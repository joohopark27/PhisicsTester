package main.java.joohopark.util;

public class Clock {

    private static int ticks;
    private static long lastUpdate,
            now,
            lastTimer;
    private static double delta;
    private static final double nsPerTick = 1000000000D / 60D;
    private static boolean isPaused;

    public static void reset(){

        ticks = 0;
        lastUpdate = System.nanoTime();
        lastTimer = System.currentTimeMillis();
        delta = 0f;
        isPaused = true;

    }

    public static boolean timer(){

        now = System.nanoTime();
        delta += (now - lastUpdate) / nsPerTick;
        lastUpdate = now;
        boolean shouldRender = false;

        if(delta >= 1){
            tick();
            delta--;
            shouldRender = true;
        }


        if (System.currentTimeMillis() - lastTimer > 1000){
            System.out.println("ticks: "+ ticks);
            lastTimer += 1000;
            ticks = 0;
        }

        return shouldRender;
    }

    private static void tick(){
        ticks++;
    }

    public static long getTime(){
        return (System.nanoTime());
    }

    public static boolean isPaused(){

        return isPaused;

    }

    public static void togglePause(){

        isPaused = !isPaused;

    }


    public static void pause(){

        isPaused = true;

    }

}
