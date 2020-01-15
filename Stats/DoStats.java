package Stats;

/*
 * Compute simple statistic using StatCalc.java
 */

import java.util.Scanner;

public class DoStats {

    public static void main(String[] args) {

        Scanner enter = new Scanner(System.in);

        StatCalc myStatCalc;
        myStatCalc = new StatCalc();

        double item; // Number entered by the user.

        System.out.println("Enter your numbers: (Enter '0' when ready)");

        do {
            System.out.print("Next number: ");
            item = enter.nextDouble();
            if (item != 0)
                myStatCalc.enter(item);
        } while (item != 0);

        System.out.println();
        System.out.println("--Your results--");
        System.out.println("Count: " + myStatCalc.getCount()); // Quantity of numbers in the data set.
        System.out.println("Mean: " + myStatCalc.getMean()); //  The mean or average of the numbers in the data se
        System.out.println("Standard Deviation: "+ myStatCalc.getStandardDeviation()); //The measure of variance (or dispersion) from the mean.

    } // end main()

} // end DoStats
