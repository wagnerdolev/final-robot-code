package frc.robot.Commands.Claw;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.SubSystems.Claw;

public class openClaw extends CommandBase {

    public void initialize() {
        if (Claw.getlimitSwitchOpenBool()) {
            Claw.getIntance().open();
        }
    }

    public boolean isFinished() {
        return !Claw.getlimitSwitchOpenBool();
    }

    public void end() {
        Claw.getIntance().stop();
    }
}