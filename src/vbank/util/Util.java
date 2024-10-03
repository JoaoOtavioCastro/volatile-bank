package vbank.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Util {
	private static Util uniqueInstance = new Util();
	private int lastAccount = 123456789;
	private int lastTransfer;

	private Util() {
		lastAccount = 0;
		lastTransfer = 0;
	}

	public int generateAccount() {
		this.lastAccount = this.lastAccount++;
		return this.lastAccount;
	}

	public int generateTransfer() {
		this.lastTransfer = this.lastTransfer++;
		return lastTransfer;
	}

	public static String showValue(long value) {
		return String.valueOf(value / 100);
	}

	public static String formattedDate(LocalDateTime date) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		return date.format(format);
	}

	public static synchronized Util getInstance() {
		return uniqueInstance;
	}
}
