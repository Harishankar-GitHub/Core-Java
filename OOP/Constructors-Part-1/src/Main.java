public class Main {

    public static void main(String[] args) {
         BankAccount bankAccount = new BankAccount();
//         bankAccount.setAccountNumber("12345");
//         bankAccount.setBalance(100);
//         bankAccount.setCustomerName("Sample");
//         bankAccount.setEmail("mail@harish.com");
//         bankAccount.setPhoneNumber("123456789");
         bankAccount.withdrawFunds(100);
         bankAccount.depositFunds(50);
         bankAccount.withdrawFunds(100);
         bankAccount.depositFunds(51);
         bankAccount.withdrawFunds(100);

         BankAccount harish = new BankAccount();
//                 ("123456", 500,
//                 "Harish", "mail@harish.com", "123456789");
         harish.setAccountNumber("123456");
         harish.depositFunds(1000);
         harish.withdrawFunds(100);
         System.out.println(harish.getAccountNumber() + " has " + harish.getBalance());

         BankAccount bankAccount1 = new BankAccount("12345", 100.00, "abc",
                 "email", "321456987");
    }
}
