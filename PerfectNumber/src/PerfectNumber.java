public class PerfectNumber {

    public static boolean isPerfectNumber (int number)
    {
        // Any number can be a Perfect Number if the sum of its positive divisors
        // excluding the number itself is equal to that number. For example, 28 is a perfect
        // number because 28 is divisible by 1, 2, 4, 7, 14 and 28 and the sum of these values
        // is 1 + 2 + 4 + 7 + 14 = 28.

        if (number < 1)
        {
            return false;
        }

        int sum = 0;

        for (int i = 1; i < number; i++)
        {
            if (number % i == 0)
            {
                sum = sum + i;
            }
        }
        return (sum == number);
    }
}
