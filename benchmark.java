/**The array size is: 1000
*Time to sort it with selection sort: 3
*Time to sort it with Arrays.sort: 1
 * */
/**The array size is: 10000
 *Time to sort it with selection sort: 43
 *Time to sort it with Arrays.sort: 3
 * */
/**The array size is: 100000
 *Time to sort it with selection sort: 3891
 *Time to sort it with Arrays.sort: 11
 * */

import java.util.Arrays;

public class benchmark {

    public static void main(String[] arguments) {
        int size = 100000; // the size of the arrays
        int[] a = new int[size];
        int[] b = new int[size];

        // fill arrays with random values
        for (int i = 0; i < a.length; i++) {
            a[i] = (int)(Integer.MAX_VALUE * Math.random());
            b[i] = (int)(Integer.MAX_VALUE * Math.random());
        }

        //System.out.println("Random array A: " + Arrays.toString(a)); // print the original array A

        // benchmark sorting with selection sort
        long startTime1 = System.currentTimeMillis();
        //selection sort
        for (int lastPlace = a.length-1; lastPlace > 0; lastPlace--) {
            int maxLoc = 0;
            for (int j = 1; j <= lastPlace; j++) {
                if (a[j] > a[maxLoc]) {
                    maxLoc = j;
                }
            }
            int temp = a[maxLoc];
            a[maxLoc] = a[lastPlace];
            a[lastPlace] = temp;
        } // end of selection sort
        long runTime1 = System.currentTimeMillis() - startTime1;

        System.out.println("The array size is: " + size); //print the array size

        //System.out.println("Sorted array A: " + Arrays.toString(a)); // print the sotred array A
        System.out.println("Time to sort it with selection sort: " + runTime1); // print the time to sort with selection sort

        //System.out.println("Random array B: " + Arrays.toString(b)); // print the original array B

        // benchmark sorting with Arrays.sort
        long startTime2 = System.currentTimeMillis();
        Arrays.sort(b);
        long runTime2 = System.currentTimeMillis() - startTime2;

        //System.out.println("Sorted array B " + Arrays.toString(b)); // print the sotred array A
        System.out.println("Time to sort it with Arrays.sort: " + runTime2); // print the time to sort with Arrays.sort
    }
}