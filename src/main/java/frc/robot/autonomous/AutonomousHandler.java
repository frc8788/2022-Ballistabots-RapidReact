package frc.robot.autonomous;

import java.util.ArrayList;

public class AutonomousHandler extends Autonomous{
    
    private ArrayList<Autonomous> autonomousi = new ArrayList<Autonomous>();

    public void add(Autonomous autonomous) {
        autonomousi.add(autonomous);
    }

    @Override
    public void onAutonomousInit() {
        for (Autonomous autonomous : autonomousi) {
            autonomous.onAutonomousInit();
        }
        
    }

    @Override
    public void onAutonomousPeriodic() {
        for (Autonomous autonomous : autonomousi) {
            autonomous.onAutonomousPeriodic();
        }
        
    }

    @Override
    public void onRobotInit() {
        for (Autonomous autonomous : autonomousi) {
            autonomous.onAutonomousInit();
        }
        
    }






}
