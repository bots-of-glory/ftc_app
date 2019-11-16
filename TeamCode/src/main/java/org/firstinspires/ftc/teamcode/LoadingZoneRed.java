package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.AutonomousCommon.PlayfieldSide;


@Autonomous (name="LoadingZoneRed", group="Competition Autonomous")
public class LoadingZoneRed extends SkystoneVisionBase {
    private ElapsedTime runtime = new ElapsedTime();


    @Override
    public void runOpMode() throws InterruptedException {
        playSide = PlayfieldSide.Red;
        initMotors();
        waitForStart();
        tempSkybridgeParkAway();
        //First Skystone
        //moveToLegos();
        //locateSkystone();
        //grabLego();
        //moveToBuildingZone();
        //dropLego();

        //2nd Skystone
        //moveToLegos();
        //locateSkystone();
        //grabLego();
        //moveToBuildingZone();
        //dropLego();

    }
}
