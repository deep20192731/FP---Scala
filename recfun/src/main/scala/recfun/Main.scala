package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int =
      if(r == 0 && c == 0) 1
      else if(r < 0 || c < 0) 0
      else
        pascal(c-1, r-1) + pascal(c, r-1)
  
  /**
   * Exercise 2
   */
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

  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int =
      if(money == 0) 1
      else if(money > 0 && !coins.isEmpty)
        // This solution will avoid duplicates since 121 is possible ut 211 is not since when we are considering coin 2 then we
        // dont take into account denominations which we have left behind.
        countChange(money - coins.head, coins) + countChange(money, coins.tail)
      else 0
  }
