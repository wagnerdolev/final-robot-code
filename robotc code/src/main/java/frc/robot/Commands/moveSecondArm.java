package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.Arm;
import frc.robot.Utils.Consts;
public class moveSecondArm extends CommandBase{
    double secondArmTargetAngle;

    public moveSecondArm(double secondArmTargetAngle){
        this.secondArmTargetAngle = secondArmTargetAngle;
    }

    @Override
    public void initialize() {
        // TODO Auto-generated method stub
        super.initialize();
    }
    
    @Override
    public void execute() {

        Arm.getInstance().turnFirstTo(secondArmTargetAngle);

    }

    @Override
    public boolean isFinished() {
        // TODO Auto-generated method stub
        return (Math.abs(Arm.getInstance().m_secondArmMotor.getEncoder().getPosition()) - Consts.ArmConsts.FIRST_ARM_TURN_THRESH_HOLD == secondArmTargetAngle);
    }

    @Override
    public void end(boolean interrupted) {
        // TODO Auto-generated method stub
        super.end(interrupted);
    }
}
