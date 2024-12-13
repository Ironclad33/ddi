package frc.robot;

import frc.robot.subsystems.DrunkDriveInator;
import frc.robot.subsystems.swerve.DriveSubsystem;
import frc.robot.subsystems.swerve.Constants.AutoConstants;
import frc.robot.subsystems.swerve.Constants.DriveConstants;
import frc.robot.subsystems.swerve.Constants.OIConstants;
import frc.robot.Constants;
import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.RunDDI;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj2.command.sysid.SysIdRoutine;
import edu.wpi.first.math.MathUtil;
import frc.robot.commands.RunDDI;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class SysIdRoutineBot {
  // The robot's subsystems
  private final DriveSubsystem m_drive = new DriveSubsystem();
  private final DrunkDriveInator xDDI = new DrunkDriveInator();
  private final DrunkDriveInator yDDI = new DrunkDriveInator();
  private final RunDDI m_DDI = new RunDDI(xDDI,yDDI,m_drive);
 // private final Shooter m_shooter = new Shooter();

  // The driver's controller
  CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  /**
   * Use this method to define bindings between conditions and commands. These are useful for
   * automating robot behaviors based on button and sensor input.
   *
   * <p>Should be called during {@link Robot#robotInit()}.
   *
   * <p>Event binding methods are available on the {@link Trigger} class.
   */
  public void configureBindings() {
    // Control the drive with split-stick arcade controls
    m_drive.setDefaultCommand(
        m_drive.swerveDriveCommand(
            () -> -Math.pow(MathUtil.applyDeadband(m_driverController.getLeftY(), OIConstants.kDriverControllerDeadBand), 3) * DriveConstants.kMaxSpeedMetersPerSecond, 
            () -> -Math.pow(MathUtil.applyDeadband(m_driverController.getLeftX(), OIConstants.kDriverControllerDeadBand), 3) * DriveConstants.kMaxSpeedMetersPerSecond,
            () -> -Math.pow(MathUtil.applyDeadband(m_driverController.getRightX(), OIConstants.kDriverControllerDeadBand), 3) * AutoConstants.kMaxAngularSpeedRadiansPerSecond,
            false));

    //bind for the DrunkDriveInator
    m_driverController.y().whileTrue(new RunDDI(xDDI, yDDI, m_drive));

    // Bind full set of SysId routine tests to buttons; a complete routine should run each of these
    // once.
    // Using bumpers as a modifier and combining it with the buttons so that we can have both sets
    // of bindings at once
    m_driverController
        .a()
        .and(m_driverController.rightBumper())
        .whileTrue(m_drive.sysIdQuasistatic(SysIdRoutine.Direction.kForward));
    m_driverController
        .b()
        .and(m_driverController.rightBumper())
        .whileTrue(m_drive.sysIdQuasistatic(SysIdRoutine.Direction.kReverse));
    m_driverController
        .x()
        .and(m_driverController.rightBumper())
        .whileTrue(m_drive.sysIdDynamic(SysIdRoutine.Direction.kForward));
    m_driverController
        .y()
        .and(m_driverController.rightBumper())
        .whileTrue(m_drive.sysIdDynamic(SysIdRoutine.Direction.kReverse));

    // Control the shooter wheel with the left trigger
    //m_shooter.setDefaultCommand(m_shooter.runShooter(m_driverController::getLeftTriggerAxis));

    m_driverController
        .a()
        .and(m_driverController.leftBumper())
        .whileTrue(m_drive.sysIdQuasistatic(SysIdRoutine.Direction.kForward));
    m_driverController
        .b()
        .and(m_driverController.leftBumper())
        .whileTrue(m_drive.sysIdQuasistatic(SysIdRoutine.Direction.kReverse));
    m_driverController
        .x()
        .and(m_driverController.leftBumper())
        .whileTrue(m_drive.sysIdDynamic(SysIdRoutine.Direction.kForward));
    m_driverController
        .y()
        .and(m_driverController.leftBumper())
        .whileTrue(m_drive.sysIdDynamic(SysIdRoutine.Direction.kReverse));
  }

  /**
   * Use this to define the command that runs during autonomous.
   *
   * <p>Scheduled during {@link Robot#autonomousInit()}.
   */
  public Command getAutonomousCommand() {
    // Do nothing
    return m_drive.run(() -> {});
  }
}
