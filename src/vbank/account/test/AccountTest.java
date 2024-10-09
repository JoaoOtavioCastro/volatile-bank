package vbank.account.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

import vbank.account.Account;
import vbank.transfer.Transfer;

class AccountTest {
	
	Random rn = new Random();

	Account payer1 = new Account(1, rn.nextInt(Integer.MAX_VALUE), 10000, "Harry Potter", "123.123.123-12");
	Account payer2 = new Account(1, rn.nextInt(Integer.MAX_VALUE), 50000, "Peter Pan", "321.321.321.32");
	Account payee1 = new Account(1, rn.nextInt(Integer.MAX_VALUE), 10000, "Clark Kent", "555.555.555-55");
	Account payee2 = new Account(1, rn.nextInt(Integer.MAX_VALUE), 50000, "Brad Pitt", "222.222.222-22");
	Transfer transfer = null;
	
	@Test
	void testDeposit() {
		payer1.deposit(3000);
		assertEquals(13000, payer1.getBalance());
	}
	
	@Test
	void testDepositRandom() {
		int value = rn.nextInt();
		long oldValue = payer1.getBalance();
		payer1.deposit(value);
		assertEquals(oldValue+value, payer1.getBalance());
	}
	@Test
	void testWithdrawal() {
		payer2.withdrawal(3000);
		assertEquals(47000, payer2.getBalance());
	}
	
	@Test
	void testWithdrawalRandom() {
		long oldValue = payer1.getBalance();
		long value = rn.nextLong(oldValue);
		payer1.withdrawal(value);
		oldValue = oldValue-value;
		assertEquals(oldValue, payer1.getBalance());
	}
	@Test
	void testNormalTransferPayee() {
		transfer = payer1.transfer(5000, payee1);
		assertEquals(payee1.getBalance(), 15000);
	}
	@Test
	void testErrorTransferPayer() {
		long oldValue = payer1.getBalance();
		transfer = payer1.transfer(-5000, payee1);
		assertEquals(payer1.getBalance(), oldValue);
	}
	@Test
	void testErrorTransferPayee() {
		long oldValue = payee1.getBalance();
		transfer = payer1.transfer(-5000, payee1);
		assertEquals(payee1.getBalance(), oldValue);
	}
	@Test
	void testNormalTransferPayer() {
		long oldValue = payee2.getBalance();
		transfer = payer2.transfer(5000, payee1);
		assertEquals(payer2.getBalance(), oldValue-5000);
	}
	
}
