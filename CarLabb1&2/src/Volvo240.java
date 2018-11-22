import java.awt.*;

/**
 * This is one of the subclasses to the abstract class Car.
 * The subclass stands for all Volvo-240 cars. The methods
 * incrementSpeed and decrementSpeed has the variable speedFactor,
 * which differs in the to subclasses. Therefor we implement an
 * abstract method, speedFactor in Car that is defined here.
 */

public class Volvo240 extends Car{

    private final static double trimFactor = 1.25;

    /**
     * We create a constructor to set the values
     * we need when creating an object of this particular car.
     * Following variables are parameters in the constructor.
     * @param nrDoors
     * @param enginePower
     * @param color
     * @param modelName
     * @param x
     * @param y
     */
    public Volvo240(int nrDoors, double enginePower, Color color, String modelName,double x ,double y){
        super(nrDoors,enginePower,color,modelName,x,y);
        setNrDoors(4);
        setColor(Color.black);
        setEnginePower(100);
        setModelName("Volvo240");
        stopEngine();
    }


    /**
     * The method depends on the static variable "trimFactor" which
     * decides the percentincreasment of the speed.
     * By multiplying trimFactor with the enginepower and 0.01 we get our result.
     * @return speedFactor
     */

    public double speedFactor(){
        return getEnginePower()* 0.01 * trimFactor;
    }


}
