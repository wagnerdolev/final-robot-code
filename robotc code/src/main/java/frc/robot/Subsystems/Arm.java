package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.Utils.Consts;
public class Arm {
    public CANSparkMax m_firstArmMotor, m_secondArmMotor;
    private static Arm m_Arm;

    public Arm(){
        m_firstArmMotor = new CANSparkMax(Consts.ArmConsts.FIRST_ARM_MOTOR_ID, MotorType.kBrushless);
        m_secondArmMotor = new CANSparkMax(Consts.ArmConsts.SECOND_ARM_MOTOR_ID, MotorType.kBrushless);

        m_firstArmMotor.restoreFactoryDefaults();
        m_secondArmMotor.restoreFactoryDefaults();

        // config pid values of motor controllers
        m_firstArmMotor.getPIDController().setP(Consts.ArmConsts.FIRST_ARM_KP);
        m_firstArmMotor.getPIDController().setI(Consts.ArmConsts.FIRST_ARM_KI);
        m_firstArmMotor.getPIDController().setD(Consts.ArmConsts.FIRST_ARM_KD);
        m_firstArmMotor.getPIDController().setFF(Consts.ArmConsts.FIRST_ARM_KF);

        m_secondArmMotor.getPIDController().setP(Consts.ArmConsts.SECOND_ARM_KP);
        m_secondArmMotor.getPIDController().setI(Consts.ArmConsts.SECOND_ARM_KI);
        m_secondArmMotor.getPIDController().setD(Consts.ArmConsts.SECOND_ARM_KD);
        m_secondArmMotor.getPIDController().setFF(Consts.ArmConsts.SECOND_ARM_KF);

        m_firstArmMotor.getEncoder().setPositionConversionFactor(Consts.ArmConsts.FIRST_ARM_GEAR_RATIO * 360);
        m_secondArmMotor.getEncoder().setPositionConversionFactor(Consts.ArmConsts.SECOND_ARM_GEAR_RATIO * 360);

    }

    public static Arm getInstance(){
        if(m_Arm == null){
            m_Arm= new Arm();
        }
        return m_Arm;
    }

    public void turnFirstTo(double angle){
        m_firstArmMotor.getPIDController().setReference(angle, ControlType.kPosition);
    }

    public void turnSecondTo(double angle){
        m_secondArmMotor.getPIDController().setReference(angle, ControlType.kPosition);
    }

    
    public double getFirstArmAngle(){
        return m_firstArmMotor.getEncoder().getPosition();
    }

    public double getSecondArmAngle(){
        return m_secondArmMotor.getEncoder().getPosition();
    }

    public void setFirstArmIdleMode(IdleMode firstArmMode){
        m_firstArmMotor.setIdleMode(firstArmMode);
    }

    public void setFSecondArmIdleMode(IdleMode secondArmMode){
        m_firstArmMotor.setIdleMode(secondArmMode);
    }
}
