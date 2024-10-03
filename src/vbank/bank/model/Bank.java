package vbank.bank.model;

import java.util.List;

import vbank.account.model.Account;
import vbank.transfer.model.Transfer;

public class Bank {
	private String name;
	private String number;
	private List<Account> accounts;
	private List<Transfer> transfers;

	public Bank() {
		super();
		this.setNumber("0001");
		this.setName("The Bank");
		this.accounts.add(new Account());
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

}