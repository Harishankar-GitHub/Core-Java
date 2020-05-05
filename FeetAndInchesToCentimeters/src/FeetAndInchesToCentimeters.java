public class FeetAndInchesToCentimeters {

    public static void main(String[] args) {

        // Create a method called calcFeetAndInchesToCentimeters
        // It needs to have two parameters.
        // feet is the first parameter, inches is the 2nd parameter
        //
        // You should validate that the first parameter feet is >= 0
        // You should validate that the 2nd parameter inches is >=0 and <=12
        // return -1 from the method if either of the above is not true
        //
        // If the parameters are valid, then calculate how many centimetres
        // comprise the feet and inches passed to this method and return
        // that value.
        //
        // Create a 2nd method of the same name but with only one parameter
        // inches is the parameter
        // validate that its >=0
        // return -1 if it is not true
        // But if its valid, then calculate how many feet are in the inches
        // and then here is the tricky part
        // call the other overloaded method passing the correct feet and inches
        // calculated so that it can calculate correctly.
        // hints: Use double for your number datatypes is probably a good idea
        // 1 inch = 2.54cm  and one foot = 12 inches
        // use the link I give you to confirm your code is calculating correctly.
        // Calling another overloaded method just requires you to use the
        // right number of parameters.

        calcFeetAndInchesToCentimeters(-10);
        calcFeetAndInchesToCentimeters(100);
        calcFeetAndInchesToCentimeters(6,13);
        printText(5,"Jack");
        printText("Jill", 5);

    }

    // This method to convert feet & inches to cm
    public static double calcFeetAndInchesToCentimeters(double feet, double inches)
    {
        if (feet >= 0 && (inches >= 0 && inches <= 12))
        {
            double feetCentimeters = feet * 12 * 2.54;
            // 1 inch = 2.54cm  and one foot = 12 inches
            // 1 foot = 12 inches. So feet * 12
            // 1 inch = 2.54 cm. So feet * 12 * 2.54.

            double inchesCentimeters = inches * 2.54;
            // 1 inch = 2.54cm.
            // So inches * 2.54.

            double result = feetCentimeters + inchesCentimeters;
            System.out.println("Centimeters : " + result);
            return result;

        }
        System.out.println("Invalid");
        return  -1;

    }

    //  This method to convert inches to cm. So calling the above method by passing 0 for feet.
    // Passing 0 for feet because, we hav only inches to convert to cm.
    public static double calcFeetAndInchesToCentimeters(int inches)
    {
        if (inches >= 0)
        {
            double feet = inches / 12;
            double remainingInches = inches % 12;

            calcFeetAndInchesToCentimeters(feet,remainingInches);

        }
        System.out.println("Invalid");
        return -1;

    }

    public static void printText(String name, int age)
    {
        System.out.println(name + " " + age);
    }

    public static void printText(int age, String name)
    {
        System.out.println(name + " " + age);
    }
}
