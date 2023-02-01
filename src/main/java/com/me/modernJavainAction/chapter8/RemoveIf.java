package com.me.modernJavainAction.chapter8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class RemoveIf {
	public static void main(String[] args) {
		List<Transaction> transactions = new ArrayList<>();
		transactions.add(new Transaction(2011, 300, "012"));
		transactions.add(new Transaction(2011, 400, "raoul"));
		transactions.add(new Transaction(2012, 710, "mario"));
		transactions.add(new Transaction(2012, 700, "mario"));
		transactions.add(new Transaction(2012, 950, "alan"));

		// for (Transaction transaction : transactions) {
		// 	if (Character.isDigit(transaction.getReferenceCode().charAt(0))) {
		// 		transactions.remove(transaction);
		// 	}
		// }
		//
		// for (Iterator<Transaction> iterator = transactions.iterator(); iterator.hasNext();) {
		// 	Transaction transaction = iterator.next();
		// 	if (Character.isDigit(transaction.getReferenceCode().charAt(0))) {
		// 		iterator.remove();
		// 	}
		// }
		transactions.removeIf(transaction ->
			Character.isDigit(transaction.getReferenceCode().charAt(0)));
		System.out.println(transactions);
	}
}
