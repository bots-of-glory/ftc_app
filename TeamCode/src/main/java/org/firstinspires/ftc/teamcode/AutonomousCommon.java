package org.firstinspires.ftc.teamcode;
//testing


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import java.util.List;

public class AutonomousCommon  {
    public static void ChrisTest(DcMotor leftMotor, DcMotor rightMotor){

        leftMotor.setPower(-1);        //go backward
        rightMotor.setPower(-1);
        sleep(3000);
        StopMotors(new DcMotor[]{leftMotor,rightMotor});

        rightMotor.setPower(1);
        sleep(2000);
        StopMotors(new DcMotor[]{leftMotor,rightMotor});

        leftMotor.setPower(1);        //go backward
        rightMotor.setPower(1);
        StopMotors(new DcMotor[]{leftMotor,rightMotor});
    }


    public static void StopMotors(DcMotor[] motors){
        for (DcMotor motor : motors ) {
            motor.setPower(0);
        }
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
