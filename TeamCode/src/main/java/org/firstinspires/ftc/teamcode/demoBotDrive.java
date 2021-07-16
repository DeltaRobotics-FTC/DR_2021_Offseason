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
@TeleOp(name="demoBotDrive")
//@Disabled

public class demoBotDrive extends LinearOpMode
{
    public DcMotor motorRF = null;
    public DcMotor motorLF = null;
    public DcMotor motorRB = null;
    public DcMotor motorLB = null;

    double speed = .5;
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

        motorRF.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorLF.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorRB.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorLB.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        waitForStart();

        while (opModeIsActive())
        {
            double LFpower = ( ((-gamepad1.right_stick_y + gamepad1.right_stick_x)) - (gamepad1.left_stick_x * zScale));
            double LBpower = ( ((-gamepad1.right_stick_y - gamepad1.right_stick_x)) - (gamepad1.left_stick_x * zScale));
            double RFpower = ( ((gamepad1.right_stick_y + gamepad1.right_stick_x)) - (gamepad1.left_stick_x * zScale));
            double RBpower = ( ((gamepad1.right_stick_y - gamepad1.right_stick_x)) - (gamepad1.left_stick_x * zScale));

            motorRF.setPower(RFpower * speed);
            motorRB.setPower(RBpower * speed);
            motorLB.setPower(LBpower * speed);
            motorLF.setPower(LFpower * speed);


        }
    }
}