package vbank.bank.test;

import java.util.Random;

import org.junit.jupiter.api.Test;

import vbank.account.Account;
import vbank.bank.Bank;
import vbank.transfer.Transfer;

class BankTest {

	Random rn = new Random();

	Account payer1 = new Account(1, 10000, "Harry Potter", "123.123.123-12");
	Account payer2 = new Account(1, 50000, "Peter Pan", "321.321.321.32");
	Account payee1 = new Account(1, 10000, "Clark Kent", "555.555.555-55");
	Account payee2 = new Account(1, 50000, "Brad Pitt", "222.222.222-22");
	Bank bank = new Bank();
	Transfer transfer = null;
	
	@Test
	void testNormalTransfer() {
		assert(bank.doTransaction(payer1, payee1, 5550));
	}
	
	@Test
	void testErrorTransfer() {
		assert(!bank.doTransaction(payer2, payee2, 555555555));
	}
	
	@Test
	void testNegativeErrorTransfer() {
		assert(!bank.doTransaction(payer2, payee2, -55555555));
	}
}
