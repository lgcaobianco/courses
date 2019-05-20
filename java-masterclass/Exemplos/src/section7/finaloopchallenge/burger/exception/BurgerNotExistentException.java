package section7.finaloopchallenge.burger.exception;

/**
 * * created by lgcaobianco on 5/6/19
 **/

public class BurgerNotExistentException extends Throwable {
    public BurgerNotExistentException(){
        System.out.println("IM SO SORRY THIS BURGER ISN'T AVAILABLE.");
        System.out.println("You might want to order from the burgers that are available!");
    }
}
