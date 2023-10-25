// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.Utils.Consts;

public class RobotContainer {

  public static Joystick left = new Joystick(Consts.ChassisConsts.LEFT_JOYSTICK_ID);
  public static Joystick right = new Joystick(Consts.ChassisConsts.RIGHT_JOYSTICK_ID);

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {}

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
