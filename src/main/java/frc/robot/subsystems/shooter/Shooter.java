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

    @Override
    public void onRobotInit() {
        flyWheelMotor = new TalonFX(1);
        bottomMotor = new CANSparkMax(5, MotorType.kBrushless);
        belt = new CANSparkMax(6, MotorType.kBrushless);
    }

    @Override
    public void onRobotPeriodic() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void onTeleopInit() {
        SmartDashboard.putString("Shooter", "RAN");
        
    }

    @Override
    public void onTeleopPeriodic() {
        flyWheelMotor.set(TalonFXControlMode.PercentOutput, aid.getRawAxis(3));
        
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
