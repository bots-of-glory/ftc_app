package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.AutonomousCommon.FlapperServos;
import org.firstinspires.ftc.teamcode.AutonomousCommon.MovementMotors;
import org.firstinspires.ftc.teamcode.AutonomousCommon.PlayfieldSide;


import org.firstinspires.ftc.teamcode.vision.MasterVision;
import org.firstinspires.ftc.teamcode.vision.SampleRandomizedPositions;

import java.util.List;

@Autonomous (name="BuildingZoneBlue", group="Competition Autonomous")
public class BuildingZoneBlue extends LinearOpMode {
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

    private ElapsedTime runtime = new ElapsedTime();


    @Override
    public void runOpMode() throws InterruptedException {

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

        DcMotor[] movementMotors = new DcMotor[4];
        movementMotors[MovementMotors.FrontLeft.getValue()] = frontLeft;
        movementMotors[MovementMotors.FrontRight.getValue()] = frontRight;
        movementMotors[MovementMotors.RearRight.getValue()] = rearRight;
        movementMotors[MovementMotors.RearLeft.getValue()] = rearLeft;

        Servo[] flapperMotors = new Servo[2];
        flapperMotors[FlapperServos.Left.getValue()] = leftArmServo;
        flapperMotors[FlapperServos.Right.getValue()] = rightArmServo;


        AutonomousCommon.moveToPlatform(movementMotors,AutonomousCommon.PlayfieldSide.Blue);
        AutonomousCommon.lowerFlappers(flapperMotors);
        AutonomousCommon.movePlatformToBuildingSite(movementMotors);
        AutonomousCommon.moveToSkybridge(movementMotors,AutonomousCommon.PlayfieldSide.Blue);

    }
}
