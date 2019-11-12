package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.AutonomousCommon.PlayfieldSide;
@Autonomous (name="LoadingZoneBlue", group="Competition Autonomous")
public class LoadingZoneBlue extends SkystoneBase {
   private ElapsedTime runtime = new ElapsedTime();


    @Override
    public void runOpMode() throws InterruptedException {
        this.playSide = PlayfieldSide.Blue;
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
