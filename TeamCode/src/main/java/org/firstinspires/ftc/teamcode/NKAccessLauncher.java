package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

@TeleOp
public class NKAccessLauncher extends LinearOpMode {

    DcMotorEx leftLaunch = null;
    DcMotorEx rightLaunch = null;
    DcMotorEx intake = null;

    private double spinSpeed = 0.0;
    private double intakeSpeed = 0.0;
    private final double speedChange = 50;

    public void runOpMode() {

        leftLaunch = hardwareMap.get(DcMotorEx.class, "motor2");//check config file to make sure this is right.
        rightLaunch = hardwareMap.get(DcMotorEx.class, "motor1");//same with this.
        intake = hardwareMap.get(DcMotorEx.class, "intake");//and this.

        rightLaunch.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftLaunch.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        intake.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        rightLaunch.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftLaunch.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        intake.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        rightLaunch.setVelocity(0);
        leftLaunch.setVelocity(0);
        intake.setVelocity(0);

        leftLaunch.setDirection(DcMotorSimple.Direction.REVERSE);
        rightLaunch.setDirection((DcMotorSimple.Direction.FORWARD));

        waitForStart();
        resetRuntime();
        while(opModeIsActive()){

            if(gamepad1.dpadDownWasPressed()){
                spinSpeed-=speedChange;
            }

            if(gamepad1.dpadUpWasPressed()){
                spinSpeed+=speedChange;
            }

            if(gamepad1.aWasPressed()){
                intakeSpeed+=speedChange;
            }

            if(gamepad1.bWasPressed()){
                intakeSpeed-=speedChange;
            }

                rightLaunch.setVelocity(spinSpeed);
                leftLaunch.setVelocity(spinSpeed);

                telemetry.addData("LaunchSpeed:", spinSpeed);
                telemetry.addData("IntakeSpeed:", intakeSpeed);
                telemetry.addData("UpTime:", getRuntime());
                telemetry.update();
        }


    }
}
