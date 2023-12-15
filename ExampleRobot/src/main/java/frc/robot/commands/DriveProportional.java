package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class DriveProportional extends CommandBase {
    public DriveProportional() {
        super.addRequirements(Robot.drive);
    }

    @Override
    public void execute() {
        Robot.drive.driveProportionalWithStick(Robot.controller.getLeftY(), Robot.controller.getRightX());
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
