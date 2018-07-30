package org.usfirst.frc.team118.robot.commands;

import org.usfirst.frc.team118.robot.Constants;
import org.usfirst.frc.team118.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveForwardAuto extends Command { 
	double start_time;
	double current_time;

	public DriveForwardAuto() {	
	}
	protected void initialize() {
		start_time = System.currentTimeMillis() / 1000;
	}
	protected void execute()
	{	
		current_time = System.currentTimeMillis() / 1000;
		Robot.driveBaseTalon.drive(Constants.AUTO_SPEED, -1*Constants.AUTO_SPEED);
	}
	protected void end()
	{
		Robot.driveBaseTalon.drive(0, 0);
	}
	@Override
	protected boolean isFinished() {
		System.out.println("current_time = "+ current_time);
		System.out.println("current_time = "+ start_time);
		System.out.println("auto_time = " + Constants.AUTO_TIME);
				
		if(current_time - start_time < Constants.AUTO_TIME) {
			return false;
		}
		// TODO Auto-generated method stub
		
		else {
		System.out.println("Still running");
		return true;
	}
	
	}
}
