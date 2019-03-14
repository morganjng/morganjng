import java.io.*;
import java.util.Scanner;

public class Board {
    public Board(int rows, int columns){
        x = rows;
        y = columns;
        board = new int[x][y];
    }

    public Board(){

    }

    public void startState(File file){
        Scanner scan;
        try {
            scan = new Scanner(file);
        }catch(FileNotFoundException e){
            System.out.println(e);
            return;
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                board[i][j] = scan.nextInt() % 2;
            }
        }
    }

    public void next(){
        int newBoard[][] = new int[x][y];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(checkCell(i, j)){
                    newBoard[i][j] = 1;
                }else{
                    newBoard[i][j] = 0;
                }
            }
        }
        board = newBoard;
    }

    private boolean checkCell(int row, int col){
        int aliveNeighbors = 0, deadNeighbors = 8;
        int[][] neighbors = new int[3][3];
        for(int i = 0 ; i < 3; i++){
            for(int j = 0; j < 3; j++){
                try{
                    neighbors[i][j] = board[row - 1 + i][col - 1 + j];
                }catch(ArrayIndexOutOfBoundsException e){
                    neighbors[i][j] = 0;
                }
            }
        }
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                aliveNeighbors += neighbors[i][j];
            }
        }
//        for(int i = 0; i < neighbors.length; i++){
//            for(int j = 0; j < neighbors[i].length; j++) {
//                if(j == neighbors[i].length - 1) {
//                    System.out.print(" " + neighbors[i][j] + "\n");
//                }else{
//                    System.out.print(" " + neighbors[i][j]);
//                }
//            }
//         }
//        System.out.println(aliveNeighbors);
        if(aliveNeighbors < 2){
            return false;
        }else if((aliveNeighbors == 3 || aliveNeighbors == 4) && neighbors[1][1] == 1){
            return true;
        }else if(aliveNeighbors > 3){
            return false;
        }else if((aliveNeighbors == 3) && neighbors[1][1] == 0){
            return true;
        }
        return false;
    }

    public void setBoard(int[][] b){
        board = b;
        x = board.length;
        y = board[0].length;
    }

    public int[][] getBoard(){
        return board;
    }

    private int[][] board;
    private int x;
    private int y;
}
