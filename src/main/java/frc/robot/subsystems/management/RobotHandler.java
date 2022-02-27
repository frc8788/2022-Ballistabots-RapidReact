package frc.robot.subsystems.management;

import java.util.ArrayList;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.autonomous.Autonomous;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.sensors.Sensors;

public class RobotHandler extends Subsystem {

    private ArrayList<Subsystem> subsystems = new ArrayList<Subsystem>();

    public RobotHandler add(Subsystem subsystem) {
        subsystems.add(subsystem);
        return this;
    }

    public RobotHandler addLidarSensor(Sensors sensors) {
        sensors.setLidar();
        return this;
    }

    public RobotHandler addUltrasonicSensor(Sensors sensors, int port, int max, int zeroV) {
        sensors.setUltrasonic(port, max, zeroV);
        return this;
    }
    public RobotHandler addTouchSensor(Sensors sensors, int port) {
        sensors.setTouch(port);
        return this;
    }



    public RobotHandler allocateSensors(Sensors sensors, Autonomous autonomous) {
        autonomous.getSensors(sensors);
        return this;
    }

    public RobotHandler allocateSensors(Sensors sensors, Subsystem subsystem) {
        subsystem.getSensors(sensors);
        return this;
    }

    public RobotHandler allocateDrivetrain(Drivetrain drivetrain, Autonomous autonomous) {
        autonomous.getDrivetrain(drivetrain);
        return this;
    }

    public RobotHandler allocateDrivetrain(Drivetrain drivetrain, Subsystem subsystem) {
        subsystem.getDrivetrain(drivetrain);
        return this;
    }

    public RobotHandler allocateGamepads(GenericHID driver, GenericHID aid, Subsystem subsystem) {
        subsystem.getGamepad(driver, aid);
        return this;
    }

    @Override
    public void onRobotInit() {
        SmartDashboard.putNumber("number of subsystems", subsystems.size());
        for (Subsystem subsystem : subsystems) {
            subsystem.onRobotInit();
        }

    }

    @Override
    public void onRobotPeriodic() {
        for (Subsystem subsystem : subsystems) {
            subsystem.onRobotPeriodic();
        }

    }

    @Override
    public void onTeleopInit() {
        for (Subsystem subsystem : subsystems) {
            subsystem.onTeleopInit();
        }
    }

    @Override
    public void onTeleopPeriodic() {
        for (Subsystem subsystem : subsystems) {
            subsystem.onTeleopPeriodic();
        }

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
