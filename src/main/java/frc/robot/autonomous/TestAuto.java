package frc.robot.autonomous;

import edu.wpi.first.wpilibj.AnalogPotentiometer;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.Drivetrain;

public class TestAuto extends Autonomous{

    private int port = 0;
    private int max = 5000;
    private int zeroV = 0;
    private AnalogPotentiometer ultransonic;
    private Drivetrain dt = new Drivetrain(0);

    @Override
    public void onAutonomousInit() {
        //dt.tankDriveCustom(.5, .5);
    }

    @Override
    public void onAutonomousPeriodic() {


    
 
    }

    @Override
    public void onRobotInit() {
        ultransonic = new AnalogPotentiometer(port, max, zeroV);

    }


    
}
