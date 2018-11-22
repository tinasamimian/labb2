import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

abstract public class Loading {

    enum position {
        UP, DOWN
    }

    int maxNrOfCars;
    int currentNumberOfCars;
    double trailerDistance;

    Loading.position currentPosition = Loading.position.UP;

    Vehicle vehicle;



    public void rise () throws IllegalArgumentException {
        if (vehicle.getCurrentSpeed() == 0) {
            if(currentPosition == Loading.position.DOWN){
                currentPosition = Loading.position.UP;
                return;
            }
        }
        throw new IllegalArgumentException("Trailer does not stand still");
    }

    public void sink() throws IllegalArgumentException {
        if (vehicle.getCurrentSpeed() == 0) {
            if(currentPosition == Loading.position.UP){
                currentPosition = Loading.position.DOWN;
                return;
            }
        }
        throw new IllegalArgumentException("Trailer does not stand still");
    }

    double getDistance(Car car){
        return Math.sqrt ((Math.pow(vehicle.getX() - car.getX(), 2)) + (Math.pow(vehicle.getY() - car.getY(), 2)));
    }

    public void load(Car car) throws IllegalArgumentException{
        if(currentPosition == Loading.position.DOWN) {
            if (currentNumberOfCars < maxNrOfCars){
                if (getDistance(car) <= trailerDistance) {
                    this.addCars(car);
                    currentNumberOfCars ++;
                    car.setX(vehicle.getX()); // Bilens position blir ...
                    car.setY(vehicle.getY()); // ... densamma som lastbilens
                    return; // hoppar ur direkt
                }
                throw new IllegalArgumentException("Car distance to the trailer is more than allowed loading distance");
            }
            throw new IllegalArgumentException("Trailer is fully loaded");
            //else if(currentNumberOfCars >= maxNrOfCars){
        }
        throw new IllegalArgumentException("Trailer ramp is up");
    }

    public void discharge(Car car){
        if(currentPosition == Loading.position.DOWN){
            currentNumberOfCars --;
            this.removeCars(car);
            car.setX(vehicle.getX() + trailerDistance);
            car.setY(vehicle.getY() + trailerDistance);
            return;
        }
        throw new IllegalArgumentException("Trailer ramp is up");
    }


    Deque<Vehicle> carStack = new ArrayDeque<>();
    List<Vehicle> carList = new ArrayList<>();


    abstract public void addCars(Car car);


    abstract public void removeCars(Car car);
}
