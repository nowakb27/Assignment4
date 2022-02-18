package edu.wctc;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
public class Room implements Serializable {
    private List<Wall> WALLLIST = new ArrayList<>();
    public Room(double length, double width, double height) {
        Wall WALL1 = new Wall(width,height);
        Wall WALL2 = new Wall(width,height);
        Wall WALL3 = new Wall(length, height);
        Wall WaLL4 = new Wall(length, height);
        WALLLIST.add(WALL1);
        WALLLIST.add(WALL2);
        WALLLIST.add(WALL3);
        WALLLIST.add(WaLL4);
    }
    public double getArea() {
        double AREA = 0;
        for (Wall someWall : WALLLIST) {
            AREA += someWall.getArea();
        }
        return AREA;
    }
    public String toString() {
        return "ROOM AREA: " + this.getArea();
    }

}