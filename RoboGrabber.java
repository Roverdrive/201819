package org.firstinspires.ftc.team13180;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * This is a RoboGrabber classs having following functions
 * TODO:
 */
public class RoboGrabber {
    private DcMotor grabber;
    private DcMotor winch;
    private Servo tilt1;
    private Servo tilt2;


    public void init(HardwareMap hardwareMap) {
        grabber = hardwareMap.get(DcMotor.class, "Grabber");
        winch = hardwareMap.get(DcMotor.class, "Winch");
        tilt1 = hardwareMap.get(Servo.class, "Tilt1");
        tilt2 = hardwareMap.get(Servo.class, "Tilt2");
        // TODO: Set motor direction or test
    }

    public void moveGrabberDown(double power) {
        grabber.setPower(-power);
    }

    public void moveGrabberUp(double power) {
        grabber.setPower(power);
    }

    public void stopGrabberMotor() {
        grabber.setPower(0);
    }

    public void moveGrabberDownTime(double power, long time) throws InterruptedException {
        moveGrabberDown(power);
        Thread.sleep(time);
        stopGrabberMotor();
    }

    public void moveGrabberUpTime(double power, long time) throws InterruptedException {
        moveGrabberUp(power);
        Thread.sleep(time);
        stopGrabberMotor();
    }
    
    public void moveWinchDown(double power) {
        winch.setPower(-power);
    }

    public void moveWinchUp(double power) {
        winch.setPower(power);
    }

    public void stopWinchMotor() {
        winch.setPower(0);
    }

    public void moveWinchDownTime(double power, long time) throws InterruptedException {
        moveWinchDown(power);
        Thread.sleep(time);
        stopWinchMotor();
    }

    public void moveWinchUpTime(double power, long time) throws InterruptedException {
        moveWinchUp(power);
        Thread.sleep(time);
        stopWinchMotor();
    }

}
