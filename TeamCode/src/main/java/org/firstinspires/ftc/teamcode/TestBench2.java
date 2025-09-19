package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class TestBench2 {
    private DcMotor motorS;

    public final int motorTicks = 28;
    public final double gearRatio = 3.61 * 5.23;
    public final double end = gearRatio * motorTicks;
    private double comp;
    public void initialize(HardwareMap hwMap){
            motorS = hwMap.get(DcMotor.class, "state_motor");
            motorS.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            motorS.setTargetPosition(0);
            motorS.setPower(0);
            motorS.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void setPosition(int ticks) {
    motorS.setTargetPosition(ticks);
    motorS.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    motorS.setPower(0.5);
    }

    public boolean getBusy() {
        return motorS.isBusy();
    }

    public void sleepMotor() {
        motorS.setPower(0.0);
    }

    public void setPosWithCalc(int degrees) {
        comp = end*degrees/360;
        motorS.setTargetPosition((int)comp);
        motorS.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorS.setPower(0.5);
    }

    public int getPos() {
    return motorS.getCurrentPosition();
    }

    public double getEnd()
    {
        return end;
    }

    public int getComp() { return (int)comp;}

}
