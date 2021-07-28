// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Drivetrain;

public class Auton extends SequentialCommandGroup {

  /** Creates a new Auton.
   *  
   * @param drivetrain The drivetrain subsystem on which this command will rum
  */
  public Auton(Drivetrain drivetrain) 
  {
    addCommands(
      new DriveDistance(0.6, 12, drivetrain),
      new TurnDegrees(0.6, 90, drivetrain),
      new DriveDistance(0.6, 12, drivetrain),
      new DriveAndTurn(0.6, 12, 0.6, drivetrain)
    );
  }
}
