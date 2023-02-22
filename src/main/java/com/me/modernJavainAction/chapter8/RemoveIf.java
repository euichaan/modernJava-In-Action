package com.me.modernJavainAction.chapter8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 컬렉션을 바꾸는 동작은 에러를 유발하며 복잡함을 더한다.
 * removeIf : 프레디케이트를 만족하는 요소를 제거한다. List나 Set을 구현하거나 그 구현을 상속받은 모든 클래스에서 이용할 수 있다.
 */
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

		// for (Iterator<Transaction> iterator = transactions.iterator(); iterator.hasNext();) {
		// 	Transaction transaction = iterator.next(); // Iterator 객체. next(), hasNext () 를 이용해 소스를 질의한다.
		// 	if (Character.isDigit(transaction.getReferenceCode().charAt(0))) {
		// 		// transactions.remove(transaction); // Collection 객체 자체, remove를 호출해 요소를 삭제한다.
		// 		iterator.remove();
		// 	}
		// }
		transactions.removeIf(transaction ->
			Character.isDigit(transaction.getReferenceCode().charAt(0)));
	}
}
