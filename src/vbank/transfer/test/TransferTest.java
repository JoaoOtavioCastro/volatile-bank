package vbank.transfer.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

import vbank.account.Account;
import vbank.transfer.Transfer;

class TransferTest {
	Random rn = new Random();

	Account payer1 = new Account(1, rn.nextInt(Integer.MAX_VALUE), 100, "Harry Potter", "123.123.123-12");
	Account payer2 = new Account(1, rn.nextInt(Integer.MAX_VALUE), 500, "Peter Pan", "321.321.321.32");
	Account payee1 = new Account(1, rn.nextInt(Integer.MAX_VALUE), 100, "Clark Kent", "555.555.555-55");
	Account payee2 = new Account(1, rn.nextInt(Integer.MAX_VALUE), 500, "Brad Pitt", "222.222.222-22");
	Transfer transfer = null;
	@Test
	void testNormalTransfer() {
		transfer = payer1.transfer(50, payee1);
		assertNotNull(transfer);
		//System.out.println(transfer.toString());
	}

}
