package net.ericlefevre;

public class FooBarQix {
	private static final String TEXT_FOR_7 = "Qix";
	private static final String TEXT_FOR_5 = "Bar";
	private static final String TEXT_FOR_3 = "Foo";
	private static final String[] TEXT = new String[] { "", "", "", TEXT_FOR_3,
			"", TEXT_FOR_5, "", TEXT_FOR_7, "", "" };

	public static void main(String[] args) {
		System.out.println(new FooBarQix().asTextUpTo(100));
	}

	public String asTextUpTo(int topNumber) {
		StringBuilder str = new StringBuilder();
		for (int i = 1; i <= topNumber; i++) {
			str.append(toText(i));
			if (i < topNumber) {
				str.append("\n");
			}
		}
		return str.toString();
	}

	public String toText(int number) {
		StringBuffer result = new StringBuffer();
		addTextForDivisible(number, 3, result);
		addTextForDivisible(number, 5, result);
		addTextForDivisible(number, 7, result);
		addTextForDigits(number, result);

		return result.length() > 0 ? result.toString() : Integer
				.toString(number);
	}

	private void addTextForDivisible(int number, int digit, StringBuffer str) {
		if (number % digit == 0) {
			str.append(TEXT[digit]);
		}
	}

	private void addTextForDigits(int numberToConvert, StringBuffer str) {
		String asString = Integer.toString(numberToConvert);
		for (int i = 0; i < asString.length(); i++) {
			int digit = Integer.parseInt(asString.substring(i, i + 1));
			str.append(TEXT[digit]);
		}
	}
}
