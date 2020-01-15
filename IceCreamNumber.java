import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class IceCreamNumber {

    public static void main(String[] args) throws FileNotFoundException{
        getWordCount("C:\\Users\\sk\\IdeaProjects\\JavaCourse\\src\\icecream.dat");
    }

    public static void getWordCount(String filename) throws FileNotFoundException{
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        double strawberryCounter = 0;
        double lines = 0;

        while (scanner.hasNextLine()) {
            lines++;
            if (scanner.nextLine().equals("Strawberry")) {
                strawberryCounter++;
            }
        }

        System.out.println("The total number of ice cream cones that were sold is: " + (int)lines);
        System.out.println("The total number of \"Strawberry\" cones that were sold is: " + (int)strawberryCounter);
        System.out.println("The percentage of cones that were Strawberry: " + (float)(strawberryCounter / lines * 100));
        scanner.close();
    }
}