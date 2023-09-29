import java.io.*;
class game{
    public static void main(String args[])
    {
        System.out.println("Welcome To The Game...");
        Console con=System.console();
        int random=(int)(Math.random()*100);
        System.out.print("Wait! while I am generating a random number..."+"\nEnter your guess:");
        
        for(int i=5;i>0;i--)
        {
            int guess=Integer.parseInt(con.readLine());
            if(random==guess)
            {
                System.out.println("Congratulation!!!!! You Won The Game");
                break;
            }
            else
            {
                if(guess>random)
                {
                    System.out.println("Your Guess Number Is Greater Than Number...");
                    
                }
                else if(guess<random){
                    System.out.println("Your Guess Number Is Less Than Number...");
                    
                }
                 System.out.println("You Have "+(i-1)+" tries Left");
                 if(i==1)
                 {
                    System.out.println("You Lose the Game:::::  Better Luck Next Time....");
                 }
            }
        }
    }
}