package org.firstinspires.ftc.teamcode;

@Config
@TeleOp(name="customOdoRound2")

public class customOdoRound2 extends LinearOpMode
{
  
    @Override
    public void runOpMode() throws InterruptedException
    {
    
    RobotHardware robot = new RobotHardware(hardwareMap);
    
    //odometry constants
    double encoderWidth = 13; // distance between parallel encoders
    double perpendicularOffset = 5; //center of parallel encoders to perpendicular encoder
    double wheelRadius = 1; //odometry wheel radius in inches
    double encoderCPR = 8192; //encoder ticks(counts) per revolution (cpr)
    double inchesPerTick = 2.0 * Math.PI * R/N;
    
    //current readings
    int CurrentRightPos = 0;
    int CurrentLeftPos = 0;
    int CurrentPerpendicularPos = 0;
    
    //position before this movement
    int OldRightPos = 0;
    int OldLeftPos = 0;
    int OldPerpendicularPos = 0;
    
    //XyhVecors keep track of the robots cordinates as (x, y, h) with h as the heading 
    
    XyhVector START_POS = new XyhVector(0, 0, 0) //start position of the robot
    XyhVector CURRENT_POS = new XyhVector(START_POS) //this variable will keep track of the robots location globaly 
    
      waitForStart();

        while (opModeIsActive())
        {
            //recording the positions of the encoders before the move
            OldRightPos = CurrentRightPos; 
            OldLeftPos = CurrentLeftPos;
            OldPerpendicularPos = CurrentPerpendicularPos;
            
            //finding the positions of the encoders after the move
            CurrentRightPos = robot.leftEncoder.getCurrentPosition(); //right encoder position;
            CurrentLeftPos = robot.rightEncoder.getCurrentPosition(); //left encoder position;
            CurrentPerpendicularPos = robot.perpendicularEncoder.getCurrentPosition(); //perpendicular encoder position;
            
            //finding the delta of each encoder value to calculate the distance moved
            int deltaLeft = CurrentRightPos - OldRightPos;
            int deltaRight = CurrentLeftPos - OldLeftPos;
            int deltaPerpendicular = CurrentPerpendicularPos - OldPerpendicularPos;
            
            //find the delta in each direction + the heading
            double deltaTheta = inchesPerTick * (deltaRight - deltaLeft) / encoderWidth;
            double deltaX = inchesPerTick * (deltaRight + deltaLeft) / 2.0;
            double deltaY = inchesPerTick * (deltaPerpendicular - (deltaRight - deltaLeft) * perpendicularOffset / encoderWidth)
            
            //movements are added to the global position
            double theta = CURRENT_POS.h + (deltaTheta / 2.0);
            CURRENT_POS.x += deltaX * Math.cos(theta) - deltaY * Math.sin(theta);
            CURRENT_POS.y += deltaX * Math.sin(theta) + deltaY * Math.cos(theta);
            CURRENT_POS.h += deltaTheta
            
            telemetry.addData("X ", CURRENT_POS.x);
            telemetry.addData("Y ", CURRENT_POS.y);
            telemetry.addData("Heading ", CURRENT_POS.h);
        }
    }
  
}
