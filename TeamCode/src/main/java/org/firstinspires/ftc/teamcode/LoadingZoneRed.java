package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.AutonomousCommon.PlayfieldSide;
@Autonomous (name="LoadingZoneRed", group="Competition Autonomous")
public class LoadingZoneRed extends SkystoneBase {
    private ElapsedTime runtime = new ElapsedTime();


    @Override
    public void runOpMode() throws InterruptedException {
        initMotors();

        moveToLegos();
        locateSkystone(PlayfieldSide.Red);
        grabLego();
        moveToBuildingZone(PlayfieldSide.Red);
        dropLego();

        moveToLegos();
        locateSkystone(PlayfieldSide.Red);
        grabLego();
        moveToBuildingZone(PlayfieldSide.Red);
    }
}
