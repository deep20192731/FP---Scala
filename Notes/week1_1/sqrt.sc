def abs(a: Double): Double =
  if(a < 0 ) -a
  else a

def sqrtIter(guess: Double, a: Double): Double =
  if(guessGoodEnough(guess, a)) guess
  else sqrtIter(improveGuess(guess, a), a)

def guessGoodEnough(guess: Double, a: Double) =
  abs(guess * guess - a) / a <= 0.001

def improveGuess(guess: Double, a: Double): Double =
  (guess + a / guess) / 2

def sqrt(a: Double): Double = sqrtIter(1.0, a)

sqrt(1e80)





