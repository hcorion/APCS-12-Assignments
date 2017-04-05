// Lab14bv100.java
// This is the 100 point version
// Zion Nimchuk
// March 24, 2017
// This program draws a steam-powered train using Object Oriented Programming

import java.awt.*;
import java.util.ArrayList;

public class Train
{
    private int x;
    private int y;
    private ArrayList<RailCar> railCars = new ArrayList<RailCar>();
    public Train(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    // All of the trainCar's x position is set to 0 because when we can add trainCars at any position.
    public void addCar(int num, String carName, Color color)
    {
        num = num - 1;
        
        // Cleanly avoid programming error, most likely what was wanted anyway.
        if (num > railCars.size())
        {
            num = railCars.size();
        }
        
        switch (carName)
        {
            case "Locomotive":
                railCars.add(num, new Locomotive(color, 0, y));
                break;
            case "PassengerCar":
                railCars.add(num, new PassengerCar(color, 0, y));
                break;
            case "FreightCar":
                railCars.add(num, new FreightCar(color, 0, y));
                break;
            case "Caboose":
                railCars.add(num, new Caboose(color, 0, y));
                break;
            default:
                System.out.println("Unknown trainCar type: " + carName);
                break;
        }
    }

    public void addCar(String carName, Color color)
    {
        addCar(railCars.size() + 1, carName, color);
    }

    public void showCars(Graphics g)
    {
        for (int i = 0; i < railCars.size(); i++) 
        {
            // Because the programmer has the ability to add a trainCar at whatever position they like,
            // I need to recalculate the trainCars position on draw based on their position in the ArrayList.
            int newCarPosX = x + ((i + 1) * RailCar.carWidth);
            railCars.get(i).adjustPos(newCarPosX, y);
            // Now we can draw the car.
            railCars.get(i).drawCar(g);
        }
    }
}