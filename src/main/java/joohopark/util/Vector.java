package main.java.joohopark.util;

public class Vector {

    private double x;
    private double y;

    public Vector(Vector v){

        this.x = v.x;
        this.y = v.y;

    }

    public Vector(double x, double y){

        this.x = x;
        this.y = y;

    }

    public Vector(double x1, double y1, double x2, double y2){

        this(x2 - x1, y2 - y1);

    }

    private static double calcDistance(double x1, double y1, double x2, double y2){

        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));

    }

    private static double calcAngle(double x1, double y1, double x2, double y2){

        return ((x2 - x1 >= 0) ? 0 : Math.PI) + Math.atan2(x2 - x1, y2 - y1);

    }

    public double getX(){

        return x;

    }

    public double getY(){

        return y;

    }

    public void add(Vector v){

        x += v.x;
        y += v.y;

    }

    public void multiply(double scalar){

        x *= scalar;
        y *= scalar;

    }

}
