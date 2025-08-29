package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp
public class ServoAndTouch extends LinearOpMode{

    boolean touchValue;
    double servoPos = 135;
    TestBench bench = new TestBench();
    private ElapsedTime runTime = new ElapsedTime();
    public void runOpMode() {

        bench.init(hardwareMap);
        waitForStart();

        while(opModeIsActive()){
            double runTimeThing = getRuntime();
            touchValue = bench.TouchValue();
            while(touchValue){

                runTime.reset();
                while(runTime.seconds() <= 1){
                    bench.setServoSpeed(135);
                }
                runTime.reset();
                while(runTime.seconds() <= 1){
                    bench.setServoSpeed(-135);
                }

            }
            telemetry.addData("Runtime", runTimeThing);
            telemetry.addData("Touch Value", touchValue);
            telemetry.addData("Servo Position", servoPos);
            telemetry.update();
        }
    }

}
