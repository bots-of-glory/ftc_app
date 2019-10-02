package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;


@Autonomous (name="BuildingZoneBlue", group="Competition Autonomous")
public class BuildingZoneBlue extends  SkystoneBase {

    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {
        initMotors();

        AutonomousCommon.moveToPlatform(movementMotors,AutonomousCommon.PlayfieldSide.Blue);
        AutonomousCommon.lowerFlappers(flapperMotors);
        AutonomousCommon.movePlatformToBuildingSite(movementMotors);
        AutonomousCommon.moveToSkybridge(movementMotors,AutonomousCommon.PlayfieldSide.Blue);

    }
}
