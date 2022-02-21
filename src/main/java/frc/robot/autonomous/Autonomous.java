package frc.robot.autonomous;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.management.ResourceManagement;
import frc.robot.subsystems.sensors.Sensors;
import frc.robot.util.Conversions;

public abstract class Autonomous implements ResourceManagement {

    private Conversions conversions = new Conversions();

    private final double KP_TURN = .05;
    private final double KP_DRIVE = .05;

    public abstract void onAutonomousInit();

    public Autonomous forward(Drivetrain drivetrain, double power) {
        drivetrain.tankDriveCustom(power, power);

        return this;
    }

    public Autonomous turn(double angle) {
        SmartDashboard.putNumber("turn", angle);
        return this;
    }

    public Autonomous ultrasonicAway(Drivetrain drivetrain, Sensors sensors, double distanceMM, double power) {
        while (sensors.getUltrasonicData(0) < distanceMM) {
            drivetrain.tankDriveCustom(power, power);
        }
        drivetrain.tankDriveCustom(0, 0);

        return this;
    }

    public Autonomous ultrasonicTowards(Drivetrain drivetrain, Sensors sensors, double distanceMM, double power) {
        while (sensors.getUltrasonicData(0) > distanceMM) {
            drivetrain.tankDriveCustom(power, power);
        }
        drivetrain.tankDriveCustom(0, 0);

        return this;
    }

    public Autonomous test(Drivetrain drivetrain, Sensors sensors, double range, int index1, int index2,
            boolean found) {
        SmartDashboard.putNumber("DIFFERENCE",
                Math.abs(sensors.getUltrasonicData(index1) - sensors.getUltrasonicData(index2)));
        while (found == false) {

            if (sensors.getUltrasonicData(index1) < sensors.getUltrasonicData(index2)) {
                if (Math.abs(sensors.getUltrasonicData(index1) - sensors.getUltrasonicData(index2)) > 20) {
                    drivetrain.strafeLeft(.1);
                    SmartDashboard.putString("FOUND", "NOT FOUND");
                } else {
                    found = true;
                    SmartDashboard.putString("FOUND", "FOUND");
                    drivetrain.tankDriveCustom(0, 0);
                }

            }

            if (sensors.getUltrasonicData(index1) > sensors.getUltrasonicData(index2)) {
                if (Math.abs(sensors.getUltrasonicData(index1) - sensors.getUltrasonicData(index2)) > 20) {
                    drivetrain.strafeRight(.1);
                    SmartDashboard.putString("FOUND", "NOT FOUND");
                } else {
                    found = true;
                    SmartDashboard.putString("FOUND", "FOUND");
                    drivetrain.tankDriveCustom(0, 0);
                }

            }
        }
        return this;

    }

    public Autonomous senseBall(Sensors sensors, double min, double max, int index1, int index2) {
        if (sensors.getUltrasonicData(index1) > min && sensors.getUltrasonicData(index1) < max) {
            SmartDashboard.putString("Ball in front of", "ultrasonic 0");
        } else {
            SmartDashboard.putString("Ball in front of", "none");
        }

        if (sensors.getUltrasonicData(index2) > min && sensors.getUltrasonicData(index2) < max) {
            SmartDashboard.putString("Ball in front of", "ultrasonic 1");
        } else {
            SmartDashboard.putString("Ball in front of", "none");
        }
        return this;
    }

    /*
     * //Need ability to ramp speed?
     * public void turnWithGyro(double angle) {
     * // Find the heading error; setpoint is 90
     * double error = 90 - gyro.getAngle();
     * 
     * // Turns the robot to face the desired direction
     * drivetrain.tankDriveCustom(kpTurn * error, -kpTurn * error);
     * 
     * }
     * 
     * //Need ability to ramp speed
     * public void driveWithGyroAndUltrasonic(double speed, AnalogPotentiometer
     * ultrasonic, double distanceM) {
     * double error = -gyro.getRate();
     * 
     * // Drives forward continuously at half speed, using the gyro to stabilize the
     * heading
     * while(ultrasonic.get() >= conversions.metersToMillimeters(distanceM)) {
     * drivetrain.tankDriveCustom(speed + kpDriveStraight * error, speed -
     * kpDriveStraight * error);
     * }
     * drivetrain.tankDriveCustom(0, 0);
     * 
     * }
     */

}
