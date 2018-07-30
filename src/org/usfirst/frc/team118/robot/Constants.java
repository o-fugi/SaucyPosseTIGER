package org.usfirst.frc.team118.robot;

//this file contains all of the constant values that are used throughout the code.
//Any value in here can be accessed from the rest of the code with <Constants."variable name">
//															Example: Constants.FL_DRIVE;
public class Constants {
	//Defines the IDs for creating talon objects
	public final static int FL_DRIVE_TALON = 1;		////////////////////////////////////////////////////////////
	public final static int BL_DRIVE_TALON = 2;		//These IDs may not be correct for your robot			  //
													//To find the correct ID open internet explorer and go to //
	public final static int FR_DRIVE_TALON = 3;		//roboRIO-####-FRC.local where #### is your team number	  //
	public final static int BR_DRIVE_TALON = 4;  
	public final static int SPINNER_TALON = 0;												//once there you can find the IDs for all of your talons //
 //which talon is which			
	
	public static final double AUTO_SPEED = 0.75;
	public static final double AUTO_TIME = 10;
	//
													//														  //
           ///////////////////////////////////////////////////////////

	//Defines the IDs for creating Spark objects
	public final static int FL_DRIVE_SPARK = 11;		///////////////////////////////////////////////////////////
	public final static int BL_DRIVE_SPARK = 31;		//These IDs may not be correct for your robot			 //
															//To find the correct ID open internet explorer and go to//
	public final static int FR_DRIVE_SPARK = 21;		//roboRIO-####-FRC.local where #### is your team number	 //
	public final static int BR_DRIVE_SPARK = -11;		//once there you can find the IDs for all of your talons //


}
