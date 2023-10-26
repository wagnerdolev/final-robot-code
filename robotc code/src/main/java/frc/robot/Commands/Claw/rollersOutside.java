package frc.robot.Commands.Claw;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.SubSystems.Claw;

public class rollersOutside extends CommandBase {

    public void initialize() {
        Claw.getInstance().rollersOutside();
    }

    public void end() {
        Claw.getInstance().stopRollers();
    }

}