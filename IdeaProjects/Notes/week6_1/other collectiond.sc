// vector (very shallow trees) - balanced access methods, if # elements>32 every element is a pointer to vector of 32 and then so on
// scala lists are LL
/**
  * Q: Should I use List or Vector?
Answer: You most probably want a Vector, unless your algorithm can be expressed only using ::, head and tail, then use a List.
Explanation: Some people compare List vs Vector in Scala to LinkedList vs ArrayList in Java. This is partially OK, because:

Scala Vector is a collection with good random access (like java.util.ArrayList)
Scala List is indeed a linked list with very fast append-first operation (::), but the links are unidirectional (for bi-directional use DoubleLinkedList).
However, Scala Vector has a very effective iteration implementation and, comparing to List is faster in traversing linearly (which is weird?), so unless you are planning to do quite some appending, Vector is a better choice. Additionally, Lists don’t work well with parallel algorithms, it’s hard to break them down into pieces and put together in an efficient way.
  */

// by default choose vector
// vectors very good for bulk operations where some operation involved on most elements
// operations are on a chunks of 32. Canbe parallel
// Size of cache line is also 32 so fast access. Good Locality

// If operations fit with head and tail then choose lists. Since oth constant type

// no cons :: in vectors but
// +: and :+  -> : is always with :
val v1 = Vector(1,2,3,4,5)
val v2 = Vector(6,7,8,9)

v1 :+ 10
1 +: v2

// They are child class of Iterable


// Sequence is the base class - Vector Lists Range(sequence of evenly spaced integers)
// Arrays and Strings support same operations as Sequences and can be implicitly converted
// They come from java so they cannot be child class of sequence
val a1 = Array(1,2,3)
a1 map (x=>x+1) // Implictly converted

// Range have 3 fields, lower_bound, upper_bound, step - stored as compact values
val r1 = 1 until 10 // 1 to 5
val r2 = 1 until 10 by 2
val r3 = 1 until 10 by -2


v1 exists (x => x==2)
v1 forall (x => x >0)
v1 zip v2
v1 flatMap (x => List('.' + x)) // coonverts each element to a list and then aggregae back each
1 to 10 flatMap (x => 1 to 10 map (y => (x, y)))

// Scalar product of v1 and v2
//(v1 zip v2 map (p => List(p._1*p._2))).sum

// Sets too
// unordered
// no duplicates

// Map too (both iterables and functions) class map also extend funtin type Key=>Value
val m1 = Map("I" -> 1, "S" -> 2)
m1 get "S"

// Option values (another type)
// Option can be Some(case class) and None(object)..

// since option is a case clas, we can do pattern matching
m1 get "p" match {
  case Some(x) => x
  case None => "Nothing found"
}


// orderBy equivalent sortWith, sorted(natural order)
// groupBy equivalent groupBy

// Maps are partial functions(functions that dont enforce all elements of domain to match to range)
// In maps if we apply map to a non existent key value we get exception
// map withDefaultValue ...
// This will convert map to full function













