abstract class IntSet {
  // No body
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
}

// Binary tree representation of set
// Scala Singleton objects
object EmptySet extends IntSet {
  override def incl(x: Int): IntSet = new NonEmptySet(x, EmptySet, EmptySet)

  override def contains(x: Int): Boolean = false
}

// Persistenet DS = When we make changes, we create new parts rather than mutating
  // the original one. But the old versions are still maintained.
// This is persistent DS
class NonEmptySet(elem  : Int, left: IntSet, right: IntSet) extends IntSet {
  override def incl(x: Int): IntSet = new NonEmptySet(x, EmptySet, EmptySet)

  override def contains(x: Int): Boolean = false
}