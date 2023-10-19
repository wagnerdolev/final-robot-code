package frc.robot.SubSystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import frc.robot.Utils.Consts;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Claw extends SubsystemBase {
    private static Claw m_Claw;
    private static TalonSRX m_clawMotor;
    private static CANSparkMax m_rightClawMotor, m_leftClawMotor;
    private static MotorControllerGroup m_ClawRollersMotorControllerGroup;

    public Claw() {
        m_clawMotor = new TalonSRX(Consts.ClawConsts.CLAW_MOTOR);

        m_rightClawMotor = new CANSparkMax(Consts.ClawConsts.RIGHT_CLAW_ROLLERS_MOTOR, MotorType.kBrushless);
        m_leftClawMotor = new CANSparkMax(Consts.ClawConsts.LEFT_CLAW_ROLLERS_MOTOR, MotorType.kBrushless);

        m_ClawRollersMotorControllerGroup = new MotorControllerGroup(m_rightClawMotor, m_leftClawMotor);
    }

    public static Claw getInstance(){
        if (m_Claw == null){
            m_Claw = new Claw();
        }
        return m_Claw;
    }

    public static void clawMotor(double motorSpeed){
        m_clawMotor.set(ControlMode.PercentOutput, motorSpeed);
    }

    public static void clawRollers(double rollersSpeed){
        m_ClawRollersMotorControllerGroup.set(rollersSpeed);
    }

    public static void openClaw(){
        clawMotor(Consts.ClawConsts.CLAW_OPEN_SPEED);
    }

    public static void closeClaw(){
        clawMotor(Consts.ClawConsts.CLAW_CLOSE_SPEED);
    }

    public static void ROLLERS_OUTSIDE_SPEED(){
        m_ClawRollersMotorControllerGroup.set(Consts.ClawConsts.ROLLERS_OUTSIDE_SPEED);
    }

    public static void ROLLERS_INSIDE_SPEED(){
        m_ClawRollersMotorControllerGroup.set(Consts.ClawConsts.ROLLERS_INSIDE_SPEED);
    }
}
