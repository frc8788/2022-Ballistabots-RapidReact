package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.subsystems.management.Subsystem;
import frc.robot.subsystems.sensors.Sensors;

public class Drivetrain extends Subsystem {

  public GenericHID driver;
  public GenericHID aid;

  private CANSparkMax leftFrontMotor;
  private CANSparkMax leftBackMotor;
  private CANSparkMax rightFrontMotor;
  private CANSparkMax rightBackMotor;

  // private TalonFX testFalcon;

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

  }

  public void tankDriveCustom(double leftSidePower, double rightSidePower) {

    leftFrontMotor.set(leftSidePower);
    leftBackMotor.set(leftSidePower);

    rightFrontMotor.set(-rightSidePower);
    rightBackMotor.set(-rightSidePower);

  }

  public void strafeLeft(double power) {
    leftFrontMotor.set(-power);
    leftBackMotor.set(power);

    rightFrontMotor.set(-power);
    rightBackMotor.set(power);
  }

  public void strafeRight(double power) {

    leftFrontMotor.set(power);
    leftBackMotor.set(-power);

    rightFrontMotor.set(power);
    rightBackMotor.set(-power);

  }

  @Override
  public void onRobotInit() {


    leftBackMotor = new CANSparkMax(10, MotorType.kBrushless);
    leftFrontMotor = new CANSparkMax(20, MotorType.kBrushless);
    rightFrontMotor = new CANSparkMax(30, MotorType.kBrushless);
    rightBackMotor = new CANSparkMax(40, MotorType.kBrushless);


    // testFalcon = new TalonFX(2);
  }

  @Override
  public void onTeleopInit() {
    SmartDashboard.putString("Drivetrain", "RAN");

  }

  @Override
  public void onTeleopPeriodic() {

    mecanumDriveCustom(
        (Math.abs(driver.getRawAxis(1)) < .1) ? 0 : driver.getRawAxis(1),
        (Math.abs(driver.getRawAxis(0)) < .1) ? 0 : -driver.getRawAxis(0) * 1.1,
        (Math.abs(driver.getRawAxis(4)) < .1) ? 0 : -driver.getRawAxis(4),
        (driver.getRawAxis(3) > 0 ? .3 : 1));

    // rightFrontMotor.set(driver.getRawAxis(3));
    SmartDashboard.putNumber("Drivetrain test", leftBackMotor.get());

  }

  @Override
  public void onRobotPeriodic() {

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

}
