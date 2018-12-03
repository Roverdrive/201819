package org.firstinspires.ftc.team13180;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * This is a lander clasds having following functions
 * Move lander motor up and down and stop the motor
 */
public class Lander {
    private DcMotor lander;

    public void init(HardwareMap hardwareMap) {
        lander = hardwareMap.get(DcMotor.class, "Lander");
        //leftMotor.setDirection(DcMotor.Direction.REVERSE);
    }

    public void moveDown(double power) {
        lander.setPower(power);
    }

    public void moveUp(double power) {
        lander.setPower(power);
    }

    public void stopMotor() {
        lander.setPower(0);
    }

    public void moveUpTime(double power, long time) throws InterruptedException {
        moveUp(power);
        Thread.sleep(time);
        stopMotor();
    }

    public void moveDownTime(double power, long time) throws InterruptedException {
        moveDown(power);
        Thread.sleep(time);
        stopMotor();
    }

    public void setPower(double power)  {
        lander.setPower(power);
    }

    public void moveDownUsingEncoder(double speed, double inches, double timeOutS) {
        encoderDrive(speed, inches, timeOutS);
    }

    public void moveUpUsingEncoder(double speed, double inches, double timeOutS) {
        encoderDrive(speed, inches, timeOutS);
    }


    public void setRunWithEncoderMode() {
        lander.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        lander.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void setTargetPosition(int position) {
        lander.setTargetPosition(position);
    }

    public int getCurrentPosition() {
        return lander.getCurrentPosition();
    }

    public void setRunToPosition() {
        lander.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void setDirection(DcMotor motor, DcMotor.Direction direction) {
        lander.setDirection(direction); // Set to REVERSE if using AndyMark motor
    }

    // Testing Encoder Mode
    // Note: Reverse movement is obtained by setting a negative distance (not speed)
    //encoderDrive(DRIVE_SPEED,  DRIVE_SPEED,24,  24, 10.0);  // S1: Forward 24 Inches with 5 Sec timeout
    //encoderDrive(TURN_SPEED,  TURN_SPEED, -18,  18, 10.0);
    private ElapsedTime runtime = new ElapsedTime();

static final double     COUNTS_PER_MOTOR_REV    = 1440 ;    // eg: TETRIX Motor Encoder
static final double     DRIVE_GEAR_REDUCTION    = 0.5 ;     // This is < 1.0 if geared UP
// 2.0 : 6 gives 27 inches.
static final double     WHEEL_DIAMETER_INCHES   = 4.0 ;     // For figuring circumference
static final double     COUNTS_PER_INCH         = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) /
        (WHEEL_DIAMETER_INCHES * 3.1415);
static final double     DRIVE_SPEED             = 0.1;
static final double     TURN_SPEED              = 0.1;

/*
 *  Method to perfmorm a relative move, based on encoder counts.
 *  Encoders are not reset as the move is based on the current position.
 *  Move will stop if any of three conditions occur:
 *  1) Move gets to the desired position
 *  2) Move runs out of time
 */

public void encoderDrive(double speed, double moveInches, double timeoutS) {
        int newTarget;

        // Determine new target position, and pass to motor controller
        newTarget = getCurrentPosition() + (int)(moveInches * COUNTS_PER_INCH);

        setTargetPosition(newTarget);

        // Turn On RUN_TO_POSITION
        setRunToPosition();

        // reset the timeout time and start motion.
        runtime.reset();
        lander.setPower(speed);

        // TODO: Check
        // Stop all motion;
        stopMotor();

        // Turn off RUN_TO_POSITION
        setRunWithEncoderMode();
}

}
