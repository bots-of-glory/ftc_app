package org.firstinspires.ftc.teamcode;
//test


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import java.util.List;

public class AutonomousCommon  {


    public static void strafeLeft(long milliseconds){

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
