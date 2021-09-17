package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

public class driveClass
{

    RobotHardware robot = new RobotHardware(hardwareMap);

    void forward (int distance, double power) {
        RobotHardware robot = new RobotHardware(hardwareMap);

        robot.motorLB.setTargetPosition(distance);
        robot.motorLF.setTargetPosition(distance);
        robot.motorRB.setTargetPosition(distance);
        robot.motorRF.setTargetPosition(distance);

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

        robot.motorLB.setTargetPosition(-distance);
        robot.motorLF.setTargetPosition(-distance);
        robot.motorRB.setTargetPosition(-distance);
        robot.motorRF.setTargetPosition(-distance);

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

        robot.motorLB.setTargetPosition(distance);
        robot.motorLF.setTargetPosition(distance);
        robot.motorRB.setTargetPosition(-distance);
        robot.motorRF.setTargetPosition(-distance);

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

        robot.motorLB.setTargetPosition(-distance);
        robot.motorLF.setTargetPosition(-distance);
        robot.motorRB.setTargetPosition(distance);
        robot.motorRF.setTargetPosition(distance);

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

        robot.motorLB.setTargetPosition(-distance);
        robot.motorLF.setTargetPosition(distance);
        robot.motorRB.setTargetPosition(distance);
        robot.motorRF.setTargetPosition(-distance);

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

        robot.motorLB.setTargetPosition(distance);
        robot.motorLF.setTargetPosition(-distance);
        robot.motorRB.setTargetPosition(-distance);
        robot.motorRF.setTargetPosition(distance);

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

        //robot.motorLB.setTargetPosition(distance);
        robot.motorLF.setTargetPosition(distance);
        robot.motorRB.setTargetPosition(distance);
        //robot.motorRF.setTargetPosition(distance);

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

        robot.motorLB.setTargetPosition(distance);
        //robot.motorLF.setTargetPosition(distance);
        //robot.motorRB.setTargetPosition(distance);
        robot.motorRF.setTargetPosition(distance);

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

        robot.motorLB.setTargetPosition(-distance);
        //robot.motorLF.setTargetPosition(distance);
        //robot.motorRB.setTargetPosition(distance);
        robot.motorRF.setTargetPosition(-distance);

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

        //robot.motorLB.setTargetPosition(distance);
        robot.motorLF.setTargetPosition(-distance);
        robot.motorRB.setTargetPosition(-distance);
        //robot.motorRF.setTargetPosition(distance);

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
