package frc.robot.commands;

import frc.robot.subsystems.DrunkDriveInator;
import edu.wpi.first.wpilibj2.command.Command;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.subsystems.swerve.DriveSubsystem;
import frc.robot.subsystems.swerve.SwerveModule;
import frc.robot.Constants;

public class RunDDI extends Command{
  private DrunkDriveInator xDDI;
  private DrunkDriveInator yDDI;
  private DriveSubsystem heading;
  
  public RunDDI(double xDDI,double yDDI, double heading){
    addRequirements(_xDDI);
    addRequirements(_yDDI);
    addRequirements(_heading);

    xDDI = _xDDI;
    yDDI = _yDDI;
    heading = _heading
  }
  @Override
  public void initialize(){}
  
}
