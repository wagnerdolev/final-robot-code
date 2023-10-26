package frc.robot.Commands.Claw;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.SubSystems.Claw;

public class openClaw extends CommandBase {

    public void initialize() {
        if (!Claw.getInstance().getlimitSwitchOpenBool()) {
            Claw.getInstance().openClaw();
        }
    }

    public boolean isFinished() {
        return Claw.getInstance().getlimitSwitchOpenBool();

    }

    public void end() {
        Claw.getInstance().stopClaw();
    }
}