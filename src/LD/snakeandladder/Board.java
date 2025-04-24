package LD.snakeandladder;

import java.util.concurrent.ThreadLocalRandom;

public class Board {

    Cell[][] cells;

    Board(int boardSize, int numberOfSnakes, int numberOfLadders){
        cells = new Cell[boardSize][boardSize];
        for(int i=0; i<boardSize; i++){
            for(int j=0; j<boardSize; j++){
                cells[i][j] = new Cell();
            }
        }

        addSnakesLadders(cells, numberOfSnakes, numberOfLadders);
    }

    private void addSnakesLadders(Cell[][] cells, int numberOfSnakes, int numberOfLadders){
        while(numberOfSnakes>0){
           int snakeHead = ThreadLocalRandom.current().nextInt(1, cells.length*cells.length + 1);
              int snakeTail = ThreadLocalRandom.current().nextInt(1, cells.length*cells.length + 1);
              if(snakeTail>= snakeHead){
                  continue;
              }

              Jump snakeObj= new Jump(snakeHead, snakeTail);
              Cell cell = getCell(snakeHead);
                cell.setJump(snakeObj);
                numberOfSnakes--;
        }

        while (numberOfLadders > 0) {
            int ladderStart = ThreadLocalRandom.current().nextInt(1, cells.length*cells.length + 1);
            int ladderEnd = ThreadLocalRandom.current().nextInt(ladderStart, cells.length*cells.length + 1);
            if (ladderEnd <= ladderStart) {
                continue;
            }
            Jump ladderObj = new Jump(ladderStart, ladderEnd);
            Cell cell = getCell(ladderStart);
            cell.setJump(ladderObj);
            numberOfLadders--;
        }
    }

    Cell getCell(int snakeHead) {

        int row = (snakeHead-1)/cells.length;
        int col = (snakeHead-1)%cells.length;
        return cells[row][col];
    }
}
