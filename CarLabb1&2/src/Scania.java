import java.awt.*;
import java.security.InvalidParameterException;

public class Scania extends Vehicle {


    private double fbDegree;

    public Scania(int nrDoors, double enginePower, Color color, String modelName, double x, double y) {
        super(nrDoors, enginePower, color, modelName, x, y);
        setNrDoors(2);
        setColor(Color.blue);
        setEnginePower(200);
        setModelName("Scania");
        stopEngine();
    }

    @Override
    protected double speedFactor() {
        return 0;
    }

    public double getFbDegree() {
        return fbDegree;
    }

    public void setFbDegree(double fbDegree) {
        this.fbDegree = fbDegree;
    }

    protected double flatbed(double fbDegree) {
        if (getCurrentSpeed() == 0) {
            if (fbDegree <= 0) {
                fbDegree = 0;
            }
            if (fbDegree >= 70) {
                fbDegree = 70;
            } else {
                this.fbDegree = fbDegree;
            }
        }else {
            fbDegree = 0;
        }
        return fbDegree;
    }

    @Override
    public void startEngine() {
        if(fbDegree == 0){
            super.startEngine();
        }
    }

    @Override
    public void gas(double amount) throws InvalidParameterException {
        if(fbDegree == 0){
            super.gas(amount);
        }
    }

}
