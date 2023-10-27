package frc.robot.Commands.Chassis;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.Chassis;
import frc.robot.Utils.Consts;
public class driveBySpeed extends CommandBase{
    double m_targetSpeed;

    private double m_lastRightSpeed = 0;
    private double m_lastLeftSpeed = 0;

    public driveBySpeed(double targetSpeed){
        this.m_targetSpeed = targetSpeed;
    }

    @Override
    public void initialize() {
        // TODO Auto-generated method stub
        super.initialize();
    }
    
    @Override
    public void execute() {
       double currentRightSpeed = Chassis.getInstance().getLeftChassisSpeed();
       double currentLeftSpeed = Chassis.getInstance().getLeftChassisSpeed();

       double rP = m_targetSpeed - currentRightSpeed;
       double lP = m_targetSpeed - currentLeftSpeed;

       double rD = currentRightSpeed - m_lastRightSpeed;
       double lD = currentLeftSpeed - m_lastLeftSpeed;

       double rightPIDOutput = (rP * Consts.ChassisConsts.SPEED_KP) - (rD * Consts.ChassisConsts.SPEED_KD);
       double leftPIDOutput = (lP * Consts.ChassisConsts.SPEED_KP) - (lD * Consts.ChassisConsts.SPEED_KD);

       Chassis.getInstance().drive(rightPIDOutput, leftPIDOutput);

       m_lastRightSpeed = currentRightSpeed;
       m_lastLeftSpeed = currentLeftSpeed;
    }

    @Override
    public void end(boolean interrupted) {
        Chassis.getInstance().stopChassis();
    }
}
