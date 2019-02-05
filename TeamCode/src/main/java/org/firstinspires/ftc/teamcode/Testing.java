//Goes into alliances's crater
//Right
package org.firstinspires.ftc.teamcode;

import android.hardware.Sensor;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsAnalogOpticalDistanceSensor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.IntegratingGyroscope;
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

@Autonomous(name="TEST", group="Competition Autonomous")
@Disabled
public class Testing extends LinearOpMode
{
    DcMotor liftMotor;
    DcMotor frontLeft;
    DcMotor rearLeft;
    DcMotor frontRight;
    DcMotor rearRight;
    Servo armServo;
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
        armServo = hardwareMap.servo.get("armServo");
        sensorGyro = hardwareMap.gyroSensor.get("gyro");

        //declare motor directions
        frontLeft.setDirection(DcMotor.Direction.FORWARD);
        rearLeft.setDirection(DcMotor.Direction.FORWARD);
        frontRight.setDirection(DcMotor.Direction.REVERSE);
        rearRight.setDirection(DcMotor.Direction.REVERSE);
        armServo.setDirection(Servo.Direction.FORWARD);
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

        telemetry.addLine("going to the right");


        //-------------------Place Marker Start--------------------------------------------------
        armServo.setPosition(0.0);
        sleep(400); //wait


        //-------------------Block End--------------------------------------------------

        //-----------------------------Lift Up(lower robot) Start-------------------------------------------
        operateLift(1, 1, 5);
        //Wait 1 second
        sleep(500);
//-----------------------------Lift Up(lower robot) End---------------------------------------------


        //----------------------Strafe off Lander Start-------------------------------------

        rearLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rearRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rearLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rearRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        liftMotor.setPower(0.1);
        rearLeft.setTargetPosition(-800);
        rearLeft.setPower(0.5);
        rearRight.setTargetPosition(800);
        rearRight.setPower(0.5);
        frontLeft.setTargetPosition(800);
        frontLeft.setPower(0.6);
        frontRight.setTargetPosition(-800);
        frontRight.setPower(0.5);
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
        liftMotor.setPower(0);
        //-------------------Block End--------------------------------------------------

        //----------------------Straight off Lander Start-------------------------------------
        rearLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rearRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rearLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rearRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rearLeft.setTargetPosition(600);
        rearLeft.setPower(0.5);
        rearRight.setTargetPosition(600);
        rearRight.setPower(0.5);
        frontLeft.setTargetPosition(600);
        frontLeft.setPower(0.5);
        frontRight.setTargetPosition(600);
        frontRight.setPower(0.5);
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
        //-------------------Block End--------------------------------------------------

        //----------------------Get in Position for Mineral Start-------------------------------------
        rearLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rearRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rearLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rearRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rearLeft.setTargetPosition(2000);
        rearLeft.setPower(0.5);
        rearRight.setTargetPosition(-2000);
        rearRight.setPower(0.5);
        frontLeft.setTargetPosition(-2000);
        frontLeft.setPower(0.5);
        frontRight.setTargetPosition(2000);
        frontRight.setPower(0.5);
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
        //-------------------Block End--------------------------------------------------

        //----------------------Straight to Knock Mineral Start-------------------------------------
        rearLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rearRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rearLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rearRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rearLeft.setTargetPosition(2500);
        rearLeft.setPower(1);
        rearRight.setTargetPosition(2500);
        rearRight.setPower(1);
        frontLeft.setTargetPosition(2500);
        frontLeft.setPower(1);
        frontRight.setTargetPosition(2500);
        frontRight.setPower(1);
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
        //-------------------Block End--------------------------------------------------

        //-------------------Place Marker Start--------------------------------------------------
        armServo.setPosition(0.7);
        sleep(400); //wait


        //-------------------Block End--------------------------------------------------

        //-----------------------------Lift Down Start------------------------------------------------------
        operateLift(0, 1, 5);
        //Wait 1 second
        sleep(500);
//-----------------------------Lift Down End--------------------------------------------------------

        //----------------------WAIT-------------------------------------
        sleep(25000);
        //----------------------------------------------------------------
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
                liftMotor.setTargetPosition(liftMotor.getCurrentPosition() - 7600
                );
                liftMotor.setPower(-speed);
            }
            else {
                //Change This Number to Determine the Lower Position of the Lift
                liftMotor.setTargetPosition(liftMotor.getCurrentPosition() + 7600
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