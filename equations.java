import java.util.Scanner;

public class equations {

    /**
     * Returns the larger of the two roots of the quadratic equation
     * A*x*x + B*x + C = 0, provided it has any roots.  If A == 0 or
     * if the discriminant, B*B - 4*A*C, is negative, then an exception
     * of type IllegalArgumentException is thrown.
     */
    static public double root( double A, double B, double C )
            throws IllegalArgumentException {
        if (A == 0) {
            throw new IllegalArgumentException("A can't be zero.");
        }
        else {
            double disc = B*B - 4*A*C;
            if (disc < 0)
                throw new IllegalArgumentException("Discriminant < zero.");
            return  (-B + Math.sqrt(disc)) / (2*A);
        }
    }
    /**
     * @return the result of execution 'root' method
     */
    static public String answer() {
        Scanner input = new Scanner(System.in);

        System.out.print("Please enter A: ");
        double A = Double.parseDouble(input.nextLine());
        System.out.print("Please enter B: ");
        double B = Double.parseDouble(input.nextLine());
        System.out.print("Please enter C: ");
        double C = Double.parseDouble(input.nextLine());

        return ("The larger of the two roots is " + root(A, B, C));
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);


        while (true) {
            System.out.print("Do you have an equation? (Print 'Yes' or 'No'): ");
            String decision = input.nextLine();
            if (decision.equals("Yes")) {
                System.out.println(answer());
            }
            if (decision.equals("No")) {
                break;
            }
        }

    }
}
