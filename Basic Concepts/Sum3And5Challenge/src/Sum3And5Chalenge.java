public class Sum3And5Chalenge {

    public static void main(String[] args) {

        int sum = 0;
        int count = 0;

        for (int i = 1; i <= 1000; i++)
        {
            if (i % 3 == 0 && i % 5 == 0)
            {
                sum += i;
                System.out.println("Found number = " + i);
                count++;
                if (count == 5)
                {
                    break;
                }
            }
        }
        System.out.println("Sum is " + sum);
    }
}
