import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {

	Scanner scan = new Scanner(System.in);
	//Creating ArrayList of Customers for Storing Details
	List<Customer> customerList = new ArrayList<>();
	public void addCustomer(Customer customer) {
		customerList.add(customer);
		System.out.println("Customer Added!!");
	}
	
	public boolean searchcustomer(String accno) {
		for(Customer customer : customerList) {
			if(customer.Accnum.equals(accno)) {
				return true;
			}
		}
		return false;
	}
	
	//Function for Showing the Customer Details in the Application
	public void ShowList() {
		System.out.println("----------------List of Customers with their Account Numbers----------------");
		for(Customer customer : customerList) {
			System.out.println(customer.Accnum+" "+customer.Accname+" "+customer.balance);
		}
		System.out.println("----------------------------------------------------------------------------");
	}
	
	//Function for Searching the Customer details with Account Number
	public void search(String Accnum) {
		System.out.println("----------------------------------------------------------------------------");
		for(Customer customer : customerList) {
			if(customer.Accnum.equals(Accnum)){
				System.out.println("Information of "+customer.Accnum);
				System.out.println(customer.Accname+" "+customer.balance);
			}
		}
		System.out.println("----------------------------------------------------------------------------");
	}

	//Function for depositing the amount in the required account number
	public void deposit(String accno) {
		System.out.println("----------------------------------------------------------------------------");
		long amount;
		System.out.println("Enter amount to deposit : ");
		amount = scan.nextLong();
		
		for(Customer customer : customerList) {
			if(customer.Accnum.equals(accno)) {
				customer.balance+=amount;
				System.out.println("Balance After the Deposit :" + customer.balance);
			}
		}
		
		System.out.println("----------------------------------------------------------------------------");
	}
	
	//Function for Withdrawing the Amount from the Account number
	public void withdraw(String accno) {
		System.out.println("----------------------------------------------------------------------------");
		long amount;
		System.out.println("Enter Amount to Withdraw : ");
		amount = scan.nextLong();
		for(Customer customer : customerList) {
			if(customer.Accnum.equals(accno)) {
				if(customer.balance >= amount) {
					customer.balance -= amount;
					System.out.println("Balance after Withdrawn : "+ customer.balance);
				}
				else {
					System.out.println("Your Balance is lessthan withdrawn amount, Transaction Failed....");
				}
			}
		}
		System.out.println("----------------------------------------------------------------------------");
	}
	
	//Function for Showing the Options
	public void ShowOptions() {
		System.out.println("***************Enter the required option***************");
		System.out.println("1.Create New Customer");
		System.out.println("2.Show Customer List");
		System.out.println("3.Search by Account Number");
		System.out.println("4.Deposit Amount");
		System.out.println("5.Withdraw Amount");
		System.out.println("6.Exit");
	}

	//Function for taking the input for Customer data
	public Customer CustInput() {
		System.out.print("Enter Customer name: ");
		String name = scan.next();
		System.out.println();
		System.out.print("Enter Customer Account number: ");
		String Accnum = scan.next();
		System.out.println();
		System.out.print("Enter balance: ");
		double bal = scan.nextDouble();
		System.out.println();
		//if the balance is lessthan 1000 then user will be asked to enter the balance again
		while(bal<1000) {
			System.out.println("Enter balance again: ");
			bal = scan.nextDouble();
		}
		Customer C = new Customer(name, Accnum, bal);
		return C;
	}
}
