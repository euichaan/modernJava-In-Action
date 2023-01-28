package com.me.modernJavainAction.chapter7;

import java.util.Spliterator;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class WordCount {

	private static final String SENTENCE =
		" Nel   mezzo del cammin  di nostra  vita "
			+ "mi  ritrovai in una  selva oscura"
			+ " che la  dritta via era   smarrita ";

	public static void main(String[] args) {
		System.out.println("Found " + countWordsIteratively(SENTENCE) + " words"); // 19 words
		System.out.println("Found " + countWords(SENTENCE) + " words"); // 19 words

		System.out.println("Found " + countWordsParallel(SENTENCE) + " words"); // 43 words
		System.out.println("Found " + countWordsWithCustomSpliterator(SENTENCE) + " words"); // 19 words
	}

	public static int countWordsIteratively(String inputs) {
		int counter = 0 ;
		boolean lastSpace = true;
		for (char input : inputs.toCharArray()) {
			if (Character.isWhitespace(input)) {
				lastSpace = true;
			} else { // 문자일 때
				if (lastSpace) counter++;
				lastSpace = false;
			}
		}
		return counter;
	}

	public static int countWords(String input) {
		Stream<Character> stream = IntStream.range(0, SENTENCE.length())
			.mapToObj(SENTENCE::charAt);
		return countWords(stream);
	}

	public static int countWordsParallel(String input) {
		Stream<Character> stream = IntStream.range(0, SENTENCE.length())
			.mapToObj(SENTENCE::charAt)
			.parallel();
		return countWords(stream);
	}

	public static int countWords(Stream<Character> stream) {
		WordCounter wordCounter = stream.reduce(new WordCounter(0, true),
			WordCounter::accumulate,
			WordCounter::combine);
		return wordCounter.getCounter();
	}

	public static int countWordsWithCustomSpliterator(String input) {
		Spliterator<Character> spliterator = new WordCounterSpliterator(SENTENCE);
		Stream<Character> stream = StreamSupport.stream(spliterator, true);
		return countWords(stream);
	}

	public static class WordCounter {
		private final int counter;
		private final boolean lastSpace;

		public WordCounter(int counter, boolean lastSpace) {
			this.counter = counter;
			this.lastSpace = lastSpace;
		}

		public WordCounter accumulate(Character input) {
			if (Character.isWhitespace(input)) {
				return lastSpace ? this : new WordCounter(counter, true);
			}
			else {
				return lastSpace ? new WordCounter(counter + 1, false) : this;
			}
		}

		public WordCounter combine(WordCounter wordCounter) {
			return new WordCounter(counter + wordCounter.counter, wordCounter.lastSpace);
		}

		public int getCounter() {
			return counter;
		}
	}

	private static class WordCounterSpliterator implements Spliterator<Character> {

		private final String string;
		private int currentChar = 0;

		public WordCounterSpliterator(String string) {
			this.string = string;
		}

		@Override
		public boolean tryAdvance(Consumer<? super Character> action) {
			action.accept(string.charAt(currentChar++)); // 현재 문자를 소비한다
			return currentChar < string.length(); // 소비할 문자가 남아있으면 true 를 반환한다.
		}

		@Override
		public Spliterator<Character> trySplit() {
			/**
			 * Spliterator 의 일부 요소를 분할해서 두 번째 Spliterator 생성하는 메서드
			 */
			int currentSize = string.length() - currentChar;
			if (currentSize < 10) {
				return null;
			}
			for (int splitPosition = currentSize / 2 + currentChar;
				 splitPosition < string.length(); splitPosition++) {
				if (Character.isWhitespace(string.charAt(splitPosition))) {
					Spliterator<Character> spliterator =
						new WordCounterSpliterator(string.substring(currentChar, splitPosition));
					currentChar = splitPosition;
					return spliterator;
				}
			}
			return null;
		}

		@Override
		public long estimateSize() { // 탐색해야 할 요소 수 정보
			return string.length() - currentChar;
		}

		@Override
		public int characteristics() {
			return ORDERED + SIZED + SUBSIZED + NONNULL + IMMUTABLE;
		}
	}
}
