package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public abstract class CalculationsEncoderAndDistance extends LinearOpMode {

    public final int motorTicks = 28;
    public final double gearRatio = 3.61 * 5.23;
    public final double wheelCircum = 2.245 * 2 * Math.PI;
    public double finalTicks = motorTicks * gearRatio;
    public int alphaNumber = 8;
    public double tickDistance;
    public double finalDistance;
    public DcMotor encoderMotor;

    public void initialize() {
        encoderMotor = hardwareMap.get(DcMotor.class, "encoder_motor");

        encoderMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        encoderMotor.setTargetPosition(0);
        encoderMotor.setPower(0.15);
        encoderMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        if (!encoderMotor.isBusy()) {
            encoderMotor.setPower(0.0);
        }
    }

    public void alphaUpdate() {
        if(alphaNumber < 10){
            finalDistance = (alphaNumber + 10)/wheelCircum;
            tickDistance = finalDistance*finalTicks;
        }
        else{
            finalDistance = (alphaNumber + 5.5)/wheelCircum;
            tickDistance = finalDistance*finalTicks;
        }

    }

    public void motorUpdate() {
        encoderMotor.setTargetPosition((int)tickDistance);
        encoderMotor.setPower(0.15);
    }

    public void pauseMotor() {
        if(!encoderMotor.isBusy()){
            encoderMotor.setPower(0.0);
        }
    }
    public void pauseState() {
        encoderMotor.setTargetPosition(encoderMotor.getCurrentPosition());
        encoderMotor.setPower(0.15);
    }
}
