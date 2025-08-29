package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DistanceSensor;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class TestBench{

    private DcMotor testMotor;
    private Servo testServo;
    private TouchSensor testTouch;
    private DistanceSensor testDistance;

    public void init(HardwareMap hwMap) {


        testMotor = hwMap.get(DcMotor.class, "test_motor");
        testServo = hwMap.get(Servo.class, "test_servo");
        testTouch = hwMap.get(TouchSensor.class, "touch_sensor");
        //testTouch.setMode(DigitalChannel.Mode.INPUT);
        testDistance = hwMap.get(DistanceSensor.class, "sensor_distance");
        testMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        testServo.setPosition(0);
    }

    public void setMotorSpeed(double speed) {

        testMotor.setPower(speed);
    }

    public void setServoSpeed(double pos) {

        testServo.setPosition(pos);
    }

    public boolean TouchValue() {
        return testTouch.isPressed();
    }

    public double GetDistance ()
    {
        return testDistance.getDistance(DistanceUnit.CM);
    }
}
