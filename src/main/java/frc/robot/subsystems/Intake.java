package frc.robot.subsystems;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.management.Subsystem;
import frc.robot.subsystems.sensors.Sensors;

public class Intake extends Subsystem{
    

    public GenericHID aid;


    @Override
    public void onRobotInit() {
        
    }

    @Override
    public void onRobotPeriodic() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void onTeleopInit() {
        SmartDashboard.putString("Intake", "RAN");

        
    }

    @Override
    public void onTeleopPeriodic() {
        

        
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

        this.aid = aid;

        
    }

    

}
