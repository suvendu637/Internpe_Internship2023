import java.util.Random;
import java.util.Scanner;

 class game {
    public int number;
    public int inputnumber;
    public int noofgusess=0;
    game()
    {
        Random ran=new Random();
        this.number=ran.nextInt(10);
    }
    public void takeuserinput()
    {
        System.out.println("GUSESS THE NUMBER");
        Scanner sc=new Scanner(System.in);
        inputnumber=sc.nextInt();
    }
    boolean iscorrectnumber()
    {
        noofgusess++;
        if(inputnumber==number)
        {
            System.out.printf("YES YOU GUSESS THE RIGHT NUMBER %d \n " +
                    "You pick it on %d attempt \n",number,noofgusess);
            return true;
        }
        else if (inputnumber<number)
        {
            System.out.println("TOO LOW......");
        }
        else if (inputnumber>number)
        {
            System.out.println("TOO HIGH.......");
        }

        return false;
    }
}
public class gusess_the_number
{
    public static void main(String[] args) {
        game g=new game();
        Boolean b=false;
        while (!b)
        {
            g.takeuserinput();
            b = g.iscorrectnumber();
            System.out.println(b);
        }
    }
}