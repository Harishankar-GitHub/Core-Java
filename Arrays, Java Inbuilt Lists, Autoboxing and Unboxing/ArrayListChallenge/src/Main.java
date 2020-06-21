import java.util.Scanner;

public class Main {

    private static Scanner s = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone();

    public static void main(String[] args) {

        boolean quit = false;
        int choice;

        printOptions();

        while(!quit)
        {
            System.out.println("Choose an option : (Enter 6 to know available options)");
            choice = s.nextInt();
            s.nextLine();

            switch(choice)
            {
                case 0:
                    quit = true;
                    break;

                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printOptions();
                    break;
            }
        }
    }

    public static void printOptions()
    {
        System.out.println("0 - Quit");
        System.out.println("1 - Print Contacts");
        System.out.println("2 - Add Contact");
        System.out.println("3 - Update Contact");
        System.out.println("4 - Remove Contact");
        System.out.println("5 - Query Contact");
        System.out.println("6 - Print Options");
    }

    public static void addNewContact()
    {
        System.out.println("*** Add new contact ***");
        System.out.println("Enter Name : ");
        String name = s.nextLine();
        System.out.println("Enter Phone Number : ");
        String number = s.nextLine();
        Contacts newContact = new Contacts(name, number);
        if(mobilePhone.addContacts(newContact))
        {
            System.out.println("New Contact Added !");
        }
//        else
//        {
//            System.out.println("Contact already exists !");
//        }
    }

    public static void updateContact()
    {
        System.out.println("*** Update Contact ***");
        System.out.println("Enter existing name : ");
        String name = s.nextLine();
        Contacts existingContact = mobilePhone.queryContact(name);
        if(existingContact == null)
        {
            System.out.println("Contact not found !");
            return;
        }
        System.out.println("**********************");
        System.out.println("Enter new name : ");
        String newName = s.nextLine();
        System.out.println("Enter new number : ");
        String newNumber = s.nextLine();
        Contacts newContact = new Contacts(newName, newNumber);
        if (mobilePhone.updateContact(existingContact, newContact))
        {
            System.out.println("Contact updated successfully !");
        }
//        else
//        {
//            System.out.println("Error updating record");
//        }
    }

    public static void removeContact()
    {
        System.out.println("*** Remove Contact ***");
        System.out.println("Enter name : ");
        String name = s.nextLine();
        Contacts existingContact = mobilePhone.queryContact(name);
        if(existingContact == null)
        {
            System.out.println("Contact not found !");
            return;
        }
        if(mobilePhone.removeContact(existingContact))
        {
            System.out.println("Contact deleted successfully !");
        }
        else
        {
            System.out.println("Error deleting contact !");
        }
    }

    public static void queryContact()
    {
        System.out.println("*** Query Contact ***");
        System.out.println("Enter name : ");
        String name = s.nextLine();
        Contacts existingContact = mobilePhone.queryContact(name);
        if(existingContact == null)
        {
            System.out.println("No contacts found !");
            return;
        }
        System.out.println("Name : " + existingContact.getName() + " Number : " + existingContact.getPhoneNumber());
    }
}