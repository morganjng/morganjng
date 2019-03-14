import java.util.*;
import java.io.*;
public class TextMain{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        File file; Board b;
        try{
            file = new File("start.txt");
            b = new Board(6,6);
            b.startState(file);
        }catch(Exception e){        b = new Board(1,1);}

        int[][] tempBoard;
        do{
            tempBoard = b.getBoard();
            for(int i = 0; i < tempBoard.length; i++){
                for(int j = 0; j < tempBoard[i].length; j++){
                    if(j == tempBoard[i].length - 1){
                        System.out.print(" " + tempBoard[i][j] + "\n");
                    }else {
                        System.out.print(" " + tempBoard[i][j]);
                    }
                }
            }
            b.next();
            System.out.println("");
            scan.nextLine();
        }while(true);
    }
}
