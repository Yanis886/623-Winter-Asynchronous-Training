//Hello my name is elisha.


package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;
import swervelib.SwerveDrive;

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
   }
//    double getters for the controller x, y, and z
   
//hace a constructor to get variables
    @Override
    public void end(boolean interrupted){f

    }
    

    public void execute(){
        
    }
    public boolean isFinished(){
        return false;
    }

    @Override
    public boolean runsWhenDisabled(){
        return false;
    }

}
