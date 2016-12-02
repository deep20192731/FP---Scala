import scala.annotation.tailrec

def pascal(c: Int, r: Int): Int =
  if(r == 0 && c == 0) 1
  else if(r < 0 || c < 0) 0
  else
    pascal(c-1, r-1) + pascal(c, r-1)

pascal(-1, -9)

def balance(chars: List[Char]): Boolean = {
  def iter(chars: List[Char], totalOpenBraces: Int): Boolean =
    if(totalOpenBraces < 0) false
    else
    if(chars.isEmpty)
      if(totalOpenBraces == 0) true
      else false
    else if(chars.head.equals('(')) iter(chars.tail, totalOpenBraces + 1)
    else if(chars.head.equals(')')) iter(chars.tail, totalOpenBraces - 1)
    else iter(chars.tail, totalOpenBraces)

  iter(chars, 0)
}

balance("I told him (that it’s not (yet) done). (But he wasn’t listening)".toList)

def countChange(money: Int, coins: List[Int]): Int = {
  if(money == 0)
    1
  else if(money > 0 && !coins.isEmpty)
    countChange(money - coins.head, coins) + countChange(money, coins.tail)
  else
    0
}

countChange(4, List(1, 2))


