package edu.wctc;
import java.io.*;
import java.util.Scanner;
public class Main {
    private static Scanner KEYBOARD = new Scanner(System.in);
    private static PaintCalculator PAINTCALCULATOR = new PaintCalculator();
    public static void main(String[] args) {
        int INPUT = 0;
        while (INPUT != 5) {
            printMenu();
            INPUT = KEYBOARD.nextInt();
            if (INPUT == 1) {
                createRoom();
            } else if (INPUT == 2) {
                writeFile();
            } else if (INPUT == 3) {
                readFile();
            } else if (INPUT == 4) {
                System.out.println(PAINTCALCULATOR.toString());
            }
        }
    }
    private static void printMenu() {
        System.out.println("ENTER 1: ADD ROOM");
        System.out.println("ENTER 2: WRITE ROOMS TO FILE");
        System.out.println("ENTER 3: READ ROOMS FROM FILE");
        System.out.println("ENTER 4: VIEW ROOMS");
        System.out.println("ENTER 5: EXIT");
        System.out.print("ENTER SELECTION NUMBER: ");
    }
    private static double promptForDimension(String dimensionName) {
        System.out.print("ENTER THE ROOM'S " + dimensionName + ": ");
        return KEYBOARD.nextDouble();
    }
    private static void createRoom() {
        double userLength = promptForDimension("LENGTH");
        double userWidth = promptForDimension("WIDTH");
        double userHeight = promptForDimension("HEIGHT");
        PAINTCALCULATOR.addRoom(userLength, userWidth, userHeight);
        System.out.println("ROOM CREATED SUCCESSFULLY");
    }
    private static void readFile() {
        try (
                FileInputStream fis = new FileInputStream("rooms.obj");
                ObjectInputStream ois = new ObjectInputStream(fis);
        ) {
            PAINTCALCULATOR = (PaintCalculator) ois.readObject();
            System.out.println("FILE READ SUCCESSFULLY");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private static void writeFile() {
        try (
                FileOutputStream fos = new FileOutputStream("rooms.obj");
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(PAINTCALCULATOR);
            System.out.println("FILE SAVED SUCCESSFULLY");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
