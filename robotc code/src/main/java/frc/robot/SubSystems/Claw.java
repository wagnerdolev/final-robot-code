package frc.robot.SubSystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import frc.robot.Utils.Consts;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Claw extends SubsystemBase {
    private static Claw m_Claw;
    private static TalonSRX m_clawMotor;
    private static CANSparkMax m_rightClawMotor, m_leftClawMotor;
    private static MotorControllerGroup m_ClawRollersMotorControllerGroup;
    private static DigitalInput m_limitSwitchOpen;
    private static DigitalInput m_limitSwitchCube;
    private static DigitalInput m_limitSwitchCone;

    public Claw() {
        m_clawMotor = new TalonSRX(Consts.ClawConsts.CLAW_MOTOR);

        m_rightClawMotor = new CANSparkMax(Consts.ClawConsts.RIGHT_CLAW_ROLLERS_MOTOR, MotorType.kBrushless);
        m_leftClawMotor = new CANSparkMax(Consts.ClawConsts.LEFT_CLAW_ROLLERS_MOTOR, MotorType.kBrushless);

        m_limitSwitchOpen = new DigitalInput(0);
        m_limitSwitchCube = new DigitalInput(0);
        m_limitSwitchCone = new DigitalInput(0);


        m_ClawRollersMotorControllerGroup = new MotorControllerGroup(m_rightClawMotor, m_leftClawMotor);
    }

    public static Claw getInstance(){
        if (m_Claw == null){
            m_Claw = new Claw();
        }
        return m_Claw;
    }

    

    public void openClaw(){
        m_clawMotor.set(ControlMode.PercentOutput, Consts.ClawConsts.CLAW_OPEN_SPEED);
    }

    public void closeClaw(){
        m_clawMotor.set(ControlMode.PercentOutput, Consts.ClawConsts.CLAW_CLOSE_SPEED);
    }

    public void rollersOutside(){
        m_ClawRollersMotorControllerGroup.set(Consts.ClawConsts.ROLLERS_OUTSIDE_SPEED);
    }

    public void RollersInside(){
        m_ClawRollersMotorControllerGroup.set(Consts.ClawConsts.ROLLERS_INSIDE_SPEED);
    }

    public void stopRollers(){
        m_ClawRollersMotorControllerGroup.set(0);
    }

    public void stopClaw(){
        m_clawMotor.set(ControlMode.PercentOutput, 0);
    }

    public boolean getlimitSwitchOpenBool(){
        return m_limitSwitchOpen.get();
    }

    public boolean getlimitSwitchCubeBool(){
        return m_limitSwitchCube.get();
    }

    public boolean getlimitSwitchConeBool(){
        return m_limitSwitchCone.get();
    }
}
