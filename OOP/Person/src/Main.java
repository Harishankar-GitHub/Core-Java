public class Main {

    public static void main(String[] args) {

        Person person = new Person();

        person.setFirstName("");   // firstName is set to empty string
        person.setLastName("");    // lastName is set to empty string
        person.setAge(10);

        System.out.println("Full Name = " + person.getFullName());
        System.out.println("Teen = " + person.isTeen());

        person.setFirstName("John");    // firstName is set to John
        person.setAge(18);

        System.out.println("Full Name = " + person.getFullName());
        System.out.println("Teen = " + person.isTeen());

        person.setLastName("Smith");    // lastName is set to Smith

        System.out.println("Full Name = " + person.getFullName());
    }
}
