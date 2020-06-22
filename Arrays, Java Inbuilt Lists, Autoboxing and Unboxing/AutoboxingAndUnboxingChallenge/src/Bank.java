import java.util.ArrayList;

public class Bank {

    private String bankName;
    private ArrayList<Branch> branches;

    public Bank(String bankname) {
        this.bankName = bankname;
        this.branches = new ArrayList<>();
    }

    public void addBranch(String branchName)
    {
        if(findBranch(branchName) == null)
        {
            this.branches.add(new Branch(branchName));
            System.out.println("New branch added : " + branchName);
            return;
        }
        System.out.println(branchName + " already exists !");
    }

    public void addCustomer(String branchName, String customerName, double initialAmount)
    {
        Branch branch = findBranch(branchName);
        if(branch != null)
        {
            branch.addNewCustomer(customerName, initialAmount);
            return;
        }
        System.out.println(branchName + " not found !");
    }

    public void addTransaction(String branchName, String customerName, double amount)
    {
        Branch branch = findBranch(branchName);
        if(branch != null)
        {
            branch.addCustomerTransaction(customerName, amount);
            return;
        }
        System.out.println("Branch not found ! Please enter a valid Branch name.");
    }

    public Branch findBranch(String branchName)
    {
        for(Branch branch : this.branches)
        {
            if(branch.getBranchName().equals(branchName))
            {
                return branch;
            }
        }
        return null;
    }

    public boolean listCustomers(String branchName, boolean showTransactions)
    {
        Branch branch = findBranch(branchName);
        if(branch != null)
        {
            System.out.println("Customers of " + branch.getBranchName() + " branch : ");
            ArrayList<Customer> branchCustomers = branch.getCustomers();
            for (Customer c : branchCustomers) {
                System.out.println(c.getCustomerName());
                if (showTransactions) {
                    System.out.println("Transactions of " + c.getCustomerName() + " :");
                    ArrayList<Double> transactionsOfThisCustomer = c.getTransactions();
                    for (Double amount : transactionsOfThisCustomer) {
                        System.out.println(amount);
                    }
                }
            }
            return true;
        }
        return false;
    }
}
