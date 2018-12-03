package org.firstinspires.ftc.team13180;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


@TeleOp(name="Landertest", group="manualmode")

public class LanderTest extends LinearOpMode {

    private Lander lander;
    static final double     DRIVE_SPEED  = 0.1;
    @Override
    public void runOpMode() {

        lander = new Lander();
        lander.init(hardwareMap);

        waitForStart();

        while (opModeIsActive()) {

            if (gamepad1.y) {
                lander.moveDownUsingEncoder(DRIVE_SPEED, 24,  10.0);  // S1: Forward 24 Inches with 5 Sec timeout
            }
            if (gamepad1.a) {
                lander.moveUpUsingEncoder(DRIVE_SPEED, -24, 10.0);  // S1: Forward 24 Inches with 5 Sec timeout;
            }
            lander.stopMotor();

            }
        /*
        while (opModeIsActive()) {

            if (gamepad1.y) {
                lander.moveUp(0.5);
            }
            if (gamepad1.a) {
                lander.moveDown(0.5);
            }
            lander.stopMotor();

        }
        */

        }
    }
