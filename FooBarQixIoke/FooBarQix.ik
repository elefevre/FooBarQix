use("ispec")

labels = {3 => "Foo", 5 => "Bar", 7 => "Qix"}

textForMultiples = method(number,
  [3, 5, 7] map(n, if(number % n == 0, labels[n], "")) join
)

textForDigits = method(number,
  number asText chars map(toRational) map(n, if(labels[n] nil?, "", labels[n])) join
)

fooBarQix = method(number,
  result = textForMultiples(number) + textForDigits(number)

  if(result empty?, number asText, result)
)

fooBarQixUpTo = method(number,
  (1..number) map(n, fooBarQix(n)) join("\n")
)

fooBarQixUpTo(100) println

describe("fooBarQix",
  it("should return the number by default",
  	fooBarQix(1) should == "1"
  	fooBarQix(2) should == "2"
  )
  it("should return Foo for multiples of 3",
    fooBarQix(6) should == "Foo"
    fooBarQix(9) should == "Foo"
  )
  it("should return Bar for multiples of 5",
    fooBarQix(10) should == "Bar"
    fooBarQix(20) should == "Bar"
  )
  it("should return Qix for multiples of 7",
    fooBarQix(14) should == "Qix"
    fooBarQix(28) should == "Qix"
  )
  it("should combine words for multiples of 3, 5 and 7",
    fooBarQix(210) should == "FooBarQix"
  )
  it("should return Foo each time the number contains the digit 3",
    fooBarQix(13) should == "Foo"
    fooBarQix(31) should == "Foo"
    fooBarQix(233) should == "FooFoo"
  )
  it("should return Bar each time the number contains the digit 5",
    fooBarQix(52) should == "Bar"
    fooBarQix(551) should == "BarBar"
  )
  it("should return Qix each time the number contains the digit 7",
    fooBarQix(17) should == "Qix"
    fooBarQix(71) should == "Qix"
    fooBarQix(277) should == "QixQix"
  )
  it("should combine words for each digits 3, 5, and 7 it contains",
    fooBarQix(53) should == "BarFoo"
    fooBarQix(73) should == "QixFoo"
    fooBarQix(1751) should == "QixBar"
    fooBarQix(253) should == "BarFoo"
    fooBarQix(173) should == "QixFoo"
  )
  it("should combined words for multiples and digits of 3, 5, and 7",
    fooBarQix(33) should == "FooFooFoo"
    fooBarQix(35) should == "BarQixFooBar"
  )
)

describe("fooBarQixUpTo",
  it("should return the numbers separated by carriage returns",
    fooBarQixUpTo(1) should == "1"
    fooBarQixUpTo(2) should == "1\n2"
    fooBarQixUpTo(3) should == "1\n2\nFooFoo"
  )
)