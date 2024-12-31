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

  private double xDDISpeed;
  private double yDDISpeed;
  private boolean flipped = false;

  public RunDDI(DrunkDriveInator _xDDI,DrunkDriveInator _yDDI, DriveSubsystem _driving){
    
    
    addRequirements(_driving);

    xDDI = _xDDI;
    yDDI = _yDDI;
    driving = _driving;
  }
  @Override
  public void initialize(){
    xDDISpeed=xDDI.getDDISpeed();
    yDDISpeed = yDDI.getDDISpeed();
    
  }

  @Override
  public void execute(){
    
    if((timer>25)&&(flipped = false)){
      xDDISpeed*=-0.9;
      yDDISpeed*=-0.9;
      flipped = true;
    }
    driving.swerveDriveCommand(()-> xDDISpeed,()->yDDISpeed,()->0,false);
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


  }
  
  
}

