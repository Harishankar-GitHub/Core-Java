public class CalculateInterest {

    public static void main(String[] args) {

        for (int i = 2; i < 9; i++)
        {
            System.out.println("10,000 at " + i + "% interest " + String.format("%.2f",calculateInterest(10000,i)));
        }

        System.out.println("****************************");

        for (int i = 8; i > 1; i--)
        {
            System.out.println("10,000 at " + i + "% interest " + String.format("%.2f",calculateInterest(10000,i)));
        }

        System.out.println("****************************");

        int count = 0;
        for (int i = 10; i < 50; i++)
        {
            if (isPrime(i))
            {
                System.out.println(i + " is a Prime Number");
                count = count + 1;
                if (count == 10)
                {
                    System.out.println("Exiting for loop !");
                    break;
                }
            }


        }
    }

    public static double calculateInterest (double amount, double interestRate)
    {
        return (amount * (interestRate/100));
    }

    public static boolean isPrime(int n) {

        if (n == 1) {
            return false;
        }

//        for (int i = 2; i <= n / 2; i++)      // This line is also correct.
        for (int i = 2; i <= Math.sqrt(n); i++) // But using Math.sqrt(n) is more optimized solution.
        {
            System.out.println("Looping " + i);
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}




