// Author Name: Jason Kellie
// Date: 01/12/2021
// Program Name: Kellie_Drone
// Purpose: Simulation using button, drone movement in x, y,z location

package com.sscf.edu;

import java.util.Scanner;

public class Kellie_Drone {
    private int x, y, z;
    private int direction;
    private String message = "";

    public Kellie_Drone() {
        x = 0;
        y = 0;
        z = 0;
        direction = 0;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    //move drone up
    public void moveUp() {
        z += 1;
    }

    //move drone down
    public void moveDown() {
        z -= 1;
        if(z<0) {
            z = 0;
        }
    }

    //move drone forward
    public void forward() {
        switch (direction) {
            case 0: y += 1; break;
            case 1: x += 1; break;
            case 2: y -= 1; break;
            case 3: x -= 1; break;
        }
        message = "You have moved forward";
    }

    //move drone back
    public void backward() {
        switch (direction) {
            case 0: y -= 1; break;
            case 1: x -= 1; break;
            case 2: y += 1; break;
            case 3: x += 1; break;
        }
        message = "You have moved backward";
    }

    //turn drone right
    public void turnRight() {
        direction = (direction + 1) % 4;
        message = "You have turned right";
    }

    //turn drone left
    public void turnLeft() {
        direction--;
        if (direction < 0) {
            direction = 3;
        }
        message = "You have turned left";
    }

    //report position
    public void position() {
        message = "Kellie_Drone is at (x = " + getX() + " y = " + getY() + " z = " + getZ() + ")";
    }

    @Override
    public String toString() {
        return message;
    }

    public static void main(String[] args) {
        Kellie_Drone drone = new Kellie_Drone();
        Scanner scanner = new Scanner(System.in);
        Integer choice = 0;

        while (!choice.equals(8)) {
            System.out.println("\n" + drone + "\n");
            System.out.println("Enter 1 to move up");
            System.out.println("Enter 2 to move down");
            System.out.println("Enter 3 to move forward");
            System.out.println("Enter 4 to move backward");
            System.out.println("Enter 5 to turn right");
            System.out.println("Enter 6 to turn left");
            System.out.println("Enter 7 to display position");
            System.out.println("Enter 8 to exit navigation");
            System.out.print("Your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1: drone.moveUp(); break;
                case 2: drone.moveDown(); break;
                case 3: drone.forward(); break;
                case 4: drone.backward(); break;
                case 5: drone.turnRight(); break;
                case 6: drone.turnLeft(); break;
                case 7: drone.position();
            }
        }
    }
}
