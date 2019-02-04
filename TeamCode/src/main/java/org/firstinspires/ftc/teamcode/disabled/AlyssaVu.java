package org.firstinspires.ftc.teamcode.disabled;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.teamcode.vision.MasterVision;
import org.firstinspires.ftc.teamcode.vision.SampleRandomizedPositions;

@Autonomous(name="VuforiaDepot", group="please work")
@Disabled
public class AlyssaVu extends LinearOpMode {
    DcMotor liftMotor;
    DcMotor frontLeft;
    DcMotor rearLeft;
    DcMotor frontRight;
    DcMotor rearRight;
    Servo armServo;
    GyroSensor sensorGyro;
    ModernRoboticsI2cGyro mrGyro;

    private ElapsedTime runtime = new ElapsedTime();

    MasterVision vision;
    SampleRandomizedPositions goldPosition;

    @Override
    public void runOpMode() throws InterruptedException {
        //declare motors
        liftMotor = hardwareMap.dcMotor.get("liftMotor");
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        rearLeft = hardwareMap.dcMotor.get("rearLeft");
        frontRight = hardwareMap.dcMotor.get("frontRight");
        rearRight = hardwareMap.dcMotor.get("rearRight");
        armServo = hardwareMap.servo.get("armServo");
        sensorGyro = hardwareMap.gyroSensor.get("gyro");

        //declare motor directions
        frontLeft.setDirection(DcMotor.Direction.FORWARD);
        rearLeft.setDirection(DcMotor.Direction.FORWARD);
        frontRight.setDirection(DcMotor.Direction.REVERSE);
        rearRight.setDirection(DcMotor.Direction.REVERSE);
        armServo.setDirection(Servo.Direction.FORWARD);
        liftMotor.setDirection(DcMotor.Direction.REVERSE);

        mrGyro = (ModernRoboticsI2cGyro) sensorGyro;

        double turnSpeed = 0.2;
        int zAccumulated;
        int target = 0;

        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters();
        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;// recommended camera direction
        parameters.vuforiaLicenseKey = "AY6Meoz/////AAABmQc5CaX2TkUNpeTSIhDkq6hpMaYBbEADbL9FJnnxEFux4SlusRcuohqON9/SaGSzfy7JdW9uD0CvFOg6ewpITWDnS9OLn5dk4S/uDj8NvGvdvcWbNzK0EhrtfVyNe1Aj/Nb2O0fouTb0L9CXiRSdx/RGFYcEpgS30CixfaMrZfp8NE7JJjRbnKfg0kdgAiLFGSVka0Wwt4hFN9/HYP2xz9/SqbpczhCDcS7cwytiW/1rHSpS8w/ftjMca9HyD76bdB2qmsQIrnLYyn2F/K3/zJvZQ3/XwpBiZfjdLNetlU16mnnb+BCs7ue36a6QHFrOmQqxEmKc+vUWfXv+kiZAjQqGfksnEY6PnyN2F6maCJsC";

        vision = new MasterVision(parameters, hardwareMap, true, MasterVision.TFLiteAlgorithm.INFER_LEFT);
        vision.init();// enables the camera overlay. this will take a couple of seconds
        vision.enable();// enables the tracking algorithms. this might also take a little time

        waitForStart();

        vision.disable();// disables tracking algorithms. this will free up your phone's processing power for other jobs.

        goldPosition = vision.getTfLite().getLastKnownSampleOrder();

        while (opModeIsActive()) {
            telemetry.addData("goldPosition was", goldPosition);// giving feedback

            switch (goldPosition) { // using for things in the autonomous program
                case LEFT:
                    vision.shutdown();

                    telemetry.addLine("going to the left");

//-----------------------------Lift Up(lower robot) Start-------------------------------------------
//                    operateLift(1, 0.8, 5);
//                    //Wait 1 second
//                    sleep(500);
//-----------------------------Lift Up(lower robot) End---------------------------------------------

//-----------------------------Strafe off Lander Start----------------------------------------------
                    rearLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rearRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rearLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    rearRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    rearLeft.setTargetPosition(-800);
                    rearLeft.setPower(.5);
                    rearRight.setTargetPosition(800);
                    rearRight.setPower(.5);
                    frontLeft.setTargetPosition(800);
                    frontLeft.setPower(.6);
                    frontRight.setTargetPosition(-800);
                    frontRight.setPower(.5);
                    while (rearLeft.isBusy() && opModeIsActive()) {
                    }
                    while (rearRight.isBusy() && opModeIsActive()) {
                    }
                    while (frontLeft.isBusy() && opModeIsActive()) {
                    }
                    while (frontRight.isBusy() && opModeIsActive()) {
                    }
                    rearLeft.setPower(0);
                    rearRight.setPower(0);
                    frontLeft.setPower(0);
                    frontRight.setPower(0);
//-----------------------------Strafe off Lander End------------------------------------------------

//-----------------------------Straight off Lander Start--------------------------------------------
                    rearLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rearRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rearLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    rearRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    rearLeft.setTargetPosition(500);
                    rearLeft.setPower(.5);
                    rearRight.setTargetPosition(500);
                    rearRight.setPower(.5);
                    frontLeft.setTargetPosition(500);
                    frontLeft.setPower(.5);
                    frontRight.setTargetPosition(500);
                    frontRight.setPower(.5);
                    while (rearLeft.isBusy() && opModeIsActive()) {
                    }
                    while (rearRight.isBusy() && opModeIsActive()) {
                    }
                    while (frontLeft.isBusy() && opModeIsActive()) {
                    }
                    while (frontRight.isBusy() && opModeIsActive()) {
                    }
                    rearLeft.setPower(0);
                    rearRight.setPower(0);
                    frontLeft.setPower(0);
                    frontRight.setPower(0);
//-----------------------------Straight off Lander End----------------------------------------------

//-----------------------------Get in Position for Depot Start--------------------------------------
                    rearLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rearRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rearLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    rearRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    rearLeft.setTargetPosition(1750);
                    rearLeft.setPower(.5);
                    rearRight.setTargetPosition(-1750);
                    rearRight.setPower(.5);
                    frontLeft.setTargetPosition(-1750);
                    frontLeft.setPower(.5);
                    frontRight.setTargetPosition(1750);
                    frontRight.setPower(.5);
                    while (rearLeft.isBusy() && opModeIsActive()) {
                    }
                    while (rearRight.isBusy() && opModeIsActive()) {
                    }
                    while (frontLeft.isBusy() && opModeIsActive()) {
                    }
                    while (frontRight.isBusy() && opModeIsActive()) {
                    }
                    rearLeft.setPower(0);
                    rearRight.setPower(0);
                    frontLeft.setPower(0);
                    frontRight.setPower(0);
//-----------------------------Get in Position for Depot End----------------------------------------

//-----------------------------Straight to Depot Start----------------------------------------------
                    rearLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rearRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rearLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    rearRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    rearLeft.setTargetPosition(1600);
                    rearLeft.setPower(.9);
                    rearRight.setTargetPosition(1600);
                    rearRight.setPower(.9);
                    frontLeft.setTargetPosition(1600);
                    frontLeft.setPower(.9);
                    frontRight.setTargetPosition(1600);
                    frontRight.setPower(.9);
                    while (rearLeft.isBusy() && opModeIsActive()) {
                    }
                    while (rearRight.isBusy() && opModeIsActive()) {
                    }
                    while (frontLeft.isBusy() && opModeIsActive()) {
                    }
                    while (frontRight.isBusy() && opModeIsActive()) {
                    }
                    rearLeft.setPower(0);
                    rearRight.setPower(0);
                    frontLeft.setPower(0);
                    frontRight.setPower(0);
//-----------------------------Straight to Depot End------------------------------------------------


//-----------------------------Get in Position for Gold Start--------------------------------------
                    rearLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rearRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rearLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    rearRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    rearLeft.setTargetPosition(500);
                    rearLeft.setPower(.5);
                    rearRight.setTargetPosition(-500);
                    rearRight.setPower(.5);
                    frontLeft.setTargetPosition(-500);
                    frontLeft.setPower(.5);
                    frontRight.setTargetPosition(500);
                    frontRight.setPower(.5);
                    while (rearLeft.isBusy() && opModeIsActive()) {
                    }
                    while (rearRight.isBusy() && opModeIsActive()) {
                    }
                    while (frontLeft.isBusy() && opModeIsActive()) {
                    }
                    while (frontRight.isBusy() && opModeIsActive()) {
                    }
                    rearLeft.setPower(0);
                    rearRight.setPower(0);
                    frontLeft.setPower(0);
                    frontRight.setPower(0);
//-----------------------------Get in Position for Gold End----------------------------------------


//-----------------------------Straight to Depot Start----------------------------------------------
                    rearLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rearRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rearLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    rearRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    rearLeft.setTargetPosition(1600);
                    rearLeft.setPower(.9);
                    rearRight.setTargetPosition(1600);
                    rearRight.setPower(.9);
                    frontLeft.setTargetPosition(1600);
                    frontLeft.setPower(.9);
                    frontRight.setTargetPosition(1600);
                    frontRight.setPower(.9);
                    while (rearLeft.isBusy() && opModeIsActive()) {
                    }
                    while (rearRight.isBusy() && opModeIsActive()) {
                    }
                    while (frontLeft.isBusy() && opModeIsActive()) {
                    }
                    while (frontRight.isBusy() && opModeIsActive()) {
                    }
                    rearLeft.setPower(0);
                    rearRight.setPower(0);
                    frontLeft.setPower(0);
                    frontRight.setPower(0);
//-----------------------------Straight to Depot End------------------------------------------------


//-----------------------------Place Marker Start---------------------------------------------------
                    armServo.setPosition(0.7);
                    sleep(500); //wait
//-----------------------------Place Marker End-----------------------------------------------------
sleep(25000);
                break;
                case CENTER:
                    vision.shutdown();

                    telemetry.addLine("going straight");

//-----------------------------Lift Up(lower robot) Start-------------------------------------------
//                    operateLift(1, 0.8, 5);
//                    //Wait 1 second
//                    sleep(500);
//-----------------------------Lift Up(lower robot) End---------------------------------------------

//-----------------------------Strafe off Lander Start----------------------------------------------
                    rearLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rearRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rearLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    rearRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    rearLeft.setTargetPosition(-800);
                    rearLeft.setPower(.5);
                    rearRight.setTargetPosition(800);
                    rearRight.setPower(.5);
                    frontLeft.setTargetPosition(800);
                    frontLeft.setPower(.6);
                    frontRight.setTargetPosition(-800);
                    frontRight.setPower(.5);
                    while (rearLeft.isBusy() && opModeIsActive()) {
                    }
                    while (rearRight.isBusy() && opModeIsActive()) {
                    }
                    while (frontLeft.isBusy() && opModeIsActive()) {
                    }
                    while (frontRight.isBusy() && opModeIsActive()) {
                    }
                    rearLeft.setPower(0);
                    rearRight.setPower(0);
                    frontLeft.setPower(0);
                    frontRight.setPower(0);
//-----------------------------Strafe off Lander End------------------------------------------------

//-----------------------------Straight off Lander Start--------------------------------------------
                    rearLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rearRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rearLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    rearRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    rearLeft.setTargetPosition(500);
                    rearLeft.setPower(.5);
                    rearRight.setTargetPosition(500);
                    rearRight.setPower(.5);
                    frontLeft.setTargetPosition(500);
                    frontLeft.setPower(.5);
                    frontRight.setTargetPosition(500);
                    frontRight.setPower(.5);
                    while (rearLeft.isBusy() && opModeIsActive()) {
                    }
                    while (rearRight.isBusy() && opModeIsActive()) {
                    }
                    while (frontLeft.isBusy() && opModeIsActive()) {
                    }
                    while (frontRight.isBusy() && opModeIsActive()) {
                    }
                    rearLeft.setPower(0);
                    rearRight.setPower(0);
                    frontLeft.setPower(0);
                    frontRight.setPower(0);
//-----------------------------Straight off Lander End----------------------------------------------

//-----------------------------Get in Position for Depot Start--------------------------------------
                    rearLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rearRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rearLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    rearRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    rearLeft.setTargetPosition(800);
                    rearLeft.setPower(.5);
                    rearRight.setTargetPosition(-800);
                    rearRight.setPower(.5);
                    frontLeft.setTargetPosition(-800);
                    frontLeft.setPower(.5);
                    frontRight.setTargetPosition(800);
                    frontRight.setPower(.5);
                    while (rearLeft.isBusy() && opModeIsActive()) {
                    }
                    while (rearRight.isBusy() && opModeIsActive()) {
                    }
                    while (frontLeft.isBusy() && opModeIsActive()) {
                    }
                    while (frontRight.isBusy() && opModeIsActive()) {
                    }
                    rearLeft.setPower(0);
                    rearRight.setPower(0);
                    frontLeft.setPower(0);
                    frontRight.setPower(0);
//-----------------------------Get in Position for Depot End----------------------------------------


//-----------------------------Straight to Depot Start----------------------------------------------
                    rearLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rearRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rearLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    rearRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    rearLeft.setTargetPosition(3640);
                    rearLeft.setPower(.9);
                    rearRight.setTargetPosition(3640);
                    rearRight.setPower(.9);
                    frontLeft.setTargetPosition(3640);
                    frontLeft.setPower(.9);
                    frontRight.setTargetPosition(3640);
                    frontRight.setPower(.9);
                    while (rearLeft.isBusy() && opModeIsActive()) {
                    }
                    while (rearRight.isBusy() && opModeIsActive()) {
                    }
                    while (frontLeft.isBusy() && opModeIsActive()) {
                    }
                    while (frontRight.isBusy() && opModeIsActive()) {
                    }
                    rearLeft.setPower(0);
                    rearRight.setPower(0);
                    frontLeft.setPower(0);
                    frontRight.setPower(0);
//-----------------------------Straight to Depot End------------------------------------------------


//-----------------------------Place Marker Start---------------------------------------------------
                    armServo.setPosition(0.7);
                    sleep(500); //wait
//-----------------------------Place Marker End-----------------------------------------------------

//-----------------------------Turn 90 Degrees Counterclockwise Start-------------------------------
                    rearLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rearRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rearLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    rearRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    rearLeft.setTargetPosition(-1440);
                    rearLeft.setPower(1);
                    rearRight.setTargetPosition(1440);
                    rearRight.setPower(1);
                    frontLeft.setTargetPosition(-1440);
                    frontLeft.setPower(1);
                    frontRight.setTargetPosition(1440);
                    frontRight.setPower(1);
                    while (rearLeft.isBusy() && opModeIsActive()) {
                    }
                    while (rearRight.isBusy() && opModeIsActive()) {
                    }
                    while (frontLeft.isBusy() && opModeIsActive()) {
                    }
                    while (frontRight.isBusy() && opModeIsActive()) {
                    }
                    rearLeft.setPower(0);
                    rearRight.setPower(0);
                    frontLeft.setPower(0);
                    frontRight.setPower(0);
//-----------------------------Turn 90 Degrees Counterclockwise End---------------------------------

//-----------------------------Forward Towards Wall Start-------------------------------------------
                    rearLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rearRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rearLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    rearRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    rearLeft.setTargetPosition(1200);
                    rearLeft.setPower(.7);
                    rearRight.setTargetPosition(1200);
                    rearRight.setPower(.7);
                    frontLeft.setTargetPosition(1200);
                    frontLeft.setPower(.7);
                    frontRight.setTargetPosition(1200);
                    frontRight.setPower(.7);
                    while (rearLeft.isBusy() && opModeIsActive()) {
                    }
                    while (rearRight.isBusy() && opModeIsActive()) {
                    }
                    while (frontLeft.isBusy() && opModeIsActive()) {
                    }
                    while (frontRight.isBusy() && opModeIsActive()) {
                    }
                    rearLeft.setPower(0);
                    rearRight.setPower(0);
                    frontLeft.setPower(0);
                    frontRight.setPower(0);
//-----------------------------Forward Towards Wall End---------------------------------------------

//-----------------------------Turn 45 Degrees Counterclockwise Start-------------------------------
                    rearLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rearRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rearLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    rearRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    rearLeft.setTargetPosition(-640);
                    rearLeft.setPower(1);
                    rearRight.setTargetPosition(640);
                    rearRight.setPower(1);
                    frontLeft.setTargetPosition(-640);
                    frontLeft.setPower(1);
                    frontRight.setTargetPosition(640);
                    frontRight.setPower(1);
                    while (rearLeft.isBusy() && opModeIsActive()) {
                    }
                    while (rearRight.isBusy() && opModeIsActive()) {
                    }
                    while (frontLeft.isBusy() && opModeIsActive()) {
                    }
                    while (frontRight.isBusy() && opModeIsActive()) {
                    }
                    rearLeft.setPower(0);
                    rearRight.setPower(0);
                    frontLeft.setPower(0);
                    frontRight.setPower(0);
//-----------------------------Turn 45 Degrees Counterclockwise End---------------------------------

//-----------------------------Strafe Towards Wall Start--------------------------------------------
                    rearLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rearRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rearLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    rearRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    rearLeft.setTargetPosition(-1000);
                    rearLeft.setPower(.5);
                    rearRight.setTargetPosition(1000);
                    rearRight.setPower(.5);
                    frontLeft.setTargetPosition(1000);
                    frontLeft.setPower(.5);
                    frontRight.setTargetPosition(-1000);
                    frontRight.setPower(.5);
                    while (rearLeft.isBusy() && opModeIsActive()) {
                    }
                    while (rearRight.isBusy() && opModeIsActive()) {
                    }
                    while (frontLeft.isBusy() && opModeIsActive()) {
                    }
                    while (frontRight.isBusy() && opModeIsActive()) {
                    }
                    rearLeft.setPower(0);
                    rearRight.setPower(0);
                    frontLeft.setPower(0);
                    frontRight.setPower(0);
//-----------------------------Strafe Towards Wall End----------------------------------------------

//-----------------------------Forward Towards Crater Start-----------------------------------------
                    rearLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rearRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rearLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    rearRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    rearLeft.setTargetPosition(5250);
                    rearLeft.setPower(1);
                    rearRight.setTargetPosition(5250);
                    rearRight.setPower(1);
                    frontLeft.setTargetPosition(5250);
                    frontLeft.setPower(1);
                    frontRight.setTargetPosition(5250);
                    frontRight.setPower(1);
                    while (rearLeft.isBusy() && opModeIsActive()) {
                    }
                    while (rearRight.isBusy() && opModeIsActive()) {
                    }
                    while (frontLeft.isBusy() && opModeIsActive()) {
                    }
                    while (frontRight.isBusy() && opModeIsActive()) {
                    }
                    rearLeft.setPower(0);
                    rearRight.setPower(0);
                    frontLeft.setPower(0);
                    frontRight.setPower(0);
//-----------------------------Forward Towards Crater End-------------------------------------------

//----------------------------------Lift Down Start-------------------------------------------------
//                    operateLift(0, 1, 5);
//                    //Wait 1 second
//                    sleep(500);
//-----------------------------------Lift Down End--------------------------------------------------
                    sleep(25000);
                    break;


                    case RIGHT:
                    vision.shutdown();

                    telemetry.addLine("going to the right");

//-----------------------------Lift Up(lower robot) Start-------------------------------------------
//                    operateLift(1, 0.8, 5);
//                    //Wait 1 second
//                    sleep(500);
//-----------------------------Lift Up(lower robot) End---------------------------------------------

//----------------------Strafe off Lander Start-------------------------------------
                        rearLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                        rearRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                        rearLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                        rearRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                        rearLeft.setTargetPosition(-1200);
                        rearLeft.setPower(0.5);
                        rearRight.setTargetPosition(1200);
                        rearRight.setPower(0.5);
                        frontLeft.setTargetPosition(1200);
                        frontLeft.setPower(0.6);
                        frontRight.setTargetPosition(-1200);
                        frontRight.setPower(0.5);
                        while (rearLeft.isBusy() && opModeIsActive()) {
                        }
                        while (rearRight.isBusy() && opModeIsActive()) {
                        }
                        while (frontLeft.isBusy() && opModeIsActive()) {
                        }
                        while (frontRight.isBusy() && opModeIsActive()) {
                        }
                        rearLeft.setPower(0);
                        rearRight.setPower(0);
                        frontLeft.setPower(0);
                        frontRight.setPower(0);
//-------------------Block End--------------------------------------------------

                        //----------------------Straight off Lander Start-------------------------------------
                        rearLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                        rearRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                        rearLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                        rearRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                        rearLeft.setTargetPosition(800);
                        rearLeft.setPower(0.5);
                        rearRight.setTargetPosition(800);
                        rearRight.setPower(0.5);
                        frontLeft.setTargetPosition(800);
                        frontLeft.setPower(0.5);
                        frontRight.setTargetPosition(800);
                        frontRight.setPower(0.5);
                        while (rearLeft.isBusy() && opModeIsActive()) {
                        }
                        while (rearRight.isBusy() && opModeIsActive()) {
                        }
                        while (frontLeft.isBusy() && opModeIsActive()) {
                        }
                        while (frontRight.isBusy() && opModeIsActive()) {
                        }
                        rearLeft.setPower(0);
                        rearRight.setPower(0);
                        frontLeft.setPower(0);
                        frontRight.setPower(0);
//-------------------Block End--------------------------------------------------

                        //----------------------Strafe off Lander Start-------------------------------------
                        rearLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                        rearRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                        rearLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                        rearRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                        rearLeft.setTargetPosition(-800);
                        rearLeft.setPower(0.5);
                        rearRight.setTargetPosition(800);
                        rearRight.setPower(0.5);
                        frontLeft.setTargetPosition(800);
                        frontLeft.setPower(0.5);
                        frontRight.setTargetPosition(-800);
                        frontRight.setPower(0.5);
                        while (rearLeft.isBusy() && opModeIsActive()) {
                        }
                        while (rearRight.isBusy() && opModeIsActive()) {
                        }
                        while (frontLeft.isBusy() && opModeIsActive()) {
                        }
                        while (frontRight.isBusy() && opModeIsActive()) {
                        }
                        rearLeft.setPower(0);
                        rearRight.setPower(0);
                        frontLeft.setPower(0);
                        frontRight.setPower(0);
//-------------------Block End--------------------------------------------------

                        //----------------------Strafe off Lander Start-------------------------------------
                        rearLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                        rearRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                        rearLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                        rearRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                        rearLeft.setTargetPosition(1100);
                        rearLeft.setPower(0.5);
                        rearRight.setTargetPosition(1100);
                        rearRight.setPower(0.5);
                        frontLeft.setTargetPosition(1100);
                        frontLeft.setPower(0.5);
                        frontRight.setTargetPosition(1100);
                        frontRight.setPower(0.5);
                        while (rearLeft.isBusy() && opModeIsActive()) {
                        }
                        while (rearRight.isBusy() && opModeIsActive()) {
                        }
                        while (frontLeft.isBusy() && opModeIsActive()) {
                        }
                        while (frontRight.isBusy() && opModeIsActive()) {
                        }
                        rearLeft.setPower(0);
                        rearRight.setPower(0);
                        frontLeft.setPower(0);
                        frontRight.setPower(0);
//-------------------Block End--------------------------------------------------

                        //----------------------Strafe off Lander Start-------------------------------------
                        rearLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                        rearRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                        rearLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                        rearRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                        rearLeft.setTargetPosition(-800);
                        rearLeft.setPower(0.5);
                        rearRight.setTargetPosition(-800);
                        rearRight.setPower(0.5);
                        frontLeft.setTargetPosition(-800);
                        frontLeft.setPower(0.5);
                        frontRight.setTargetPosition(-800);
                        frontRight.setPower(0.5);
                        while (rearLeft.isBusy() && opModeIsActive()) {
                        }
                        while (rearRight.isBusy() && opModeIsActive()) {
                        }
                        while (frontLeft.isBusy() && opModeIsActive()) {
                        }
                        while (frontRight.isBusy() && opModeIsActive()) {
                        }
                        rearLeft.setPower(0);
                        rearRight.setPower(0);
                        frontLeft.setPower(0);
                        frontRight.setPower(0);
//-------------------Block End--------------------------------------------------


//-------------------Turn 45 degrees counterclockwise start-------------------------------
                        rearLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                        rearRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                        rearLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                        rearRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                        rearLeft.setTargetPosition(-700);
                        rearLeft.setPower(.9);
                        rearRight.setTargetPosition(700);
                        rearRight.setPower(.9);
                        frontLeft.setTargetPosition(-700);
                        frontLeft.setPower(.9);
                        frontRight.setTargetPosition(700);
                        frontRight.setPower(.9);
                        while (rearLeft.isBusy() && opModeIsActive()) {
                        }
                        while (rearRight.isBusy() && opModeIsActive()) {
                        }
                        while (frontLeft.isBusy() && opModeIsActive()) {
                        }
                        while (frontRight.isBusy() && opModeIsActive()) {
                        }
                        rearLeft.setPower(0);
                        rearRight.setPower(0);
                        frontLeft.setPower(0);
                        frontRight.setPower(0);
//------------------------Turn 45 degrees counterclockwise end-------------------------------


//-----------------------------Strafe Right Start----------------------------------------------
                        rearLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                        rearRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                        rearLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                        rearRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                        rearLeft.setTargetPosition(-1300);
                        rearLeft.setPower(.5);
                        rearRight.setTargetPosition(1300);
                        rearRight.setPower(.5);
                        frontLeft.setTargetPosition(1300);
                        frontLeft.setPower(.6);
                        frontRight.setTargetPosition(-1300);
                        frontRight.setPower(.5);
                        while (rearLeft.isBusy() && opModeIsActive()) {
                        }
                        while (rearRight.isBusy() && opModeIsActive()) {
                        }
                        while (frontLeft.isBusy() && opModeIsActive()) {
                        }
                        while (frontRight.isBusy() && opModeIsActive()) {
                        }
                        rearLeft.setPower(0);
                        rearRight.setPower(0);
                        frontLeft.setPower(0);
                        frontRight.setPower(0);
//-----------------------------Strafe Right End------------------------------------------------

//-----------------------------Back to Crater Start----------------------------------------------
                        rearLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                        rearRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                        rearLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                        rearRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                        rearLeft.setTargetPosition(1500);
                        rearLeft.setPower(.9);
                        rearRight.setTargetPosition(1500);
                        rearRight.setPower(.9);
                        frontLeft.setTargetPosition(1500);
                        frontLeft.setPower(.9);
                        frontRight.setTargetPosition(1500);
                        frontRight.setPower(.9);
                        while (rearLeft.isBusy() && opModeIsActive()) {
                        }
                        while (rearRight.isBusy() && opModeIsActive()) {
                        }
                        while (frontLeft.isBusy() && opModeIsActive()) {
                        }
                        while (frontRight.isBusy() && opModeIsActive()) {
                        }
                        rearLeft.setPower(0);
                        rearRight.setPower(0);
                        frontLeft.setPower(0);
                        frontRight.setPower(0);
//-----------------------------Back to Crater End------------------------------------------------

//-----------------------------Place Marker Start---------------------------------------------------
                        armServo.setPosition(0.7);
                        sleep(500); //wait
//-----------------------------Place Marker End-----------------------------------------------------

//-----------------------------Place Marker Start---------------------------------------------------
                        armServo.setPosition(0);
                        sleep(100); //wait
//-----------------------------Place Marker End-----------------------------------------------------


//-----------------------------Straight to Crater Start----------------------------------------------
                        rearLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                        rearRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                        rearLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                        rearRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                        rearLeft.setTargetPosition(-3700);
                        rearLeft.setPower(.9);
                        rearRight.setTargetPosition(-3700);
                        rearRight.setPower(.9);
                        frontLeft.setTargetPosition(-3700);
                        frontLeft.setPower(.9);
                        frontRight.setTargetPosition(-3700);
                        frontRight.setPower(.9);
                        while (rearLeft.isBusy() && opModeIsActive()) {
                        }
                        while (rearRight.isBusy() && opModeIsActive()) {
                        }
                        while (frontLeft.isBusy() && opModeIsActive()) {
                        }
                        while (frontRight.isBusy() && opModeIsActive()) {
                        }
                        rearLeft.setPower(0);
                        rearRight.setPower(0);
                        frontLeft.setPower(0);
                        frontRight.setPower(0);
//-----------------------------Straight to Crater End------------------------------------------------
                sleep(25000);
                break;

                case UNKNOWN:
                    vision.shutdown();

                    telemetry.addLine("going straight");

//-----------------------------Lift Up(lower robot) Start-------------------------------------------
//                    operateLift(1, 0.8, 5);
//                    //Wait 1 second
//                    sleep(500);
//-----------------------------Lift Up(lower robot) End---------------------------------------------

//-----------------------------Strafe off Lander Start----------------------------------------------
                    rearLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rearRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rearLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    rearRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    rearLeft.setTargetPosition(-800);
                    rearLeft.setPower(.5);
                    rearRight.setTargetPosition(800);
                    rearRight.setPower(.5);
                    frontLeft.setTargetPosition(800);
                    frontLeft.setPower(.6);
                    frontRight.setTargetPosition(-800);
                    frontRight.setPower(.5);
                    while (rearLeft.isBusy() && opModeIsActive()) {
                    }
                    while (rearRight.isBusy() && opModeIsActive()) {
                    }
                    while (frontLeft.isBusy() && opModeIsActive()) {
                    }
                    while (frontRight.isBusy() && opModeIsActive()) {
                    }
                    rearLeft.setPower(0);
                    rearRight.setPower(0);
                    frontLeft.setPower(0);
                    frontRight.setPower(0);
//-----------------------------Strafe off Lander End------------------------------------------------

//-----------------------------Straight off Lander Start--------------------------------------------
                    rearLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rearRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rearLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    rearRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    rearLeft.setTargetPosition(500);
                    rearLeft.setPower(.5);
                    rearRight.setTargetPosition(500);
                    rearRight.setPower(.5);
                    frontLeft.setTargetPosition(500);
                    frontLeft.setPower(.5);
                    frontRight.setTargetPosition(500);
                    frontRight.setPower(.5);
                    while (rearLeft.isBusy() && opModeIsActive()) {
                    }
                    while (rearRight.isBusy() && opModeIsActive()) {
                    }
                    while (frontLeft.isBusy() && opModeIsActive()) {
                    }
                    while (frontRight.isBusy() && opModeIsActive()) {
                    }
                    rearLeft.setPower(0);
                    rearRight.setPower(0);
                    frontLeft.setPower(0);
                    frontRight.setPower(0);
//-----------------------------Straight off Lander End----------------------------------------------

//-----------------------------Get in Position for Depot Start--------------------------------------
                    rearLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rearRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rearLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    rearRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    rearLeft.setTargetPosition(800);
                    rearLeft.setPower(.5);
                    rearRight.setTargetPosition(-800);
                    rearRight.setPower(.5);
                    frontLeft.setTargetPosition(-800);
                    frontLeft.setPower(.5);
                    frontRight.setTargetPosition(800);
                    frontRight.setPower(.5);
                    while (rearLeft.isBusy() && opModeIsActive()) {
                    }
                    while (rearRight.isBusy() && opModeIsActive()) {
                    }
                    while (frontLeft.isBusy() && opModeIsActive()) {
                    }
                    while (frontRight.isBusy() && opModeIsActive()) {
                    }
                    rearLeft.setPower(0);
                    rearRight.setPower(0);
                    frontLeft.setPower(0);
                    frontRight.setPower(0);
//-----------------------------Get in Position for Depot End----------------------------------------


//-----------------------------Straight to Depot Start----------------------------------------------
                    rearLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rearRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rearLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    rearRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    rearLeft.setTargetPosition(3640);
                    rearLeft.setPower(.9);
                    rearRight.setTargetPosition(3640);
                    rearRight.setPower(.9);
                    frontLeft.setTargetPosition(3640);
                    frontLeft.setPower(.9);
                    frontRight.setTargetPosition(3640);
                    frontRight.setPower(.9);
                    while (rearLeft.isBusy() && opModeIsActive()) {
                    }
                    while (rearRight.isBusy() && opModeIsActive()) {
                    }
                    while (frontLeft.isBusy() && opModeIsActive()) {
                    }
                    while (frontRight.isBusy() && opModeIsActive()) {
                    }
                    rearLeft.setPower(0);
                    rearRight.setPower(0);
                    frontLeft.setPower(0);
                    frontRight.setPower(0);
//-----------------------------Straight to Depot End------------------------------------------------


//-----------------------------Place Marker Start---------------------------------------------------
                    armServo.setPosition(0.7);
                    sleep(500); //wait
//-----------------------------Place Marker End-----------------------------------------------------

//-----------------------------Place Marker Start---------------------------------------------------
                    armServo.setPosition(0);
                    sleep(100); //wait
//-----------------------------Place Marker End-----------------------------------------------------


//-----------------------------Turn 90 Degrees Counterclockwise Start-------------------------------
                    rearLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rearRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rearLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    rearRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    rearLeft.setTargetPosition(-1440);
                    rearLeft.setPower(1);
                    rearRight.setTargetPosition(1440);
                    rearRight.setPower(1);
                    frontLeft.setTargetPosition(-1440);
                    frontLeft.setPower(1);
                    frontRight.setTargetPosition(1440);
                    frontRight.setPower(1);
                    while (rearLeft.isBusy() && opModeIsActive()) {
                    }
                    while (rearRight.isBusy() && opModeIsActive()) {
                    }
                    while (frontLeft.isBusy() && opModeIsActive()) {
                    }
                    while (frontRight.isBusy() && opModeIsActive()) {
                    }
                    rearLeft.setPower(0);
                    rearRight.setPower(0);
                    frontLeft.setPower(0);
                    frontRight.setPower(0);
//-----------------------------Turn 90 Degrees Counterclockwise End---------------------------------

//-----------------------------Forward Towards Wall Start-------------------------------------------
                    rearLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rearRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rearLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    rearRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    rearLeft.setTargetPosition(1200);
                    rearLeft.setPower(.7);
                    rearRight.setTargetPosition(1200);
                    rearRight.setPower(.7);
                    frontLeft.setTargetPosition(1200);
                    frontLeft.setPower(.7);
                    frontRight.setTargetPosition(1200);
                    frontRight.setPower(.7);
                    while (rearLeft.isBusy() && opModeIsActive()) {
                    }
                    while (rearRight.isBusy() && opModeIsActive()) {
                    }
                    while (frontLeft.isBusy() && opModeIsActive()) {
                    }
                    while (frontRight.isBusy() && opModeIsActive()) {
                    }
                    rearLeft.setPower(0);
                    rearRight.setPower(0);
                    frontLeft.setPower(0);
                    frontRight.setPower(0);
//-----------------------------Forward Towards Wall End---------------------------------------------

//-----------------------------Turn 45 Degrees Counterclockwise Start-------------------------------
                    rearLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rearRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rearLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    rearRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    rearLeft.setTargetPosition(-640);
                    rearLeft.setPower(1);
                    rearRight.setTargetPosition(640);
                    rearRight.setPower(1);
                    frontLeft.setTargetPosition(-640);
                    frontLeft.setPower(1);
                    frontRight.setTargetPosition(640);
                    frontRight.setPower(1);
                    while (rearLeft.isBusy() && opModeIsActive()) {
                    }
                    while (rearRight.isBusy() && opModeIsActive()) {
                    }
                    while (frontLeft.isBusy() && opModeIsActive()) {
                    }
                    while (frontRight.isBusy() && opModeIsActive()) {
                    }
                    rearLeft.setPower(0);
                    rearRight.setPower(0);
                    frontLeft.setPower(0);
                    frontRight.setPower(0);
//-----------------------------Turn 45 Degrees Counterclockwise End---------------------------------

//-----------------------------Strafe Towards Wall Start--------------------------------------------
                    rearLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rearRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rearLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    rearRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    rearLeft.setTargetPosition(-1000);
                    rearLeft.setPower(.5);
                    rearRight.setTargetPosition(1000);
                    rearRight.setPower(.5);
                    frontLeft.setTargetPosition(1000);
                    frontLeft.setPower(.5);
                    frontRight.setTargetPosition(-1000);
                    frontRight.setPower(.5);
                    while (rearLeft.isBusy() && opModeIsActive()) {
                    }
                    while (rearRight.isBusy() && opModeIsActive()) {
                    }
                    while (frontLeft.isBusy() && opModeIsActive()) {
                    }
                    while (frontRight.isBusy() && opModeIsActive()) {
                    }
                    rearLeft.setPower(0);
                    rearRight.setPower(0);
                    frontLeft.setPower(0);
                    frontRight.setPower(0);
//-----------------------------Strafe Towards Wall End----------------------------------------------

//-----------------------------Forward Towards Crater Start-----------------------------------------
                    rearLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rearRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rearLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    rearRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    rearLeft.setTargetPosition(5250);
                    rearLeft.setPower(1);
                    rearRight.setTargetPosition(5250);
                    rearRight.setPower(1);
                    frontLeft.setTargetPosition(5250);
                    frontLeft.setPower(1);
                    frontRight.setTargetPosition(5250);
                    frontRight.setPower(1);
                    while (rearLeft.isBusy() && opModeIsActive()) {
                    }
                    while (rearRight.isBusy() && opModeIsActive()) {
                    }
                    while (frontLeft.isBusy() && opModeIsActive()) {
                    }
                    while (frontRight.isBusy() && opModeIsActive()) {
                    }
                    rearLeft.setPower(0);
                    rearRight.setPower(0);
                    frontLeft.setPower(0);
                    frontRight.setPower(0);
//-----------------------------Forward Towards Crater End-------------------------------------------

//----------------------------------Lift Down Start-------------------------------------------------
//                    operateLift(0, 1, 5);
//                    //Wait 1 second
//                    sleep(500);
//-----------------------------------Lift Down End--------------------------------------------------
                    sleep(25000);
                    break;
            }

            telemetry.update();
        }

        vision.shutdown();
    }

    public void operateLift(int position, double speed, int timeoutS) {
        if (opModeIsActive()) {
            if (position == 0) {
                //Change This Number to Determine the Upper Position of the Lift
                liftMotor.setTargetPosition(liftMotor.getCurrentPosition() - 7600
                );
                liftMotor.setPower(-speed);
            } else {
                //Change This Number to Determine the Lower Position of the Lift
                liftMotor.setTargetPosition(liftMotor.getCurrentPosition() + 7600
                );
                liftMotor.setPower(-speed);
            }
            liftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            runtime.reset();

            while (liftMotor.isBusy() && opModeIsActive() &&
                    (runtime.seconds() < timeoutS)) {
                // Display it for the driver.
                telemetry.addData("Lift", "Running to %7d : %7d", liftMotor.getCurrentPosition(), liftMotor.getTargetPosition());
//                telemetry.addData("Path2",  "Running at %7d :%7d",
//                                            robot.leftDrive.getCurrentPosition(),
//                                            robot.rightDrive.getCurrentPosition());
                telemetry.update();
            }
            liftMotor.setPower(0);
            liftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }
    }
}