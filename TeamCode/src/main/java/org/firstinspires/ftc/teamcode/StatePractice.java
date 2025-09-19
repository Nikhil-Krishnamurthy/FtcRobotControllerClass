package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous
public class StatePractice  extends LinearOpMode {
        TestBench2 bench = new TestBench2();


        public void runOpMode() {
            bench.initialize(hardwareMap);

            int state = 0;
            waitForStart();

            while(opModeIsActive())
            {
                telemetry.addLine("Current State " + state);
                switch (state) {

                    case 0:
                        telemetry.addLine("To Exit State: Press A");

                        if (gamepad1.a && !bench.getBusy()) {
                            state++;
                    }
                        break;

                    case 1:
                        telemetry.addLine("To Exit State: Press B");
                        if(gamepad1.b  && !bench.getBusy()) {
                            state++;
                    }
                        break;

                    case 2:
                        telemetry.addLine("To Exit State: Press X");
                        if(gamepad1.x  && !bench.getBusy())
                        {
                            state++;
                        }
                        break;
                    default:
                        telemetry.addLine("AutoStateMachine Finished");
                        break;
                }
                telemetry.update();
            }
        }

}
