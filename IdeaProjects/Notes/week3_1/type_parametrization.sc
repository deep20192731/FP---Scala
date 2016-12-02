package week3_1

// im-mutable LL
trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}

// at the same-time intializing param and field in the class
class Cons[T](val v: T, val link: List[T]) extends List {
  def isEmpty: Boolean = false
  def head: Int = head
  def tail: List[T] = link
}

class Nil extends List {
  def isEmpty: Boolean = true
  def head: Nothing = throw new NoSuchElementException("Empty list..so no head")
  def tail: Nothing = throw new NoSuchElementException("Same error message")
}


// type parameters are passed as [] to both classes and fucntions(generic functions)
// def singletonObj[T](e: T) = ...


// Before evaluating the program, through substituion model, we remove all type params
// this property is known as type erasure(ex java too has this)
// These languages, does not keep type params at runtime, C++ keeps those


// Polymorphism principles = subtyping and generics(type parameters)