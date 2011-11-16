package net.ericlefevre;

public class FooBarQix {
	private final IndividualFooBarQix individualFooBarQix = new IndividualFooBarQix();

	public String asTextUpTo(int topNumber) {
		StringBuilder str = new StringBuilder();
		for (int i = 1; i <= topNumber; i++) {
			str.append(individualFooBarQix.toText(i));
			if (i < topNumber) {
				str.append("\n");
			}
		}
		return str.toString();
	}

	public static void main(String[] args) {
		System.out.println(new FooBarQix().asTextUpTo(100));
	}

}
