import java.awt.*;
import java.security.InvalidParameterException;

import static java.lang.Math.*;


/**
 * This in an abstract class which collects mutual varibles
 * and methods of the two subclasses Volo240 and Saab95.
 * The class imports a math class to enable the equation required
 * to complete the move method.
 * The Car class implements the interface Movable which contains
 * the three crucial methods move(), turnright(),turnleft().
 */



abstract public class Vehicle implements Movable {
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName;
    private double x; // koordinate
    private double y; // koordinate
    private double degree = 0;


    /**
     * We create a constructor to set the variables
     * we need when creating an object. Following
     * variables are parameters in the constructor.
     * @param nrDoors
     * @param enginePower
     * @param color
     * @param modelName
     * @param x
     * @param y
     */
    public Vehicle(int nrDoors, double enginePower, Color color, String modelName,double x,double y) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.x = x;
        this.y = y;

    }


    protected void setNrDoors(int nrDoors) {
        this.nrDoors = nrDoors;
    }

    protected void setEnginePower(double enginePower) {
        this.enginePower = enginePower;
    }

    protected void setCurrentSpeed(double currentSpeed) {
        if(currentSpeed >= enginePower){
            currentSpeed = enginePower;
        }
        if(currentSpeed <= 0){
            currentSpeed = 0;
        }
        this.currentSpeed = currentSpeed; // if currentspeed (inparameter) doesn't fit any of the if's, currentspeed gets the given value
    }

    protected void setColor(Color color) {
        this.color = color;
    }

    protected void setModelName(String modelName) {
        this.modelName = modelName;
    }

    protected double getEnginePower() {
        return enginePower;
    }

    protected double getCurrentSpeed() {
        return currentSpeed;
    }

    protected double getX() {
        return x;
    }

    protected double getY() {
        return y;
    }

    protected void setX(double newX) {
        x = newX;
    }

    protected void setY(double newY) {
        y = newY;
    }

    protected double getDegree() {
        return degree;
    }// :/

    /**
     * This method is public do to the fact that someone
     * (e.g. a class, driver) will use the method to
     * start the car. We set currentSpeed to 0.1 to
     * give the car a speed bigger than 0.
     */
    public void startEngine(){
        setCurrentSpeed(0.1);
    }

    /**
     * This method is public do to the fact that someone
     * (e.g. a class, driver) will use the method to
     * turn the car off. We set currentSpeed to 0.
     */
    public void stopEngine(){
        setCurrentSpeed(0);
    }


    protected abstract double speedFactor();


    /**
     * The method increases the speed based on the speedFactor method,
     * which is implemented in each subclass with its own
     * characteristics.
     * @param amount
     */
    private void incrementSpeed(double amount){
        setCurrentSpeed(getCurrentSpeed() + speedFactor() * amount);

    }

    /**
     * The method decreases the speed based on the speedFactor method,
     * which is implemented in each subclass with its own
     * characteristics.
     * @param amount
     */
    private void decrementSpeed(double amount){
        setCurrentSpeed(getCurrentSpeed() - speedFactor() * amount);
    }


    /**
     * The method changes the x and y coordinates of the car
     * and will be used in the separate subclasses.
     * CurrentSpeed is equal to dx and dy.
     * The method uses a unit circle where sines and cosines is used
     * to represent the direction of the new coordinate. By default the
     * car moves straight forward.
     */

    @Override
    public void move() {
        x = x + (cos(Math.toRadians(degree)) * currentSpeed);
        y = y + (sin(Math.toRadians(degree)) * currentSpeed);
    }


    /**
     * This method enables the car to turn and here we decide
     * the size of the degree. By incrementing with 90 degrees
     * the car turns left.
     */


    @Override
    public void turnLeft() {
        degree += 90;
    }

    /**
     * This method enables the car to turn and here we decide
     * the size of the degree. By decrementing with 90 degrees
     * the car turns right.
     */


    @Override
    public void turnRight() {
        degree -= 90;
    }


    /**
     * This method will give the car a new speed based on the "amount" value
     * and higher than the current speed.
     * The usage of the incrementSpeed method secures that the speed is always increasing.
     * We make sure that the method only can accept values between 0 and 1 with the the if-statement.
     * When the user inserts a value higher than 1 or lower than 0 the program throws a exception.
     * @param amount
     */

    public void gas(double amount) throws InvalidParameterException{ // får göra exeption
        if (amount >= 0 && amount <= 1){
            incrementSpeed(amount);
        }
        else{
            throw new InvalidParameterException();
        }
    }

    /**
     *This method will give the car a new speed based on the "amount" value
     * and lower than the current speed.
     * The usage of the decrementSpeed method secures that the speed is always deceasing.
     * We make sure that the method only can accept values between 0 and 1 with the the if-statement.
     * When the user inserts a value higher than 1 or lower than 0 the program throws a exception.
     * @param amount
     */

    public void brake(double amount)throws InvalidParameterException{
        if (amount >= 0 && amount <= 1){
            decrementSpeed(amount);
        }
        else{
            throw new InvalidParameterException();
        }
    }


}