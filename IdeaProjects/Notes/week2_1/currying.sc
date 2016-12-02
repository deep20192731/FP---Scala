def sum(f: Int => Int): ((Int, Int) => Int) = {
  def sumF(a: Int, b: Int): Int =
    if(a > b) 0
    else f(a) + sumF(a+1, b)
  sumF
}


// Awsome :) Look at the LOC and the amount of logic it solves. Same thing in
// java would be like around 20-30 LOC
sum((a: Int) => a)(1, 10)
sum((a: Int) => a * a * a)(1, 3)


// Another way of writing that(Multiple parameter lists)
// This is so common in scala. The inner function parameters can be passed just after
// the outer function parameter. The return type here is of the inner function, since the
// return type of the outer function is assumed to be the inner function

// Last parameter list is the parameter list of the inner function which is anonomous
// So if we have multiple parameter list then that is equivalent to n nested inner function
// with the return type defined for last anonomous function(This way of wrting is currying)
def sumNew(f: Int => Int)(a: Int, b: Int): Int = {
    if(a > b) 0
    else f(a) + sumNew(f)(a+1, b)
}

sumNew((a: Int) => a * a)(1, 4)