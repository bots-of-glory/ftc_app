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
    public static void moveToPlatform(DcMotor[]movementMotors,PlayfieldSide side) {
        //add logic here
        //move forward to platform
        //strafe right to platform
        //or go in angle
    }
    public static void lowerFlappers(Servo[]flapperMotors){
        //drop flapper to grab platform
    }
    public static void moveToSkybridge(DcMotor[] movementMotors,PlayfieldSide side) {
        //reverse pull platform to building site + 10pts
        //pull forward to sky bridge
    }
    public static void movePlatformToBuildingSite(DcMotor[] movementMotors){
        //drag the platform back to the building site
    }
    public static void moveToLegos(DcMotor[] movementMotors){

    }
    public  static void locateSkystone(DcMotor[] movementMotors,PlayfieldSide side){

    }
    public static void grabLego(){

    }
    public static void moveToBuildingZone(DcMotor[] movementMotors,PlayfieldSide side){

    }
    public static void dropLego() {

    }
}
