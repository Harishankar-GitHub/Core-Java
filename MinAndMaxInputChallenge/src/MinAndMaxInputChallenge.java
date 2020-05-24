import java.util.Scanner;

public class MinAndMaxInputChallenge {

    public static void main(String[] args) {

//        Scanner scanner = new Scanner(System.in);
//
//        int min = Integer.MAX_VALUE;
//        int max = Integer.MIN_VALUE;
//
//        while (true)
//        {
//            System.out.println("Enter number : ");
//            boolean isAnInt = scanner.hasNextInt();
//
//            if (isAnInt)
//            {
//                int number = scanner.nextInt();
//
//                if (number > max)
//                {
//                    max = number;
//                }
//                if (number < min)
//                {
//                    min = number;
//                }
//            }
//            else
//            {
//                break;
//            }
//            scanner.nextLine();
//        }
//        System.out.println("Min : " + min + " Max : " + max);
//        scanner.close();
//    }

// Another solution
        Scanner scanner = new Scanner(System.in);

        int count = 0;
        int min = 0;
        int max = 0;
        while (true)
        {
            System.out.println("Enter number : ");
            boolean isAnInt = scanner.hasNextInt();

            if (isAnInt)
            {
                int number = scanner.nextInt();
                count+=1;

                if (count == 1)
                {
                    min = number;
                    max = number;
                }

                if (number > max)
                {
                    max = number;
                }
                if (number < min)
                {
                    min = number;
                }
            }
            else
            {
                break;
            }
            scanner.nextLine();
        }
        System.out.println("Min : " + min + " Max : " + max);
        scanner.close();
    }
}
