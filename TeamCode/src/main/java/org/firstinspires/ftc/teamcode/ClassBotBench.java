package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.robotcore.hardware.DcMotor;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

public class ClassBotBench {
    DcMotor leftMotor;
    DcMotor rightMotor;
    DcMotor armMotor;
    TouchSensor armSensor;
    Servo armServo;

    double gearRatio = 3.61*5.23;
    double singleRotationTicks = 28 * gearRatio;
    double inputPos;
    double tickResult;

    public void init(HardwareMap hwMap){
        leftMotor = hwMap.get(DcMotor.class, "left_motor");
        rightMotor = hwMap.get(DcMotor.class, "right_motor");
        armMotor = hwMap.get(DcMotor.class, "arm_motor");
        armSensor = hwMap.get(TouchSensor.class, "arm_sensor");
        armServo = hwMap.get(Servo.class, "arm_servo");

        leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        armMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        armMotor.setPower(0.1);
        while(!armSensor.isPressed()){
            telemetry.addLine("Initilization Status: Incomplete");
        }
        if(armSensor.isPressed()) {
            armMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            armMotor.setPower(0.0);
            armMotor.setTargetPosition(0);
            armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }
    }

    public void SetArmPos(int pos) {
        inputPos =  pos/360.0;
        tickResult = inputPos*singleRotationTicks;
        armMotor.setTargetPosition((int)tickResult);
    }

    public void SetArmPower(double power){
        armMotor.setPower(power);
    }

    public void sleepArm(){
        armMotor.setPower(0.0);
    }
}
