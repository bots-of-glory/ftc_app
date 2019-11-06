package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.teamcode.AutonomousCommon.FlapperServos;
import org.firstinspires.ftc.teamcode.AutonomousCommon.MovementMotors;
import org.firstinspires.ftc.teamcode.AutonomousCommon.PlayfieldSide;
import org.firstinspires.ftc.teamcode.vision.MasterVision;
import org.firstinspires.ftc.teamcode.vision.SampleRandomizedPositions;

import static org.firstinspires.ftc.teamcode.AutonomousCommon.*;

public class SkystoneBase extends LinearOpMode {
    MasterVision vision;
    SampleRandomizedPositions goldPosition;
    DcMotor liftMotor;
    DcMotor frontLeft;
    DcMotor rearLeft;
    DcMotor frontRight;
    DcMotor rearRight;
    Servo leftServo;
    Servo rightServo;
    GyroSensor sensorGyro;
    ModernRoboticsI2cGyro mrGyro;
    PlayfieldSide playSide;

    @Override
    public void runOpMode() throws InterruptedException {
    }
    public void initMotors(){
        //declare motors
        liftMotor = hardwareMap.dcMotor.get("liftMotor");
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        rearLeft = hardwareMap.dcMotor.get("rearLeft");
        frontRight = hardwareMap.dcMotor.get("frontRight");
        rearRight = hardwareMap.dcMotor.get("rearRight");
        sensorGyro = hardwareMap.gyroSensor.get("gyro");
        leftServo = hardwareMap.servo.get("leftServo");
        rightServo = hardwareMap.servo.get("rightServo");

        //declare motor directions
        frontLeft.setDirection(DcMotor.Direction.FORWARD);
        rearLeft.setDirection(DcMotor.Direction.FORWARD);
        frontRight.setDirection(DcMotor.Direction.REVERSE);
        rearRight.setDirection(DcMotor.Direction.REVERSE);
        liftMotor.setDirection(DcMotor.Direction.REVERSE);
        leftServo.setDirection(Servo.Direction.FORWARD);
        rightServo.setDirection(Servo.Direction.FORWARD);

        mrGyro = (ModernRoboticsI2cGyro) sensorGyro;

    }

    /**
     * Moves the robot to the platform depending on the side.
     */
    public void moveToPlatform() {
        telemetry.addLine("Begin moveToPlatform " + playSide.toString());

        int backupPosition = AutonomousCommon.convertInchesToPosition(1,false);
        double power = 1.0;

        macanumMovement(frontLeft,rearLeft,frontRight,rearRight,StrafeDirection.Backward,backupPosition,power,opModeIsActive(),telemetry);
        telemetry.addLine("End moveToPlatform " + playSide.toString());
    }

    /**
     * Lowers the flappers in position to grab the platform
     */
    public  void lowerFlappers() {
        telemetry.addLine("Begin lowerFlappers " + playSide.toString());
        double position = 1;
        AutonomousCommon.serverMovement(leftServo, position);
        AutonomousCommon.serverMovement(rightServo, position);
        telemetry.addLine("End lowerFlappers " + playSide.toString());
    }

    /**
     * Moves the robot to the platform depending on the side.
     */
    public void moveToSkybridge() {
        telemetry.addLine("Begin moveToSkybridge");
        int forwardPosition = 0;
        double power = 0.0;
        macanumMovement(frontLeft,rearLeft,frontRight,rearRight,StrafeDirection.Forward,forwardPosition,power,opModeIsActive(),telemetry);
        telemetry.addLine("End moveToSkybridge");
    }

    /**
     * Moves the platform to the building site.
     */
    public void movePlatformToBuildingSite(){
        telemetry.addLine("Begin movePlatformToBuildingSite");
        int strafePosition = 0;
        double power = 0.0;
        if(playSide==PlayfieldSide.Red){
            macanumMovement(frontLeft,rearLeft,frontRight,rearRight,StrafeDirection.Left,strafePosition,power,opModeIsActive(),telemetry);
        }
        else if(playSide==PlayfieldSide.Blue){
            macanumMovement(frontLeft,rearLeft,frontRight,rearRight,StrafeDirection.Right,strafePosition,power,opModeIsActive(),telemetry);
        }
        telemetry.addLine("End movePlatformToBuildingSite");
    }

    /**
     * Moves the robot to the Legos.
     */
    public void moveToLegos(){
        telemetry.addLine("Begin moveToLegos");

        telemetry.addLine("End moveToLegos");
    }

    /**
     * Attempts to locate the Skystone.
     */
    public  void locateSkystone(){
        telemetry.addLine("Begin locateSkystone");
        if(playSide==PlayfieldSide.Blue){
        }
        if(playSide==PlayfieldSide.Red){
        }
        telemetry.addLine("End locateSkystone");
    }

    /**
     * Grabs the lego.
     */
    public void grabLego(){
        telemetry.addLine("Begin grabLego");

        telemetry.addLine("End grabLego");
    }

    /**
     * moves the robot to the building zone.
     */
    public void moveToBuildingZone(){
        telemetry.addLine("Begin moveToBuildingZone");
        if(playSide==PlayfieldSide.Blue){
        }
        if(playSide==PlayfieldSide.Red){
        }
        telemetry.addLine("End moveToBuildingZone");
    }

    /**
     * Drops the lego.
     */
    public void dropLego() {
        telemetry.addLine("Begin dropLego");
        telemetry.addLine("End dropLego");
    }
}
