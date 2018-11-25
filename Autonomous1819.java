package org.firstinspires.ftc.team13180;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by Shivam Adeshara on 12/29/2017.
 * This is autonomous program with time
 */

@Autonomous(name="Autonomous1819", group="autonomusGroup1")
public class Autonomous1819 extends LinearOpMode {
    private RobotNavigator robotNavigator;
    private GoldTensorFlowObjectDetection tensorFlow;
    private ConceptVuforiaNavRoverRuckus vuforia;
    private Lander lander;

    @Override
    public void runOpMode() {
        double forwardPower = 0.5;
        int forwardTime = 1000;
        double leftPower = 0.5;
        int leftTime = 1000;

        double armPower = 0.25;
        int armTime = 1000;

        robotNavigator = new RobotNavigator();
        robotNavigator.init(hardwareMap);
        //
        tensorFlow = new GoldTensorFlowObjectDetection();
        //tensorFlow.init(hardwareMap);
        //
        vuforia = new ConceptVuforiaNavRoverRuckus();

        //
        lander = new Lander();
        lander.init(hardwareMap);

        telemetry.addData("Status:", "initialized");
        telemetry.update();

        // Power up the motor and move lander up
        lander.moveUp(1);

        waitForStart();

        try {
            // Wait and stop the motor. Spring tension will bring robot down slowly.
            Thread.sleep(100);
            lander.stopMotor();
            Thread.sleep(100);

            // Move the robot left and wait for 1 second.
            robotNavigator.shiftLeftTime(1,1000);

          /*  String goldLocation = tensorFlow.getGoldLocation() ;

            // Move the robot forward and wait for 1 second
            //robotNavigator.moveForwardTime(1,1000);

            while (opModeIsActive()) {
                if(goldLocation.equals("Center")){
                    robotNavigator.moveForwardTime(1,2000);
                } else if(goldLocation.equals("Left")) {
                    robotNavigator.shiftLeftTime(1, 500);
                } else if (goldLocation.equals(("Right"))){
                    robotNavigator.shiftRightTime(1,500);
                }
            }

            tensorFlow.shutdown();

            */
        } catch (Exception e) {
            telemetry.addData("Exception:", e);
            telemetry.update();
        }


    }
}