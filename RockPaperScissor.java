import java.util.Scanner;
import java.util.Random;
public class RockPaperScissor
{
    public static void main(String[] args)
    {
        //0 for ROCK
        //1 FOR PAPER
        //2 OR SCISSOR
        int i;
        int a=0,b=0,c=0;
        Scanner input=new Scanner(System.in);
        for(i=0;i<5;i++)
        {
            System.out.println("ENTER 0 FOR ROCK -- 1 FOR PAPER -- 2 FOR SCISSOR");
            int userinput = input.nextInt();

            Random random = new Random();
            int computerinput = random.nextInt(3);

            if (computerinput == userinput)
            {
                System.out.println("DRAW");
                a=a+1;
            }
            else if (userinput == 0 && computerinput == 2 || userinput == 2 
            && computerinput == 1 || userinput == 1 && computerinput == 0)
            {
                System.out.println("YOU WIN");
                b=b+1;
            }
            else
            {
                System.out.println("COMPUTER WIN");
                c=c+1;
            }
            System.out.println("COMPUTER INPUT IS =" + computerinput);
            if(computerinput==0)
                System.out.println("computer input :ROCK");
            else if(computerinput==1)
                System.out.println("computer choice :PAPER");
            else if(computerinput==2)
                System.out.println("computer choice :SCISSOR");
        }
        System.out.println("value of a "+a);
        System.out.println("value of b "+b);
        System.out.println("value of c "+c);

    }
}