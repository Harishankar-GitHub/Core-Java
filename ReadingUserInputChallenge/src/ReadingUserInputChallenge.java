import java.util.Scanner;

public class ReadingUserInputChallenge {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int count = 1;
        int sum = 0;

        while (count < 11)
        {
            System.out.println("Enter number #" + count + " : ");
            boolean isAnInt = scanner.hasNextInt();
            if (isAnInt)
            {
                int number = scanner.nextInt();
                sum = sum + number;
                count++;
            }
            else
            {
                System.out.println("Invalid !");
            }
            scanner.nextLine();
        }
        System.out.println("Sum = " + sum);
        scanner.close();

    }
}
