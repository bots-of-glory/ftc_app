package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous (name="LoadingZoneBlue", group="Competition Autonomous")
public class LoadingZoneBlue extends SkystoneBase {
   private ElapsedTime runtime = new ElapsedTime();


    @Override
    public void runOpMode() throws InterruptedException {

        initMotors();

        AutonomousCommon.moveToLegos(movementMotors);
        AutonomousCommon.locateSkystone(movementMotors,AutonomousCommon.PlayfieldSide.Blue);
        AutonomousCommon.grabLego();
        AutonomousCommon.moveToBuildingZone(movementMotors,AutonomousCommon.PlayfieldSide.Blue);
        AutonomousCommon.dropLego();

        AutonomousCommon.moveToLegos(movementMotors);
        AutonomousCommon.locateSkystone(movementMotors,AutonomousCommon.PlayfieldSide.Blue);
        AutonomousCommon.grabLego();
        AutonomousCommon.moveToBuildingZone(movementMotors,AutonomousCommon.PlayfieldSide.Blue);
    }
}
