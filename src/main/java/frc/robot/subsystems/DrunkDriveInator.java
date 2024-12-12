package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.subsystems.swerve.DriveSubsystem;
import frc.robot.subsystems.swerve.SwerveModule;
import frc.robot.Constants;

public class DrunkDriveInator{
  public void getDDISpeed(){
    int ddiCoef = Math.nextInt(Constants.ddiMaxVelocity);
    double ddiSpeed = Math.random()*xcoef;
    
    return ddiSpeed;
    
  }
}
