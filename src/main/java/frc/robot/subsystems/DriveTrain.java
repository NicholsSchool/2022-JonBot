/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import frc.robot.RobotMap;

public class DriveTrain extends SubsystemBase {

  private WPI_TalonSRX lFLeader;
  private WPI_TalonSRX lFFollower;

  private WPI_TalonSRX lBLeader;
  private WPI_TalonSRX lBFollower;

  private WPI_TalonSRX rFLeader;
  private WPI_TalonSRX rFFollower;

  private WPI_TalonSRX rBLeader;
  private WPI_TalonSRX rBFollower;

  private DifferentialDrive drive;

  public DriveTrain() {

    lFLeader = new WPI_TalonSRX(RobotMap.LEFT_FRONT_LEADER_ID);
    lFFollower = new WPI_TalonSRX(RobotMap.LEFT_FRONT_FOLLOWER_ID);

    lBLeader = new WPI_TalonSRX(RobotMap.LEFT_BACK_LEADER_ID);
    lBFollower = new WPI_TalonSRX(RobotMap.LEFT_BACK_FOLLOWER_ID);

    rFLeader = new WPI_TalonSRX(RobotMap.RIGHT_FRONT_LEADER_ID);
    rFFollower = new WPI_TalonSRX(RobotMap.RIGHT_FRONT_FOLLOWER_ID);

    rBLeader = new WPI_TalonSRX(RobotMap.RIGHT_BACK_LEADER_ID);
    rBFollower = new WPI_TalonSRX(RobotMap.RIGHT_BACK_FOLLOWER_ID);

    lFFollower.set(ControlMode.Follower, RobotMap.LEFT_FRONT_LEADER_ID);

    lBFollower.set(ControlMode.Follower, RobotMap.LEFT_BACK_LEADER_ID);

    rFFollower.set(ControlMode.Follower, RobotMap.RIGHT_FRONT_LEADER_ID);

    rBFollower.set(ControlMode.Follower, RobotMap.RIGHT_BACK_LEADER_ID);

    drive = new DifferentialDrive(new SpeedControllerGroup(lFLeader, lBLeader),
        new SpeedControllerGroup(rFLeader, rBLeader));
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void move(double leftSpeed, double rightSpeed)
  {
    drive.tankDrive(leftSpeed, rightSpeed);
  }
}
