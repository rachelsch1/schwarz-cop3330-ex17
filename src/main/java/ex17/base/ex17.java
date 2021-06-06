package ex17.base;

/* Sometimes you have to perform a more complex calculation based on some provided inputs and then use that result to make a determination.

Create a program that prompts for your weight, gender, total alcohol consumed (in ounces), and the amount of time since your last drink. Calculate your blood alcohol content (BAC) using this formula

BAC = (A × 5.14 / W × r) − .015 × H
where

A is total alcohol consumed, in ounces (oz).
W is body weight in pounds.
r is the alcohol distribution ratio:
0.73 for men
0.66 for women
H is number of hours since the last drink.
Display whether or not it’s legal to drive by comparing the blood alcohol content to 0.08.

Example Output
Your BAC is 0.08
It is not legal for you to drive.
Constraint
Prevent the user from entering non-numeric values.
 */

import java.util.Scanner;
import java.text.DecimalFormat;

public class ex17 {
    private static DecimalFormat df = new DecimalFormat("0.00");
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double alcConsumption = 0;
        double weight = 0;
        double time = 0;
        boolean isValid = false;

        while(!isValid) {
            System.out.print("What is your weight? ");
            if (input.hasNextDouble()) {
                weight = input.nextDouble();
                isValid = true;
            }
            else {
                System.out.println("Invalid input. Try again.");
            }
            input.nextLine();
        }

        System.out.print("Are you male or female? ");
        String sex = input.nextLine();

        isValid = false;
        while(!isValid) {
            System.out.print("How much alcohol have you consumed in ounces? ");
            if (input.hasNextDouble()) {
                alcConsumption = input.nextDouble();
                isValid = true;
            }
            else {
                System.out.println("Invalid input. Try again.");
            }
            input.nextLine();
        }

        isValid = false;
        while(!isValid) {
            System.out.print("How long has it been since your last drink in hours? ");
            if (input.hasNextDouble()) {
                time = input.nextDouble();
                isValid = true;
            }
            else {
                System.out.println("Invalid input. Try again.");
            }
            input.nextLine();
        }

        double bac = 0;

        if(sex.equals("male") || sex.equals("Male")) {
            bac = ((alcConsumption * 5.14) / (weight * 0.73)) - .015 * time;
        }
        if(sex.equals("female") || sex.equals("Female")) {
            bac = ((alcConsumption * 5.14) / (weight * 0.66)) - .015 * time;
        }

        System.out.println("Your BAC is " + df.format(bac));

        if(bac >= 0.08) {
            System.out.println("It is not legal for you to drive.");
        }
        else {
            System.out.println("It is legal for you to drive.");
        }
    }
}
