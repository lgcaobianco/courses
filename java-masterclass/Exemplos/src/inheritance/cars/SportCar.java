package inheritance.cars;

/**
 * * created by lgcaobianco on 5/4/19
 **/

public class SportCar extends Car{
    private boolean scissorsDoors;
    private boolean spoiler;

    public SportCar(int amountOfDoors, int amountOfWheels, boolean automaticGear, boolean engineOnFront, boolean scissorsDoors, boolean spoiler) {
        super(amountOfDoors, amountOfWheels, automaticGear, engineOnFront);
        this.scissorsDoors = scissorsDoors;
        this.spoiler = spoiler;
    }

    @Override
    public void gearForward() {
        int gear = this.getGear();
        if(gear <= 6) {
            setGear(++gear);
        } else{
            System.out.println("gear at max level 7");
        }
    }


}
