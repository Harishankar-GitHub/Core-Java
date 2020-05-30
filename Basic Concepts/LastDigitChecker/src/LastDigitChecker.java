public class LastDigitChecker {

    public static boolean hasSameLastDigit (int firstNum, int secondNum, int thirdNum)
    {
        if (isValid(firstNum) && isValid(secondNum) && isValid(thirdNum))
        {
            int AlastDigit = firstNum % 10;
            int BlastDigit = secondNum % 10;
            int ClastDigit = thirdNum % 10;

            if (AlastDigit == BlastDigit || AlastDigit == ClastDigit || BlastDigit == ClastDigit)
            {
                return true;
            }
            return false;
        }
        return false;
    }

    public static boolean isValid (int number)
    {
        if (number >= 10 && number <= 1000)
        {
            return true;
        }
        return false;
    }
}
