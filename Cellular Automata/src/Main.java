import javax.swing.*;
import javax.swing.text.Highlighter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main{
    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setSize(1500, 1500);

        JTextPane game = new JTextPane();
        game.setLocation(0, 0);
        game.setSize(1500, 1500);

        frame.add(game);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(null);

        Scanner scan = new Scanner(System.in);
        File file; Board b;

        try{
            //file = new File("start.txt");
            b = new Board();
            //b.startState(file);
        }catch(Exception e){
            b = new Board(1,1);
        }

        int[][] tempBoard = new int[128][128];
        String string;
        Random random = new Random();
        for(int i = 0; i < tempBoard.length; i++){
            for(int j = 0; j < tempBoard[i].length; j++){
                tempBoard[i][j] = Math.abs(random.nextInt() % 2);
            }
        }

        b.setBoard(tempBoard);

        while(true){
            string = "";
            tempBoard = b.getBoard();
            for(int i = 0; i < tempBoard.length; i++) {
                for (int j = 0; j < tempBoard[i].length; j++) {
                    if (j == tempBoard[i].length - 1) {
                        if(tempBoard[i][j] == 1){
                            string += "o \n";
                        }else{
                            string += "+ \n";
                        }
                    } else {
                        if(tempBoard[i][j] == 1){
                            string += "o ";
                        }else{
                            string += "+ ";
                        }
                    }
                }
            }
            game.setText(string);
            try {
                TimeUnit.SECONDS.sleep(1);
            }catch(InterruptedException e){

            }
            b.next();
            frame.repaint();
        }
    }
}
