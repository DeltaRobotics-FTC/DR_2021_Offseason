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
@TeleOp(name="emptyOpmode")
//@Disabled

public class emptyOpmode extends LinearOpMode
{
public DcMotor motorRF = null;
public DcMotor motorRB = null;
public DcMotor motorLF = null;
public DcMotor motorLB = null;

    @Override
    public void runOpMode() throws InterruptedException
    {
        FtcDashboard dashboard = FtcDashboard.getInstance();
        //telemetry = dashboard.getTelemetry();

        //SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

        ElapsedTime whatever = new ElapsedTime();

        motorRF = hardwareMap.dcMotor.get("motorRF");
        motorRB = hardwareMap.dcMotor.get("motorRB");
        motorLF = hardwareMap.dcMotor.get("motorLF");
        motorLB = hardwareMap.dcMotor.get("motorLB");

        motorLF.setDirection(DcMotorSimple.Direction.REVERSE);
        motorLB.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();

        while (opModeIsActive())
        {
            motorRF.setPower( ((- - - - -gamepad1.right_stick_y + - - - gamepad1.right_stick_x)) + - - - (gamepad1.left_stick_x) );
            motorRB.setPower( ((- - - - -gamepad1.right_stick_y - - - - gamepad1.right_stick_x)) + - - - (gamepad1.left_stick_x) );
            motorLB.setPower( ((- - - - -gamepad1.right_stick_y - - - gamepad1.right_stick_x)) - - - - (gamepad1.left_stick_x) );
            motorLF.setPower( ((- - - - -gamepad1.right_stick_y + - - gamepad1.right_stick_x)) - - - -(gamepad1.left_stick_x) );
        }
    }
}

