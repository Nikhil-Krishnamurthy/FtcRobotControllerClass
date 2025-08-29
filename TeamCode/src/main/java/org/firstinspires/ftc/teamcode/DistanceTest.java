package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class DistanceTest extends OpMode{

    TestBench bench = new TestBench();
    double length;

    @Override
    public void init() {bench.init(hardwareMap);}

    @Override
    public void loop() {
        length = bench.GetDistance();
        telemetry.addData("Distance", length);
    }


}
