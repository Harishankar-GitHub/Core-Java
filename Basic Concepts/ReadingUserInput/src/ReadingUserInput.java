import java.util.Scanner;

public class ReadingUserInput {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter year of birth : ");

        Boolean hasNextInt = scanner.hasNextInt();
        // The above line returns true if the next input given by the user is an int.
        // It returns false if the input is not an int.

        if (hasNextInt)
        {
            int yearOfBirth = scanner.nextInt();
            scanner.nextLine();
            // In the above line, we use scanner.nextLine().
            // The reason is, after giving input to scanner.nextInt(), we press Enter in keyboard.
            // After this, subsequent inputs are not got from the user.
            // To solve this issue, we always use a scanner.nextLine() after scanner.nextInt().

            System.out.println("Enter your name : ");
            String name = scanner.nextLine();

            int age = 2019 - yearOfBirth;

            if (age >= 0 && age <= 100)
            {
                System.out.println("Your name is " + name + ", and you are " + age + " years old !");
            }
            else
            {
                System.out.println("Invalid year of birth !");
            }
        }
        else
        {
            System.out.println("Unable to parse year of birth !");
        }
        scanner.close();
    }

}
