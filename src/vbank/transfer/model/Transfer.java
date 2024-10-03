package vbank.transfer.model;

import java.time.LocalDateTime;

import vbank.account.model.Account;

public class Transfer {
	private Account payer;
	private Account payee;
	private long value;
	private LocalDateTime date;

	public Transfer(Account payer, Account payee, long value) {
		super();
		this.payer = payer;
		this.payee = payee;
		this.value = value;
		date = LocalDateTime.now();
	}

	public Account getPayer() {
		return payer;
	}

	public Account getPayee() {
		return payee;
	}

	public long getValue() {
		return value;
	}

	public LocalDateTime getDate() {
		return date;
	}

}
