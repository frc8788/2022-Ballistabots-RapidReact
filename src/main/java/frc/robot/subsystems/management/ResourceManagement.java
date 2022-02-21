package frc.robot.subsystems.management;

import edu.wpi.first.wpilibj.GenericHID;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.sensors.Sensors;

public interface ResourceManagement {

        public void getSensors(Sensors sensors);

        public void getDrivetrain(Drivetrain drivetrain);

        public void getGamepad(GenericHID driver, GenericHID aid);
}
