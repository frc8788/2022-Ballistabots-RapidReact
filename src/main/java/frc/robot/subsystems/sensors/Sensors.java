package frc.robot.subsystems.sensors;

import java.util.ArrayList;
import java.util.Timer;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.management.Subsystem;

public class Sensors extends Subsystem {

    private AnalogPotentiometer ultrasonic;
    private ArrayList<AnalogPotentiometer> ultrasonics = new ArrayList<AnalogPotentiometer>();
    private DigitalInput touchSensor;
    private ArrayList<DigitalInput> touchSensors = new ArrayList<DigitalInput>();

    private I2C lidar;

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

    public Sensors setTouch(int port) {
        touchSensor = new DigitalInput(port);
        touchSensors.add(touchSensor);
        return this;
    }

    public Sensors setLidar() {
        lidar = new I2C(I2C.Port.kOnboard, 0x62);
        return this;
    }

    public int getLidar() {

        byte[] buffer;
        buffer = new byte[2];
        lidar.write(0x00, 0x04);
        lidar.read(0x8f, 2, buffer);
        SmartDashboard.putString("TEST PRINT", "PRINTING ");
        SmartDashboard.putRaw("BUFFER", buffer);
        System.out.print("Buffer" + " " + buffer);
        return (int) Integer.toUnsignedLong(buffer[0]) + Byte.toUnsignedInt(buffer[1]);


    }


    public boolean getTouchSensorData(int index) {

        return touchSensors.get(index).get();
    }

    @Override
    public void onRobotInit() {
         //DigitalOutput do = new DigitalOutput(0);
         DigitalInput di = new DigitalInput(0);
         SmartDashboard.putBoolean("DI TEST", di.get());
    }

    @Override
    public void onRobotPeriodic() {
        SmartDashboard.putNumber("GET LIDAR", getLidar());

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
