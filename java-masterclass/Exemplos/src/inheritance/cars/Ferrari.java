package inheritance.cars;

/**
 * * created by lgcaobianco on 5/4/19
 **/

public class Ferrari extends SportCar {
    public Ferrari(int amountOfDoors, int amountOfWheels, boolean automaticGear, boolean engineOnFront, boolean scissorsDoors, boolean spoiler) {
        super(amountOfDoors, amountOfWheels, automaticGear, engineOnFront, scissorsDoors, spoiler);
    }

    public static void main(String[] args) {
        Car ferrari = new Ferrari(4, 4, false, false, true, true);
        System.out.println("ferrari is on gear: " + ferrari.getGear());
        ferrari.gearBack();
        ferrari.gearBack();
        System.out.println("ferrari is on gear: " + ferrari.getGear());
        ferrari.gearForward();
        ferrari.gearForward();
        ferrari.steerRight();
        ferrari.steerRight();
        System.out.println("the steering wheel is steered " + ferrari.getDegreeSteered() + " degrees");
        ferrari.steerLeft();
        System.out.println("the steering wheel is steered " + ferrari.getDegreeSteered() + " degrees");
        System.out.println("ferrari is on gear: " + ferrari.getGear());
    }


}
