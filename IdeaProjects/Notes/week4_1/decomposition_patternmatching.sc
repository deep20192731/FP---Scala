
// Problem: Find a general and convenient way to access objects in a extesible class hierarchy
// We want to avoid checking whether an object is part of that class and then do
// some operations on it (1 Classification and acess methods)

//2
// Type tesing isInstanceOf
// Ty[e casting asInstanceOf

//3
// In scala..they are discouraged and there are better methods (they are low level and unsafe)
// OO Decomposition

//4
// Pattern Matching ()
// case class (implicitly add companion objects containg factory methods with apply)

//You can do pattern matching on it,
//You can construct instances of these classes without using the new keyword,
//All constructor arguments are accessible from outside using automatically generated accessor functions,
//The toString method is automatically redefined to print the name of the case class and all its arguments,
//The equals method is automatically redefined to compare two instances of the same case class structurally rather than by identity.
//The hashCode method is automatically redefined to use the hashCodes of constructor arguments.
//  Most of the time you declare a class as a case class because of point 1


trait Exprr {}
case class Number(n: Int) extends Exprr
case class Sum(e1: Exprr, e2: Exprr) extends Exprr

val e = new Number(2)
// normally this is not allowed. i.e constructor parameters are private
e.n
