package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

@Disabled
public class GamePadControl extends OpMode{

    @Override
    public void init() {

    }

    @Override
    public void loop() {
        double speedForward =  -gamepad1.left_stick_y / 2.0;
        double differenceLeftX =  gamepad1.left_stick_x - gamepad1.right_stick_x;
        double sumTrigger =  gamepad1.right_trigger + gamepad1.left_trigger;

        telemetry.addData("left x", gamepad1.left_stick_x);
        telemetry.addData("left y", speedForward);
        telemetry.addData("right x" , gamepad1.right_stick_x);
        telemetry.addData("right y" , gamepad1.right_stick_y);
        telemetry.addData("Difference X" , differenceLeftX);

        telemetry.addData("a button", gamepad1.a);
        telemetry.addData("b button", gamepad1.b);

        telemetry.addData("Sum Triggers",  sumTrigger);
    }

}
