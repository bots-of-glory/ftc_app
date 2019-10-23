package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.AutonomousCommon.PlayfieldSide;
@Autonomous (name="LoadingZoneRed", group="Competition Autonomous")
public class LoadingZoneRed extends SkystoneBase {
    private ElapsedTime runtime = new ElapsedTime();


    @Override
    public void runOpMode() throws InterruptedException {
        playSide = PlayfieldSide.Red;
        initMotors();

        moveToLegos();
        locateSkystone();
        grabLego();
        moveToBuildingZone();
        dropLego();

        moveToLegos();
        locateSkystone();
        grabLego();
        moveToBuildingZone();
    }
}
