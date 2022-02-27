package frc.robot.subsystems.shooter;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.management.Subsystem;
import frc.robot.subsystems.sensors.Sensors;

public class Shooter extends Subsystem{

    public GenericHID driver;
    public GenericHID aid;

    private TalonFX flyWheelMotor;
    private CANSparkMax bottomMotor;
    private CANSparkMax belt;


    private int numberOfBalls;
    private Sensors sensors;

    @Override
    public void onRobotInit() {
        flyWheelMotor = new TalonFX(1);
        bottomMotor = new CANSparkMax(3, MotorType.kBrushless);
        belt = new CANSparkMax(2, MotorType.kBrushless);
        flyWheelMotor.setInverted(true);
        bottomMotor.setInverted(true);

    }

    @Override
    public void onRobotPeriodic() {
        // TODO Auto-generated method stub
        SmartDashboard.putNumber("LIDAR", sensors.getLidar());
        
    }

    @Override
    public void onTeleopInit() {
        SmartDashboard.putString("Shooter", "RAN");
       




        
    }

    public void touchtest() {
        SmartDashboard.putBoolean("TOUCH ONE", sensors.getTouchSensorData(0));
        SmartDashboard.putBoolean("TOUCH TWO", sensors.getTouchSensorData(1));
    }


    public void ShooterCustom(double LY, double RY) {
        double BeltPower = (LY);
        double IntakePower = (-RY);

        bottomMotor.set(IntakePower);
        belt.set(BeltPower);
        flyWheelMotor = new TalonFX(1);
        flyWheelMotor.set(TalonFXControlMode.PercentOutput, -.75);
        
    }

    @Override
    public void onTeleopPeriodic() {

        touchtest();
        SmartDashboard.putBoolean("BUTTON PRESSED", driver.getRawButtonPressed(3));

        if (driver.getRawButton(3)) {


            bottomMotor.set(.5);
            belt.set(.5);

            if (!sensors.getTouchSensorData(0)) {

                belt.set(0);
            }
            
            if (!sensors.getTouchSensorData(0) && driver.getRawButton(5)) {
                flyWheelMotor.set(ControlMode.PercentOutput, .5);
                belt.set(.5);
            }

            if (!sensors.getTouchSensorData(0) && !sensors.getTouchSensorData(1)) {
                bottomMotor.set(0);
            }



        }else {
            flyWheelMotor.set(ControlMode.PercentOutput, 0);
            bottomMotor.set(0);
            belt.set(0);
        }
        if (driver.getRawButton(6)) {
            flyWheelMotor.set(ControlMode.PercentOutput, .5);
        }

        /*
        if (aid.getRawButton(3)) { 

            if (sensors.getTouch() && numberOfBalls == 0) {
                flyWheelMotor.set(ControlMode.PercentOutput, .1);
                bottomMotor.set(.5);
                belt.set(.5); 
                if (!sensors.getTouch()) {
                    numberOfBalls = 1;
                }
            } 
        }else {
            flyWheelMotor.set(ControlMode.PercentOutput, 0);
            bottomMotor.set(0);
            belt.set(0);
        }
        */

        

    }





    @Override
    public void getSensors(Sensors sensors) {
        this.sensors = sensors;
        
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
