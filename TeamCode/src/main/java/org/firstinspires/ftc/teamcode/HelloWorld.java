package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@Disabled
public class HelloWorld extends OpMode{
    private String greeting;
    public void init() {
        greeting = new String ("Hello, FTC World!");
        telemetry.addData("Greeting", greeting);
    }

    @Override
    public void loop() {
        telemetry.update();
    }

}
