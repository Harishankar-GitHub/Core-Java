public class Main {

    public static void main(String[] args) {

        Ford ford = new Ford(36);
        ford.steer(45);
        System.out.println("************************");
        ford.accelerate(50);
        System.out.println("************************");
        ford.accelerate(20);
        System.out.println("************************");
        ford.accelerate(-55);
        System.out.println("************************");
    }
}
