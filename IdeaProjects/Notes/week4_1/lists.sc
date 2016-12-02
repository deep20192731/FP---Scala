// Lists
// Lists are immutable and they are recursive i.e they can have lists inside
// They way they are constructed are same as trees which we used in earlier lectures
val fruits: List[String] = List("apples", "banana", "grapes")

// Functional Decomposition is the process of taking a complex process and breaking it down into its smaller, simpler parts.
// Stamdard way of dcomposing a list
def insert(x: Int, l: List[Int]): List[Int]
def insertionSort(l: List[Int]): List[Int] = l match {
  case List() => Nil
  case y :: ys => insert(y, insertionSort(ys))
}

// all lists are constructed from Nil
// :: (pronounced as Cons) is the construction operataion

// x::xs first elemet as x and then the rest of elements == similar to new Cons(x, xs)

val nums = 1 :: 2 :: 3 :: 4 :: Nil // operatiors ending in : are right associative
// and they are method calls with objet on the right side

// Nil.::(4).::(3).::(2).::(1)

// patterns for list
// Nil
// x::xs matches a list with first ele as x and rest as xs
// List(q1, q2..)
// List(2 :: xs) - list with single element which is a list that starts with 2

