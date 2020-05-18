public class NumberToWords {

    public static void numberToWords (int number)
    {
        if (number < 0)
        {
            System.out.println("Invalid Value");
        }
        if (number == 0)
        {
            System.out.println("Zero");
        }

        int digitCount = getDigitCount(number);
        System.out.println("Digit Count : " + digitCount);

        int reversedNumber = reverse(number);
        System.out.println("Reversed Number : " + reversedNumber);

        int digitCountReversedNumber = getDigitCount(reversedNumber);
        System.out.println("Digit Count Reversed Number : " + digitCountReversedNumber);

        while (reversedNumber > 0)
        {
            int lastDigit = reversedNumber % 10;

            switch (lastDigit)
            {
                case 0:
                    System.out.println("Zero");
                    break;

                case 1:
                    System.out.println("One");
                    break;

                case 2:
                    System.out.println("Two");
                    break;

                case 3:
                    System.out.println("Three");
                    break;

                case 4:
                    System.out.println("Four");
                    break;

                case 5:
                    System.out.println("Five");
                    break;

                case 6:
                    System.out.println("Six");
                    break;

                case 7:
                    System.out.println("Seven");
                    break;

                case 8:
                    System.out.println("Eight");
                    break;

                default:
                    System.out.println("Nine");
                    break;
            }

            reversedNumber = reversedNumber / 10;

        }

        while (digitCount - digitCountReversedNumber != 0)
        {
            System.out.println("Zero");
            digitCountReversedNumber++;
        }
    }

    public static int reverse (int number)
    {
        int sum = 0;
        while (number > 0 || number < 0)
        {
            int lastDigit = number % 10;
            sum = (sum * 10) + lastDigit;
            number = number / 10;
        }
        return sum;
    }

    public static int getDigitCount (int number)
    {
        if (number < 0)
        {
            return -1;
        }

        if (number >= 0 && number <= 9)
        {
            return 1;
        }

        int count = 0;
        while (number > 0)
        {
            number = number / 10;
            count ++;

        }
        return count;
    }
}
