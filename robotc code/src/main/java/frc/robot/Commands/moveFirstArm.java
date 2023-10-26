package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.Arm;
import frc.robot.Utils.Consts;
public class moveFirstArm extends CommandBase{
    double firstArmTargetAngle;

    public moveFirstArm(double firstArmTargetAngle){
        this.firstArmTargetAngle = firstArmTargetAngle;
    }

    @Override
    public void initialize() {
        // TODO Auto-generated method stub
        super.initialize();
    }
    
    @Override
    public void execute() {

        Arm.getInstance().turnFirstTo(firstArmTargetAngle);

    }

    @Override
    public boolean isFinished() {
        // TODO Auto-generated method stub
        return (Math.abs(Arm.getInstance().m_firstArmMotor.getEncoder().getPosition()) - Consts.ArmConsts.FIRST_ARM_TURN_THRESH_HOLD == firstArmTargetAngle);
    }

    @Override
    public void end(boolean interrupted) {
        // TODO Auto-generated method stub
        super.end(interrupted);
    }
}
