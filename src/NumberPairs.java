/*
Design an application that will prompt the user for the numerical value of two cards. The program will receive
the two numbers and display their sum on the screen. If the calculated sum is 21, an asterisk is to be displayed
beside the sum.

The program shall end when two zeros are entered.The program shall print a welcome message when it is first started
and an goodbye message when it terminates.

Bonus:
Modify the application to allow the user to enter the face cards as J,Q,K or A. If the user enters J, Q, or K then
convert the entered value to 10. If the user enters A then count the value as 11 points.

Bonus Bonus:
Modify the algorithm to allow the user who receives the A to designate it either as 1 or 11.
 */


import java.util.Scanner;

public class NumberPairs {
    public static Scanner sc = new Scanner(System.in);
    public static int evaluateTwoNums(String input1, String input2) {
        int num1,num2,sum = 0;

        num1 = faceValues(input1);
        num2 = faceValues(input2);
        sum = num1 + num2;

        return sum;
    }

    public static int faceValues(String input) {
        int toReturn;
        if(input.equalsIgnoreCase("J") || input.equalsIgnoreCase("Q") ||
            input.equalsIgnoreCase("K"))
            toReturn = 10;
        else if(input.equalsIgnoreCase("A")) {
            System.out.println("What value do you want for A? 1 or 11");
            toReturn = sc.nextInt();
        } else
            toReturn = Integer.valueOf(input);

        return toReturn;
    }


    public static void main(String[] args) {
        String input1,input2;
        boolean toQuit = true;
        int sum;

        System.out.println("Welcome the Number Pairs!");

        while(toQuit){
            System.out.print("Please enter 2 cards separated by a space: or \"0 0\": ");
            input1 = sc.next();
            input2 = sc.next();

            sum = evaluateTwoNums(input1,input2);
            if(sum == 21)
                System.out.println("Your sum is : " + sum + "*");
            else
                System.out.println("Your sum is: " + sum);

            if(sum == 0) // quit program if user enters two 0s
                toQuit = false;
        }

        System.out.println("Thanks for using Number Pairs!");
    }
}
