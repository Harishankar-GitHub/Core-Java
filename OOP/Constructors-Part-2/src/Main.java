public class Main {

    public static void main(String[] args) {

        VipCustomer vipCustomer = new VipCustomer();
        System.out.println(vipCustomer.getName() + " " + vipCustomer.getCreditLimit() + " "
        + vipCustomer.getEmail());
        // Above code for testing Default Constructor.

        VipCustomer vipCustomer1 = new VipCustomer("Sample2", 10000);
        System.out.println(vipCustomer1.getName() + " " + vipCustomer1.getCreditLimit() + " "
                + vipCustomer1.getEmail());
        // Above code for testing Constructor with 2 Parameters.

        VipCustomer vipCustomer2 = new VipCustomer("Sample3", 150000, "sample3@mail.com");
        System.out.println(vipCustomer2.getName() + " " + vipCustomer2.getCreditLimit() + " "
                + vipCustomer2.getEmail());
        // Above code for testing Constructor with 3 Parameters.
    }
}
