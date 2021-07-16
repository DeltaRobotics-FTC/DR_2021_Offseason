package org.firstinspires.ftc.teamcode;


import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

@Config
@TeleOp(name="demoBot")
//@Disabled

public class demoBot extends LinearOpMode
{
    public DcMotor motorRF = null;
    public DcMotor motorLF = null;
    public DcMotor motorRB = null;
    public DcMotor motorLB = null;
    public DcMotor shooterMotor = null;

    double speed = 1;
    double zScale = .8;


    @Override
    public void runOpMode() throws InterruptedException
    {
        //FtcDashboard dashboard = FtcDashboard.getInstance();
        //telemetry = dashboard.getTelemetry();

        //SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

        //ElapsedTime whatever = new ElapsedTime();

        motorRF = hardwareMap.dcMotor.get("motorRF");
        motorLF = hardwareMap.dcMotor.get("motorLF");
        motorRB = hardwareMap.dcMotor.get("motorRB");
        motorLB = hardwareMap.dcMotor.get("motorLB");

        shooterMotor = hardwareMap.dcMotor.get("shooterMotor");
        shooterMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        waitForStart();

        while (opModeIsActive())
        {
            double LFpower = ( ((-gamepad1.right_stick_x + gamepad1.right_stick_y)) - (gamepad1.left_stick_x * zScale) );
            double LBpower = ( ((-gamepad1.right_stick_x - gamepad1.right_stick_y)) + (gamepad1.left_stick_x * zScale) );
            double RFpower = ( ((-gamepad1.right_stick_x - gamepad1.right_stick_y)) - (gamepad1.left_stick_x * zScale) );
            double RBpower = ( ((-gamepad1.right_stick_x + gamepad1.right_stick_y)) + (gamepad1.left_stick_x * zScale) );

            motorRF.setPower(RFpower * speed);
            motorRB.setPower(RBpower * speed);
            motorLB.setPower(LBpower * speed);
            motorLF.setPower(LFpower * speed);

            if (gamepad1.b) {
                shooterMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                shooterMotor.setTargetPosition(-1600);
                shooterMotor.setPower(1);
                shooterMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

                sleep(1000);
            }

            if (gamepad1.a)
            {
                shooterMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                shooterMotor.setPower(-.6);
            }
            else {
                shooterMotor.setPower(0);
            }
        }
    }
}