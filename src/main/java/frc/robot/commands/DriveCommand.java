package frc.robot.commands;

import java.util.HashSet;
import java.util.Set;
import java.util.function.DoubleSupplier;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.Drivetrain;

public class DriveCommand extends Command {
   //variable drivetreain
   Drivetrain drivetrain;
   DoubleSupplier xSupplier;
   DoubleSupplier ySupplier;
   DoubleSupplier thetaSupplier;
   

   public DriveCommand(DoubleSupplier xSupplier, DoubleSupplier ySupplier, DoubleSupplier thetaSupplier, Drivetrain drivetrain){
    this.xSupplier = xSupplier;
    this.ySupplier = ySupplier;
    this.thetaSupplier = thetaSupplier;
    this.drivetrain = drivetrain;
    addRequirements(drivetrain);
   }
//    double getters for the controller x, y, and z
   
//hace a constructor to get variables
   
   //Marks the commands start (Calls when the command is scheduled)
    @Override
    public void initialize(){
        
    }
    //Called repeatedly when the command is scheduled
    @Override
    public void execute(){
        drivetrain.swerveDrive.driveFieldOriented(new ChassisSpeeds(

            deadzone(xSupplier.getAsDouble(),0.05)* .3
              * drivetrain.swerveDrive.getMaximumChassisVelocity(),

            deadzone(ySupplier.getAsDouble(),0.05)
              * drivetrain.swerveDrive.getMaximumChassisVelocity() * .3,

            deadzone(thetaSupplier.getAsDouble(),0.05)
              * drivetrain.swerveDrive.getMaximumChassisAngularVelocity()* .3),
          new Translation2d());
    }
    //Called once when the command ends
    @Override
    public void end(boolean interrupted){

    }
    //Returns true whenever the command ends
    @Override
    public boolean isFinished(){
        return false;
    }
    //Returns whether the robot can run when disabled, method is defaulted to return false to ensure safety.
    public boolean runsWhenDisabled(){
        return false;
    }
    //Returns which takes priority in conflict 
    @Override
    public Command.InterruptionBehavior getInterruptionBehavior(){
        return InterruptionBehavior.kCancelSelf;
    }

    
    public Set<Subsystem> getRequirements(){
        Set<Subsystem> req = new HashSet<>();
        req.add(drivetrain);
        return req;
    }

    public static double deadzone(double num, double deadband){
        if(Math.abs(num)<deadband){
            return 0.0;
        }
        return num;
    }
}
