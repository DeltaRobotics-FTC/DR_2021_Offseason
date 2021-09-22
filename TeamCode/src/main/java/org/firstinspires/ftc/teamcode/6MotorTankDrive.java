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
@Disabled

public class emptyOpmode extends LinearOpMode
{

    @Override
    public void runOpMode() throws InterruptedException
    {
        //FtcDashboard dashboard = FtcDashboard.getInstance();
        //telemetry = dashboard.getTelemetry();

        RobotHardware robot = new RobotHardware(hardwareMap);

        //SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

        //ElapsedTime whatever = new ElapsedTime();

        waitForStart();

        while (opModeIsActive())
        {
            robot.motorRF.setPower(-gamepad1.right_stick_y);
            robot.motorRM.setPower(-gamepad1.right_stick_y);
            robot.motorRB.setPower(-gamepad1.right_stick_y);
            robot.motorLB.setPower(-gamepad1.left_stick_y);
            robot.motorLM.setPower(-gamepad1.left_stick_y);
            robot.motorLF.setPower(-gamepad1.left_stick_y);
        }
    }
}
