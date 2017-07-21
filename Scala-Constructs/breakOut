// Avoid Creating Intermediate Collection
val li = List(('A', 1), ('B', 1), ('C', 11), ('D', 231))
val result: Map[Char, Int] = li.map(tup => (tup._1 -> tup._2))(collection.breakOut)
println(result)

Result
Map(A -> 1, B -> 1, C -> 11, D -> 231)
