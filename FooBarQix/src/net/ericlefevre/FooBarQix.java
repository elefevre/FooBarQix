package net.ericlefevre;

public class FooBarQix {

	public String asTextUpTo(int topNumber) {
		String str = "";
		for (int i = 1; i <= topNumber; i++) {
			str += new IndividualFooBarQix().toText(i);
			if (i < topNumber) {
				str += "\n";
			}
		}
		return str;
	}

	public static void main(String[] args) {
		System.out.println(new FooBarQix().asTextUpTo(100));
	}

}
