package vbank.account.cli;

import java.util.Random;
import java.util.Scanner;

import vbank.account.Account;

public class AccountCLI {
	Account account;
	Scanner sc;

	public AccountCLI(Account account) {
		super();
		this.account = account;
		this.sc = new Scanner(System.in);
	}

	public void showAccount() {
		System.out.println("--- Current Account values ---");
		System.out.println(account.toString());
		System.out.println("------------------------------");
	}

	public void showCLI() {
		boolean stop = false;
		do {
			showAccount();
			System.out.println("\nType the number to the function: " + "\n1 - Update Account" + "\n2 - Do Transactions"
					+ "\n0- Stop");
			int option = sc.nextInt();
			try {
				switch (option) {
				case 1:
					updateAccount();
				case 2:
					doTransactions();
				default:
					throw new IllegalArgumentException("Unexpected value: " + option);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			showAccount();
			if (stop) {
				System.out.println("\nWant to do another anything? (y / n)");
				char opt = sc.next().charAt(0);
				if (opt == 'y') {
					updateAccount();
				}
			}

		} while (!stop);
	}

	private void updateAccount() {
		boolean stop = false;
		do {
			showAccount();
			System.out.println("\nType the number to the function: " + "\n1 - Update Account Number"
					+ "\n2 - Update Account Owner Name" + "\n3 - Update Account Agency Number" + "\n0- Stop");
			int option = sc.nextInt();

			try {
				switch (option) {
				case 1:
					stop = updateNumber();
					break;
				case 2:
					stop = updateOwner();
					break;
				case 3:
					stop = updateAgency();
					break;
				case 0:
					stop = true;
					break;
				default:
					throw new IllegalArgumentException("Unexpected value: " + option);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			showAccount();
			if (stop) {
				System.out.println("\nWant to update another info? (y / n)");
				char opt = sc.next().charAt(0);
				if (opt == 'y') {
					updateAccount();
				}
			}

		} while (!stop);
	}

	private void doTransactions() {
		boolean stop = false;
		do {
			showAccount();
			try {
				System.out.println("\nType the number to the function: " + "\n1 - Do Deposit" + "\n2 - Do Withdrawal+ "
						+ "\n0- Stop");
				int option = sc.nextInt();
				switch (option) {
				case 1:
					stop = doDeposit();
					break;
				case 2:
					stop = doWithdrawal();
					break;
				case 0:
					stop = true;
					break;
				default:
					throw new IllegalArgumentException("Unexpected value: " + option);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			showAccount();
			if (stop) {
				System.out.println("\nWant to do another transaction? (y / n)");
				char opt = sc.next().charAt(0);
				if (opt == 'y') {
					updateAccount();
				}
			}
		} while (!stop);

	}

	private boolean updateNumber() {
		try {
			System.out.println("Type the new Account Number");
			int number = sc.nextInt();
			account.setNumber(number);
			return true;
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			return false;
		}
	}

	private boolean updateOwner() {
		try {
			System.out.println("Type the new Owner Name");
			String owner = sc.nextLine();
			account.setOwner(owner);
			return true;
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			return false;
		}
	}

	private boolean updateAgency() {
		try {
			System.out.println("Type the new Account Agency");
			int number = sc.nextInt();
			account.setAgency(number);
			return true;
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			return false;
		}
	}

	private boolean doDeposit() {
		System.out.println("Type the value to deposit(only numbers): ");
		try {
			account.deposit(sc.nextLong());
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	private boolean doWithdrawal() {
		System.out.println("Type the value to deposit(only numbers): ");
		try {
			return account.withdrawal(sc.nextLong());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public static Account createAccount() {
		Scanner scan = new Scanner(System.in);
		Random rn = new Random();
		System.out.println("New Account:");
		int number = rn.nextInt();
		int agency = 1;
		System.out.println("type the identity:");
		String identity = scan.nextLine();
		System.out.println("type the Owner Name:");
		String owner = scan.nextLine();
		return new Account(agency, number, owner, identity);
	}
}
