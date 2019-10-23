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
    Servo leftArmServo;
    Servo rightArmServo;
    GyroSensor sensorGyro;
    ModernRoboticsI2cGyro mrGyro;

    DcMotor[] movementMotors;
    Servo[] flapperMotors;

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
        leftArmServo = hardwareMap.servo.get("leftArmServo");
        rightArmServo = hardwareMap.servo.get("rightArmServo");

        //declare motor directions
        frontLeft.setDirection(DcMotor.Direction.FORWARD);
        rearLeft.setDirection(DcMotor.Direction.FORWARD);
        frontRight.setDirection(DcMotor.Direction.REVERSE);
        rearRight.setDirection(DcMotor.Direction.REVERSE);
        liftMotor.setDirection(DcMotor.Direction.REVERSE);
        leftArmServo.setDirection(Servo.Direction.FORWARD);
        rightArmServo.setDirection(Servo.Direction.FORWARD);

        mrGyro = (ModernRoboticsI2cGyro) sensorGyro;

        movementMotors = new DcMotor[4];
        movementMotors[MovementMotors.FrontLeft.getValue()] = frontLeft;
        movementMotors[MovementMotors.FrontRight.getValue()] = frontRight;
        movementMotors[MovementMotors.RearRight.getValue()] = rearRight;
        movementMotors[MovementMotors.RearLeft.getValue()] = rearLeft;

        flapperMotors = new Servo[2];
        flapperMotors[FlapperServos.Left.getValue()] = leftArmServo;
        flapperMotors[FlapperServos.Right.getValue()] = rightArmServo;
    }

    /**
     * Moves the robot to the platform depending on the side.
     */
    public void moveToPlatform(PlayfieldSide side) {
        telemetry.addLine("Begin moveToPlatform " + side.toString());

        int strafePosition = 0;
        int forwardPosition = 0;
        double power = 0.0;

        if(side==PlayfieldSide.Red){
            macanumMovement(frontLeft,rearLeft,frontRight,rearRight,StrafeDirection.Right,strafePosition,power,opModeIsActive(),telemetry);
            macanumMovement(frontLeft,rearLeft,frontRight,rearRight,StrafeDirection.Left,strafePosition,power,opModeIsActive(),telemetry);
        }
        else if(side==PlayfieldSide.Blue){
            macanumMovement(frontLeft,rearLeft,frontRight,rearRight,StrafeDirection.Left,strafePosition,power,opModeIsActive(),telemetry);
            macanumMovement(frontLeft,rearLeft,frontRight,rearRight,StrafeDirection.Right,strafePosition,power,opModeIsActive(),telemetry);
        }

        macanumMovement(frontLeft,rearLeft,frontRight,rearRight,StrafeDirection.Forward,forwardPosition,power,opModeIsActive(),telemetry);

        telemetry.addLine("End moveToPlatform " + side.toString());
    }

    /**
     * Lowers the flappers in position to grab the platform
     */
    public  void lowerFlappers(){
        telemetry.addLine("Begin lowerFlappers");

        telemetry.addLine("End lowerFlappers");
    }

    /**
     * Moves the robot to the platform depending on the side.
     */
    public void moveToSkybridge(PlayfieldSide side) {
        telemetry.addLine("Begin moveToSkybridge");
        if(side==PlayfieldSide.Blue){
        }
        if(side==PlayfieldSide.Red){
        }
        telemetry.addLine("End moveToSkybridge");
    }

    /**
     * Moves the platform to the building site.
     */
    public void movePlatformToBuildingSite(){
        telemetry.addLine("Begin movePlatformToBuildingSite");

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
    public  void locateSkystone(PlayfieldSide side){
        telemetry.addLine("Begin locateSkystone");
        if(side==PlayfieldSide.Blue){
        }
        if(side==PlayfieldSide.Red){
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
    public void moveToBuildingZone(PlayfieldSide side){
        telemetry.addLine("Begin moveToBuildingZone");
        if(side==PlayfieldSide.Blue){
        }
        if(side==PlayfieldSide.Red){
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
