import java.util.Scanner;

public class MinElementChallenge {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Enter the number of elements : ");
        int elements = scanner.nextInt();
        scanner.nextLine();
        int[] array = readIntegers(elements);
        System.out.println("Minimum value : " + findMin(array));
    }

    public static int[] readIntegers(int elements)
    {
        int[] array = new int[elements];
        int count = 1;
        while(count <= elements)
        {
            System.out.println("Enter number #" + count + " : ");
            boolean hasNextInt = scanner.hasNextInt();
            if(hasNextInt)
            {
                array[count-1] = scanner.nextInt();
                count += 1;
            }
            else
            {
                System.out.println("Enter valid number !");
            }
            scanner.nextLine();
        }
        scanner.close();
        return array;
    }

    public static int findMin(int[] array)
    {
        int minimumValue = array[0];
        for(int a : array)
        {
            if(a < minimumValue)
            {
                minimumValue = a;
            }
        }
        return minimumValue;
    }
}