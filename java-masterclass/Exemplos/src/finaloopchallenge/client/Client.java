package finaloopchallenge.client;


import finaloopchallenge.burger.StandardBurger;
import finaloopchallenge.burger.additional.Additional;

import java.util.ArrayList;
import java.util.List;

/**
 * * created by lgcaobianco on 5/6/19
 **/

public class Client implements CalculateValueOfOrder {
    private String name;
    private List<StandardBurger> burgers;

    public Client(String name) {
        this.name = name;
        burgers = new ArrayList<>();
    }

    public StandardBurger getBurger(int number){
        return burgers.get(number);
    }

    public void orderBurger(StandardBurger burger){
        System.out.println("Order of burger by client: "+ name);
        System.out.println(burger);
        this.burgers.add(burger);
    }

    public void askForAdditional(Additional additional){
        StandardBurger burger = burgers.get(burgers.size()-1);
        System.out.println("client "+ this.name +" has ordered the following additional: ");
        System.out.println(additional);
        burger.addAdditional(additional);
    }

    @Override
    public double calculateValueOfOrder() {
        Double totalOfOrder = 0D;
        System.out.println("BURGERS ASKED BY CLIENT " +name.toUpperCase() + ": ");
        for(StandardBurger burger: burgers){
            System.out.println(burger);
            totalOfOrder += burger.calculateValueOfBurger();
            System.out.println("\n\n");
        }
        System.out.println("==== TOTAL OF: "+totalOfOrder +" ====");
        return totalOfOrder;
    }
}
