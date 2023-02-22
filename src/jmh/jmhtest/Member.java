package jmhtest;

import lombok.Getter;

@Getter
public class Member {
	private String name;

	public Member(String name) {
		this.name = name;
	}
}
