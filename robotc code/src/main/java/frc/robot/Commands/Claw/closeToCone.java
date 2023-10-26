package frc.robot.Commands.Claw;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.SubSystems.Claw;

public class closeToCone extends CommandBase {

    public void initialize() {
        if (Claw.getInstance().getlimitSwitchConeBool()) {
            Claw.getInstance().closeClaw();
        }
    }

    public boolean isFinished() {
        return !Claw.getInstance().getlimitSwitchConeBool();
    }

    public void end() {
        Claw.getInstance().stopClaw();
    }

}