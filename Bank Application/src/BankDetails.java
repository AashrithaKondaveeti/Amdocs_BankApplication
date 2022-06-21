import java.util.*;
public class BankDetails {
	public static void main(String [] args) {
		
		Main main = new Main(); //creating constructor for main class
		
		Scanner scan = new Scanner(System.in);
		int option;
		System.out.println("=========================================================================");
		System.out.println("**************************Banking Application****************************");
		System.out.println("=========================================================================");
		main.ShowOptions();
		do {
			option = scan.nextInt();
			
			switch (option) {
			case 1:
				//create new customer
				Customer c = main.CustInput();
				main.addCustomer(c);
				break;
				
			case 2:
				//Showing Customer Details
				main.ShowList();
				break;
				
			case 3:
				//Searching by Account Number
				System.out.println("Enter Account Number to search: ");
				String accnum = scan.next();
				main.search(accnum);
				break;
				
			case 4:
				//Depositing Amount for required account number
				System.out.println("Enter Account Number in which you want to deposit: ");
				String accnum1 = scan.next();
				boolean found = false;
				found = main.searchcustomer(accnum1);
				if(found) {
					main.deposit(accnum1);
				}
				break;
				
			case 5:
				//Withdrawing Amount from the given account number
				System.out.println("Enter Account Number in which you want to Withdraw: ");
				String accnum2 = scan.next();
				boolean flag = false;
				flag = main.searchcustomer(accnum2);
				if(flag) {
					main.withdraw(accnum2);
				}
				break;
		
			case 6:
				System.exit(1);
				break;
			}
			
		}while(option != 6);
	}
}
