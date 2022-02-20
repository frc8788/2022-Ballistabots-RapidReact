package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogPotentiometer;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Intake implements Subsystem{
    

    private int port = 0;
    private int max = 5000;
    private int zeroV = 0;
    private AnalogPotentiometer ultransonic;

    @Override
    public void onRobotInit() {
        ultransonic = new AnalogPotentiometer(port, max, zeroV);
        
    }

    @Override
    public void onRobotPeriodic() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void onTeleopInit() {
        //ultransonic.get();
        SmartDashboard.putNumber("Ultrasonic", ultransonic.get());
        
    }

    @Override
    public void onTeleopPeriodic() {
        // TODO Auto-generated method stub
        SmartDashboard.putNumber("Ultrasonic", ultransonic.get());
        
    }

    

}
