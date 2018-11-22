import sun.print.DialogOwner;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.math.*;
import java.util.List;

public class Trailer extends Vehicle {

    public Trailer(int nrDoors, double enginePower, Color color, String modelName, double x, double y) {
        super(nrDoors, enginePower, color, modelName, x, y);
        setNrDoors(2);
        setColor(Color.white);
        setEnginePower(300);
        setModelName("Trailer2000");
        stopEngine();
    }


    Loading loading = new Loading() {

        Deque<Vehicle> carStack = new ArrayDeque<>();
        @Override
        public void addCars(Car car) {
            carStack.push(car);
        }

        @Override
        public void removeCars(Car car) {
            carStack.pop();
        }

    };


    int maxNrOfCars = 10;
    int currentNumberOfCars = 0;
    double trailerDistance = 5.0;



    Loading.position currentPosition = Loading.position.UP;


    @Override
    protected double speedFactor() {
        return 2;
    }



    public void tSink(){
        loading.sink();
    }

    public void tRise(){
        loading.rise();
    }

    public void tLoad(Car car){
        loading.load(car);
    }

    public void tDischarge(Car car){
        loading.discharge(car);
    }

}
