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
  private DriveSubsystem driving;
  
  public RunDDI(DrunkDriveInator _xDDI,DrunkDriveInator _yDDI, DriveSubsystem _driving){
    
    
    addRequirements(_driving);

    xDDI = _xDDI;
    yDDI = _yDDI;
    driving = _driving;
  }
  @Override
  public void initialize(){}

  @Override
  public void execute(){
    driving.drive(xDDI.getDDISpeed(),yDDI.getDDISpeed(),driving.getHeading(),false);
  }

  @Override
  public boolean isFinished(){
    return false;
  }
  
  
}
