package LD.snakeandladder;

import java.util.Deque;
import java.util.LinkedList;

public class Game {

    Board board;
    Dice dice;
    Deque<Player> playerList = new LinkedList<>();
    // why deque bcz once played he will be removed from first and added to last
    Player winner;

    public Game(){
        initializeGame();
    }

    public void initializeGame(){
        board = new Board(10 , 5, 4);
        dice = new Dice(1);
        playerList.add(new Player("1", 0));
        playerList.add(new Player("2", 0));
        winner = null;
    }

    public void startGame(){
        while(winner == null){
           Player playerTurn = findPlayerTurn();

            System.out.println("Player : " + playerTurn.getId() + " is playing"+" at position : " + playerTurn.getCurrentPosition());

            int diceValue = dice.rollDice();

            //Get new position
            int newPosition = playerTurn.getCurrentPosition() + diceValue;
            newPosition = jumpCheck(newPosition);
            playerTurn.setCurrentPosition(newPosition);

            System.out.println("Player : " + playerTurn.getId() + " got dice value : " + diceValue + " and new position : " + playerTurn.getCurrentPosition());

            if(playerTurn.getCurrentPosition() >= board.cells.length*board.cells.length-1){
                winner = playerTurn;
                break;
            }

        }
        System.out.println("Winner is : " + winner.getId());
    }

    private Player findPlayerTurn() {
        Player player = playerList.removeFirst();
        playerList.addLast(player);
        return player;
    }

    private int jumpCheck(int newPosition){

        if(newPosition > board.cells.length*board.cells.length-1){
            return newPosition;
        }
        Cell cell = board.getCell(newPosition);
        if(cell.getJump()!=null && cell.getJump().getStart() == newPosition){
            String jumpBy = (cell.jump.start < cell.jump.end) ? "Ladder" : "Snake";
            System.out.println("Got "+jumpBy+" at position : "+newPosition);
            return cell.getJump().getEnd();
        }
        return newPosition;
    }
}
