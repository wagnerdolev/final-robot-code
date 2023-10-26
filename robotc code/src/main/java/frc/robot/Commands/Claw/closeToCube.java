package frc.robot.Commands.Claw;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.SubSystems.Claw;

public class closeToCube extends CommandBase {

    public void initialize() {
        if (Claw.getInstance().getlimitSwitchCubeBool()) {
            Claw.getInstance().closeClaw();
        }
    }

    public boolean isFinished() {
        return !Claw.getInstance().getlimitSwitchCubeBool();
    }

    public void end() {
        Claw.getInstance().stopClaw();
    }

}