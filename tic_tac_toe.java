

import java.util.Scanner;

public class tic_tac_toe {
    public static void main(String[] args) {
        char [][] board=new char[3][3];
        for (int row=0 ; row<board.length ; row++)
        {
            for (int col=0 ;col<board.length ;col++)
            {
                board[row][col]=' ';
            }
        }
        char player= 'X';
        boolean gameover=false;
        Scanner scanner=new Scanner(System.in);

        while(!gameover)
        {
            printBoard(board);
            System.out.println("player " + player +" enter");
            int row=scanner.nextInt();
            int col=scanner.nextInt();
            System.out.println();

            if (board[row][col] == ' ')
            {
                board[row][col] =player;
                gameover=havewon(board,player);
                if (gameover)
                {
                    System.out.println("player  "+player+" has won");
                }
                else
                {
                    if (player == 'X')
                    {
                        player ='O';
                    }
                    else
                    {
                        player = 'X';
                    }
                }
            }
            else {
                System.out.println("invalid move . Try again!");
            }
        }
        printBoard(board);
    }
    public  static boolean havewon(char[][] board,char player)
    {
        // CHESK THE ROWS
        for (int row=0 ; row<board.length ; row++)
        {
            if (board[row] [0] ==player && board[row] [1] ==player && board[row] [2] ==player ) {
                return true;
            }
        }
        //CHECK THE COLOUM
        for (int col=0 ; col<board[0].length ; col++)
        {
            if (board[0] [col] ==player && board[1] [col] ==player && board[2] [col] ==player ) {
                return true;
            }
        }
        //CHECK FOR DIAGONAL
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player )
        {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player )
        {
            return true;
        }
        return false;
    }

    public  static void printBoard(char[][] board)
    {
        for (int row=0 ; row<board.length ; row++)
        {
            for (int col=0 ;col<board.length ;col++)
            {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println( );
        }
    }
}
