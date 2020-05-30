public class AreaCalculator {

    public static double area(double radius)
    {
        double result = -1.0;
        if (radius < 0)
        {
            return result;
        }
        result = Math.PI * radius * radius; // Area of circle = PI * r * r
        return result;
    }

    public static double area(double x, double y)
    {
        double result = -1.0;
        if (x < 0 || y < 0)
        {
            return result;
        }
        return  x * y; // Area of rectangle = x * y
    }
}
