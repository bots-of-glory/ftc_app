package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.AutonomousCommon.PlayfieldSide;
@Autonomous (name="LoadingZoneBlue", group="Competition Autonomous")
public class LoadingZoneBlue extends SkystoneBase {
   private ElapsedTime runtime = new ElapsedTime();


    @Override
    public void runOpMode() throws InterruptedException {

        initMotors();

        moveToLegos(movementMotors);
        locateSkystone(movementMotors,PlayfieldSide.Blue);
        grabLego();
        moveToBuildingZone(movementMotors,PlayfieldSide.Blue);
        dropLego();

        moveToLegos(movementMotors);
        locateSkystone(movementMotors,PlayfieldSide.Blue);
        grabLego();
        moveToBuildingZone(movementMotors,PlayfieldSide.Blue);
    }
}
