package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.hardware.ColorSensor;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import com.qualcomm.robotcore.hardware.DistanceSensor;

@TeleOp(name="Midterm Hardware Diagnostic", group="Tools")
public class MidtermHardwareDiagnostic extends LinearOpMode {

    private DcMotor p3NkMotor;
    private Servo p3NkServo;
    private TouchSensor p3NkTouch;
    private ColorSensor p3NkColor;
    private DistanceSensor p3NkDistance;

    @Override
    public void runOpMode() {

        // --- Hardware names must match the Robot Configuration ---
        p3NkMotor    = hardwareMap.get(DcMotor.class, "p3_nk_motor");
        p3NkServo    = hardwareMap.get(Servo.class, "p3_nk_servo");
        p3NkTouch = hardwareMap.get(TouchSensor.class, "p3_nk_touch");
        p3NkColor = hardwareMap.get(ColorSensor.class, "p3_nk_color");
        p3NkDistance = hardwareMap.get(DistanceSensor.class, "p3_nk_color"); // same sensor

        telemetry.addLine("✅ Hardware mapped");
        telemetry.addLine("Press START to begin test.");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {

            // --- Touch Test: Motor runs at 0.25 if pressed ---
            if (p3NkTouch.isPressed()) {
                p3NkMotor.setPower(0.25);
            } else {
                p3NkMotor.setPower(0.0);
            }

            // --- Color Test: Show only RED value ---
            int redValue = p3NkColor.red();

            // --- Distance Test: Servo position control ---
            double distCM = p3NkDistance.getDistance(DistanceUnit.CM);
            if (distCM < 1.5) {
                p3NkServo.setPosition(0.0);
            } else {
                p3NkServo.setPosition(1.0);
            }

            // --- Display results ---
            telemetry.addData("Touch pressed", p3NkTouch.isPressed());
            telemetry.addData("Motor power", p3NkMotor.getPower());
            telemetry.addData("Red value", redValue);
            telemetry.addData("Distance (cm)", "%.2f", distCM);
            telemetry.addData("Servo position", p3NkServo.getPosition());
            telemetry.update();

            idle();
        }
    }
}


