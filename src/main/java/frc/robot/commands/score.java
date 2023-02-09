// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Ground_Intake;

public class score extends CommandBase {
  private Ground_Intake ground_Intake;
  private double d;
  /** Creates a new score. */
  public score(Ground_Intake intake) {
    this.ground_Intake = intake;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(ground_Intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //Tilt robot down, open clamp, send out kicker, wait 1.5s, bring kicker back in
    ground_Intake.tiltDownward();
    delay(3.5);
    ground_Intake.openClamp();
    delay(3.5);
    ground_Intake.sendKicker();
    delay(1.5);
    ground_Intake.returnKicker();
  }

  private void delay(double d) {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
