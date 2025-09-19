package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.ColorSensor;


import org.firstinspires.ftc.robotcore.external.JavaUtil;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class TestBench{

    private DcMotor testMotor;
    private Servo testServo;
    private TouchSensor testTouch;
    private DistanceSensor testDistance;
    private ColorSensor testColor;
    private DistanceSensor testColorDistance;

    public void init(HardwareMap hwMap) {


        testMotor = hwMap.get(DcMotor.class, "test_motor");
        testServo = hwMap.get(Servo.class, "test_servo");
        testTouch = hwMap.get(TouchSensor.class, "touch_sensor");
        testColor = hwMap.get(ColorSensor.class, "color_sensor");
        testDistance = hwMap.get(DistanceSensor.class, "sensor_distance");
        testColorDistance = hwMap.get(DistanceSensor.class, "color_sensor");
        testMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        testServo.setPosition(0);
    }

    public void setMotorSpeed(double speed) {

        testMotor.setPower(speed);
    }

    public void setServoPosition(double pos) {

        testServo.setPosition(pos);
    }

    public double getServoPos(){

        return testServo.getPosition();
    }

    public boolean touchValue() {
        return testTouch.isPressed();
    }

    public double getDistance ()
    {
        return testDistance.getDistance(DistanceUnit.MM);
    }


    public double getBlue () {
        return testColor.blue();}

    public double getRed () {return testColor.red();}

    public double getGreen () {return testColor.green();}

    public double getHue () {return JavaUtil.colorToHue(testColor.red());}

    public double getColorDistance () {return testColorDistance.getDistance(DistanceUnit.MM);}//
}
