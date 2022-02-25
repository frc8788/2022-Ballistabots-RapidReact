package frc.robot.subsystems.sensors;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.GenericHID;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.management.Subsystem;

public class Sensors extends Subsystem {

    private AnalogPotentiometer ultrasonic;
    private ArrayList<AnalogPotentiometer> ultrasonics = new ArrayList<AnalogPotentiometer>();

    // private ADXRS450_Gyro gyro;

    /*
     * public Sensors setGyroscope() {
     * 
     * gyro = new ADXRS450_Gyro();
     * return this;
     * }
     */

    public double getUltrasonicData(int index) {

        return ultrasonics.get(index).get();
    }

    public Sensors setUltrasonic(int port, int max, int zeroV) {
        ultrasonic = new AnalogPotentiometer(port, max, zeroV);
        ultrasonics.add(ultrasonic);
        return this;
    }

    @Override
    public void onRobotInit() {

    }

    @Override
    public void onRobotPeriodic() {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTeleopInit() {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTeleopPeriodic() {
        // TODO Auto-generated method stub

    }

    @Override
    public void getSensors(Sensors sensors) {
        // TODO Auto-generated method stub

    }

    @Override
    public void getDrivetrain(Drivetrain drivetrain) {
        // TODO Auto-generated method stub

    }

    @Override
    public void getGamepad(GenericHID driver, GenericHID aid) {
        // TODO Auto-generated method stub

    }

}
