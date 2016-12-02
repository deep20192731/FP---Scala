def product(f: Int => Int)(a: Int,b: Int): Int =
  if (a > b) 1 else f(a) * product(f)(a + 1, b)

def sum(f: Int => Int)(a: Int,b: Int): Int =
  if (a > b) 0 else f(a) + sum(f)(a + 1, b)

product((a: Int) => a * a)(3, 4)

// factorial in terms of product
def fact(n: Int) = product((a: Int) => a)(1, n)

fact(5)

// currying up of sum and product(This is what exactly we do in mapReduce)
def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b:Int): Int =
  if(a > b) zero
  else combine(f(a), mapReduce(f, combine, zero)(a+1, b))


mapReduce((n: Int) => n, (x: Int, y: Int) => x * y, 1)(1, 3)
