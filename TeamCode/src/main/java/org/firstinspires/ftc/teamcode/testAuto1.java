package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

@Config
@Autonomous(name="testAuto1")


public class testAuto1 extends LinearOpMode
{

    @Override
    public void runOpMode() throws InterruptedException
    {
        FtcDashboard dashboard = FtcDashboard.getInstance();
        //telemetry = dashboard.getTelemetry();

        RobotHardware robot = new RobotHardware(hardwareMap);

        //SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

        //driveClass drive = new driveClass();


        waitForStart();




            forward(300,.9);

            sleep(1000);

            backwards(300,.9);

            sleep(1000);

            turnLeft(500,.9);

            sleep(1000);

            turnRight(500,.9);

            sleep(1000);

            forwardLeft(500,.9);

            sleep(1000);

            backwardsRight(500,.9);

            sleep(1000);

            forwardRight(500,.9);

            sleep(1000);

            backwardsLeft(500,.9);

            sleep(1000);

            strafeLeft(700,.9);

            sleep(1000);

            strafeRight(700,.9);


        }


    void forward (int distance, double power) {
        RobotHardware robot = new RobotHardware(hardwareMap);

        robot.motorLB.setTargetPosition(distance+robot.motorLB.getCurrentPosition());
        robot.motorLF.setTargetPosition(distance+robot.motorLB.getCurrentPosition());
        robot.motorRB.setTargetPosition(distance+robot.motorLB.getCurrentPosition());
        robot.motorRF.setTargetPosition(distance+robot.motorLB.getCurrentPosition());

        robot.motorLB.setPower(power);
        robot.motorLF.setPower(power);
        robot.motorRB.setPower(power);
        robot.motorRF.setPower(power);

        robot.motorLB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.motorLF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.motorRB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.motorRF.setMode(DcMotor.RunMode.RUN_TO_POSITION);

    }

    void backwards (int distance, double power){
        RobotHardware robot = new RobotHardware(hardwareMap);

        robot.motorLB.setTargetPosition(-distance+robot.motorLB.getCurrentPosition());
        robot.motorLF.setTargetPosition(-distance+robot.motorLB.getCurrentPosition());
        robot.motorRB.setTargetPosition(-distance+robot.motorLB.getCurrentPosition());
        robot.motorRF.setTargetPosition(-distance+robot.motorLB.getCurrentPosition());

        robot.motorLB.setPower(-power);
        robot.motorLF.setPower(-power);
        robot.motorRB.setPower(-power);
        robot.motorRF.setPower(-power);

        robot.motorLB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.motorLF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.motorRB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.motorRF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    void turnRight (int distance, double power) {
        RobotHardware robot = new RobotHardware(hardwareMap);

        robot.motorLB.setTargetPosition(distance+robot.motorLB.getCurrentPosition());
        robot.motorLF.setTargetPosition(distance+robot.motorLB.getCurrentPosition());
        robot.motorRB.setTargetPosition(-distance+robot.motorLB.getCurrentPosition());
        robot.motorRF.setTargetPosition(-distance+robot.motorLB.getCurrentPosition());

        robot.motorLB.setPower(power);
        robot.motorLF.setPower(power);
        robot.motorRB.setPower(-power);
        robot.motorRF.setPower(-power);

        robot.motorLB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.motorLF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.motorRB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.motorRF.setMode(DcMotor.RunMode.RUN_TO_POSITION);

    }

    void turnLeft (int distance, double power)
    {
        RobotHardware robot = new RobotHardware(hardwareMap);

        robot.motorLB.setTargetPosition(-distance+robot.motorLB.getCurrentPosition());
        robot.motorLF.setTargetPosition(-distance+robot.motorLB.getCurrentPosition());
        robot.motorRB.setTargetPosition(distance+robot.motorLB.getCurrentPosition());
        robot.motorRF.setTargetPosition(distance+robot.motorLB.getCurrentPosition());

        robot.motorLB.setPower(-power);
        robot.motorLF.setPower(-power);
        robot.motorRB.setPower(power);
        robot.motorRF.setPower(power);

        robot.motorLB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.motorLF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.motorRB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.motorRF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    void strafeRight (int distance, double power) {
        RobotHardware robot = new RobotHardware(hardwareMap);

        robot.motorLB.setTargetPosition(-distance+robot.motorLB.getCurrentPosition());
        robot.motorLF.setTargetPosition(distance+robot.motorLB.getCurrentPosition());
        robot.motorRB.setTargetPosition(distance+robot.motorLB.getCurrentPosition());
        robot.motorRF.setTargetPosition(-distance+robot.motorLB.getCurrentPosition());

        robot.motorLB.setPower(-power);
        robot.motorLF.setPower(power);
        robot.motorRB.setPower(power);
        robot.motorRF.setPower(-power);

        robot.motorLB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.motorLF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.motorRB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.motorRF.setMode(DcMotor.RunMode.RUN_TO_POSITION);

    }

    void strafeLeft (int distance, double power) {
        RobotHardware robot = new RobotHardware(hardwareMap);

        robot.motorLB.setTargetPosition(distance+robot.motorLB.getCurrentPosition());
        robot.motorLF.setTargetPosition(-distance+robot.motorLB.getCurrentPosition());
        robot.motorRB.setTargetPosition(-distance+robot.motorLB.getCurrentPosition());
        robot.motorRF.setTargetPosition(distance+robot.motorLB.getCurrentPosition());

        robot.motorLB.setPower(power);
        robot.motorLF.setPower(-power);
        robot.motorRB.setPower(-power);
        robot.motorRF.setPower(power);

        robot.motorLB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.motorLF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.motorRB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.motorRF.setMode(DcMotor.RunMode.RUN_TO_POSITION);

    }

    void forwardRight (int distance, double power) {
        RobotHardware robot = new RobotHardware(hardwareMap);

        //robot.motorLB.setTargetPosition(distance+robot.motorLB.getCurrentPosition());
        robot.motorLF.setTargetPosition(distance+robot.motorLB.getCurrentPosition());
        robot.motorRB.setTargetPosition(distance+robot.motorLB.getCurrentPosition());
        //robot.motorRF.setTargetPosition(distance+robot.motorLB.getCurrentPosition());

        //robot.motorLB.setPower(power);
        robot.motorLF.setPower(power);
        robot.motorRB.setPower(power);
        //robot.motorRF.setPower(power);

        //robot.motorLB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.motorLF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.motorRB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        //robot.motorRF.setMode(DcMotor.RunMode.RUN_TO_POSITION);

    }

    void forwardLeft (int distance, double power) {
        RobotHardware robot = new RobotHardware(hardwareMap);

        robot.motorLB.setTargetPosition(distance+robot.motorLB.getCurrentPosition());
        //robot.motorLF.setTargetPosition(distance+robot.motorLB.getCurrentPosition());
        //robot.motorRB.setTargetPosition(distance+robot.motorLB.getCurrentPosition());
        robot.motorRF.setTargetPosition(distance+robot.motorLB.getCurrentPosition());

        robot.motorLB.setPower(power);
        //robot.motorLF.setPower(power);
        //robot.motorRB.setPower(power);
        robot.motorRF.setPower(power);

        robot.motorLB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        //robot.motorLF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        //robot.motorRB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.motorRF.setMode(DcMotor.RunMode.RUN_TO_POSITION);

    }

    void backwardsRight (int distance, double power) {
        RobotHardware robot = new RobotHardware(hardwareMap);

        robot.motorLB.setTargetPosition(-distance+robot.motorLB.getCurrentPosition());
        //robot.motorLF.setTargetPosition(distance+robot.motorLB.getCurrentPosition());
        //robot.motorRB.setTargetPosition(distance+robot.motorLB.getCurrentPosition());
        robot.motorRF.setTargetPosition(-distance+robot.motorLB.getCurrentPosition());

        robot.motorLB.setPower(-power);
        //robot.motorLF.setPower(power);
        //robot.motorRB.setPower(power);
        robot.motorRF.setPower(-power);

        robot.motorLB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        //robot.motorLF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        //robot.motorRB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.motorRF.setMode(DcMotor.RunMode.RUN_TO_POSITION);

    }

    void backwardsLeft (int distance, double power) {
        RobotHardware robot = new RobotHardware(hardwareMap);

        //robot.motorLB.setTargetPosition(distance+robot.motorLB.getCurrentPosition());
        robot.motorLF.setTargetPosition(-distance+robot.motorLB.getCurrentPosition());
        robot.motorRB.setTargetPosition(-distance+robot.motorLB.getCurrentPosition());
        //robot.motorRF.setTargetPosition(distance+robot.motorLB.getCurrentPosition());

        //robot.motorLB.setPower(power);
        robot.motorLF.setPower(-power);
        robot.motorRB.setPower(-power);
        //robot.motorRF.setPower(power);

        //robot.motorLB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.motorLF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.motorRB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        //robot.motorRF.setMode(DcMotor.RunMode.RUN_TO_POSITION);

    }
}
