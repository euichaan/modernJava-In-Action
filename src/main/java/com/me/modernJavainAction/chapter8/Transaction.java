package com.me.modernJavainAction.chapter8;

import com.me.modernJavainAction.chapter5.Trader;

public class Transaction {
	private final int year;
	private final int value;
	private final String referenceCode;

	public Transaction(int year, int value, String referenceCode) {
		this.year = year;
		this.value = value;
		this.referenceCode = referenceCode;
	}

	public String getReferenceCode() {
		return referenceCode;
	}

	@Override
	public String toString() {
		return "Transaction{" +
			"year=" + year +
			", value=" + value +
			", referenceCode='" + referenceCode + '\'' +
			'}';
	}
}
