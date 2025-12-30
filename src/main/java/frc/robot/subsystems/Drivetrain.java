package frc.robot.subsystems;

import java.io.File;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import swervelib.SwerveDrive;
import swervelib.parser.SwerveParser;

public class Drivetrain extends SubsystemBase{
    SwerveDrive swerveDrive;
    public Drivetrain(File directory){
        try{
        swerveDrive = new SwerveParser(directory).createSwerveDrive(Constants.MAX_SPEED,
           new Pose2d() );
        } catch (Exception e)    {
            //in case code up top crashes
            System.out.println("constructor failed");
            throw new RuntimeException();
        }
    //you candrive now
    swerveDrive.setMotorIdleMode(true);
    }
         public Pose2d getPose(){
            return swerveDrive.getPose();
         }

         public void resetOdometry(Pose2d pose){
            swerveDrive.resetOdometry(pose);
         }

         public void zeroGyro(){
            swerveDrive.zeroGyro();
         }

         public ChassisSpeeds getRobotVelocity(){
            return swerveDrive.getFieldVelocity();
         }
         public double deadzone(double input, double threshold){
            if(Math.abs(input)>threshold){
                return input;
            } else{
                return 0.0;
            }
         }
         }









