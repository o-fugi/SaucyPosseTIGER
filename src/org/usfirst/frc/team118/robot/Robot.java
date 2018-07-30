//this defines where the file is
package org.usfirst.frc.team118.robot; 

import org.usfirst.frc.team118.robot.commands.DoNothingAuto;
import org.usfirst.frc.team118.robot.commands.DriveForwardAuto;
//import org.usfirst.frc.team118.robot.subsystems.Motor;
import org.usfirst.frc.team118.robot.subsystems.OurFirstMechanism;
import org.usfirst.frc.team118.robot.subsystems.TankDriveTalon;

//all of these import libraries that are used in this file 
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


//now we create a class called Robot, which is a subclass of IterativeRobot. IterativeRobot is an FRC-defined construct.
public class Robot extends IterativeRobot {
	
	//initialize the driver station							
	public static DriverStation ds;

	//initialize the joystick
	public static XboxController controller;

	//initialize the drive base
	//public static TankDriveSpark driveBaseSpark;
	public static TankDriveTalon driveBaseTalon;

	//public static Intake intake;
	//public static Motor motor;
	public static OurFirstMechanism mek;
	Command auto_command;

	SendableChooser<Command> chooser;
	
		
	//////////////////////////////////////////////////////////////
	//			Define other subsystem variables here so		// 
	//			they can be accessed throughout the code		//	
	//															//
	//					DON'T INSTANTIATE THEM HERE!			//
	//															//
	//	just define a variable of the subsystem class type here	//
	//////////////////////////////////////////////////////////////

	

	
	
	//this function is run when the robot is initialized
	//put all code that needs to be run just once when the robot is just turned on here
	//Initialize subsystems and put values on the smartDashboard here
	public void robotInit() {
		//driveBaseSpark = new TankDriveSpark(); 		//create the drive base (defines all of the motor controllers and related terms)
		driveBaseTalon = new TankDriveTalon();
		//intake = new Intake();
		//////////////////////////////////////////////
		//	Instantiate any other subsystems here 	//
		//  	such as a shooter or any other		//
		//			additional mechanisms			//
		//////////////////////////////////////////////
		chooser = new SendableChooser<Command>();
		chooser.addDefault("Do nothing", new DoNothingAuto());
		chooser.addObject("Drive Forward", new DriveForwardAuto());
		SmartDashboard.putData(chooser);
		controller = new XboxController(0); //create a controller object for receiving joystick inputs
		
		ds = DriverStation.getInstance(); /* this is how you access information from the Driver Station. See more at 
										   * https://wpilib.screenstepslive.com/s/currentCS/m/java/l/599722-driver-station-input-overview
										   */
		//motor = new Motor();
	    mek = new OurFirstMechanism();
	}

	//function is run when autonomous begins
	public void autonomousInit() {
		auto_command = chooser.getSelected();
		auto_command.start();
	}
	
	//function is called over and over again during autonomous
	public void autonomousPeriodic() {
		Scheduler.getInstance().run(); 	//Leave this here it is important(it makes sure the auto command is running in the background)
	}
	
	//this function is called when autonomous ends
	public void teleopInit(){
if(auto_command != null)
	auto_command.cancel();
	}
	
	//this function is called over and over again during teleop
	public void teleopPeriodic() {
		//tell the robot to drive with inputs from the controllers
		//Uses scaledDrive instead of drive to apply a deadzone and
		//to scale the joystick values for smoother driving
		
		driveBaseTalon.drive(-1*controller.getY(GenericHID.Hand.kLeft), -1*controller.getY(GenericHID.Hand.kRight)); 
		//motor.spinner.set(-1*controller.getY(GenericHID.Hand.kLeft));
	/*	if(controller.getAButton()) {
			
			motor.SpinRight();
		}
		else if(controller.getBButton()) {
			motor.SpinLeft();
		}
		else{
			motor.spinner.set(0);} */
		if(controller.getXButton()) {
			mek.LiftUp();
		}
		else if (controller.getYButton()) {
			mek.LiftDown();
		}
		else {
			mek.mecha1.set(0);
			mek.mecha2.set(0);
		}
			
		}
}
		
		
		
	/*    if(controller.getXButton()) {
	    	//intake.spinOut();
	    	
	  //  }
	   // if(controller.getYButton()) {
	    	//intake.spinIn();
	    	 	
	    }
	   // if(controller.getAButton()) {
	    //	intake.SolDown();
	    }
	    //if(controller.getBButton())	 {
	    	//intake.SolUp(); 
	    }
	}
	
} */
