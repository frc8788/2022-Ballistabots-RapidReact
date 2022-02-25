package frc.robot.autonomous;

import edu.wpi.first.wpilibj.GenericHID;

import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.sensors.Sensors;

public class TestAuto extends Autonomous{

    private Sensors sensors;
    private Drivetrain drivetrain;



    @Override
    public void onAutonomousInit() {
                
    }

    @Override
    public void getSensors(Sensors sensors) {
        this.sensors = sensors;
        
    }

    @Override
    public void getDrivetrain(Drivetrain drivetrain) {
        this.drivetrain = drivetrain;
        
    }

    public double getData() {
        return sensors.getUltrasonicData(0);
    }

    @Override
    public void getGamepad(GenericHID driver, GenericHID aid) {
        // TODO Auto-generated method stub
        
    }

    

    
}
