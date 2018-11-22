import java.awt.*;

/**
 * This is one of the subclasses to the abstract class Car.
 * The subclass stands for all Saab-95 cars. The methods
 * incrementSpeed and decrementSpeed has the variable speedFactor,
 * which differs in the to subclasses. Therefor we implement an
 * abstract method, speedFactor in Car that is defined here.
 */


public class Saab95 extends Car {

    private boolean turboOn;

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
    public Saab95(int nrDoors, double enginePower, Color color, String modelName, double x, double y){
        super(nrDoors,enginePower,color,modelName,x,y);
        setNrDoors(2);
        setColor(Color.red);
        setEnginePower(125);
	    turboOn = false;
        setModelName("Saab95");
        stopEngine();
    }

    /**
     * The method depends on the boolean variable "turboOn" which
     * decides the percentincreasment of the speed.
     * By multiplying turboOn with the enginepower and 0.01 we get our result.
     * @return speedFactor
     */

    protected double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }


    /**
     * TurboOn is set to false in the constructor.
     * When the method is used the variable
     * sets to true. The variable is used to
     * change the turbo multiplier.
     */
    protected void setTurboOn(){
	    turboOn = true;
    }

    /**
     * When the method is used the variable
     * sets to false. The variable is used to
     * change the turbo multiplier.
     * The method is used when the turbo has been true.
     */
    protected void setTurboOff(){
	    turboOn = false;
    }

}
