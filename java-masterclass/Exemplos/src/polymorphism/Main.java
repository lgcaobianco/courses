package polymorphism;

/**
 * * created by lgcaobianco on 5/5/19
 * eu odeio esse tipo de linguicao mas é a instrução do ex
 **/

// We are going to go back to the car analogy.
// Create a base class called Car
// It should have a few fields that would be appropriate for a generice car calss.
// engine, cylinders, wheels, etc.
// Constructor should initialize cylinders (number of) and name, and set wheels to 4
// and engine to true. Cylinders and names would be passed parameters.
//
// Create appropriate getters
//
// Create some methods like startEngine, accelerate, and brake
//
// show a message for each in the base class
// Now create 3 sub classes for your favorite vehicles.
// Override the appropriate methods to demonstrate polymorphism in use.
// put all classes in the one java file (this one).
class Car {
    private boolean engine;
    private int cylinders;
    private int wheels;
    private int doors;
    private double currentSpeed;
    private double maxSpeed;
    private int maxGear;
    private String name;
    private int currentGear;
    private boolean engineOn;

    public Car(int cylinders, int doors, double maxSpeed, int maxGear, String name) {
        this.engine = true;
        this.cylinders = cylinders;
        this.wheels = 4;
        this.doors = doors;
        this.maxSpeed = maxSpeed;
        this.maxGear = maxGear;
        this.currentGear = 0;
        this.name = name;
        this.currentSpeed = 0D;
        this.engineOn = false;
    }

    public boolean isEngine() {
        return engine;
    }

    public int getCylinders() {
        return cylinders;
    }

    public int getWheels() {
        return wheels;
    }

    public int getDoors() {
        return doors;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public int getMaxGear() {
        return maxGear;
    }

    public String getName() {
        return name;
    }

    public boolean isEngineOn() {
        return engineOn;
    }

    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public void speedUp() {
        if (engineOn) {
            System.out.println("generic car is speeding up");
            currentSpeed += 12.5;
        } else {
            System.out.println("engine is off!!!");
        }
    }

    public void slowDown() {
        if (engineOn) {
            System.out.println("normal car is slowind down");
            currentSpeed -= 12.5;
        } else {
            System.out.println("ALERT - NORMAL CAR's ENGINE OFF, SLOW DOWN INEFFECTIVE");
            currentSpeed -= 4.5;
        }
    }

    public void startEngine() {
        if (!engineOn) {
            engineOn = true;
            System.out.println("generic car turning on - braaaaaaaaaaaaaaam bram brammmmmmmm");
        } else {
            System.out.println("generic car says: engine already on");
        }
    }
}

class Ferrari extends Car {
    boolean leatherSeats;

    public Ferrari(int cylinders, int doors, double maxSpeed, int maxGear, String name, boolean leatherSeats) {
        super(cylinders, doors, maxSpeed, maxGear, name);
        this.leatherSeats = leatherSeats;
    }

    public boolean isLeatherSeats() {
        return leatherSeats;
    }

    @Override
    public void speedUp() {
        if (isEngineOn()) {
            System.out.println("Ferrari is speeding up");
            setCurrentSpeed(getCurrentSpeed() + 25.5);
        } else {
            System.out.println("ferrari is off!");
        }
    }

    @Override
    public void slowDown() {
        if (isEngineOn()) {
            System.out.println("eeeeeeeeeeeeeeeeeeeeeeerk, slow down ferrari!!!");
            setCurrentSpeed(getCurrentSpeed() - 17.5);
        } else {
            System.out.println("ferrari off, slowing down ineffective");
            setCurrentSpeed(getCurrentSpeed()- 8.5);
        }
    }
}

class Santana extends Car{
    public Santana(int cylinders, int doors, double maxSpeed, int maxGear, String name) {
        super(cylinders, doors, maxSpeed, maxGear, name);
    }

    @Override
    public void speedUp() {
        if (isEngineOn()) {
            System.out.println("santana is speeding up");
            setCurrentSpeed(getCurrentSpeed() + 15.5);
        } else {
            System.out.println("santana is off!");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Car ferrari = new Ferrari(8, 2, 350.5, 7, "la ferrari", true);

        Car generic = new Car(4, 4, 140, 5, "palio");

        Car santana = new Santana(6, 4, 200, 6, "santana 2000");

        ferrari.startEngine();
        ferrari.speedUp();
        System.out.println("ferrari's speed: "+ ferrari.getCurrentSpeed());
        ferrari.slowDown();

        generic.startEngine();
        generic.speedUp();
        generic.slowDown();

        santana.startEngine();
        santana.speedUp();
        santana.slowDown();
    }
}
