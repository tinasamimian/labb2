import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class VehicleTest {

    private Volvo240 volvo= new Volvo240(4,100, Color.BLACK, "volvo240", 100, 0);
    private Saab95 saab = new Saab95(2, 125, Color.red, "Saab95", 150, 150);
    private Scania scania = new Scania(2,200,Color.blue,"Scania",10,0);



    @Test
    public void startEngine() {
        volvo.startEngine();
        saab.startEngine();
        assertEquals(0.1, volvo.getCurrentSpeed(), 0.0001);
    }


    @Test
    public void stopEngine(){
        volvo.stopEngine();
        assertEquals(0.0, volvo.getCurrentSpeed(), 0.00001);
    }

    @Test
    public void move(){
        volvo.setCurrentSpeed(100);
        volvo.move();
        volvo.move();
        volvo.turnLeft();
        volvo.move();
        assertEquals(300, volvo.getX(), 0.001);
        assertEquals(100, volvo.getY(), 0.001);
    }

    @Test
    public void turnLeft(){
        volvo.turnLeft();
        volvo.turnLeft();
        assertEquals(180, volvo.getDegree(), 0.50);
    }

    @Test
    public void turnRight(){ //fel med enhetscirkeln??
        volvo.turnRight();
        volvo.turnRight();
        assertEquals(-180, volvo.getDegree(), 0.50);
    }

    @Test
    public void getX(){
        volvo.getX();
        assertEquals(100, volvo.getX(), 0.0001);
    }

    @Test
    public void gas(){
        volvo.setCurrentSpeed(90);
        volvo.gas(0.5);
        assert volvo.getCurrentSpeed()>90;

    }

    @Test
    public void brake(){
        volvo.setCurrentSpeed(100);
        volvo.brake(0.5);
        assert volvo.getCurrentSpeed()<100;
    }

    @Test
    public void speedFactor(){
        saab.speedFactor();
        assert saab.speedFactor()== 1.25;
        saab.setTurboOn();
        saab.speedFactor();
        assert saab.speedFactor()==1.625;
        saab.setTurboOff();
        saab.speedFactor();
        assert saab.speedFactor()==1.25;
    }

    @Test
    public void flatbed(){
        scania.setCurrentSpeed(0);
        scania.flatbed(10);
        assertEquals(10,scania.getFbDegree(),0.0001);
       // scania.setFbDegree(40);
        scania.startEngine();
        scania.gas(10);
        assertEquals(0,scania.getCurrentSpeed(),0.0001);
    }




}