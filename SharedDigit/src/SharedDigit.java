public class SharedDigit {

    public static boolean hasSharedDigit (int num1, int num2)
    {
        if ((num1 >= 10 && num1 <= 99) && (num2 >= 10 && num2 <= 99))
        {
            int num1A = num1 % 10;
            int num1B = num1 /10;
            int num2A = num2 % 10;
            int num2B = num2 / 10;
            if (num1A == num2A || num1A == num2B || num1B == num2A || num1B == num2B)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        return false;
    }
}
