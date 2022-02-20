package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.gamepad.Gamepad;


public class Drivetrain extends Gamepad implements Subsystem{
    

public Drivetrain(int gamepadId) {
        super(gamepadId);
    }


//Motors
  //IDs: 
  /*
    leftBack: 1
    leftFront: 2
    rightFront: 3
    rightBack: 4
  */
  private CANSparkMax leftFrontMotor;
  private CANSparkMax leftBackMotor;   
  private CANSparkMax rightFrontMotor; 
  private CANSparkMax rightBackMotor;

 // private TalonFX testFalcon;

  private double leftStickY;
  private double leftStickX;
  private double rightStickX;



private void mecanumDriveCustom(double y, double x, double rx, double k) {

            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
            double frontLeftPower = (y + x + rx) / denominator;
            double backLeftPower = (y - x + rx) / denominator;
            double frontRightPower = (y - x - rx) / denominator;
            double backRightPower = (y + x - rx) / denominator;

            leftFrontMotor.set(-frontLeftPower * k);
            leftBackMotor.set(-backLeftPower * k);
            rightFrontMotor.set(frontRightPower * k);
            rightBackMotor.set(backRightPower * k);

            SmartDashboard.putNumber("frontLeftPower", -frontLeftPower * k);
            SmartDashboard.putNumber("backLeftPower", -backLeftPower * k);
            SmartDashboard.putNumber("frontRightPower", frontRightPower * k);
            SmartDashboard.putNumber("backRightPower", backRightPower * k);
}

public void tankDriveCustom(double leftSidePower, double rightSidePower) {

  leftFrontMotor.set(leftSidePower);
  leftBackMotor.set(leftSidePower);
  
  rightFrontMotor.set(rightSidePower);
  rightBackMotor.set(rightSidePower);

}

@Override
public void onRobotInit() {

  leftBackMotor = new CANSparkMax(1, MotorType.kBrushless);
  leftFrontMotor = new CANSparkMax(2, MotorType.kBrushless);
  rightFrontMotor = new CANSparkMax(3, MotorType.kBrushless);
  rightBackMotor = new CANSparkMax(4, MotorType.kBrushless);

  //testFalcon = new TalonFX(2);
  SmartDashboard.putString("onRobotInit", "RUNNING");
}


@Override
public void onTeleopInit() {

    
}


@Override
public void onTeleopPeriodic(){ 

  leftStickX = getLeftStickX();
  leftStickY = getLeftStickY();
  rightStickX = getRightStickX();



    SmartDashboard.putNumber("y", leftStickY);
    SmartDashboard.putNumber("x", leftStickX);
    SmartDashboard.putNumber("rx", rightStickX);

    rightFrontMotor.set(getRightTrigger());
    

    mecanumDriveCustom(
    (Math.abs(getLeftStickY()) < .1) ? 0 : getLeftStickY(), 
    (Math.abs(getLeftStickX()) < .1) ? 0 : -getLeftStickX() * 1.1, 
    (Math.abs(getRightStickX()) < .1) ? 0 : getRightStickX(), 
    (getRightTrigger() > 0 ? .3 : 1)
    );
    
    

    //SmartDashboard.putNumber("k", (rightTrigger() ? .3 : 1));



}


@Override
public void onRobotPeriodic() {

}






}
