package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Utils.Consts;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.kauailabs.navx.frc.AHRS;

public class Chassis extends SubsystemBase{

    private static CANSparkMax m_rightForwardChassisMotor, m_rightMidChassisMotor, m_rightBackChassisMotor, m_leftForwardChassisMotor, m_leftMidChassisMotor, m_leftBackChassisMotor;
    private static MotorControllerGroup m_rightChassisMotorGroup, m_leftChassisMotorGroup;
    private static Chassis m_chassis;
    public static AHRS m_ChassisNavXGyro;
    
    public Chassis() {
        m_ChassisNavXGyro = new AHRS();

        m_rightForwardChassisMotor = new CANSparkMax(Consts.ChassisConsts.RIGHT_FORWARD_CHASSIS_MOTOR_ID, MotorType.kBrushless);
        m_rightMidChassisMotor = new CANSparkMax(Consts.ChassisConsts.RIGHT_MID_CHASSIS_MOTOR_ID, MotorType.kBrushless);
        m_rightBackChassisMotor = new CANSparkMax(Consts.ChassisConsts.RIGHT_BACK_CHASSIS_MOTOR_ID, MotorType.kBrushless);
        m_leftForwardChassisMotor = new CANSparkMax(Consts.ChassisConsts.LEFT_FORWARD_CHASSIS_MOTOR_ID, MotorType.kBrushless);
        m_leftForwardChassisMotor = new CANSparkMax(Consts.ChassisConsts.LEFT_MID_CHASSIS_MOTOR_ID, MotorType.kBrushless);
        m_leftBackChassisMotor = new CANSparkMax(Consts.ChassisConsts.LEFT_BACK_CHASSIS_MOTOR_ID, MotorType.kBrushless);

        m_rightChassisMotorGroup = new MotorControllerGroup(m_leftBackChassisMotor, m_leftMidChassisMotor, m_leftForwardChassisMotor);
        m_leftChassisMotorGroup = new MotorControllerGroup(m_rightBackChassisMotor, m_rightMidChassisMotor, m_rightForwardChassisMotor);
    }

    public static void getChassis(){
        if (m_chassis == null)
            m_chassis = new Chassis();
    }

    public static void drive(double rSpeed, double lSpeed){
        m_rightChassisMotorGroup.set(rSpeed);
        m_leftChassisMotorGroup.set(lSpeed);
    }

    public static void setMode(IdleMode idleMode){
        m_rightForwardChassisMotor.setIdleMode(idleMode);
        m_rightMidChassisMotor.setIdleMode(idleMode);
        m_rightBackChassisMotor.setIdleMode(idleMode);
        m_leftForwardChassisMotor.setIdleMode(idleMode);
        m_leftMidChassisMotor.setIdleMode(idleMode);
        m_leftBackChassisMotor.setIdleMode(idleMode);

    }
    public static double getRightDistance(){
        return (m_rightForwardChassisMotor.getEncoder().getPosition() * Consts.ChassisConsts.POSITION_TO_DISTANCE);
    }

    public static double getLeftDistance(){
        return (m_leftForwardChassisMotor.getEncoder().getPosition() * Consts.ChassisConsts.POSITION_TO_DISTANCE);
    }
    
    public static AHRS getGyro(){
        return m_ChassisNavXGyro;
    }

    public static void stopChassis(){
        m_rightChassisMotorGroup.set(0);
        m_leftChassisMotorGroup.set(0);
    }
    
}
