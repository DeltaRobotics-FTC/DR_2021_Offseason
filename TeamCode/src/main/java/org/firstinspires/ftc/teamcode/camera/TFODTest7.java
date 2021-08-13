/**
 * i don't know if the tensor flow files are still in the sdk from rover ruckus.
 * this file should be run to see if the files are in here and i just cant find them.
 * if it does not run properly, someone needs to go here:
 * https://github.com/ftctechnh/ftc_app/tree/master/FtcRobotController/src/main/assets
 * and move the RoverRuckus.tflite file into the sdk under assets in the ftc robot controller
 * this is RR2 tfod code
 */

package org.firstinspires.ftc.teamcode.camera;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import java.util.List;
import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.teamcode.drive.StandardTrackingWheelLocalizer;


@TeleOp(name = "TFODTest7", group = "Concept")
//@Disabled
public class TFODTest7 extends LinearOpMode {
    private static final String TFOD_MODEL_ASSET = "RoverRuckus.tflite";
    private static final String LABEL_GOLD_MINERAL = "Gold Mineral";
    private static final String LABEL_SILVER_MINERAL = "Silver Mineral";

    private static final String VUFORIA_KEY = "AQIjJXP/////AAABmX8DXrmUxEBjvVNbT94EWcg3A75NZTjC3HG9/ur6NlOGrwrPUBWwLK8GlSeDl/fPcBsf+HkwYZQt7Fu8g/fJSvgftOYprWUaAWTCcyEnjfqU7CKCEEeWOO97PEJHdsjSPaRCoKAUjmRCknWJWxPuvgBXU4z63zwtr45AR0DzsF9FRdoj9pNR7hcmPKZmMLSfU6zdeBinzk2DQrJq2GGHJJgI0Mgh/IcrRA54NaGttRaqLpvLOuDHRiPyHnOtOXkjHBZp4Simdyqht675alc36Kyz3PF34/9X6m3b/43kuI231AaSBt1r5GnQv0jL9QRbGde2lr0U8mTmnatRm1ASpgCIcAJJ82jRpyWf3yELRH1w";

    private VuforiaLocalizer vuforia;

    private TFObjectDetector tfod;

    private static double CameraHeight = 8;
    private static double CameraAngle = 45;
    private static double VerticlePixels = 720;
    private static double HorizontalPixels = 1280;
    private static double VerticalAnglePerPixel = 0.05854859;
    private static double HorizontalAnglePerPixel = 0.05391957;
    private static double CameraLocationX = 0;
    private static double CameraLocationY = 0;

    private double ObjectHeight;
    private double ObjectWidth;
    private double ObjectLeft;
    private double ObjectBottom;

    private double ObjectAngleVerticle;
    private double ObjectAngleHorizontal;

    private double CameraDistanceX;
    private double CameraDistanceHypot;
    private double CameraDistanceY;

    private double RobotDistanceX;
    private double RobotDistanceY;

    private double objectDistance;
    private double objectAngleRadians;

    private double objectFieldLocationX;
    private double objectFieldLocationY;

    private double picLocationX;
    private double picLocationY;
    private double picLocationHeading;

    @Override
    public void runOpMode() {
        // The TFObjectDetector uses the camera frames from the VuforiaLocalizer, so we create that first.
        initVuforia();

        initTfod();

        FtcDashboard.getInstance().startCameraStream(vuforia, 0);

        StandardTrackingWheelLocalizer localizer = new StandardTrackingWheelLocalizer(hardwareMap);

        telemetry.addData(">", "Press Play to start tracking");
        telemetry.update();
        waitForStart();

        if (opModeIsActive()) {
            if (tfod != null) {
                tfod.activate();
            }

            while (opModeIsActive()) {
                if (tfod != null) {
                    // getUpdatedRecognitions() will return null if no new information is available since the last time that call was made.
                    List<Recognition> updatedRecognitions = tfod.getUpdatedRecognitions();
                    if (updatedRecognitions != null) {
                        telemetry.addData("# Object Detected", updatedRecognitions.size());

                        picLocationX = localizer.getPoseEstimate().getX();
                        picLocationY = localizer.getPoseEstimate().getY();
                        picLocationHeading = localizer.getPoseEstimate().getHeading();

                        for (Recognition recognition : updatedRecognitions) {
                            //get recognition's stats
                            ObjectHeight = recognition.getHeight();
                            ObjectWidth = recognition.getWidth();
                            ObjectLeft = recognition.getLeft();
                            ObjectBottom = recognition.getBottom();

                            //find the recognition's angle vertically and horizontally
                            ObjectAngleVerticle = ((ObjectBottom + (ObjectHeight/2) - (VerticlePixels/2)) * VerticalAnglePerPixel) + CameraAngle;
                            ObjectAngleHorizontal = ((ObjectLeft + (ObjectWidth/2) - (HorizontalPixels/2)) * HorizontalAnglePerPixel);

                            //find the location of recognition relletive to the camera
                            CameraDistanceX = Math.tan(Math.toRadians(ObjectAngleVerticle)) * CameraHeight;
                            CameraDistanceHypot = CameraHeight / Math.cos(Math.toRadians(ObjectAngleVerticle));
                            CameraDistanceY = Math.tan(Math.toRadians(ObjectAngleHorizontal)) * CameraDistanceHypot;

                            //Y negative to the left, X always positive
                            //telemetry.addData("X distance from the camera", CameraDistanceX);
                            //telemetry.addData("Y distance from the camera", CameraDistanceY);

                            //find the location of recognition reletive to the robots odometry center
                            RobotDistanceX = CameraLocationX + CameraDistanceX;
                            RobotDistanceY = CameraLocationY + CameraDistanceY;

                            //telemetry.addData("X distance from the robot center", RobotDistanceX);
                            //telemetry.addData("Y distance from the robot center", RobotDistanceY);

                            //find recognitions location on the field
                            objectDistance = Math.hypot(RobotDistanceX, RobotDistanceY);
                            objectAngleRadians = Math.atan(RobotDistanceX / RobotDistanceY) + picLocationHeading;

                            objectFieldLocationX = (Math.acos(objectAngleRadians) * objectDistance) + picLocationX;
                            objectFieldLocationY = (Math.asin(objectAngleRadians) * objectDistance) + picLocationY;

                            telemetry.addData("X field location", objectFieldLocationX);
                            telemetry.addData("Y field location", objectFieldLocationY);

                        }

                        telemetry.update();
                    }
                }
            }
        }

        if (tfod != null) {
            tfod.shutdown();
        }
    }

    //Initialize the Vuforia localization engine.
    private void initVuforia() {
        /*
         * Configure Vuforia by creating a Parameter object, and passing it to the Vuforia engine.
         */
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters();

        parameters.vuforiaLicenseKey = VUFORIA_KEY;
        parameters.cameraName = hardwareMap.get(WebcamName.class, "Webcam 1");

        //  Instantiate the Vuforia engine
        vuforia = ClassFactory.getInstance().createVuforia(parameters);

        // Loading trackables is not necessary for the TensorFlow Object Detection engine.
    }

    // Initialize the TensorFlow Object Detection engine.
    private void initTfod() {
        int tfodMonitorViewId = hardwareMap.appContext.getResources().getIdentifier(
                "tfodMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        TFObjectDetector.Parameters tfodParameters = new TFObjectDetector.Parameters(tfodMonitorViewId);
        tfod = ClassFactory.getInstance().createTFObjectDetector(tfodParameters, vuforia);
        tfod.loadModelFromAsset(TFOD_MODEL_ASSET, LABEL_GOLD_MINERAL, LABEL_SILVER_MINERAL);
    }
}