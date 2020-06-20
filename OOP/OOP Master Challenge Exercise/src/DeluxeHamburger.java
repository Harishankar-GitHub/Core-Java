public class DeluxeHamburger extends Hamburger {

    public DeluxeHamburger() {
        super("Deluxe", "Veggie", 150, "Garlic Bread");
        super.addHamburgerAddition1("Chips", 25);
        super.addHamburgerAddition2("Drinks", 20);
    }

    @Override
    public void addHamburgerAddition1(String name, double price) {
        System.out.println("Cannot add additional items to a Deluxe Burger");
    }

    @Override
    public void addHamburgerAddition2(String name, double price) {
        System.out.println("Cannot add additional items to a Deluxe Burger");
    }

    @Override
    public void addHamburgerAddition3(String name, double price) {
        System.out.println("Cannot add additional items to a Deluxe Burger");
    }

    @Override
    public void addHamburgerAddition4(String name, double price) {
        System.out.println("Cannot add additional items to a Deluxe Burger");
    }
}
