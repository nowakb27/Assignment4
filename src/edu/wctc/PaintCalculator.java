package edu.wctc;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
public class PaintCalculator implements Serializable {
    private List<Room> ROOMLIST = new ArrayList<>();
    public void addRoom(double length, double width, double height) {
        ROOMLIST.add(new Room(length, width, height));
    }
    public String toString() {
        if (ROOMLIST.size() == 0) {
            return "NO ROOMS YET";
        }
        String RETURN = "";
        for (Room someRoom : ROOMLIST) {
            RETURN += someRoom.toString() + "\n";
        }
        return RETURN;
    }
}