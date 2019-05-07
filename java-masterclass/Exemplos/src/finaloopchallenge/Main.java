package finaloopchallenge;

import finaloopchallenge.burger.*;
import finaloopchallenge.burger.additional.Additional;
import finaloopchallenge.burger.additional.AdditionalsAvailable;
import finaloopchallenge.burger.exception.BurgerNotExistentException;
import finaloopchallenge.client.Client;

/**
 * * created by lgcaobianco on 5/6/19
 **/

public class Main {
    public static BurgerAvailable createSomeBurgers() {
        BurgerAvailable burgersAvailable = new BurgerAvailable();
        burgersAvailable.addBurgerAsAvailable(new StandardBurger("Pao de batata", Meat.CHICKEN));
        burgersAvailable.addBurgerAsAvailable(new DeluxeBurguer("Pao de mandioquinha", Meat.BEEF));
        burgersAvailable.addBurgerAsAvailable(new HealthyBurger(Meat.VEGETARIAN));
        return burgersAvailable;
    }

    public static AdditionalsAvailable createSomeAdditionals() {
        AdditionalsAvailable additionalsAvailable = new AdditionalsAvailable();
        additionalsAvailable.addAdditionalAsAvailable(new Additional("bacon", 2.5));
        additionalsAvailable.addAdditionalAsAvailable(new Additional("double cheese", 2.30));
        additionalsAvailable.addAdditionalAsAvailable(new Additional("cheddar", 1.35));
        additionalsAvailable.addAdditionalAsAvailable(new Additional("gorgonzolla", 3.20));
        additionalsAvailable.addAdditionalAsAvailable(new Additional("toasted garlic", 1.95));
        additionalsAvailable.addAdditionalAsAvailable(new Additional("parmeson cheese", 3.10));
        return additionalsAvailable;
    }

    public static void main(String[] args) throws BurgerNotExistentException     {
        Client client = new Client("Luiz Gustavo");
        BurgerAvailable burgersAvailable = createSomeBurgers();


        AdditionalsAvailable currentAdditionals = createSomeAdditionals();
        currentAdditionals.showAdditionalsAvailable();
        client.orderBurger(burgersAvailable.getBurgerByName("standard"));
        client.askForAdditional(currentAdditionals.getAdditionalByName("bacon"));
        client.askForAdditional(currentAdditionals.getAdditionalByName("double cheese"));
        client.askForAdditional(currentAdditionals.getAdditionalByName("cheddar"));
        client.askForAdditional(currentAdditionals.getAdditionalByName("toasted garlic"));
        client.askForAdditional(currentAdditionals.getAdditionalByName("double cheese"));


        client.orderBurger(burgersAvailable.getBurgerByName("deluxe"));

        client.orderBurger(burgersAvailable.getBurgerByName("healthy"));

        System.out.println("\n\nYOUR ORDER HAS BEEN FINISHED. CHECK WILL NOW BE ASSESSD");
        client.calculateValueOfOrder();

        Client client2 = new Client("Ana Paula");
        client2.orderBurger(burgersAvailable.getBurgerByName("healthy"));
        client2.askForAdditional(currentAdditionals.getAdditionalByName("bacon"));
        client2.askForAdditional(currentAdditionals.getAdditionalByName("double cheese"));
        client2.calculateValueOfOrder();

        Client beatriz = new Client("Beatriz");
        beatriz.orderBurger(burgersAvailable.getBurgerByName("delueeeexe"));
        beatriz.calculateValueOfOrder();


    }
}
