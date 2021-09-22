package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by User on 9/26/2017.
 */

public class RobotHardware
{
    //drive motors
    public DcMotor motorRF = null;
    public DcMotor motorLF = null;
    public DcMotor motorRB = null;
    public DcMotor motorLB = null;

    public DcMotor leftEncoder = null;
    public DcMotor rightEncoder = null;
    public DcMotor perpendicularEncoder = null;

    //mechanism motors
    public DcMotor motorRM = null;
    public DcMotor motorLM = null;
    public DcMotor motor3 = null;
    public DcMotor motor4 = null;

    //odometry encoders
    public DcMotor verticalRight = null;
    public DcMotor verticalLeft = null;
    public DcMotor horizontal = null;

    //servos
    public Servo servo = null;
    public Servo servo2 = null;
    public Servo servo3 = null;
    public Servo servo4 = null;
    public Servo servo5 = null;
    public Servo servo6 = null;
    public Servo servo7 = null;
    public Servo servo8 = null;
    public Servo servo9 = null;
    public Servo servo10 = null;
    public Servo servo11 = null;
    public Servo servo12 = null;

    boolean useEncoder = false;

    HardwareMap hwMap = null;
    private ElapsedTime elapsedTime = new ElapsedTime();

    public RobotHardware(HardwareMap ahwMap)
    {
        //dive motors
        motorRF = ahwMap.dcMotor.get("motorRF");
        motorLF = ahwMap.dcMotor.get("motorLF");
        motorRB = ahwMap.dcMotor.get("motorRB");
        motorLB = ahwMap.dcMotor.get("motorLB");
        motorRM = ahwMap.dcMotor.get("motorRM");
        motorLM = ahwMap.dcMotor.get("motorLM");

        motorRB = leftEncoder;
        motorLB = rightEncoder;
        motorRF = perpendicularEncoder;



        //mechanism motors
//        motor1 = ahwMap.get(DcMotorEx.class, "flywheel");
//        motor2 = ahwMap.dcMotor.get("wobble");
//        motor3 = ahwMap.get(DcMotorEx.class, "intake1");
//        motor4 = ahwMap.dcMotor.get("intake2");


        //servos
//        servo = ahwMap.servo.get("servo");
//        servo2 = ahwMap.servo.get("servo2");
//        servo3 = ahwMap.servo.get("servo3");
//        servo4 = ahwMap.servo.get("servo4");
//        servo5 = ahwMap.servo.get("servo5");
//        servo6 = ahwMap.servo.get("servo6");
//        servo7 = ahwMap.servo.get("servo7");
//        servo8 = ahwMap.servo.get("servo8");
//        servo9 = ahwMap.servo.get("servo9");
//        servo10 = ahwMap.servo.get("servo10");
//        servo11 = ahwMap.servo.get("servo11");
//        servo12 = ahwMap.servo.get("servo12");

        //drive motors and odometry encoders
        motorRF.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorLF.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorRB.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorLB.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorRM.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorLM.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);



        motorLF.setDirection(DcMotorSimple.Direction.REVERSE);
        motorLB.setDirection(DcMotorSimple.Direction.REVERSE);
        motorLM.setDirection(DcMotorSimple.Direction.REVERSE);

        motorRF.setPower(0);
        motorLF.setPower(0);
        motorRB.setPower(0);
        motorLB.setPower(0);
        motorRM.setPower(0);
        motorLM.setPower(0);

        //mechanism motors


        //servos
//        servo.setPosition(0);
//        servo2.setPosition(0);
//        servo3.setPosition(0);
//        servo4.setPosition(0);
//        servo5.setPosition(0);
//        servo6.setPosition(0);
//        servo7.setPosition(0);
//        servo8.setPosition(0);
//        servo9.setPosition(0);
//        servo10.setPosition(0);
//        servo11.setPosition(0);
//        servo12.setPosition(0);
    }

}
