/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package org.usfirst.frc.team118.robot.subsystems;

import org.usfirst.frc.team118.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
//import javafx.scene.control.Spinner;
//An example subsystem.  You can replace me with your own Subsystem.
public class TankDriveTalon extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
   WPI_TalonSRX FrRight, FrLeft, BckRight, BckLeft;
    public TankDriveTalon()
    {
       FrRight = new WPI_TalonSRX(Constants.FR_DRIVE_TALON);
       FrLeft = new WPI_TalonSRX(Constants.FL_DRIVE_TALON);
       BckRight = new WPI_TalonSRX(Constants.BR_DRIVE_TALON);
       BckLeft = new WPI_TalonSRX(Constants.BL_DRIVE_TALON);
    }
    public void initDefaultCommand() {
        // <NOT NECESSARY> Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
    public double cube(double x) {
    	if(Math.abs(x) < .2) {
    		x = 0;
    	}
    	 x = Math.pow(x, 3);
    return x;
    }
    public void drive(double lValue, double rValue)
    {
    	
        FrRight.set(ControlMode.PercentOutput, cube(rValue)*-.5);
        FrLeft.set(ControlMode.PercentOutput, cube(lValue)*.5);
        BckRight.set(ControlMode.PercentOutput, cube(rValue)*-.5);
        BckLeft.set(ControlMode.PercentOutput, cube(lValue)*.5);
    }
}// nameoftalon.set(ControlMode.PercentOutput, x);
