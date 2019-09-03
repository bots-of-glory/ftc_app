package org.firstinspires.ftc.teamcode;
//test


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.util.List;

public class AutonomousCommon  {

    public static void macanumStrafe(DcMotor frontLeft, DcMotor rearLeft, DcMotor frontRight, DcMotor rearRight,StrafeDirection strafeDirection, int targetPosition,double power, boolean opModeIsActive, Telemetry telemetry) {

        telemetry.addLine("Begin macanumStrafe");
        telemetry.update();
        rearLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rearRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rearLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rearRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        if(strafeDirection == StrafeDirection.Left){
            telemetry.addLine("strafing left");
            rearLeft.setTargetPosition(targetPosition);
            rearRight.setTargetPosition(-targetPosition);
            frontLeft.setTargetPosition(-targetPosition);
            frontRight.setTargetPosition(targetPosition);

        }

        if(strafeDirection == StrafeDirection.Right) {
            telemetry.addLine("strafing right");
            rearLeft.setTargetPosition(-targetPosition);
            rearRight.setTargetPosition(targetPosition);
            frontLeft.setTargetPosition(targetPosition);
            frontRight.setTargetPosition(-targetPosition);
        }
        rearLeft.setPower(power);
        rearRight.setPower(power);
        frontLeft.setPower(power);
        frontRight.setPower(power);

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

        telemetry.addLine("End macanumStrafe");
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
    public enum StrafeDirection{
        Left,
        Right
    }
}
