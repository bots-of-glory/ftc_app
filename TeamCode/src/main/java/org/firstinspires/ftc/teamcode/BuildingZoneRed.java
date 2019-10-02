package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.AutonomousCommon.PlayfieldSide;

@Autonomous (name="BuildingZoneRed", group="Competition Autonomous")
public class BuildingZoneRed extends SkystoneBase {

    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {

        initMotors();

        moveToPlatform(movementMotors,PlayfieldSide.Red);
        lowerFlappers(flapperMotors);
        movePlatformToBuildingSite(movementMotors);
        moveToSkybridge(movementMotors,PlayfieldSide.Red);
    }
}
