public class SpeedConverter {

    public static long toMilesPerHour(double kilometersPerHour)
    {
        if (kilometersPerHour < 0)
        {
            return -1;
        }

        return Math.round(kilometersPerHour / 1.609);
        // 1 mile per hour = 1.609 kilometers per hour.
        // kilometersPerHour is passed.
        // To find number of miles in that, we do kilometersPerHour / 1.609.
    }

    public static void printConversion (double kilometersPerHour)
    {
        if (kilometersPerHour < 0)
        {
            System.out.println("Invalid Value");
        }
        else
        {
            long milesPerHour = toMilesPerHour(kilometersPerHour);
            System.out.println(kilometersPerHour + " km/h = " + milesPerHour + " mi/h");
        }
    }
}