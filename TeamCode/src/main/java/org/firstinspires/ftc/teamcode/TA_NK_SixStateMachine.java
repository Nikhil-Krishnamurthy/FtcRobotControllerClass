package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class TA_NK_SixStateMachine extends OpMode {
    enum State { INIT_HW, HOME, WAIT_FOR_INPUT, SET_TARGET, MOVE_TO_TARGET, HOLD;}
    State st = State.INIT_HW;

    int targetDeg = 0;
    int targetTicks = 0;

    boolean prevA=false, prevB=false,prevX=false,prevY=false,prevStart=false;


        TestBench2 bench = new TestBench2();
        public void init() {

        }

        public void loop() {
            switch(st ) {
                case INIT_HW:
                    bench.initialize(hardwareMap);
                    st=State.HOME;
                    break;

                case HOME:
                    if(gamepad1.startWasPressed()) {st =State.WAIT_FOR_INPUT;}
                    break;

                case WAIT_FOR_INPUT:
                    if (gamepad1.a) {targetDeg = 90; st = State.SET_TARGET;}
                    else if (gamepad1.b) {targetDeg = 180; st =State.SET_TARGET;}
                    else if (gamepad1.x) {targetDeg = 270; st =State.SET_TARGET;}
                    else if (gamepad1.y) {targetDeg = 360; st =State.SET_TARGET;}
                    else if (gamepad1.startWasPressed()) {st = State.HOME;}
                    break;

                case SET_TARGET:
                    targetTicks = (int)(bench.getEnd() * (targetDeg/360));
                    st = State.MOVE_TO_TARGET;
                    break;

                case MOVE_TO_TARGET:
                    bench.setPosWithCalc(targetDeg);
                    if(bench.getPos() < (bench.getComp() + 15) && bench.getPos() > (bench.getComp() - 15) )
                    {
                        st = State.HOLD;
                        bench.sleepMotor();
                    }
                    break;

                case HOLD:
                    bench.sleepMotor();
                    if(gamepad1.a) {targetDeg = 90; st = State.SET_TARGET;}
                    else if (gamepad1.b) { targetDeg = 180; st = State.SET_TARGET;}
                    else if(gamepad1.x) {targetDeg = 270; st = State.SET_TARGET;}
                    else if(gamepad1.y) {targetDeg = 360; st = State.SET_TARGET;}
                    else if(gamepad1.startWasPressed()) {st = State.HOME;}
                    break;
                    }
                    telemetry.addData("State", st);
                    telemetry.addData("Target Degrees", targetDeg);
                    telemetry.addData("Target Position", targetTicks);
            }
        }