public class SnakeEyes {

    public static void main(String[] arguments) {
        int die1;
        int die2;
        int i;
        int counter1 = 0;
        int counter2 = 0;

        // counter number of rolls before "Snake Eyes"
        while(true) {
            die1 = (int) (Math.random() * 6) + 1;
            die2 = (int) (Math.random() * 6) + 1;
            counter1 ++;
            if (die1 == 1 && die2 == 1) {
                System.out.println("Number of rolls of the dice before we got snake eyes is " + counter1);
                break;
            }
        }

        //number of "Snake Eyes" in 1000 rolls
        for (i = 1; i<= 1000; i++) {
            die1 = (int) (Math.random() * 6) + 1;
            die2 = (int) (Math.random() * 6) + 1;
            if (die1 == 1 && die2 == 1) {
                counter2 ++;
            }
        }

        System.out.println("The average number of rolls required to get snake eyes for 1000 rolls is " + counter2);
    }
}