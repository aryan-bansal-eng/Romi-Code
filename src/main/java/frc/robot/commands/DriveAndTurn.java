// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class DriveAndTurn extends CommandBase {

  private final Drivetrain m_drive;
  private final double m_distance;
  private final double m_drive_speed;
  private final double m_turn_speed;

  /** Creates a new DriveAndTurn. 
   * 
   * @param driveSpeed The speed at which the robot will drive
   * @param inches The number of inches the robot will drive
   * @param drive The drivetrain subsystem on which this command will run 
  */
  public DriveAndTurn(double driveSpeed, double inches, double turnSpeed, Drivetrain drive)
  {
    m_distance = inches;
    m_drive_speed = driveSpeed;
    m_turn_speed = turnSpeed;
    m_drive = drive;

    addRequirements(drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_drive.arcadeDrive(0, 0);
    m_drive.resetEncoders();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drive.arcadeDrive(m_drive_speed, m_turn_speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drive.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Math.abs(m_drive.getAverageDistanceInch()) >= m_distance;
  }
}
