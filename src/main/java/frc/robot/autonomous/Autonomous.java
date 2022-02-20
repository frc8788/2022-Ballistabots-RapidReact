package frc.robot.autonomous;


import frc.robot.subsystems.Drivetrain;
import frc.robot.util.Conversions;

public abstract class Autonomous {

    //ADXRS450_Gyro gyro = new ADXRS450_Gyro();
    
    
    private final Drivetrain drivetrain = new Drivetrain(0);
    private final Conversions conversions = new Conversions();

    private final double kpTurn = .05;
    private final double kpDriveStraight = .05;
    
    public abstract void onAutonomousInit();

    public abstract void onAutonomousPeriodic();

    public abstract void onRobotInit();

/*
    //Need ability to ramp speed?
    public void turnWithGyro(double angle) {
            // Find the heading error; setpoint is 90
    double error = 90 - gyro.getAngle();

    // Turns the robot to face the desired direction
    drivetrain.tankDriveCustom(kpTurn * error, -kpTurn * error);

    }

    //Need ability to ramp speed
    public void driveWithGyroAndUltrasonic(double speed, AnalogPotentiometer ultrasonic, double distanceM) {
        double error = -gyro.getRate();

        // Drives forward continuously at half speed, using the gyro to stabilize the heading
        while(ultrasonic.get() >= conversions.metersToMillimeters(distanceM)) {
            drivetrain.tankDriveCustom(speed + kpDriveStraight * error, speed - kpDriveStraight * error);
        }
        drivetrain.tankDriveCustom(0, 0);

    }
    */

}
