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
    private ElapsedTime runTimeDouble =  new ElapsedTime();
    private double x;
    public void runOpMode() {

        bench.init(hardwareMap);
        waitForStart();
        runTimeDouble.reset();
        while(opModeIsActive()){

            while(bench.touchValue()){


                while(runTime.seconds() <= 1 && bench.touchValue()){
                    bench.setServoPosition(0);
                     x = runTime.seconds();
                }

                while(runTime.seconds() <= 2 && bench.touchValue()){
                    bench.setServoPosition(1);
                }
            }
            telemetry.addData("Servo Positions", bench.getServoPos());
            telemetry.addData("Touch Value", bench.touchValue());
            telemetry.addData("Runtime", runTimeDouble);
            telemetry.update();
        }
    }

}
