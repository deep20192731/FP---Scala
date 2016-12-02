// nested sequences in combinatorial search problems
// generate all pairs from 1 to n
// .fatten can also be used
1 until 4 flatMap (i =>
  1 until i map (j => (i, j)))


// In functionsal languages, higher order functionsa re good abstractions to for loop
// But using them in such conditions woould be diffcilu to understand ,so the below

// for expression
case class Person(name: String, age: Int)

val deep = Person("Deepesh", 21)
val persons: Seq[Person] = Vector(deep, Person("Raj", 19))

// to get all persons with age > 20
persons filter (p => p.age > 20)

// Using for expression (<- means taken from) - In java for loop operates a side effect that is it changes something while here it yields something
for(p <- persons if p.age < 20) yield p

// for (s) yield e
// s is a sequence of generators and filters
// generator    p<-j where p is a pattern and e an expression
// filter      if f where f is a boolean
// last generator is the inner loop type i.e it vary faster
// can also write for {}



for {
  i <- 0 until 4 // a genrator
  //j <- 0 until i // a generator
} yield (i)

val l1 = List(("a", 1), ("a", 2), ("b", 1), ("b", 2))
val l2 = List((("a", 1), ("b", 2)), (("a", 2), ("b", 2)))
l1 map (pair => List(pair))
l2 map (pair => List(pair))
l1 :: l2

val occ = List(('a', 2), ('b', 2))
