package frc.robot.commands;

import frc.robot.subsystems.DrunkDriveInator;
import edu.wpi.first.wpilibj2.command.Command;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.subsystems.swerve.DriveSubsystem;
import frc.robot.subsystems.swerve.SwerveModule;
import frc.robot.Constants;

public class RunDDI extends Command{
  private final DrunkDriveInator xDDI;
  private final DrunkDriveInator yDDI;
  private final DriveSubsystem driving;
  
  //increments with execute, when it hits 50 it will end the command
  private int timer = 0;


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
    driving.drive(xDDI.getDDISpeed(),yDDI.getDDISpeed(),0,false);
    timer++;
  }

  @Override
  public boolean isFinished(){
    if(timer>=50){
      return true;
    }else{
      return false;
    }
    
  }
  
  
}

