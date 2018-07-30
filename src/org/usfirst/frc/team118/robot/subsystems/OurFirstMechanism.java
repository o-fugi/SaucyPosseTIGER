package org.usfirst.frc.team118.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;

public class OurFirstMechanism extends Subsystem{
	public PWMVictorSPX mecha1;
	public PWMVictorSPX mecha2;
	public OurFirstMechanism() {
		mecha1 = new PWMVictorSPX(1);
		mecha2 = new PWMVictorSPX(2);
	}
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		mecha1.set(0);
		mecha2.set(0);
	}
public void LiftUp() {
	mecha1.set(.5);
	mecha2.set(-.5);
}
public void LiftDown() {
	mecha1.set(-.5);
	mecha2.set(.5);
}
}
