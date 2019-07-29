package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

// below is the Annotation that registers this OpMode with the FtcRobotController app.
// @Autonomous classifies the OpMode as autonomous, name is the OpMode title and the
// optional group places the OpMode into the Exercises group.
// uncomment the @Disable annotation to remove the OpMode from the OpMode list.
@Autonomous(name = "SimpleRobotTest", group = "Exercises")
//@Disabled
public class SimpleRobotTest extends LinearOpMode {
    private DcMotor rightMotor;
    private DcMotor leftMotor;
//test sc
    // called when init button is  pressed.
    @Override
    public void runOpMode() {
        leftMotor = hardwareMap.dcMotor.get("leftMotor");
        rightMotor = hardwareMap.dcMotor.get("rightMotor");

        leftMotor.setDirection(DcMotor.Direction.FORWARD);
        rightMotor.setDirection(DcMotor.Direction.REVERSE);


        telemetry.addData("Mode", "waiting");
        telemetry.update();
        // wait for start button.
        waitForStart();
        telemetry.addData("Mode", "running");
        telemetry.update();

        AutonomousCommon.ChrisTest(leftMotor,rightMotor);
    }
}

