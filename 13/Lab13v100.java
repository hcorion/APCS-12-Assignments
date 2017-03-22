// Lab13v100.java
// This is the 100 point version
// Zion Nimchuk
// March 20, 2017
// This program simulates a variety of stores using 1 interface, 1 abstract class and 5 concrete classes.

import java.util.ArrayList;
import java.util.Arrays;

public class Lab13v100
{
    public static void main (String[] args)
    {
        FarmersMarket market = new FarmersMarket<Consumable>();

        ArrayList<Consumable> foods = new ArrayList<Consumable>();
        foods.add(new Consumable("Banana"));
        foods.add(new Consumable("Pumpkin"));
        foods.add(new Consumable("Apple", true));
        market.stock(foods);

        System.out.println(market.getGoods());
        
        Object item = market.buy(new Consumable("Banana"));

        market.addEmployee(new Employee("Jimmy McGives"));

        Consumable pumpkin = (Consumable)market.buy(new Consumable("Pumpkin"));

        System.out.println(market.getGoods());

        market.closeStore();


    }
}