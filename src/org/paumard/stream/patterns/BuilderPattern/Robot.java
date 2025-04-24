package org.paumard.stream.patterns.BuilderPattern;

public class Robot implements  RobotPlan{
    private String head;
    private String torso;
    private String arms;
    private String legs;

    @Override
    public void setRobotHead(String head) {
      this.head = head;
    }

    public String getRobotHead(){ return this.head;}

    @Override
    public void setRobotTorso(String Torso) {
        this.torso = Torso;
    }

    public String getRobotTorso(){ return this.torso;}

    @Override
    public void setRobotArms(String arms) {
        this.arms = arms;
    }
    public String getRobotArms(){ return this.arms;}

    @Override
    public void setRobotLegs(String legs) {
        this.legs = legs;
    }
    public String getRobotLegs(){ return this.legs;}
}
