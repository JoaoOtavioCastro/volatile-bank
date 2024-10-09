package vbank.bank.cli;

import java.util.Scanner;

import vbank.account.Account;
import vbank.account.cli.AccountCLI;
import vbank.bank.Bank;
import vbank.transfer.Transfer;

public class BankCLI {
	Bank bank;
	Scanner sc;
	AccountCLI acccli;

	public BankCLI() {
		this.bank = new Bank();
		this.sc = new Scanner(System.in);
	}

	public void showBankCLI() {
		System.out.println("--- " + bank.getName() + " ---");
		boolean stop = false;
		do {

			System.out.println("\nType the number to the function: " + "\n1 - Show Accounts" + "\n2 - Show Transfers"
					+ "\n3 - Select Account to use" + "\n4 - New Account" + "\n5 - New Transfer" + "\n0- Stop");
			int option = sc.nextInt();

			try {
				switch (option) {
				case 1:
					showAccounts(0, 10);
					break;
				case 2:
					showTransfers();
					break;
				case 3:
					selectAccount();
					break;
				case 4:
					newAccount();
					break;
				case 5:
					newTransfer();
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

			if (stop) {
				System.out.println("\nWant to do another anything? (y / n)");
				char opt = sc.next().charAt(0);
				if (opt == 'n') {
					stop = true;
				}
			}

		} while (!stop);
		sc.close();
	}

	public void showAccounts(int page, int qtd) {
		int fval = 0 + (page * 10);
		int i = fval;
		while (i < (qtd * page) || i < bank.getAllAccounts().size()) {
			System.out.println("---------------");
			System.out.println(bank.getAllAccounts().get(i).basictoString(i));
			System.out.println("---------------");
			i++;
		}
		if (i < bank.getAllAccounts().size()) {
			System.out.println("\nWant to show next page? (y / n)");
			char opt = sc.next().charAt(0);
			if (opt == 'y') {
				showAccounts(page++, qtd);
			}
		}
	}

	public void newAccount() {
		try {
			bank.addAccount(AccountCLI.createAccount());
			System.out.println("Account Created!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void selectAccount() {
		try {
			System.out.println("Type the account id: ");
			acccli = new AccountCLI(bank.getAllAccounts().get(sc.nextInt()));
			acccli.showAccount();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			acccli = null;
		}
	}

	public void showTransfers() {
		for (Transfer tf : bank.getAllTransfer()) {
			tf.toString();
		}
	}

	public void newTransfer() {

		System.out.println("\nWant to Show Accounts before? (y / n)");
		char opt = sc.next().charAt(0);
		if (opt == 'y') {
			showAccounts(0, 10);
		}
		System.out.println("Type the payer ID: ");
		Account acc1 = bank.getAllAccounts().get(sc.nextInt());
		System.out.println("Type the payee ID: ");
		Account acc2 = bank.getAllAccounts().get(sc.nextInt());
		System.out.println("Type the Transfer Value: ");
		bank.addTransfer(acc1.transfer(sc.nextLong(), acc2));
		System.out.println("Transaction successful!");
	}
}
