public class Main {

    public static void main(String[] args) {

        double areaOfCircle = AreaCalculator.area(5.0);
        System.out.println(areaOfCircle);
        areaOfCircle = AreaCalculator.area(-1);
        System.out.println(areaOfCircle);
        double areaOfRectangle = AreaCalculator.area(5.0, 4.0);
        System.out.println(areaOfRectangle);
        areaOfRectangle = AreaCalculator.area(-1.0, 4.0);
        System.out.println(areaOfRectangle);
    }
}
