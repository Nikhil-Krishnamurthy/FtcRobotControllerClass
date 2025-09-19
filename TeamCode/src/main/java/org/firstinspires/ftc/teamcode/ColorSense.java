package org.firstinspires.ftc.teamcode;

import static android.graphics.Color.red;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
@TeleOp
public class ColorSense extends LinearOpMode{
    TestBench bench = new TestBench();
    ElapsedTime time = new ElapsedTime();

    private final int inDis = 40;
    private final int outDis = 50;
    double green;
    double blue;
    double red;
    float[] hsv = new float[3];
    @Override

    public void runOpMode() {
        bench.init(hardwareMap);

        waitForStart();
        while(opModeIsActive()){
            red = bench.getRed();
            green = bench.getGreen();
            blue = bench.getBlue();
            android.graphics.Color.RGBToHSV((int)red, (int)green, (int)blue, hsv);
            float hue = hsv[0];
            float saturation = hsv[1];
            float value = hsv[2];



            telemetry.addData("RunTime: ", time);
            telemetry.addData("Red", red);
            telemetry.addData("Green", green);
            telemetry.addData("Blue", blue);

            telemetry.addData("Hue", hue);
            telemetry.addData("Saturation", saturation);
            telemetry.addData("Value", value);

            telemetry.addData("Distance", bench.getColorDistance());
            telemetry.addData("Distance Sensor", bench.getDistance());

            telemetry.update();


            if(bench.getColorDistance() <= outDis && bench.getColorDistance() >= inDis) {
                if(value >= 0.62)
                {
                    bench.setMotorSpeed(0.8);
                    telemetry.addLine("WHITE");
                    telemetry.addLine("Speed: Forward 80%");
                }
                else {
                    if (hue <= 55 || hue >= 300) {
                        bench.setMotorSpeed(0.6);
                        telemetry.addLine("RED");
                        telemetry.addLine("Speed: Forward 60%");
                    } else if (hue <= 180 && hue >= 136) {
                        bench.setMotorSpeed(-0.4);
                        telemetry.addLine("Dark GREEN");
                        telemetry.addLine("Speed: Backward 40%");
                    } else if (hue >= 181 && hue <= 299) {
                        bench.setMotorSpeed(0.3);
                        telemetry.addLine("BLUE");
                        telemetry.addLine("Speed: Forward 30%");
                    } else if (hue >= 55 && hue <= 110) {
                        bench.setMotorSpeed(-0.6);
                        telemetry.addLine("Yellow");
                        telemetry.addLine("Speed: Backward 60%");
                    } else if (hue >= 111 && hue <= 135) {
                        bench.setMotorSpeed(0.4);
                        telemetry.addLine("Green");
                        telemetry.addLine("Speed: Forward 40%");
                    }
                }
            }
            else{
                bench.setMotorSpeed(0);
                telemetry.addLine("Not In Range");
                telemetry.addLine("Speed: 0%");
            }

        }




    }

}
