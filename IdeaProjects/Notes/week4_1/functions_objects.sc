// functions are classes while function values are represented as objects.
// Similarly primitive types are represented as classes

// A => B (function type)
// is expanded as below

trait Function1[A, B] {
  def apply(x: A): B
}

// (x: Int) => x+2
// is expanded as below (class name is not important)

class AnonFunc extends Function1[Int, Int] {
  def apply(x: Int): Int = x+2
  new AnonFunc
}

// apply functions bridge the gap between functional and OO paradigms
// val f = (x: Int) => x+3 Type = Function1[Int,Int]
// f(7)
// translation will be

val f = new Function1[Int, Int] {
  def apply(x:Int): Int = x+3
}
f.apply(7)


// So this apply method can covert a class to a function too like below
class TestClass extends Function1[Int, Int] {
  def apply(x: Int): Int = 3
}

val t = new TestClass
t(2)


// Important - Only functions are objects, not Methods..so apply is not object


