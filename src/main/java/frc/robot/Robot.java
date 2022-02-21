// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.TimedRobot;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.autonomous.TestAuto;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.management.RobotHandler;
import frc.robot.subsystems.sensors.Sensors;
import frc.robot.subsystems.shooter.Shooter;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the
 * name of this class or
 * the package after creating this project, you must also update the
 * build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();

  private final Sensors sensors = new Sensors();
  private final RobotHandler robotHandler = new RobotHandler();

  private boolean found;

  private final TestAuto testAuto = new TestAuto();

  private final Drivetrain drivetrain = new Drivetrain();
  private final Intake intake = new Intake(); // 5000mm is max range?
  private final Shooter shooter = new Shooter();

  public GenericHID driver = new GenericHID(0);
  public GenericHID aid = new GenericHID(1);

  /**
   * This function is run when the robot is first started up and should be used
   * for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);

    robotHandler
        .add(drivetrain)
        .add(intake)
        .add(shooter)
        .add(sensors).addUltrasonicSensor(sensors, 0, 5000, 0).addUltrasonicSensor(sensors, 1, 5000, 0)
        .allocateSensors(sensors, testAuto)
        .allocateGamepads(driver, aid, drivetrain).allocateGamepads(driver, aid, shooter)
        .allocateDrivetrain(drivetrain, testAuto);

    robotHandler.onRobotInit();

  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for
   * items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and
   * test.
   *
   * <p>
   * This runs after the mode specific periodic functions, but before LiveWindow
   * and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    robotHandler.onRobotPeriodic();
    SmartDashboard.putNumber("CONSTANT READING of ultrasonic port 0 ", sensors.getUltrasonicData(0));
    SmartDashboard.putNumber("CONSTANT READING of ultrasonic port 1 ", sensors.getUltrasonicData(1));
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different
   * autonomous modes using the dashboard. The sendable chooser code works with
   * the Java
   * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the
   * chooser code and
   * uncomment the getString line to get the auto name from the text box below the
   * Gyro
   *
   * <p>
   * You can add additional auto modes by adding additional comparisons to the
   * switch structure
   * below with additional strings. If using the SendableChooser make sure to add
   * them to the
   * chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    testAuto.onAutonomousInit();
    testAuto.test(drivetrain, sensors, 700, 0, 1, found).forward(drivetrain, -.1);

    found = false;
    System.out.println("Auto selected: " + m_autoSelected);
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    switch (m_autoSelected) {
      case kCustomAuto:

        break;
      case kDefaultAuto:
      default:

        break;
    }
  }

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {

    robotHandler.onTeleopInit();

  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {

    robotHandler.onTeleopPeriodic();

  }

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {
  }

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {
  }

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {
  }

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {
  }

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {
  }
}
