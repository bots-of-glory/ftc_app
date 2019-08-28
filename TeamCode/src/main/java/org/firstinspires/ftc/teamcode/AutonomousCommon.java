package org.firstinspires.ftc.teamcode;
//test


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.util.List;

public class AutonomousCommon  {


    public static void strafeLeft(DcMotor frontLeft,DcMotor rearLeft,DcMotor frontRight,DcMotor rearRight,long milliseconds){
        frontLeft.setPower(-1);
        rearLeft.setPower(1);
        frontRight.setPower(1);
        rearRight.setPower(-1);
        sleep(milliseconds);
    }

    public static void macanumStrafeLeft(DcMotor frontLeft, DcMotor rearLeft, DcMotor frontRight, DcMotor rearRight, int targetPosition,boolean opModeIsActive, Telemetry telemetry) {
        telemetry.addLine("Begin macanumStrafeLeft");
        telemetry.update();
        rearLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rearRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rearLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rearRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rearLeft.setTargetPosition(-targetPosition);
        rearLeft.setPower(0.6);
        rearRight.setTargetPosition(targetPosition);
        rearRight.setPower(0.6);
        frontLeft.setTargetPosition(targetPosition);
        frontLeft.setPower(0.6);
        frontRight.setTargetPosition(-targetPosition);
        frontRight.setPower(0.6);
        while (rearLeft.isBusy() && opModeIsActive) {
        }
        while (rearRight.isBusy() && opModeIsActive) {
        }
        while (frontLeft.isBusy() && opModeIsActive) {
        }
        while (frontRight.isBusy() && opModeIsActive) {
        }
        rearLeft.setPower(0);
        rearRight.setPower(0);
        frontLeft.setPower(0);
        frontRight.setPower(0);

        telemetry.addLine("End macanumStrafeLeft");
        telemetry.update();
    }

    //sleep from LinearOpMode class
    public static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
