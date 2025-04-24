package org.paumard.stream.patterns.BuilderPattern;

public class TestRobotBuilder {

    public static  void main(String[] args){
        RobotBuilder oldStyleRobot = new OldRobotBuilder();
       //Kind of blue print which type of of robot you want to make
        RobotEngineer engineer = new RobotEngineer(oldStyleRobot);
        // need someone to build a robot for us given blue print

        engineer.makeRobot();

        Robot  firstRobot = engineer.getRobot();
        System.out.println("Robot Built");

        System.out.println("Robot Head Type: " + firstRobot.getRobotHead());
        System.out.println("Robot Torso Type: " + firstRobot.getRobotTorso());
        System.out.println("Robot Legs Type: "+ firstRobot.getRobotLegs());
    }

}

