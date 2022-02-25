package frc.robot.subsystems.shooter;

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

    @Override
    public void onRobotInit() {
        flyWheelMotor = new TalonFX(1);
        bottomMotor = new CANSparkMax(3, MotorType.kBrushless);
        belt = new CANSparkMax(2, MotorType.kBrushless);


    @Override
    public void onRobotPeriodic() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void onTeleopInit() {
        SmartDashboard.putString("Shooter", "RAN");
        
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
        numberOfBalls = 0;
        //flyWheelMotor.set(TalonFXControlMode.PercentOutput, aid.getRawAxis(3));
        //ShooterCustom(driver.getRawAxis(1), driver.getRawAxis(5));

        if (aid.getRawButtonPressed(0)) {
            if (numberOfBalls == 0) {


                if (true /*touched pressed true */) {
                    belt.set(0);
                    numberOfBalls = 1;


                } else {
                    bottomMotor.set(.5);
                    belt.set(.5);
                    
                }

            } 

            if (numberOfBalls == 1 && aid.getRawButton(0)) {
                bottomMotor.set(.5);

            }


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
        this.driver = driver;
        this.aid = aid;
        
    }
    
}
