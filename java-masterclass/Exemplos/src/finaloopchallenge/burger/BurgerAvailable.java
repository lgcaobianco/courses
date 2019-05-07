package finaloopchallenge.burger;

import finaloopchallenge.burger.additional.Additional;
import finaloopchallenge.burger.exception.BurgerNotExistentException;

import java.util.ArrayList;
import java.util.List;

/**
 * * created by lgcaobianco on 5/6/19
 **/

public class BurgerAvailable {
    private List<StandardBurger> burgers;

    public BurgerAvailable() {
        burgers = new ArrayList<>();
    }

    public void addBurgerAsAvailable(StandardBurger burger) {
        burgers.add(burger);
    }

    public StandardBurger getBurgerByName(String name) {
        for (StandardBurger standardBurger : burgers) {
            if (standardBurger.getName().equals(name)) {
                return standardBurger;
            }
        }
        System.out.println("Burger not found, adding normal burger!");
        return burgers.get(0);
    }

    public void showBurgersAvailable() {
        for (StandardBurger burger : burgers) {
            System.out.println(burger);
        }
    }
}
