import java.util.Arrays;

public class ReverseArrayChallenge {

    public static void main(String[] args) {

        int[] anArray = {1,2,3,4,5,6,7,8,9,10,11,12};
        reverse(anArray);

    }

    public static void reverse(int[] array)
    {
        //Method 1 - Assigning the 1st value of Array 1 to Last value of Array 2 & so on.

        int n = array.length;
        int[] reverseArray = new int[n];
        System.out.println("Original Array : " + Arrays.toString(array));

//        for (int i=0; i<array.length; i++)
//        {
//            reverseArray[n-1] = array[i];
//            n -= 1;
//        }

        // Below is the enhanced For Loop. Both above & below For Loops are correct.

        for (int value : array) {
            reverseArray[n - 1] = value;
            n -= 1;
        }

        System.out.println("Reversed Array : " + Arrays.toString(reverseArray));


        // Method 2 - Swapping 1st value with Last value and so on in the same array.

//        int n = array.length;
//        System.out.println("Original Array : " + Arrays.toString(array));
//        for (int i = 0; i < n/2; i++)
//        {
//            int temp = array[i];
//            array[i] = array[n-i-1];
//            array[n-i-1] = temp;
//        }
//        System.out.println("Reversed Array : " + Arrays.toString(array));
    }
}
