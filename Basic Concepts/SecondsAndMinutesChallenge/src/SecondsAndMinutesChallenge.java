public class SecondsAndMinutesChallenge {

    public static final String INVALID_VALUE_MESSAGE = "Invalid Value";

    public static void main(String[] args) {
        System.out.println(getDurationString(65,45));
        System.out.println(getDurationString(3945L));
        System.out.println(getDurationString(-41));
        System.out.println(getDurationString(65,9));

    }

    private static String getDurationString (long minutes, long seconds)
    {
        if ((minutes > 0) && (seconds >= 0 && seconds <= 59))
        {
            long hours = minutes / 60;
            long min = minutes % 60;

            String hoursString = hours + "h";
            if (hours < 10)
            {
                hoursString = "0" + hoursString;
            }

            String minuteString = min + "m";
            if (min < 10)
            {
                minuteString = "0" + minuteString;
            }

            String secString = seconds + "s";
            if (seconds < 10)
            {
                secString = "0" + secString;
            }
            String duration = hoursString + " " + minuteString + " " + secString;
            return duration;
        }
        return INVALID_VALUE_MESSAGE;
    }

    private static String getDurationString (long seconds)
    {
        if (seconds < 0)
        {
            return "Invalid Value";
        }
        long min = seconds / 60;
        long sec = seconds % 60;

        return getDurationString(min, sec);
    }
}
