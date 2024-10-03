package vbank.account.model;

import vbank.transfer.model.Transfer;
import vbank.util.Util;

public class Account {
	protected int number;
	protected int agency;
	protected long balance;
	protected String owner;
	protected String identity;
	private Util util = Util.getInstance();

	public Account(int agency, int balance, String owner, String identity) {
		super();
		this.number = util.generateAccount();
		this.agency = agency;
		this.balance = balance;
		this.owner = owner;
		this.identity = identity;
	}

	public Account() {
		this.number = 0;
		this.agency = 1;
		this.balance = 1000;
		this.owner = "Default";
		this.identity = "999.999.999-99";
	}

	public String showNumber() {
		return String.format("%010d", this.number);
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getAgency() {
		return agency;
	}

	public void setAgency(int agency) {
		this.agency = agency;
	}

	public long getBalance() {
		return balance;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public void withdrawal(long value) {
		this.balance -= value;
	}

	public void deposit(long value) {
		this.balance += value;
	}

	public Transfer transfer(long value, Account payee) {
		if (payee.getIdentity().isBlank()) {
			return null;
		}
		if (payee.getIdentity().equals("999.999.999-99")) {
			return null;
		}
		if (this.balance < value) {
			return null;
		}
		this.withdrawal(value);
		payee.deposit(value);
		return new Transfer(this, payee, value);
	}
}
