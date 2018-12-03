package org.firstinspires.ftc.team13180;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


@TeleOp(name="Robonavtest", group="manualmode")

public class RobonavigatorTest extends LinearOpMode {

    private DcMotor topl;
    private DcMotor topr;
    private DcMotor rearl;
    private DcMotor rearr;

    private RobotNavigator robotnav;

    @Override
    public void runOpMode() {

        robotnav = new RobotNavigator();
        robotnav.init(hardwareMap);


        waitForStart();




        while (opModeIsActive()) {

            if (gamepad1.y) {
                robotnav.moveForward(0.5);
            }
            if (gamepad1.a) {
                robotnav.moveBackward(0.5);
            }
            if (gamepad1.b) {
                robotnav.shiftRight(0.5);
            }
            if (gamepad1.x) {
                robotnav.shiftLeft(0.5);
            }
            if (gamepad1.right_bumper) {
                robotnav.turnRight(0.5);
            }
            if (gamepad1.left_bumper) {
                robotnav.turnLeft(0.5);
            }

        }}}