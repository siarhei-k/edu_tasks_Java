import java.util.Scanner;

/***
 * The program takes the non-negative integer N as a users input
 * and print N's factorial and fibonacchi
 ***/

public class FactorialFibonacci {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num;
        System.out.println("Enter an integer to count : ");
        num = sc.nextInt();
        System.out.println("Factorial of "+num+" = "+factorial(num)+"");
        System.out.println("Fibonacci of "+num+" = "+fibonacci(num)+"");
    }

    static long factorial(int num)
    {
        if (num>=1)
            return num*factorial(num-1);
        else
            return 1;
    }
    static int fibonacci(int num)
    {
        if (num == 1||num==0)
        {
            return 1;
        }
        else if(num>1)
        {
            int result= fibonacci(num - 1) + fibonacci(num - 2);
            System.out.print(result + " ");
            return result;
        }
        else {
            return 0;
        }
    }



}