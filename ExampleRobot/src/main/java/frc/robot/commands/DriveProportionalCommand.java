package frc.robot.commands;

import java.lang.module.ModuleDescriptor.Requires;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class DriveProportionalCommand extends CommandBase {
    private DriveSubsystem m_driveSub;
    private XboxController m_controller;

    public DriveProportionalCommand(DriveSubsystem driveSub, XboxController controller) {
        m_driveSub = driveSub;
        m_controller = controller;

        super.addRequirements(m_driveSub);
    }

    @Override 
    public void execute() {
        m_driveSub.driveProportionalWithStick(-1*m_controller.getLeftY(), m_controller.getRightX());
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
