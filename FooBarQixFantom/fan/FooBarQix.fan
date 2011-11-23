
class FooBarQix
{
  
  static Void main(Str[] args)
  {
    fooBarQix := FooBarQix {}
    for (index := 1; index <= 100; ++index)
    {
      echo(fooBarQix.asText(index))
    }
  }
    Str asText(Int value) {
      result := asTextFromMultiple(value, 3, "Foo") 
        + asTextFromMultiple(value, 5, "Bar") 
        + asTextFromMultiple(value, 7, "Qix")
        + asTextFromDigit(value)
      return result == "" ? "" + value : result
    }
  
  private Str asTextFromMultiple(Int number, Int value, Str text)
  {
    return number % value == 0 ? text : ""
  }

  private Str asTextFromDigit(Int number)
  {
    text := ("" + number).chars
    Str result := ""
    for (index := 0; index < text.size; ++index)
    {
      if (text[index] == '3') result = result + "Foo"
      if (text[index] == '5') result = result + "Bar"
      if (text[index] == '7') result = result + "Qix"
    }
    return result
  }
}
