
class FooBarQix
{
  static Void main(Str[] args)  {
    fooBarQix := FooBarQix {}
    (1..100).each |Int c| { echo(fooBarQix.asText(c)) }
  }

  const Map digitsToStrings := [3:"Foo", 5:"Bar", 7:"Qix"]
  Str asText(Int value)
  {
    result := asTextFromMultiple(value) + asTextFromDigit(value)
    return result == "" ? "" + value : result
  }
  
  private Str asTextFromMultiple(Int number)
  {
    return digitsToStrings.keys.map |Int c -> Str?| { return number % c == 0 ? digitsToStrings[c] : "" }.join;
  }

  private Str asTextFromDigit(Int number)
  {
    list := number.toStr.chars.map (|Int c -> Obj?| { return digitsToStrings[c.fromDigit] } );
    return list.join("") |Obj? c -> Str| { c == null ? "": c };
  }
}
