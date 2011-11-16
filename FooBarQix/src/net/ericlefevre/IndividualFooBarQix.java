package net.ericlefevre;

public class IndividualFooBarQix {
	private static final String TEXT_FOR_7 = "Qix";
	private static final String TEXT_FOR_5 = "Bar";
	private static final String TEXT_FOR_3 = "Foo";
	private static final String[] TEXT = new String[] { "", "", "", TEXT_FOR_3,
			"", TEXT_FOR_5, "", TEXT_FOR_7, "", "" };

	public String toText(int number) {
		String result = //
		""//
				+ addTextForDivisible(number, 3)//
				+ addTextForDivisible(number, 5)//
				+ addTextForDivisible(number, 7)//
				+ addTextForDigits(number);

		return !result.isEmpty() ? result : Integer.toString(number);
	}

	private String addTextForDivisible(int number, int digit) {
		return (number % digit == 0) ? TEXT[digit] : "";
	}

	private String addTextForDigits(int numberToConvert) {
		String result = "";

		String asString = Integer.toString(numberToConvert);
		for (int i = 0; i < asString.length(); i++) {
			int digit = Integer.parseInt("" + asString.charAt(i));
			result += TEXT[digit];
		}
		return result;
	}

}
