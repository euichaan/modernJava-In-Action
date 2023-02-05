package com.me.modernJavainAction.chapter8;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CacheExample {
	private MessageDigest messageDigest;

	public static void main(String[] args) {
		new CacheExample().main();
	}

	public CacheExample() {
		try {
			messageDigest = MessageDigest.getInstance("SHA-256");
		}
		catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	private void main() {
		List<String> lines = Arrays.asList(
			" Nel   mezzo del cammin  di nostra  vita ", // get(0)
			"mi  ritrovai in una  selva oscura", // get(1)
			" che la  dritta via era   smarrita " // get(2)
		);

		Map<String, byte[]> dataToHash = new HashMap<>();

		byte[] hellos = calculateDigest("hello");
		System.out.println(Arrays.toString(hellos));

		lines.forEach(line ->
			dataToHash.computeIfAbsent(line, this::calculateDigest));

		dataToHash.forEach((line, hash) ->
			System.out.printf("%s -> %s%n", line,
				new String(hash).chars().map(i -> i & 0xff).mapToObj(String::valueOf).collect(
					Collectors.joining(", ", "[", "]"))));
	}

	private byte[] calculateDigest(String key) {
		return messageDigest.digest(key.getBytes(StandardCharsets.UTF_8));
	}

}
