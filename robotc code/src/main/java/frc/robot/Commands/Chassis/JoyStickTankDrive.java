package frc.robot.Commands.Chassis;

import frc.robot.Subsystems.Chassis;
import frc.robot.Utils.Consts;

import java.util.function.Supplier;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class JoyStickTankDrive extends CommandBase {
  private Supplier<Double> m_rightMotorSpeed;
  private Supplier<Double> m_leftMotorSpeed;

  public JoyStickTankDrive(Supplier<Double> leftMotorSpeed, Supplier<Double> rightMotorSpeed) {
    this.m_rightMotorSpeed = rightMotorSpeed;
    this.m_leftMotorSpeed = leftMotorSpeed;
    // getting supplier
  }

  @Override
  public void initialize() {
    addRequirements(Chassis.getInstance());

  }

  @Override
  public void execute() {
    if (Math.abs(m_leftMotorSpeed.get()) > Consts.ChassisConsts.JOYSTICK_THRESHOLD && Math.abs(m_rightMotorSpeed.get()) > Consts.ChassisConsts.JOYSTICK_THRESHOLD ){
      return;
    }

    Chassis.getInstance().drive(0, 0);(m_leftMotorSpeed.get() * Consts.ChassisConsts.SPEED, m_rightMotorSpeed.get() * Consts.ChassisConsts.SPEED);

  }

  @Override
  public boolean isFinished() {
    return false;
  }

  @Override
  public void end(boolean interrupted) {
    Chassis.getInstance().stopChassis();
  }

}
