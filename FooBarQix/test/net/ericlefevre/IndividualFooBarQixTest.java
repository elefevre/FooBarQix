package net.ericlefevre;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class IndividualFooBarQixTest {
	@Test
	public void should_display_the_number_itself_by_default() {
		assertThat(new IndividualFooBarQix().toText(1), is("1"));
		assertThat(new IndividualFooBarQix().toText(2), is("2"));
	}

	@Test
	public void should_display_Foo_or_Bar_or_Qix_based_on_divisibility() {
		assertThat(new IndividualFooBarQix().toText(6), is("Foo"));
		assertThat(new IndividualFooBarQix().toText(9), is("Foo"));
		assertThat(new IndividualFooBarQix().toText(10), is("Bar"));
		assertThat(new IndividualFooBarQix().toText(20), is("Bar"));
		assertThat(new IndividualFooBarQix().toText(14), is("Qix"));
		assertThat(new IndividualFooBarQix().toText(28), is("Qix"));
	}

	@Test
	public void should_display_Foo_or_Bar_or_Qix_based_on_digits() {
		assertThat(new IndividualFooBarQix().toText(23), is("Foo"));
		assertThat(new IndividualFooBarQix().toText(31), is("Foo"));
		assertThat(new IndividualFooBarQix().toText(52), is("Bar"));
		assertThat(new IndividualFooBarQix().toText(521), is("Bar"));
		assertThat(new IndividualFooBarQix().toText(17), is("Qix"));
		assertThat(new IndividualFooBarQix().toText(71), is("Qix"));
	}

	@Test
	public void should_display_combined_text_based_on_digits() {
		assertThat(new IndividualFooBarQix().toText(352), is("FooBar"));
		assertThat(new IndividualFooBarQix().toText(3571), is("FooBarQix"));
	}

	@Test
	public void should_display_text_repeatedly_based_on_digits() {
		assertThat(new IndividualFooBarQix().toText(331), is("FooFoo"));
	}

	@Test
	public void should_combine_text_for_multiples_and_for_digits() {
		assertThat(new IndividualFooBarQix().toText(15), is("FooBarBar"));
		assertThat(new IndividualFooBarQix().toText(35), is("BarQixFooBar"));
	}

	@Test
	public void should_maintain_the_order_of_the_digits() {
		assertThat(new IndividualFooBarQix().toText(352), is("FooBar"));
		assertThat(new IndividualFooBarQix().toText(53), is("BarFoo"));
	}

	@Test
	public void should_execute_specifications_examples_correctly() {
		assertThat(new IndividualFooBarQix().toText(13), is("Foo"));
		assertThat(new IndividualFooBarQix().toText(15), is("FooBarBar"));
		assertThat(new IndividualFooBarQix().toText(33), is("FooFooFoo"));
		assertThat(new IndividualFooBarQix().toText(51), is("FooBar"));
		assertThat(new IndividualFooBarQix().toText(53), is("BarFoo"));
		assertThat(new IndividualFooBarQix().toText(21), is("FooQix"));
	}

	// 1
	// 2
	// FooFoo
	// 4
	// BarBar
	// -Foo
	// QixQix
	// 8
	// -Foo
	// -Bar
}
