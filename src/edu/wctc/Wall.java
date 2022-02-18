package edu.wctc;
import java.io.Serializable;
public class Wall implements Serializable {
    private double WIDTH;
    private double HEIGHT;
    public Wall(double width, double height) {
        this.WIDTH = width;
        this.HEIGHT = height;
    }
    public double getWidth() {
        return this.WIDTH;
    }
    public double getHeight() {
        return this.HEIGHT;
    }
    public double getArea() {
        return this.WIDTH * this.HEIGHT;
    }
}