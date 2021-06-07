/**
 * i don't know if the tensor flow files are still in the sdk from rover ruckus.
 * this file should be run to see if the files are in here and i just cant find them.
 * if it does not run properly, someone needs to go here:
 * https://github.com/ftctechnh/ftc_app/tree/master/FtcRobotController/src/main/assets
 * and move the RoverRuckus.tflite file into the sdk under assets in the ftc robot controller
 * this is RR2 tfod code
 */

package org.firstinspires.ftc.teamcode.camera;

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


@TeleOp(name = "TFODObjectSize", group = "Concept")
//@Disabled
public class TFODObjectSize extends LinearOpMode {
    private static final String TFOD_MODEL_ASSET = "RoverRuckus.tflite";
    private static final String LABEL_GOLD_MINERAL = "Gold Mineral";
    private static final String LABEL_SILVER_MINERAL = "Silver Mineral";

    private static final String VUFORIA_KEY = "AQIjJXP/////AAABmX8DXrmUxEBjvVNbT94EWcg3A75NZTjC3HG9/ur6NlOGrwrPUBWwLK8GlSeDl/fPcBsf+HkwYZQt7Fu8g/fJSvgftOYprWUaAWTCcyEnjfqU7CKCEEeWOO97PEJHdsjSPaRCoKAUjmRCknWJWxPuvgBXU4z63zwtr45AR0DzsF9FRdoj9pNR7hcmPKZmMLSfU6zdeBinzk2DQrJq2GGHJJgI0Mgh/IcrRA54NaGttRaqLpvLOuDHRiPyHnOtOXkjHBZp4Simdyqht675alc36Kyz3PF34/9X6m3b/43kuI231AaSBt1r5GnQv0jL9QRbGde2lr0U8mTmnatRm1ASpgCIcAJJ82jRpyWf3yELRH1w";

    private VuforiaLocalizer vuforia;

    private TFObjectDetector tfod;

    Recognition recognition;

    @Override
    public void runOpMode() {
        // The TFObjectDetector uses the camera frames from the VuforiaLocalizer, so we create that
        // first.

        List<Recognition> recognitions;
        double[] angle = {};
        double[] height_width = {};
        int index;
        int i;

        initVuforia();

        initTfod();


        telemetry.addData(">", "Press Play to start tracking");
        telemetry.update();
        waitForStart();

        if (opModeIsActive()) {

            //while (opModeIsActive()) {
                if (tfod != null) {
                    // getUpdatedRecognitions() will return null if no new information is available since
                    // the last time that call was made.
                    recognitions = tfod.getRecognitions();
                    if (recognitions != null) {
                        telemetry.addData("# Object Detected", recognitions.size());

                        index = 0;

                        for (Recognition recognition : recognitions) {
                            angle [index] = recognition.estimateAngleToObject(AngleUnit.DEGREES);
                            height_width [index] = recognition.getHeight() / recognition.getWidth();
                            index++;
                        }

                        i = 0;

                        while (index != i) {
                            telemetry.addData("object " + index + " angle = ", angle[i]);
                            telemetry.addData("object " + index + " height_width = ", height_width[i]);
                            i++;
                        }

                        telemetry.update();
                    }

                    while (opModeIsActive()) {}
                }
            //}
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