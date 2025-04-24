package LD.snakeandladder;

public class Cell {

    //Just jump object because cell is already defined by index
    //we just need there is a jump or not
    Jump jump;

    public Jump getJump() {
        return jump;
    }

    public void setJump(Jump jump) {
        this.jump = jump;
    }
}
