import java.util.ArrayList;

public class Branch {

    private String branchName;
    private ArrayList<Customer> customers;

    public Branch(String branchName) {
        this.branchName = branchName;
        this.customers = new ArrayList<Customer>();
    }

    public String getBranchName() {
        return branchName;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public boolean addNewCustomer(String name, double initialAmount)
    {
        if(findCustomer(name) == null)
        {
            this.customers.add(new Customer(name,initialAmount));
            System.out.println("New customer added (" + this.branchName + " branch) : " + name);
            return true;
        }
        System.out.println(name + " is an existing customer ! Please add a new customer.");
        return false;
    }

    public boolean addCustomerTransaction(String name, double amount)
    {
        Customer existingCustomer = findCustomer(name);

        if(existingCustomer != null)
        {
            existingCustomer.addTransaction(amount);
            System.out.println("New transaction by " + name +  " : " + amount);
            return true;
        }
        System.out.println("Customer name (" + name + ") not found !");
        return false;
    }

    private Customer findCustomer(String name)
    {
        for(Customer customer : this.customers)
        {
            if(customer.getCustomerName().equals(name))
            {
                return customer;
            }
        }
        return null;
    }
}
