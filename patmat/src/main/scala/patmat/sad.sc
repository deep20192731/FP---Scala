import patmat.Huffman.{CodeTree, Fork, Leaf}

def times(chars: List[Char]): List[(Char, Int)] = chars match {
  case Nil => List()
  case List(y) => List((y, 1))
  case x :: xs => List((x, xs.count((c: Char) => c == x) + 1)) ::: times(xs.filterNot((c: Char) => c == x))
}

val a = times(List('a', 'a', 'b', 'b', 'c'))


def makeOrderedLeafList(freqs: List[(Char, Int)]): List[Leaf] = {
  def insert(x: Leaf, xs: List[Leaf]): List[Leaf] = xs match {
    case List() => List(x)
    case y :: ys => if (x.weight <= y.weight) x :: xs else y :: insert(x, ys)
  }
  def iSort(xs: List[(Char, Int)]): List[Leaf] = xs match {
    case List() => List()
    case y :: ys => insert(Leaf(y._1, y._2), iSort(ys))
  }

  iSort(freqs)
}

def weight(tree: CodeTree): Int = tree match {
  case Leaf(char, wei) => wei
  case Fork(left, right, chars, wei) => weight(left) + weight(right)
}

def chars(tree: CodeTree): List[Char] = tree match {
  case Leaf(char, wei) => List(char)
  case Fork(left, right, chars, wei) => chars
}

def combine(trees: List[CodeTree]): List[CodeTree] = {
  def insert(ct: CodeTree, l: List[CodeTree]): List[CodeTree] = l match {
      case List() => List()
      case x :: xs => if(weight(ct) > weight(x)) ct :: xs else List(ct) ::: List(x)
  }

  trees match {
    case List() => List()
    case x :: Nil => trees
    case x :: y :: ys => insert(Fork(x, y, chars(x) ::: chars(y), weight(x) + weight(y)),
      ys)
  }
}

type Bit = Int

/**
  * This function decodes the bit sequence `bits` using the code tree `tree` and returns
  * the resulting list of characters.
  */
def decode(tree: CodeTree, bits: List[Bit]): List[Char] = {
  def dec(t: CodeTree, biggerT: CodeTree, bits: List[Bit]): List[Char] = t match {
    case Leaf(c, w) => if(bits.size > 0) List(c) ::: dec(biggerT,biggerT, bits)
    else List(c)
    case Fork(l, r, chars, w) => if(bits.head == 0) dec(l, biggerT, bits.tail)
    else dec(r, biggerT, bits.tail)
  }
  dec(tree, tree, bits)
}

decode(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3),
  List(0,0,1, 1,0,0,0))
//combine(List(Leaf('e',1), Leaf('t',2), Leaf('x',5)))

//times(List('a', 'a', 'b', 'b', 'c'))
//makeOrderedLeafList(times(List('a', 'a', 'b', 'b', 'c', 'b')))