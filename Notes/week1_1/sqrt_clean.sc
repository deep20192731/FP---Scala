def abs(a: Double): Double =
  if(a < 0 ) -a
  else a

def sqrt(a: Double): Double = {
  def sqrtIter(guess: Double): Double =
    if(guessGoodEnough(guess)) guess
    else sqrtIter(improveGuess(guess))

  // see this as an expression, so 'a' which is passed is just used in that expression
  // so these are not in a different scope
  def guessGoodEnough(guess: Double): Boolean =
    abs(guess * guess - a) / a <= 0.001

  def improveGuess(guess: Double): Double =
    (guess + a / guess) / 2

  sqrtIter(1.0)
}

//sqrt(1e80)





