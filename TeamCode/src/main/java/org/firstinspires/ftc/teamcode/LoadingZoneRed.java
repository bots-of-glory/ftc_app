package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous (name="LoadingZoneRed", group="Competition Autonomous")
public class LoadingZoneRed extends SkystoneBase {
    private ElapsedTime runtime = new ElapsedTime();


    @Override
    public void runOpMode() throws InterruptedException {
        initMotors();

        AutonomousCommon.moveToLegos(movementMotors);
        AutonomousCommon.locateSkystone(movementMotors,AutonomousCommon.PlayfieldSide.Red);
        AutonomousCommon.grabLego();
        AutonomousCommon.moveToBuildingZone(movementMotors,AutonomousCommon.PlayfieldSide.Red);
        AutonomousCommon.dropLego();

        AutonomousCommon.moveToLegos(movementMotors);
        AutonomousCommon.locateSkystone(movementMotors,AutonomousCommon.PlayfieldSide.Red);
        AutonomousCommon.grabLego();
        AutonomousCommon.moveToBuildingZone(movementMotors,AutonomousCommon.PlayfieldSide.Red);
    }
}
