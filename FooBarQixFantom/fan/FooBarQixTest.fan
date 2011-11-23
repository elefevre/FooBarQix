
class FooBarQixTest : Test { 
  Void test_that_by_default_the_text_is_the_number()
  {
    verifyEq(FooBarQix{}.asText(1), "1")
  }

  Void test_that_text_is_displayed_for_multiples_of_3_5_and_7()
  {
    verifyEq(FooBarQix{}.asText(6), "Foo")
    verifyEq(FooBarQix{}.asText(10), "Bar")
    verifyEq(FooBarQix{}.asText(14), "Qix")
  }

  Void test_that_text_is_displayed_for_numbers_containing_of_3_5_and_7()
  {
    verifyEq(FooBarQix{}.asText(13), "Foo")
    verifyEq(FooBarQix{}.asText(52), "Bar")
    verifyEq(FooBarQix{}.asText(17), "Qix")
  }

  Void test_that_text_is_combining_multiples_and_digits()
  {
    verifyEq(FooBarQix{}.asText(3), "FooFoo")
    verifyEq(FooBarQix{}.asText(5), "BarBar")
    verifyEq(FooBarQix{}.asText(7), "QixQix")
    verifyEq(FooBarQix{}.asText(15), "FooBarBar")
    verifyEq(FooBarQix{}.asText(51), "FooBar")
    verifyEq(FooBarQix{}.asText(53), "BarFoo")
    verifyEq(FooBarQix{}.asText(21), "FooQix")
    verifyEq(FooBarQix{}.asText(33), "FooFooFoo")
  }
}
