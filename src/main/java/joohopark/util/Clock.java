package main.java.joohopark.util;

public class Clock {

    private int ticks;
    private long lastUpdate,
            now,
            lastTimer;
    private double delta;
    private static double nsPerTick = 1000000000D / 60D;

    public Clock(){

        ticks = 0;
        lastUpdate = System.nanoTime();
        lastTimer = System.currentTimeMillis();
        delta = 0f;

    }

    public boolean timer(){

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

    private void tick(){
        ticks++;
    }

    public static long getTime(){
        return (System.nanoTime());
    }

}
