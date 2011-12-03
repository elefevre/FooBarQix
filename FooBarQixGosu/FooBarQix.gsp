classpath "."

uses gw.lang.cli.CommandLineAccess

if (CommandLineAccess.getRawArgs().Count > 0 ) {
	run_tests();
} else {
	for (number in 1..100) {
		print(asText(number))
	}
}

static function  asText(number : int) : String {
	var result = ""
	if (number % 3 == 0) {
		result += "Foo"
	}
	if (number % 5 == 0) {
		result += "Bar"
	}
	if (number % 7 == 0) {
		result += "Qix"
	}
	
	result +=  ("" + number).toCharArray().toList().map( \ c -> c == '3' ? "Foo" : c == '5' ? "Bar" : c == '7' ? "Qix" : "" ).join("");

	return result == "" ? ("" + number) : result
}

static function run_tests() {
	// nominal case
	assertEquals(asText(1), "1")
	assertEquals(asText(2), "2")

	// multiples
	assertEquals(asText(6), "Foo")
	assertEquals(asText(9), "Foo")
	assertEquals(asText(10), "Bar")
	assertEquals(asText(14), "Qix")

	// digits
	assertEquals(asText(13), "Foo")
	assertEquals(asText(23), "Foo")
	assertEquals(asText(31), "Foo")
	assertEquals(asText(331), "FooFoo")
	assertEquals(asText(52), "Bar")
	assertEquals(asText(17), "Qix")
	
	// multiples and digits combined
	assertEquals(asText(51), "FooBar")
	assertEquals(asText(53), "BarFoo")
	assertEquals(asText(21), "FooQix")
	assertEquals(asText(15), "FooBarBar")
	assertEquals(asText(33), "FooFooFoo")
	
	print( "Success!" )
}

static function assertEquals(result : String, expected : String) {
	if (result != expected) {
		print ("Expected '" + expected + "', but got '" + result + "'")
		throw "Test failed!"
	}
}