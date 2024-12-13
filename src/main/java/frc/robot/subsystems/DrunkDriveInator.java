package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import java.util.concurrent.ThreadLocalRandom;


import frc.robot.subsystems.swerve.DriveSubsystem;
import frc.robot.subsystems.swerve.SwerveModule;
import frc.robot.Constants;

public class DrunkDriveInator{
  public double getDDISpeed(){
    //gets a number to use for calling xspeed and yspeed drive in the DrunkDriveInator
    

    int ddiCoef = ThreadLocalRandom.current().nextInt(-Constants.ddiMaxVelocity,Constants.ddiMaxVelocity);
    System.out.println(ddiCoef);
    double ddiSpeed = Math.random()*ddiCoef;
    System.out.println("ddi speed");
    System.out.println(ddiSpeed);
    return ddiSpeed;
    
  }
}
