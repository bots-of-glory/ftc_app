package org.firstinspires.ftc.teamcode;

//import android.hardware.Sensor;
//import com.qualcomm.hardware.modernrobotics.ModernRoboticsAnalogOpticalDistanceSensor;
//import com.qualcomm.robotcore.eventloop.opmode.OpMode;
//import com.qualcomm.robotcore.hardware.IntegratingGyroscope;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.GyroSensor;

import com.qualcomm.robotcore.util.ElapsedTime;

// below is the Annotation that registers this OpMode with the FtcRobotController app.
// @Autonomous classifies the OpMode as autonomous, name is the OpMode title and the
// optional group places the OpMode into the Exercises group.
// uncomment the @Disable annotation to remove the OpMode from the OpMode list.

@Autonomous(name="straightCrater", group="Competition Autonomous")
@Disabled
public class straightCrater extends LinearOpMode
{
    DcMotor liftMotor;
    DcMotor frontLeft;
    DcMotor rearLeft;
    DcMotor frontRight;
    DcMotor rearRight;
    DcMotor armMotor;
    GyroSensor sensorGyro;
    ModernRoboticsI2cGyro mrGyro;

    private ElapsedTime runtime = new ElapsedTime();

    // called when init button is  pressed.
    @Override
    public void runOpMode() throws InterruptedException {
        //declare motors
        liftMotor = hardwareMap.dcMotor.get("liftMotor");
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        rearLeft = hardwareMap.dcMotor.get("rearLeft");
        frontRight = hardwareMap.dcMotor.get("frontRight");
        rearRight = hardwareMap.dcMotor.get("rearRight");
        armMotor = hardwareMap.dcMotor.get("armMotor");
        sensorGyro = hardwareMap.gyroSensor.get("gyro");

        //declare motor directions
        frontLeft.setDirection(DcMotor.Direction.FORWARD);
        rearLeft.setDirection(DcMotor.Direction.FORWARD);
        frontRight.setDirection(DcMotor.Direction.REVERSE);
        rearRight.setDirection(DcMotor.Direction.REVERSE);
        armMotor.setDirection(DcMotor.Direction.FORWARD);
        liftMotor.setDirection(DcMotor.Direction.REVERSE);

        mrGyro = (ModernRoboticsI2cGyro) sensorGyro;

        double turnSpeed = 0.2;
        int zAccumulated;
        int target = 0;

        telemetry.addData("Mode", "waiting");
        telemetry.update();

        // wait for start button.

        waitForStart();

        telemetry.addData("Mode", "running");
        telemetry.update();

//-----------------------------Lift Up(lower robot) Start-------------------------------------------
        operateLift(1, 0.8, 5);
        //Wait 1 second
        sleep(500);
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
        rearLeft.setTargetPosition(3500);
        rearLeft.setPower(.75);
        rearRight.setTargetPosition(3500);
        rearRight.setPower(.75);
        frontLeft.setTargetPosition(3500);
        frontLeft.setPower(.75);
        frontRight.setTargetPosition(3500);
        frontRight.setPower(.75);
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

//-----------------------------Lift Down Start------------------------------------------------------
        operateLift(0, 1, 5);
        //Wait 1 second
        sleep(500);
//-----------------------------Lift Down End--------------------------------------------------------
    }

    public void turn(int target) throws InterruptedException {
        turnAbsolute(target + mrGyro.getIntegratedZValue());
    }


    public void turnAbsolute(int target) throws InterruptedException {
        int zAccumulated = mrGyro.getIntegratedZValue();
        double turnSpeed = .5;

        while (Math.abs(zAccumulated - target) > 3) {
            if (zAccumulated > target) {
                rearLeft.setPower(turnSpeed);
                frontLeft.setPower(turnSpeed);
                rearRight.setPower(-turnSpeed);
                frontRight.setPower(-turnSpeed);
            }
            if (zAccumulated < target) {
                rearLeft.setPower(-turnSpeed);
                frontLeft.setPower(-turnSpeed);
                rearRight.setPower(turnSpeed);
                frontRight.setPower(turnSpeed);
            }

            waitOneFullHardwareCycle();

            zAccumulated = mrGyro.getIntegratedZValue();
            telemetry.addData("1. accu", String.format("%03d", zAccumulated));
        }
        rearLeft.setPower(0);
        rearRight.setPower(0);
        frontLeft.setPower(0);
        frontRight.setPower(0);

        telemetry.addData("1. accu", String.format("%03d", zAccumulated));

        waitOneFullHardwareCycle();

    }


    public void operateLift(int position, double speed, int timeoutS){
        if (opModeIsActive()) {
            if(position == 0) {
                //Change This Number to Determine the Upper Position of the Lift
                liftMotor.setTargetPosition(liftMotor.getCurrentPosition() - 7700
                );
                liftMotor.setPower(-speed);
            }
            else {
                //Change This Number to Determine the Lower Position of the Lift
                liftMotor.setTargetPosition(liftMotor.getCurrentPosition() + 7700
                );
                liftMotor.setPower(-speed);
            }
            liftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            runtime.reset();

            while (liftMotor.isBusy() && opModeIsActive() &&
                    (runtime.seconds() < timeoutS)) {
                // Display it for the driver.
                telemetry.addData("Lift",  "Running to %7d : %7d", liftMotor.getCurrentPosition(), liftMotor.getTargetPosition());
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