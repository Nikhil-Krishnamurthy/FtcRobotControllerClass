package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;

@TeleOp
public class DcMotorPractice extends OpMode {
    double speedMod;
    double servoPos;
    boolean touchValue;
    TestBench bench = new TestBench();

    @Override
    public void init() {
        bench.init(hardwareMap);
    }

    @Override
    public void loop() {
        touchValue = bench.TouchValue();
        if(gamepad1.a)
        {
            speedMod = gamepad1.left_stick_y * -1;
        }
        else
        {
            speedMod = gamepad1.left_stick_y * -0.5;
        }

        if(bench.TouchValue())
        {
            servoPos = 270;
        }
        else
        {
            servoPos = 0;
        }
        telemetry.addData("Motor Speed", gamepad1.left_stick_y);
        telemetry.addData("touch sensor", touchValue);
        bench.setMotorSpeed(speedMod);
        bench.setServoSpeed(servoPos);
    }

}
