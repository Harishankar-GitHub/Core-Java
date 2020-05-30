public class FlourPacker {

    public static boolean canPack(int bigCount, int smallCount, int goal) {

        bigCount = bigCount * 5;

        if (bigCount < 0 || smallCount < 0 || goal < 0) {
            return false;
        }

        if (bigCount == goal || smallCount == goal || bigCount + smallCount == goal)
        {
            return true;
        }

        if (bigCount + smallCount >= goal)
        {
            if (smallCount >= goal % 5)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
}