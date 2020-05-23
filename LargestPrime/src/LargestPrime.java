public class LargestPrime {

//    public static int getLargestPrime(int number) {
//        int i;
//        if(number<2){
//            return -1;
//        }
//
//        for (i = 2; i <= number; i++) {
//            if (number % i == 0) {
//                number = number / i;
//                i--;
//            }
//        }
//        return i;
//    }

    public static int getLargestPrime(int number) {
        if (number < 2) {
            return -1;
        }

        int largestPrime = 0;
        int prime = 0;

        for (int i = 2; i <= number; i++)
        {
            if (number % i == 0)
            {
                for (int a = 2; a <= i; a++) {
                    if (i % a == 0) {
                        prime = a;
                        break;
                    }
                }
            }
            if (prime > largestPrime)
            {
                largestPrime = prime;
            }
        }
        return largestPrime;
    }



// Another Method ******************************************

//public static int getLargestPrime(int number) {
//    if (number < 2)
//    {
//        return -1;
//    }
//
//    int primeFactor = 0;
//
//    for (int i = 2; i <= Math.sqrt(number); i++)
//    {
//        if (number % i == 0) {
//            primeFactor = i;
//        }
//    }
//
//    int anotherFactor = number / primeFactor;
//
//    if (isPrime(primeFactor) && isPrime(anotherFactor))
//    {
//        return Math.max(primeFactor, anotherFactor);
//    }
//
//    if (isPrime(primeFactor))
//    {
//        return primeFactor;
//    }
//    else
//    {
//        return anotherFactor;
//    }
//}
//
//    public static boolean isPrime(int number) {
//
//        if (number == 1) {
//            return false;
//        }
//
//        for (int i = 2; i <= Math.sqrt(number); i++)
//        {
//            if (number % i == 0) {
//                return false;
//            }
//        }
//        return true;
//    }
//*******************************************************

}