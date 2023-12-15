package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FollowerType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drive extends SubsystemBase {

    private WPI_TalonFX m_leftFalconMaster;
    private WPI_TalonFX m_rightFalconMaster;

    private WPI_TalonFX[] m_leftFalconFollowers;
    private WPI_TalonFX[] m_rightFalconFollowers;

    public Drive() {
        m_leftFalconMaster = new WPI_TalonFX(Constants.CAN_ID.DRIVE_MOTOR_LEFT_1);

        m_leftFalconFollowers = new WPI_TalonFX[] {
                new WPI_TalonFX(Constants.CAN_ID.DRIVE_MOTOR_LEFT_2) };

        m_rightFalconMaster = new WPI_TalonFX(Constants.CAN_ID.DRIVE_MOTOR_RIGHT_1);

        m_rightFalconFollowers = new WPI_TalonFX[] {
                new WPI_TalonFX(Constants.CAN_ID.DRIVE_MOTOR_RIGHT_2) };

        m_leftFalconMaster.configFactoryDefault();
        m_leftFalconMaster.setInverted(!Constants.DRIVE.IS_RIGHT_DRIVE_INVERTED);

        m_rightFalconMaster.configFactoryDefault();
        m_rightFalconMaster.setInverted(Constants.DRIVE.IS_RIGHT_DRIVE_INVERTED);

        for (WPI_TalonFX follower : m_leftFalconFollowers) {
            follower.configFactoryDefault();
            follower.setInverted(!Constants.DRIVE.IS_RIGHT_DRIVE_INVERTED);
            follower.setNeutralMode(NeutralMode.Brake);
            follower.follow(m_leftFalconMaster, FollowerType.PercentOutput);
        }

        for (WPI_TalonFX follower : m_rightFalconFollowers) {
            follower.configFactoryDefault();
            follower.setInverted(Constants.DRIVE.IS_RIGHT_DRIVE_INVERTED);
            follower.setNeutralMode(NeutralMode.Brake);
            follower.follow(m_rightFalconMaster, FollowerType.PercentOutput);
        }
    }

    public void driveProportionalWithStick(double speed, double turn) {
        speed = -1 * MathUtil.applyDeadband(speed, Constants.DRIVE.DEADBAND);
        turn = MathUtil.applyDeadband(turn, Constants.DRIVE.DEADBAND);
        driveProportional(speed, turn);
    }

    /**
     * 
     * @param speed -1 to 1
     * @param turn  -1 to 1
     */
    public void driveProportional(double speed, double turn) {
        double leftProportion = speed + turn;
        double rightProportion = speed - turn;

        leftProportion = MathUtil.clamp(leftProportion, -1.0, 1.0);

        rightProportion = MathUtil.clamp(rightProportion, -1.0, 1.0);

        m_leftFalconMaster.set(leftProportion);
        m_rightFalconMaster.set(rightProportion);
    }
}
