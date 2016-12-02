// Tail recursive version of factorial
def factorial(a: Int): Int = {
  def iter(result: Int, fact: Int): Int =
    if (fact == 0) result
    else iter(fact * result, fact - 1)
  iter(1, a)
}

factorial(12)




