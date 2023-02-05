package com.me.modernJavainAction.immutable;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ImmutableTest {
	@Test
	@DisplayName("불변 테스트")
	void immutable_test() {
		String s1 = "Hello World";
		String s2 = "Hello World";

		assertThat(s1 == s2).isTrue();
	}
}
