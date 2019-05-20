package section7.inheritance.cars;

/**
 * * created by lgcaobianco on 5/4/19
 **/

public class Car {
    private int amountOfDoors;
    private int amountOfWheels;
    private boolean automaticGear;
    private boolean engineOnFront;
    private int gear;
    private double degreeSteered;

    public Car(int amountOfDoors, int amountOfWheels, boolean automaticGear, boolean engineOnFront) {
        this.amountOfDoors = amountOfDoors;
        this.amountOfWheels = amountOfWheels;
        this.automaticGear = automaticGear;
        this.engineOnFront = engineOnFront;
        this.gear = 0;
        this.degreeSteered = 0D;
    }

    public int getAmountOfDoors() {
        return amountOfDoors;
    }

    public int getAmountOfWheels() {
        return amountOfWheels;
    }

    public boolean isAutomaticGear() {
        return automaticGear;
    }

    public boolean isEngineOnFront() {
        return engineOnFront;
    }

    public int getGear() {
        return gear;
    }

    public double getDegreeSteered() {
        return degreeSteered;
    }

    public void setAmountOfDoors(int amountOfDoors) {
        this.amountOfDoors = amountOfDoors;
    }

    public void setAmountOfWheels(int amountOfWheels) {
        this.amountOfWheels = amountOfWheels;
    }

    public void setAutomaticGear(boolean automaticGear) {
        this.automaticGear = automaticGear;
    }

    public void setEngineOnFront(boolean engineOnFront) {
        this.engineOnFront = engineOnFront;
    }

    public void setGear(int gear) {
        this.gear = gear;
    }

    public void setDegreeSteered(double degreeSteered) {
        this.degreeSteered = degreeSteered;
    }

    public void gearForward(){
        this.gear++;
    }

    public void gearBack(){
        if(this.gear>=0){
            this.gear--;
        } else{
            System.out.println("minimum gear achieved");
        }
    }

    public void steerLeft(){
        if(this.degreeSteered >= -120) {
            this.degreeSteered += -15;
        } else{
            System.out.println("Cant steer left anymore!");
        }
    }

    public void steerRight(){
        if(this.degreeSteered <= 120){
            this.degreeSteered += 15;
        } else{
            System.out.println("Cant steer left anymore!");
        }
    }
}
