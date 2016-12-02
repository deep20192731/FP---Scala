def sum(f: Int => Int, a: Int, b: Int): Int =
  if(a > b) 0
  else f(a) + sum(f, a+1, b)

// Instead of defining these as new functions we can treat them like literals
// for instance string exist as literals(something which is a direct source code)
// println("abc") - here we used "abc" directly
//def cube(a: Int): Int = a * a * a
//def fact(a: Int): Int = if(a == 0) 1 else a * fact(a-1)

// sum of all cubs from a->b
sum((a: Int) => a * a * a, 1, 3)

// sum of all factorials from a->b
//sum(fact, 1, 3)