package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp(name = "TA_NK_EncoderAndDistance")
public class TA_NK_EncoderAndDistance extends CalculationsEncoderAndDistance {

    int loopCount = 0;
    public void runOpMode() {

        initialize();

        waitForStart();

        while(opModeIsActive()) {
            if(loopCount == 0)
            {
                motorUpdate();
            }
            if(gamepad1.y){
                pauseState();
            }
            else {
                if (gamepad1.aWasPressed()) {
                    alphaNumber = 8;
                    alphaUpdate();
                    motorUpdate();
                }
                if (gamepad1.bWasPressed()) {
                    alphaNumber = 2;
                    alphaUpdate();
                    motorUpdate();
                }
                if(gamepad1.x){
                    alphaNumber = -10;
                    alphaUpdate();
                    motorUpdate();
                }
            }
            if(gamepad1.x){
                encoderMotor.setTargetPosition(0);
            }
            pauseMotor();
            loopCount++;

            telemetry.addData("Motor Position:", encoderMotor.getCurrentPosition());
            telemetry.addData("Number of rotations:", finalDistance);
            telemetry.addData("Distance Traveled:", finalDistance * wheelCircum);
            telemetry.addData("Alpha Number", alphaNumber);
            telemetry.update();

        }


    }



}
