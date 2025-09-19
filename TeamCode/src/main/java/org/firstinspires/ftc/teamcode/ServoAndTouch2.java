package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp
public class ServoAndTouch2 extends LinearOpMode{

    private Servo testServo;
    private TouchSensor touchSensor;
    private int count = 0;
    private ElapsedTime time = new ElapsedTime();

    @Override
    public void runOpMode() {
        testServo = hardwareMap.get(Servo.class, "test_servo");
        touchSensor = hardwareMap.get(TouchSensor.class, "touch_sensor");

        telemetry.addLine("Initialized - Press Start");
        telemetry.update();
        waitForStart();

        ElapsedTime timer = new ElapsedTime();
        boolean forward = true;

        while (opModeIsActive()) {

            if(touchSensor.isPressed()){
            if (timer.milliseconds() > 1000) {
                if (forward) {
                    testServo.setPosition(0.0);
                    telemetry.addLine("Servo CLOSED");
                    telemetry.addLine("Touch Value: True");
                    telemetry.addLine("Run Time" + time);
                } else {
                    testServo.setPosition(1.0);
                    telemetry.addLine("Servo OPEN");
                    telemetry.addLine("Touch Value: True");
                    telemetry.addLine("Run Time" + time);
                }
                forward = !forward;
                count++;
                telemetry.addLine("Loop Count " + count);
                timer.reset();
            }
        }else{
            telemetry.addLine("Button released: Servo stopped");
            telemetry.addLine("Touch Value: False");
                telemetry.addLine("Run Time" + time);
        }
            telemetry.update();
                }
            }
        }


