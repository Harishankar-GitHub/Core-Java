import java.util.Scanner;

public class InputCalculator {

    public static void inputThenPrintSumAndAverage()
    {
        int sum = 0;
        long average = 0;
        int count = 0;
        Scanner scanner = new Scanner(System.in);
        while (true)
        {
            boolean isAnInt = scanner.hasNextInt();
            if (isAnInt)
            {
                int number = scanner.nextInt();
                sum = sum + number;
                count++;
                scanner.nextLine();
            }
            else
            {
                break;
            }

        }
        scanner.close();
        average = Math.round((double) sum / count);
        System.out.println("SUM = " + sum + " AVG = " + (int) average);
    }
}