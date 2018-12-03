package org.firstinspires.ftc.team13180;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


@TeleOp(name="MecanumManual", group="manual")
public class Mecanum extends LinearOpMode {

    private DcMotor topl;
    private DcMotor topr;
    private DcMotor rearl;
    private DcMotor rearr;
    private DcMotor lander;
    private DcMotor grabber;
    private DcMotor winch;
    private Servo tilt1;
    private Servo tilt2;
    private RobotNavigator robotnav;

    @Override
    public void runOpMode() {
        //imu = hardwareMap.get(Gyroscope.class, "imu");
        topl = hardwareMap.get(DcMotor.class, "Topl");
        topr = hardwareMap.get(DcMotor.class, "Topr");
        rearl = hardwareMap.get(DcMotor.class, "Rearl");
        rearr = hardwareMap.get(DcMotor.class, "Rearr");
        lander= hardwareMap.get(DcMotor.class, "Lander");

        grabber = hardwareMap.get(DcMotor.class, "Grabber");

       winch = hardwareMap.get(DcMotor.class, "Winch");
        tilt1 = hardwareMap.get(Servo.class, "Tilt1");
        tilt2 = hardwareMap.get(Servo.class, "Tilt2");

        robotnav = new RobotNavigator();


        waitForStart();




        double tgtPower1 = 0;
        double tgtPower2 = 0;
        double tgtPower3 = 0;
        double tgtPower4 = 0;
        double tgtPower5 = 0;
        double multiPlier1 = 1;
        double multiPlier2 = 1;
        double RbrPower=0;
        double WnchPower=0;
        double Rbrmultiplier=0.5;
        double Wnchmultiplier=0.5;
        while (opModeIsActive()) {
           /* // Gamepad 1            // MotorTest1
            tgtPower1 = multiPlier1 * this.gamepad1.left_stick_y;
            topl.setPower(tgtPower1);
            // MotorTest2
            tgtPower2 = -multiPlier1 * this.gamepad1.right_stick_y;
            //tgtPower1 = - multiPlier1 * this.gamepad1.right_stick_y;
            topr.setPower(tgtPower2);
            tgtPower3 = multiPlier1 * this.gamepad1.left_stick_y;
            rearl.setPower(tgtPower3);
            // MotorTest2
            tgtPower4 = -multiPlier1 * this.gamepad1.right_stick_y;
            //tgtPower1 = - multiPlier1 * this.gamepad1.right_stick_y;
            rearr.setPower(tgtPower4);
            if(gamepad1.left_stick_y!=0){
                tgtPower1=multiPlier1*this.gamepad1.left_stick_y;
                topl.setPower(tgtPower1);
                //__________
                tgtPower2=-multiPlier1*this.gamepad1.left_stick_y;
                topr.setPower(tgtPower2);
                //__________
                tgtPower3=multiPlier1*this.gamepad1.left_stick_y;
                rearl.setPower(tgtPower3);
                //__________
                tgtPower4=-multiPlier1*this.gamepad1.left_stick_y;
                rearr.setPower(tgtPower4);
                //__________
            }
            if(gamepad1.left_stick_x!=0){
                tgtPower1=-multiPlier1*this.gamepad1.left_stick_x;
                topl.setPower(tgtPower1);
                //__________
                tgtPower2=-multiPlier1*this.gamepad1.left_stick_x;
                topr.setPower(tgtPower2);
                //__________
                tgtPower3=multiPlier1*this.gamepad1.left_stick_x;
                rearl.setPower(tgtPower3);
                //__________
                tgtPower4=multiPlier1*this.gamepad1.left_stick_x;
                rearr.setPower(tgtPower4);
                //__________
            }
            if(gamepad1.right_stick_x!=0){
                tgtPower1=multiPlier1*this.gamepad1.left_stick_x;
                topl.setPower(tgtPower1);
                //__________
                tgtPower2=multiPlier1*this.gamepad1.left_stick_x;
                topr.setPower(tgtPower2);
                //__________
                tgtPower3=multiPlier1*this.gamepad1.left_stick_x;
                rearl.setPower(tgtPower3);
                //__________
                tgtPower4=multiPlier1*this.gamepad1.left_stick_x;
                rearr.setPower(tgtPower4);
                //__________
            }
            */
            if (gamepad1.left_stick_y> 0){
                robotnav.moveForward(0.5);}
            if (gamepad1.left_stick_y<0){
                robotnav.moveBackward(0.5);}
            if(gamepad1.left_stick_x>0){
                robotnav.shiftRight(0.5);}
            if (gamepad1.left_stick_x<0){
                robotnav.shiftLeft(0.5); }
            if (gamepad1.right_stick_x>0){
                robotnav.turnRight(0.5); }
            if (gamepad1.right_stick_x<0){
                robotnav.turnLeft(0.5);}
            if(gamepad2.right_trigger!=0) {
                tgtPower5=-multiPlier2*this.gamepad2.right_trigger;
                lander.setPower(tgtPower5);
            }

          /*  if(gamepad2.right_stick_y!=0) {
                RbrPower = Rbrmultiplier * this.gamepad2.right_stick_y;
                grabber.setPower(RbrPower);
            }

            if (gamepad2.left_stick_y !=0){
                winch.setPower(WnchPower);
                WnchPower = Wnchmultiplier*this.gamepad2.left_stick_y;
            }*/
/* TODO */
/*
            tilt1.setPosition(0);
            tilt2.setPosition(0);
            if(gamepad2.dpad_up){
                tilt1.setPosition(0.5);
                tilt2.setPosition(0.5);
            }
            if(gamepad2.dpad_down){
                tilt1.setPosition(0);
                tilt2.setPosition(0);
            }
*/

            // Gamepad 2
            // Gamepad 2 is used to control Motor 3 and 4

            //tgtPower2 = - multiPlier2 * this.gamepad2.right_stick_y;
            //motorTest4.setPower(tgtPower2);
            // check to see if we need to move the servo.
            // Gamepad 2 is used to control Servo Motor 1 and 2


        }
    }
}







