package org.firstinspires.ftc.team13180;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by Shivam Adeshara on 11/24/2018.
 * This is autonomous program which does following.
 * 1. When init is pressed, it will start motor and pull robot up
 * 2. Hang the robot on clamp and wait for game to start (i.e. press "Start" only when asked)
 * 3. Robot Lander motor will stop and spring tension will bring robot down and clamp should be in middle.
 * 4. Robot will move lelf (check and see if we need to move right) and then move forward
 * 5. Find Gold Mineral position and have logic to  move the robot to Gold mineral (based on Left, Center or Right values)
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
        // Get the gold mineral position
        tensorFlow = new GoldTensorFlowObjectDetection();
        tensorFlow.init(hardwareMap);

        // Take picture to determine the robot location after landing.
        vuforia = new ConceptVuforiaNavRoverRuckus();

        // Lander object initialization
        lander = new Lander();
        lander.init(hardwareMap);

        telemetry.addData("Status:", "initialized");
        telemetry.update();

        // Power up the motor and move lander up when init button is pressed
        lander.moveUp(1);

        waitForStart();

        try {
            // Wait and stop the motor. Spring tension will bring robot down slowly and lander hook should be up.
            Thread.sleep(1000);
            lander.stopMotor();
            Thread.sleep(3000);

            // Move the robot left and wait for 1 second.
            robotNavigator.shiftLeftTime(1,1000);
            robotNavigator.moveForwardTime(1,1000);
            robotNavigator.turnRightTime(1,2000);

            Thread.sleep(1000);



            // Move the robot forward and wait for 1 second
            //robotNavigator.moveForwardTime(1,1000);

            while (opModeIsActive()) {
                // Get the gold mineral position (Left, Center or Right).
                String goldLocation = tensorFlow.getGoldLocation() ;

                if(goldLocation.equals("Center")){
                    robotNavigator.moveForwardTime(1,2000);
                    break;
                } else if(goldLocation.equals("Left")) {
                    robotNavigator.shiftLeftTime(1, 500);
                    break;
                } else if (goldLocation.equals(("Right"))){
                    robotNavigator.shiftRightTime(1,500);
                    break;
                }
         }

            Thread.sleep(1000);

            // Shutdown Tensorflow as we are not going to use in manual mode.
            tensorFlow.shutdown();


        } catch (Exception e) {
            telemetry.addData("Exception:", e);
            telemetry.update();
        }
    }
}