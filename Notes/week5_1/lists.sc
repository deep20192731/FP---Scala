val l1 = List(1, 2, 3)
val l2 = List(5, 6, 7)

// Concatenation
l1 ::: l2
l1 ++ l2

// creates a new list and returns that
l1 updated (2, 7)


// Parametrization with ordering...
// ord: Ordering.......ord.lt (less than)
// Ordering.Int, Ordering.String is already there in ordering


// Implicit params
// (implicit ord: Ordering)
// In the call, we can leave out the ordering and compiler will automatically deduct the ordering


// Higher order list functions
l1 map ((x: Int) => x*2)
l2 filter ((x: Int) => x==7)
l1 partition ((x: Int) => x<6) // filter and filterNot as a pair

l1 takeWhile (x => x<2) // stops just before that element for which the condition sosent satisfy
l1 dropWhile (x => x<2)

l1 span (x => x<2) // combine above two

// List-Reductions/ Fold-Reduce combinators - Higher Order (like reduce in Map-Reduce)
// or actions in Spark
l1 reduceLeft ((x, y) => x-y)   // (1-2) - 3 see it as tree

// shorter way - _ represents a new param going fro left to right
l2 reduceLeft (_ + _)

// fold left is same as reduce left + takes accumulator, which is returned when op performed on empty list
(l1 foldLeft 0)(_ + _) // (x1 + x2) + ... + z(accumulator)
(l2 foldLeft 1)(_ * _)

(l1 foldRight 0)(_ + _) // tree on the other side // (xn + z) + (...
// For associative and commutative function they are equal
// else for example concat


val l3 = "Deepesh"
val l4 = l3 flatMap (x => List((x, 1))) groupBy (_._1.toLower) mapValues (_ map (_._2) sum)
val l5 = List("Sd", "fg")
l5 reduceLeft ((a, b) => a.concat(b))
