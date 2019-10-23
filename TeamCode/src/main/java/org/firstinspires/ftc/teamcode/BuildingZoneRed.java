package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.AutonomousCommon.PlayfieldSide;

@Autonomous (name="BuildingZoneRed", group="Competition Autonomous")
public class BuildingZoneRed extends SkystoneBase {

    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {
        this.playSide = PlayfieldSide.Red;
        initMotors();
        moveToPlatform();
        lowerFlappers();
        movePlatformToBuildingSite();
        moveToSkybridge();
    }
}
