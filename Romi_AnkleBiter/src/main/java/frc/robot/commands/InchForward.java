// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.RomiDrivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class InchForward extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final RomiDrivetrain m_subsystem;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public InchForward(RomiDrivetrain subsystem) {
    m_subsystem = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("help");
    
    m_subsystem.resetEncoders();
    m_subsystem.arcadeDrive(0.5, 0);


  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    //System.out.print("a");
    //m_subsystem.arcadeDrive(1, 0);
    
  }
  

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    System.out.println("DEATH");
    m_subsystem.arcadeDrive(0, 0);
    

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(m_subsystem.getLeftDistanceInch() > 12 || m_subsystem.getRightDistanceInch() > 12){
      System.out.print("SUPERDEATH");
      return true;
    }
    else{
      System.out.print("b");
      return false;
    }
    
  }
}
