public class BankAccount {

    private String accountNumber;
    private double balance;
    private String customerName;
    private String email;
    private String phoneNumber;

    public BankAccount()
    {
        this("123456", 550, "Default name",
                "Default email", "Default phone number");
//        The above line can be used to set default values for variables if this empty constructor is called.
//        The above line (this(parameter1, parameter2.. etc) calls the constructor with parameters.
//        "this" keyword must be always at 1st line. It CAN'T be placed below sout.

        System.out.println("Empty constructor called");
    }

    public BankAccount(String accountNumber, double balance, String customerName, String email,
                       String phoneNumber)
    {
        System.out.println("Constructor with parameters called");
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        // We can also use setter methods here.
        // Like setAccountNumber(accountNumber);
        // But that is not recommended or that is not the best practice.
    }

    public BankAccount(String customerName, String email, String phoneNumber) {
        this("9999", 400, customerName, email, phoneNumber);
        // If we want to pass few parameters & keep default values for few parameters, we can do it.
        // We can create a constructor like this with the parameters which we want to pass.
        // Inside this constructor, we can call another constructor (Using "this" keyword) which has all the parameters.
        // While calling, we can pass default values and the parameters.
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void depositFunds(double depositAmount)
    {
        this.balance = this.balance + depositAmount;
        System.out.println("Deposit of " + depositAmount + " made. New balance is " + this.balance);
    }

    public void withdrawFunds(double withdrawalAmount)
    {
        if (this.balance - withdrawalAmount < 0)
        {
            System.out.println("Only " + this.balance + " available. Withdrawal not processed.");
        }
        else
        {
            this.balance = this.balance - withdrawalAmount;
            System.out.println("Withdrawal of " + withdrawalAmount + " processed. " +
                    "Remaining balance = " + this.balance);
        }
    }
}
