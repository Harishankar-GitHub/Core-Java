import java.util.ArrayList;

public class MobilePhone {

    private ArrayList<Contacts> contacts = new ArrayList<Contacts>();
    // If I just keep private ArrayList<Contacts> contacts; in the above line,
    // NullPointerException comes in printContacts().


    public void printContacts()
    {
        if(this.contacts.size() > 0)
        {
            System.out.println("Contact List :");
//            for(int i=0; i<this.contacts.size(); i++)
//            {
//                System.out.println((i+1) + ". " + this.contacts.get(i).getName()
//                        + " - " + this.contacts.get(i).getPhoneNumber());
//            }

            int i=0;
            for (Contacts c : this.contacts)
            {
                System.out.println((i+1) + ". " + c.getName() + " - " + c.getPhoneNumber() );
                i += 1;
            }
        }
        else
        {
            System.out.println("No Contacts found !");
        }
    }

    public boolean addContacts(Contacts newContact)
    {
        if (findContact(newContact.getName()) >= 0)
        {
            System.out.println("Contact already exists !");
            return false;
        }
        this.contacts.add(newContact);
        return true;
    }

    public boolean updateContact(Contacts oldContact, Contacts newContact)
    {
        if (findContact(newContact.getName()) > -1)
        {
            System.out.println("Contact with name " + newContact.getName() + " already exists."
             + " Update was not successful.");
            return false;
        }
        int foundPosition = findContact(oldContact);
        this.contacts.set(foundPosition,newContact);

        System.out.println(oldContact.getName() + " was replaced with " + newContact.getName());
        return true;
    }

    private int findContact(Contacts contact)
    {
        return contacts.indexOf(contact);
    }

    private int findContact(String name)
    {
        for(int i = 0; i < this.contacts.size(); i++)
        {
            Contacts c = this.contacts.get(i);
            if (c.getName().equals(name))
            {
                return i;
            }
        }
        // We are not using Enhanced For Loop here because, we need the index.
        // In Enhanced For Loop, we can't get the index.
        return -1;
    }

    public String queryContact(Contacts contact)
    {
        if(findContact(contact) > -1)
        {
            return contact.getName();
        }
        return null;
    }

    public Contacts queryContact(String name)
    {
        int position = findContact(name);
        if(position > -1)
        {
            return this.contacts.get(position);
        }
        return null;
    }

    public boolean removeContact(Contacts contact)
    {
        int foundPosition = findContact(contact);
//        if(foundPosition < 0)
//        {
//            System.out.println(contact.getName() + " not found !");
//            return false;
//        }
        this.contacts.remove(foundPosition);
//        System.out.println(contact.getName() + " removed.");
        return true;
    }
}
