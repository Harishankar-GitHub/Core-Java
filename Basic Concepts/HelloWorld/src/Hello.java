public class Hello {
    // public - Access Modifier
    // class - Keyword

    public static void main(String[] args) {
        System.out.println("Hello World");

        int myFirstNumber = (10+5) + (2*10);
        // In Java, Primitive data types are the most basic data types.
        // int is one of 8 Primitive types.
        // The 8 Primitive types are
        // boolean, byte char, short, int, long, float and double.
        int mySecondNumber = 12;
        int myThirdNumber = myFirstNumber * 2;
        int myTotal = myFirstNumber + mySecondNumber + myThirdNumber;
        System.out.println(myTotal);
        int myLastOne = 1000 - myTotal;
        System.out.println(myLastOne);
    }
}
