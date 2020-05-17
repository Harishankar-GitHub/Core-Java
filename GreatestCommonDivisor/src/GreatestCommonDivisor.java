public class GreatestCommonDivisor {

    public static int getGreatestCommonDivisor(int firstNum, int secondNum) {
        if (firstNum >= 10 && secondNum >= 10) {

//            int min;
//            if (firstNum < secondNum)
//            {
//                min = firstNum;
//            }
//            else
//            {
//                min = secondNum;
//            }

//            The commented code can also be used. But using Math.min is more optimal.

            int min = Math.min(firstNum, secondNum);
            System.out.println(min + " is the minimum in " + firstNum + " " + secondNum);

            while (min > 0) {
                if ((firstNum % min == 0) && (secondNum % min == 0)) {
                    break;
                } else min -= 1;

            }
            return min;
        }
        return -1;
    }
}
