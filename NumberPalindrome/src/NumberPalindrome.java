public class NumberPalindrome {

    public static boolean isPalindrome (int number)
    {
        int temp = number;
        int sum = 0;
        while (number > 0 || number < 0)
        {
            int lastDigit = number % 10;
            sum = (sum * 10) + lastDigit;
            number = number / 10;
        }

        if (temp == sum)
        {
            return true;
        }
        return false;
    }
}
