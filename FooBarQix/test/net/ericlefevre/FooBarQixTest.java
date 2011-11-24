package net.ericlefevre;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class FooBarQixTest {
	@Test
	public void should_display_the_number_itself_by_default() {
		assertThat(new FooBarQix().toText(1), is("1"));
		assertThat(new FooBarQix().toText(2), is("2"));
	}

	@Test
	public void should_display_Foo_or_Bar_or_Qix_based_on_divisibility() {
		assertThat(new FooBarQix().toText(6), is("Foo"));
		assertThat(new FooBarQix().toText(9), is("Foo"));
		assertThat(new FooBarQix().toText(10), is("Bar"));
		assertThat(new FooBarQix().toText(20), is("Bar"));
		assertThat(new FooBarQix().toText(14), is("Qix"));
		assertThat(new FooBarQix().toText(28), is("Qix"));
	}

	@Test
	public void should_display_Foo_or_Bar_or_Qix_based_on_digits() {
		assertThat(new FooBarQix().toText(23), is("Foo"));
		assertThat(new FooBarQix().toText(31), is("Foo"));
		assertThat(new FooBarQix().toText(52), is("Bar"));
		assertThat(new FooBarQix().toText(521), is("Bar"));
		assertThat(new FooBarQix().toText(17), is("Qix"));
		assertThat(new FooBarQix().toText(71), is("Qix"));
	}

	@Test
	public void should_display_combined_text_based_on_digits() {
		assertThat(new FooBarQix().toText(352), is("FooBar"));
		assertThat(new FooBarQix().toText(3571), is("FooBarQix"));
	}

	@Test
	public void should_display_text_repeatedly_based_on_digits() {
		assertThat(new FooBarQix().toText(331), is("FooFoo"));
	}

	@Test
	public void should_combine_text_for_multiples_and_for_digits() {
		assertThat(new FooBarQix().toText(15), is("FooBarBar"));
		assertThat(new FooBarQix().toText(35), is("BarQixFooBar"));
	}

	@Test
	public void should_maintain_the_order_of_the_digits() {
		assertThat(new FooBarQix().toText(352), is("FooBar"));
		assertThat(new FooBarQix().toText(53), is("BarFoo"));
	}

	@Test
	public void should_execute_specifications_examples_correctly() {
		assertThat(new FooBarQix().toText(13), is("Foo"));
		assertThat(new FooBarQix().toText(15), is("FooBarBar"));
		assertThat(new FooBarQix().toText(33), is("FooFooFoo"));
		assertThat(new FooBarQix().toText(51), is("FooBar"));
		assertThat(new FooBarQix().toText(53), is("BarFoo"));
		assertThat(new FooBarQix().toText(21), is("FooQix"));
	}

	@Test
	public void should_display_numbers_from_1_to_a_value() {
		assertThat(new FooBarQix().asTextUpTo(2), is("1\n2"));
	}
}
