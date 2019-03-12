package lectures.part1.basics

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n: Int): Int = {
    if (n <= 0) 1
    else {
      println("Computing factorial of " + n + " - firstly I need a factorial of " + (n - 1))
      val result = n * factorial(n - 1)
      println("Computed factorial of " + n)
      result
    }
  }

  //    println(factorial(4))

  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt = {
      if (n <= 1) accumulator
      else factHelper(x - 1, x * accumulator) // tail recursion - use recursive call at last expression
    }

    factHelper(n, 1)
  }

  println(anotherFactorial(2))

}
