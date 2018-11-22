import java.awt.*;

public abstract class Car extends Vehicle {


    /**
     * We create a constructor to set the variables
     * we need when creating an object. Following
     * variables are parameters in the constructor.
     *
     * @param nrDoors
     * @param enginePower
     * @param color
     * @param modelName
     * @param x
     * @param y
     */
    public Car(int nrDoors, double enginePower, Color color, String modelName, double x, double y) {
        super(nrDoors, enginePower, color, modelName, x, y);
    }

    @Override
    abstract protected double speedFactor();
}
