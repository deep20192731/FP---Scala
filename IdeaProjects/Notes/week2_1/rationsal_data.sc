// This is a primary condructor. takes the arguments and exceutes the clas body. All the val and not def
class Rational(n: Int, d: Int) {
   // this is a predefined function. Illegal argument exception
   require(d != 0, "Denominator should not be zero")
   // assert too Check the code of function. Assert exception
   //assert(n >= 0, "Just seeing how this works, not intended")

  // Other constructors for the class. Calls the implicit primary constructor
   def this(x: Int) = this(x, 1)

   private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
   private val g = gcd(n, d)

   // Making these val helps since we dont calculate the value of these expressions
   // more than once
   val nume = n / g
   val denm = d / g

   override def toString = nume + "/" + denm

   def neg(r: Rational) = new Rational(-r.nume, r.denm)

   def add(r: Rational) = new Rational(nume * r.denm + r.nume * denm, denm * r.denm)

  // Operators too in scala are treated as identifiers. Most languages have
  // identifiers as alphanumeric but in scala identifiers can also be symbolic
  // Scala's way of operator overloading
  def -(r: Rational) = this.add(neg(r))

   def less(r: Rational) = nume*r.denm < r.nume*denm

   def max(r: Rational) = if(less(r)) r else this
 }

 def x = new Rational(2, 3)
 def y = new Rational(1, 6)

// Precedence of a operator is defined by its first character. And then everything is same as Java
 x - y // infix notation
 x max new Rational(1, 2) // infix notation

