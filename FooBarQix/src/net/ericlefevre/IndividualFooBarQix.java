package net.ericlefevre;

public class IndividualFooBarQix {
	private static final String TEXT_FOR_7 = "Qix";
	private static final String TEXT_FOR_5 = "Bar";
	private static final String TEXT_FOR_3 = "Foo";
	private static final String[] TEXT = new String[] { "", "", "", TEXT_FOR_3,
			"", TEXT_FOR_5, "", TEXT_FOR_7, "", "" };

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
