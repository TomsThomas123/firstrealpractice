package frc.robot.outtake;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class outtake extends SubsystemBase {

  private final TalonFX outacke;

  private final VelocityVoltage velvol;

  public outtake() {
    outacke = new TalonFX(2);
    velvol = new VelocityVoltage(0);
    TalonFXConfiguration config = new TalonFXConfiguration();



    config.CurrentLimits.StatorCurrentLimit = OuttakeConstants.statcurlim;
    config.CurrentLimits.StatorCurrentLimitEnable = OuttakeConstants.statcurlim > 0;
    config.CurrentLimits.SupplyCurrentLimit = OuttakeConstants.suppcurlim;
    config.CurrentLimits.SupplyCurrentLimitEnable = OuttakeConstants.suppcurlim > 0;
    config.Slot0.kS = OuttakeConstants.KS;
    config.Slot0.kV = OuttakeConstants.KV;
    config.Slot0.kP = OuttakeConstants.KP;

    outacke.getConfigurator().apply(config);
  }

  public void setRps(double rps) {
    outacke.setControl(velvol.withVelocity(rps));
  }
}