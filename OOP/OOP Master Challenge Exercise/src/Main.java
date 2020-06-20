public class Main {

    public static void main(String[] args) {

        System.out.println("****************************************************************************");

        Hamburger hamburger = new Hamburger("Basic", "Sausage",50, "White");

        hamburger.addHamburgerAddition1("Tomato",10);
        hamburger.addHamburgerAddition2("Corn", 10);
        hamburger.addHamburgerAddition3("Onion",10);
        hamburger.addHamburgerAddition4("Sauce", 5);
        System.out.println("Total is " + hamburger.itemizeBurger() + "/-");

        System.out.println("****************************************************************************");

        HealthyBurger healthyBurger = new HealthyBurger("Mexican Aloo", 100);
        healthyBurger.addHamburgerAddition1("Onion", 10);
        healthyBurger.addHealthyAddition1("Leaves", 10);
        System.out.println("Total is " + healthyBurger.itemizeBurger() + "/-");

        System.out.println("****************************************************************************");

        DeluxeHamburger deluxeHamburger = new DeluxeHamburger();
        deluxeHamburger.addHamburgerAddition1("Onion", 10);
        System.out.println("Total is " + deluxeHamburger.itemizeBurger() + "/-");

        System.out.println("****************************************************************************");
    }
}
