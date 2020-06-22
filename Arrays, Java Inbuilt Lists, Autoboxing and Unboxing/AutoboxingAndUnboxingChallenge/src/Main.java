public class Main {

    public static void main(String[] args) {

        Bank iciciBank = new Bank("ICICI Bank");

        iciciBank.addBranch("Bangalore");

        iciciBank.addCustomer("Bangalore","Harish",20000.00);
        iciciBank.addCustomer("Bangalore","Jack",10000.00);
        iciciBank.addCustomer("Bangalore", "Bob",5000.00);
        iciciBank.addCustomer("Bangalore", "Bob",5000.00);

        iciciBank.addBranch("Chennai");
        iciciBank.addCustomer("Chennai","Jill",15000.00);

        iciciBank.addTransaction("Bangalore","Harish",30000.00);
        iciciBank.addTransaction("Bangalore","Jack",27000.00);
        iciciBank.addTransaction("Bangalore","Jaaaack",27000.00);

        iciciBank.listCustomers("Bangalore", true);
        iciciBank.listCustomers("Chennai", true);

        iciciBank.listCustomers("Bangalore", false);
        iciciBank.listCustomers("Chennai", false);
    }
}
