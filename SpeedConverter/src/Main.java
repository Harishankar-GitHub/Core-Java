public class Main {

    public static void main(String[] args) {
        SpeedConverter.printConversion(100);

        long miles = SpeedConverter.toMilesPerHour(100);
        System.out.println("Miles = " + miles);
    }
}
