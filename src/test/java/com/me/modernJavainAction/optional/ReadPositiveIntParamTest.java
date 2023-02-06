package com.me.modernJavainAction.optional;

import static org.assertj.core.api.Assertions.*;

import java.util.Optional;
import java.util.Properties;

import org.junit.jupiter.api.Test;

import com.me.modernJavainAction.chapter11.OptionalMain;

public class ReadPositiveIntParamTest {
	@Test
	void testMap() {
		Properties props = new Properties();
		props.setProperty("a", "5");
		props.setProperty("b", "true");
		props.setProperty("c", "-3");
		assertThat(5).isEqualTo(readDurationImperative(props, "a"));
		assertThat(0).isEqualTo(readDurationImperative(props, "b"));
		assertThat(0).isEqualTo(readDurationImperative(props, "c"));
		assertThat(0).isEqualTo(readDurationImperative(props, "d"));

		assertThat(5).isEqualTo(readDurationWithOptional(props, "a"));
		assertThat(0).isEqualTo(readDurationWithOptional(props, "b"));
		assertThat(0).isEqualTo(readDurationWithOptional(props, "c"));
		assertThat(0).isEqualTo(readDurationWithOptional(props, "d"));
	}

	public static int readDurationImperative(Properties props, String name) {
		String value = props.getProperty(name);
		if (value != null) {
			try {
				int i = Integer.parseInt(value);
				if (i > 0) {
					return i;
				}
			} catch (NumberFormatException nfe) { }
		}
		return 0;
	}

	public static int readDurationWithOptional(Properties props, String name) {
		return Optional.ofNullable(props.getProperty(name))
			.flatMap(OptionalMain::stringToInt)
			.filter(i -> i > 0)
			.orElse(0);
	}
}
