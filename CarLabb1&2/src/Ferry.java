import java.awt.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Ferry extends Vehicle {


    /**
     * We create a constructor to set the variables
     * we need when creating an object. Following
     * variables are parameters in the constructor.
     *
     * @param enginePower
     * @param color
     * @param modelName
     * @param x
     * @param y
     */
    public Ferry(int nrDoors, double enginePower, Color color, String modelName, double x, double y) {
        super(nrDoors, enginePower, color, modelName, x, y);
        setNrDoors(0);
        setColor(Color.gray);
        setEnginePower(500);
        setModelName("Ferry3000");
        stopEngine();
    }

    Loading loading = new Loading() {

        List<Vehicle> carList = new ArrayList<>();
        @Override
        public void addCars(Car car) {
            carList.add(car);
        }

        @Override
        public void removeCars(Car car) {
            carList.get(0);
        }

    };


    int maxNrOfCars = 50;
    int currentNumberOfCars = 0;
    double ferryDistance = 10.0;


    Loading.position currentPosition = Loading.position.UP;


    @Override
    protected double speedFactor() {
        return 3;
    }



    public void fSink(){
        loading.sink();
    }

    public void fRise(){
        loading.rise();
    }

    public void fLoad(Car car){
        loading.load(car);
    }

    public void fDischarge(Car car){
        loading.discharge(car);
    }





}