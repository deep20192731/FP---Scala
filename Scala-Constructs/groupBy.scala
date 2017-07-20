val listOfTuples = List(('A', 1, 2), ('C', 10, 34), ('B', 123, 133), ('B', 15, 42), ('C', 53, 234), ('A', 123, 0))
val mappedTuples = listOfTuples.map(tuple => tuple._1)
println(mappedTuples)

Output
Map('A' -> List(('A', 1, 2), ('A', 123, 0),
    'B' -> List(('A', 123, 133), ('B', 15, 42)),
    'C' -> List(('A', 10, 34), ('C', 53, 234)))
