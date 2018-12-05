package org.firstinspires.ftc.team13180;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="TestGrabber", group ="Testing")
public class Grabber extends LinearOpMode{
    private DcMotor grabber;
    private DcMotor lander;
    private DcMotor winch;
    private Servo tilt1;
    private Servo tilt2;
    @Override
    public void runOpMode(){
        grabber = hardwareMap.get(DcMotor.class, "Grabber");
        winch = hardwareMap.get(DcMotor.class, "Winch");
        lander=hardwareMap.get(DcMotor.class,"Lander");
        tilt1 = hardwareMap.get(Servo.class, "Tilt1");
        tilt2 = hardwareMap.get(Servo.class, "Tilt2");
        waitForStart();
        double SpinPower=0;
        double LanderPower=0;
        double Grbrmultiplier=0.5;
        double WinchMultiplier=0.5;
        tilt1.setPosition(0);
        tilt2.setPosition(0);
        while (opModeIsActive()) {
            if (this.gamepad2.left_trigger > 0) {
                SpinPower = -Grbrmultiplier * this.gamepad2.left_trigger;
                grabber.setPower(SpinPower);
            }

            if (this.gamepad2.right_trigger > 0) {
                SpinPower = this.gamepad2.right_trigger * Grbrmultiplier;
                grabber.setPower(SpinPower);
            }
          /*  if (this.gamepad2.left_stick_y!=0){
                LanderPower=this.gamepad2.left_stick_y*TiltMultiplier;
                .setPower(LanderPower);
            } ITS A SERVO IT DOESN'T HAVE POWERRRRRRRRRRRR*/
            if (gamepad2.dpad_up) {
                winch.setPower(WinchMultiplier);
            }
            if (gamepad2.dpad_down) {
                winch.setPower(-WinchMultiplier);

            }
            if (gamepad2.y) {
                    lander.setPower(LanderPower);
            }
            if(gamepad2.a){
                lander.setPower(-LanderPower);
            }
            if(gamepad2.left_bumper){
                tilt1.setPosition(-0.1);
                tilt2.setPosition(-0.1);
            }
            if(gamepad2.right_bumper){
                tilt1.setPosition(0.1);
                tilt2.setPosition(0.1);
            }
        }





    }

}
