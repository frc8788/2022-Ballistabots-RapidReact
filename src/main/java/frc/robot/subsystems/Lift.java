package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


import frc.robot.subsystems.management.Subsystem;
import frc.robot.subsystems.sensors.Sensors;

public class Lift extends Subsystem {

  public GenericHID driver;
  public GenericHID aid;

  private DoubleSolenoid LiftSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0,1);

public void LiftUp(boolean b) { 
  LiftSolenoid.set(Value.kForward);
}

public void LiftDown(boolean b) {
  LiftSolenoid.set(Value.kReverse);
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
    this.driver = driver;
    this.aid = aid;
    
  }

  @Override
  public void onRobotInit() {
    // TODO Auto-generated method stub
    
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
    if(driver.getRawButton(1)) {
      LiftUp(true);
    } else if (driver.getRawButton(2)) {
      LiftDown(true);
    } else {
      LiftSolenoid.toggle();
    }
    
  }
}
