public class PaintJob {

    public static int getBucketCount (double width, double height, double areaPerBucket, int extraBuckets)
    {
        if (width <= 0 || height <= 0 || areaPerBucket <= 0 || extraBuckets < 0)
        {
            return -1;
        }
        else
        {
            double totalArea = width * height;
            double covered = extraBuckets * areaPerBucket;
            double remaining = totalArea - covered;
            int extraBucketNeeded = 1;

            while (true)
            {
                if (extraBucketNeeded * areaPerBucket >= remaining)
                {
                    return extraBucketNeeded;
                }
                else
                {
                    extraBucketNeeded = extraBucketNeeded + 1;
                }
            }
        }
    }

    public static int getBucketCount(double width, double height, double areaPerBucket)
    {
        if (width <= 0 || height <= 0 || areaPerBucket <= 0)
        {
            return -1;
        }
        else
        {
            double totalArea = width * height;
            int bucketNeeded = 1;

            while (true)
            {
                if (bucketNeeded * areaPerBucket >= totalArea)
                {
                    return bucketNeeded;
                }
                else
                {
                    bucketNeeded = bucketNeeded + 1;
                }
            }
        }
    }

    public static int getBucketCount(double area, double areaPerBucket)
    {
        if (area <= 0 || areaPerBucket <= 0)
        {
            return -1;
        }
        else
        {
            int bucketNeeded = 1;

            while (true)
            {
                if (bucketNeeded * areaPerBucket >= area)
                {
                    return bucketNeeded;
                }
                else
                {
                    bucketNeeded = bucketNeeded + 1;
                }
            }
        }
    }
}