package frc.robot.subsystems;

import java.util.ArrayList;

public class SubsystemHandler implements Subsystem{

private ArrayList<Subsystem> subsystems = new ArrayList<Subsystem>();


public void add(Subsystem subsystem) {
    subsystems.add(subsystem);
}


@Override
public void onRobotInit() {
    for (Subsystem subsystem : subsystems) {
        subsystem.onRobotInit();
    }
    
}


@Override
public void onRobotPeriodic() {
    for (Subsystem subsystem : subsystems) {
        subsystem.onRobotPeriodic();
    }
    
}


@Override
public void onTeleopInit() {
    for (Subsystem subsystem : subsystems) {
        subsystem.onTeleopInit();
    }
}


@Override
public void onTeleopPeriodic() {
    for (Subsystem subsystem : subsystems) {
        subsystem.onTeleopPeriodic();
    }
    
}



    
}

