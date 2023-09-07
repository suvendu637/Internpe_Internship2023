
import java.util.Objects;
import java.util.Scanner;

public class Connect_4_Line {

    String[][] board;
    Boolean winner;
    Boolean draw;
    int winningplayer;
    int playerturn;

    public  Connect_4_Line()
    {
        winningplayer = 0;
        draw = false;
        playerturn = 1;
        board = new String[6][7];
        newboard();;
        displayboard();
    }

    private  void newboard()
    {
        for (int i=0;i<6 ;i++)
        {
            for (int j=0;j<7;j++)
            {
                board[i][j]=" - ";
            }
        }
    }

    private  void displayboard()
    {
        System.out.println(" ");
        System.out.println("     ***  CONNECT 4 ***");
        System.out.println(" ");
        for (int i=0; i<6 ;i++)
        {
            for (int j=0;j<7 ;j++)
            {
                System.out.print(board[i][j]);

            }
            System.out.println();
        }
        System.out.println();
    }
private  boolean validinput(String input)
{
    return ((Objects.equals(input,"1") ||
            Objects.equals(input,"2") ||
            Objects.equals(input,"3") ||
            Objects.equals(input,"4") ||
            Objects.equals(input,"5") ||
            Objects.equals(input,"6") ||
            Objects.equals(input,"7")));

}
private  boolean iscolumnfull(int column)
{
    return (board[0] [column-1] == " x " || board[0][column-1] == " 0 ");
}
private  int getNextAvalibleSlot(int column)
{
    int position=5;
    boolean found =false;
    while(position>= 0 && !found)
    {
        if (!Objects.equals((board[position][column]), " x ") && !Objects.equals(board[position][column]," 0 "))
        {
            found = true;
        }
        else
        {
            position--;
        }
    }
    return position;
}


private void SwapPlayerTurn()
{
    if(playerturn == 1)
    {
        playerturn =2;
    }
    else
    {
        playerturn=1;
    }
}

private void PlacePiece()
{
    Scanner sc=new Scanner(System.in);
    System.out.println("player "+playerturn + " _ please select which column to place your piece (1--7");
    String input= sc.nextLine();

    while (!validinput(input) || iscolumnfull(Integer.parseInt(input)))
    {
        while (!validinput(input))
        {
            System.out.println("Invalid input - please select a column from 1 - 7");
            input = sc.nextLine();
        }
        while (iscolumnfull(Integer.parseInt(input)))
        {
            System.out.println("column full , choose another column");
            input= sc.nextLine();
            if (!validinput(input))
            {
                break;
            }
        }
    }
    int columnChoice =Integer.parseInt(input) -1;

    System.out.println("Next avalible row in column : " + getNextAvalibleSlot(columnChoice));
    String pieceToPlace;
    if (playerturn == 1)
    {
        pieceToPlace = " x ";
    }
    else {
        pieceToPlace= " 0 ";
    }
    board[getNextAvalibleSlot(columnChoice)][columnChoice] =pieceToPlace;
    displayboard();
    SwapPlayerTurn();

}

private  boolean isBoardfull()
{
    boolean full = true;
    for (int i=0 ; i<1 ;i++)
    {
        for (int j=0 ;j<7 ;j++)
        {
            if (board[i][j] != " x " && board[i][j] != " 0 ")
            {
                full = false;
            }
        }
    }
    return full;
}
private  String CheckVerticalWinner()
{
    String symbol=null;
    for (int i=0 ; i<3;i++)
    {
        for (int j=0 ;j<7 ;j++)
        {
            if((board[i][j] == board[i+1][j]) &&  (board[i][j] == board[i+2][j] )  && (board[i][j] == board[i+3][j]))
            {
               if (board[i][j] == " x " || board[i][j] == " 0 ")
               {
                   symbol=board[i][j];
               }
            }
        }
    }
    return  symbol;
}


    private  String CheckHorizontalWinner()
    {
        String symbol=null;
        for (int i=0 ; i<6;i++)
        {
            for (int j=0 ;j<4 ;j++)
            {
                if((board[i][j] == board[i][j+1]) &&  (board[i][j] == board[i][j+2] )  && (board[i][j] == board[i][j+3]))
                {
                    if (board[i][j] == " x " || board[i][j] == " 0 ")
                    {
                        symbol=board[i][j];
                    }
                }
            }
        }
        return  symbol;
    }


    private  String CheckLeftDiagonalWinner()
    {
        String symbol=null;
        for (int i=0 ; i<3;i++)
        {
            for (int j=0 ;j<4 ;j++)
            {
                if((board[i][j] == board[i+1][j+1]) &&  (board[i][j] == board[i+2][j+2] )  && (board[i][j] == board[i+3][j+3]))
                {
                    if (board[i][j] == " x " || board[i][j] == " 0 ")
                    {
                        symbol=board[i][j];
                    }
                }
            }
        }
        return  symbol;
    }

    private  String CheckRightDiagonalWinner()
    {
        String symbol=null;
        for (int i=0 ; i<3;i++)
        {
            for (int j=3 ;j<7 ;j++)
            {
                if((board[i][j] == board[i+1][j-1]) &&  (board[i][j] == board[i+2][j-2] )  && (board[i][j] == board[i+3][j-3]))
                {
                    if (board[i][j] == " x " || board[i][j] == " 0 ")
                    {
                        symbol=board[i][j];
                    }
                }
            }
        }
        return  symbol;
    }

private  int CheckForWinner()
{
    int winner=0;
    String symbol=" ";
    if (CheckVerticalWinner() == " x " || CheckVerticalWinner() == " 0 ")
    {
        symbol=CheckVerticalWinner();
    }
    else if (CheckHorizontalWinner() == " x "  || CheckHorizontalWinner() == " 0 ")
    {
        symbol=CheckHorizontalWinner();
    }
    else if (CheckLeftDiagonalWinner() == " x " || CheckLeftDiagonalWinner() == " 0 " )
    {
        symbol=CheckLeftDiagonalWinner();
    }
    else if (CheckRightDiagonalWinner() == " x " || CheckRightDiagonalWinner()== " 0 ")
    {
    symbol=CheckRightDiagonalWinner();   //gives error
    }
    if (symbol == " x ")
    {
        winner=1;
    }
    else if (symbol==" 0 ")
    {
    winner=2;
    }
    return winner;
}
private  boolean CheckForDraw()
{
    return (isBoardfull() ==true && (CheckForWinner() !=1 && CheckForWinner() != 2));
}

private  void ShowWinner()
{
    System.out.println(" ");
    System.out.println("*******************************");
    System.out.println( " PLAYER " +winningplayer + " Wins !!!!");
    System.out.println("****************************");
}
public void playgame()
{while (winningplayer==0)
{
    winningplayer=CheckForWinner();
    draw=CheckForDraw();
    if (winningplayer==1)
    {
        ShowWinner();
        break;
    }
    else if (winningplayer ==2 )
    {
        ShowWinner();break;

    }
    else if (draw==true)
    {
        System.out.println("it is draw");
        break;
    }
    PlacePiece();

}

}


    public static void main(String[] args) {
Connect_4_Line c4=new Connect_4_Line();
c4.playgame();
    }
}
