package vbank.bank;

import java.util.ArrayList;
import java.util.List;

import vbank.account.Account;
import vbank.transfer.Transfer;

public class Bank {
	private String name;
	private String number;
	private List<Account> accounts;
	private List<Transfer> transfers;

	public Bank() {
		super();
		this.setNumber("0001");
		this.setName("The Bank");
		this.accounts = new ArrayList<Account>();
		this.accounts.add(new Account());
		this.transfers = new ArrayList<Transfer>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	public boolean doTransaction(Account payer, Account payee, long value) {
		try {
			Transfer transfer = payer.transfer(value, payee);
			if(transfer!=null) {
				transfers.add(transfer);
				return true;
			}
			return false;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
}