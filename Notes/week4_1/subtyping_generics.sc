// BOUNDS
class IntSet {}

// create singleotn objects
object Empty extends IntSet {}
object NonEmpty extends IntSet {}

// S<:T = S is a subtype of T (Upper Bounds)
// S>:T (Lower Bounds)
// [S >:Nonempty <: IntSet] (Mixed Bounds)
def assertAllPositives[S <: IntSet](s: S): S

// Instead of being more precise, we could have gone more precise like
// def asssertAllPositives(s: IntSet): IntSet   ... This is subtype polymorphism



// Co-variance - subtyping depends on the type parameter
// List[NonEmpty] <: List[IntSet]  (Co-Variant)
// but not List[Boolean] <: List[IntSet]

// Important in scala arrays are not co-variant, This is how they are defined in scala
// unlike java IntSet[4]
// a(2) is ~ to a[2] in java
// indexing is function calls

val a: Array[IntSet]


