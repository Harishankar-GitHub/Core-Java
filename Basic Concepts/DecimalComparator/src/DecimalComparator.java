public class DecimalComparator {

    public static boolean areEqualByThreeDecimalPlaces (double num1, double num2)
    {
        // Return true if the 2 double numbers are same up to 3 decimal places.

        num1 = num1 * 1000;
        num2 = num2 * 1000;

        int var1 = (int) num1;
        int var2 = (int) num2;

        if (var1 == var2)
            return true;
        return false;
    }
}
