package vbank.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import vbank.account.Account;
import vbank.transfer.Transfer;

public class Bank {
	private String name;
	private String number;
	private Map<Integer, Account> accounts;
	private List<Transfer> transfers;

	public Bank() {
		super();
		this.setNumber("0001");
		this.setName("The Bank");
		this.accounts = new HashMap<Integer, Account>();
		this.accounts.put(accounts.size(), new Account());
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
			if (transfer != null) {
				transfers.add(transfer);
				return true;
			}
			return false;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public List<Transfer> getTransfer(Account querry) {
		return this.transfers.stream()
				.filter(transfer -> (transfer.getPayee() == querry || transfer.getPayer() == querry)).toList();
	}

	public List<Transfer> getAllTransfer() {
		return transfers;
	}

	public Map<Integer, Account> getAllAccounts() {
		return accounts;
	}
	public void addAccount(Account acc) {
		accounts.put(accounts.size(), acc);
	}
	@Override
	public String toString() {
		return "Bank [name=" + name + ", number=" + number + ", count_accounts=" + accounts.size()
				+ ", count_transfers=" + transfers.size() + "]";
	}

}