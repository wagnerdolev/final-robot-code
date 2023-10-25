package frc.robot.Commands.Chassis;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.Chassis;
import frc.robot.Utils.Consts;

public class driveMeters extends CommandBase { // CR_NOTE: driveMeter is not a meaningful name
    private double m_targetRightMeters;
    private double m_targetLeftMeters;

    private double m_lastTraveldRightMeters = Chassis.getInstance().getRightChassisMeters();
    private double m_lastTraveldLeftMeters = Chassis.getInstance().getLeftChassisMeters();

    public driveMeters(double targetMeters) {
        m_targetRightMeters = targetMeters + Chassis.getInstance().getRightChassisMeters();
        m_targetLeftMeters = targetMeters + Chassis.getInstance().getLeftChassisMeters();

    }

    @Override
    public void initialize() {
        addRequirements(Chassis.getInstance());

    }

    @Override
    public void execute() {
        double currentRightMeters = Chassis.getInstance().getRightChassisMeters();
        double currentLeftMeters = Chassis.getInstance().getLeftChassisMeters();

        double rP = m_targetRightMeters - currentRightMeters;
        double lP = m_targetLeftMeters - currentLeftMeters;

        double rD = currentRightMeters - m_lastTraveldRightMeters;
        double lD = currentLeftMeters - m_lastTraveldLeftMeters;

        double rightPIDOutput = (rP * Consts.ChassisConsts.MOVE_KP) - (rD * Consts.ChassisConsts.MOVE_KD);
        double leftPIDOutput = (lP * Consts.ChassisConsts.MOVE_KP) - (lD * Consts.ChassisConsts.MOVE_KD);

        Chassis.getInstance().drive(rightPIDOutput, leftPIDOutput);

        m_lastTraveldRightMeters = currentRightMeters;
        m_lastTraveldLeftMeters = currentLeftMeters;
    }

    @Override
    public boolean isFinished() {
        return (Math.abs(m_targetRightMeters
                - Chassis.getInstance().getRightChassisMeters()) < Consts.ChassisConsts.DRIVE_METERS_THRESHOLD)
                && (Math.abs(m_targetLeftMeters
                        - Chassis.getInstance().getLeftChassisMeters()) < Consts.ChassisConsts.DRIVE_METERS_THRESHOLD);
        // if reached within 10 cm of target stop
    }

    @Override
    public void end(boolean interrupted) {
        Chassis.getInstance().stopChassis();
    }

}
