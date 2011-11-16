package net.ericlefevre;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class FooBarQixTest {

	@Test
	public void should_display_numbers_from_1_to_a_value() {
		assertThat(new FooBarQix().asTextUpTo(1), is("1"));
		assertThat(new FooBarQix().asTextUpTo(2), is("1\n2"));
	}

}
