// since mathematics have a common pattern for this
// summation(from a->b) f(a)
// Using higher order functions we abstract that common pattern out in a function


def sum(f: Int => Int, a: Int, b: Int): Int =
  if(a > b) 0
  else f(a) + sum(f, a+1, b)

def cube(a: Int): Int = a * a * a
def fact(a: Int): Int = if(a == 0) 1 else a * fact(a-1)

// sum of all cubs from a->b
sum(cube, 1, 3)

// sum of all factorials from a->b
sum(fact, 1, 3)

