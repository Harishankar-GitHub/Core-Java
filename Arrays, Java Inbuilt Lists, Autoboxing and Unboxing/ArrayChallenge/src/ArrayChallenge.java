import java.util.Arrays;
import java.util.Scanner;

public class ArrayChallenge {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        
        int[] arrays = getIntegers(5);
        int[] sortedArray = sortIntegers(arrays);
        printArray(sortedArray);
//        System.out.println(Arrays.toString(sortedArray));
        // Instead of calling the method to print, we can print using the above line also.
    }

    public static int[] getIntegers(int capacity)
    {
        int[] array = new int[capacity];
        System.out.println("Enter " + capacity + " integer values : \r");
        for (int i=0; i<array.length; i++)
        {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static void printArray(int[] array)
    {
        for (int i=0; i<array.length; i++)
        {
            System.out.println("Element " + i + " is " + array[i]);
        }
    }

    public static int[] sortIntegers(int[] array)
    {
        int[] sortedArray = Arrays.copyOf(array, array.length);
        boolean flag = true;
        while(flag)
        {
            flag = false;
            for (int i=0; i<sortedArray.length-1; i++)
            {
                if (sortedArray[i] < sortedArray[i+1])
                {
                    int temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i+1];
                    sortedArray[i+1] = temp;
                    flag = true;
                }       
            }
        }
        return sortedArray;
        // Sort Descending 	- if (sortedArray[i] < sortedArray[i+1])
        // Sort Ascending	- if (sortedArray[i] > sortedArray[i+1])
    }
}