package org.firstinspires.ftc.team13180;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="TestGrabber", group ="Testing")
public class Grabber extends LinearOpMode{
    private DcMotor spinner;
    private DcMotor winch;
    private Servo tiltl;
    private Servo tiltr;
    @Override
    public void runOpMode(){
        spinner = hardwareMap.get(DcMotor.class, "Spinner");
        winch = hardwareMap.get(DcMotor.class, "Winch");
        tiltl = hardwareMap.get(Servo.class, "Tiltl");
        tiltr = hardwareMap.get(Servo.class, "Tiltr");
        waitForStart();
        double SpinPower=0;
        double WnchPower=0;
        double Rbrmultiplier=0.5;
        double Wnchmultiplier=0.5;
        tiltl.setPosition(0);
        tiltr.setPosition(0);
        while (opModeIsActive()){
            if(this.gamepad2.right_stick_y!=0) {
                SpinPower = Rbrmultiplier * this.gamepad2.right_stick_y;
                spinner.setPower(SpinPower);
            }

            if (this.gamepad2.left_stick_y!=0){
                WnchPower=this.gamepad2.left_stick_y*Wnchmultiplier;
                winch.setPower(WnchPower);
            }

        if(gamepad2.dpad_up){
            tiltl.setPosition(0.1);
            tiltr.setPosition(-0.1);
        }
        if(gamepad2.dpad_down){
            tiltl.setPosition(-0.1);
            tiltr.setPosition(0.1);

        }
        }





    }

}
