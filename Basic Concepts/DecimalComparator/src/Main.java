public class Main {

    public static void main(String[] args) {

        boolean result = DecimalComparator.areEqualByThreeDecimalPlaces(-3.1756,-3.175);
        boolean result1 = DecimalComparator.areEqualByThreeDecimalPlaces(3.175,3.176);
        boolean result2 = DecimalComparator.areEqualByThreeDecimalPlaces(3.0,3.0);
        boolean result3 = DecimalComparator.areEqualByThreeDecimalPlaces(-3.123,3.123);
        System.out.println(result);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }
}
