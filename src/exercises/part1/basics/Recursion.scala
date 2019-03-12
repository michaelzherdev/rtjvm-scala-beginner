package exercises.part1.basics

import scala.annotation.tailrec

object Recursion extends App {

  // concatenate a string n times
  @tailrec
  def concatenate(a: String, n: Int, accumulator: String): String = {
    if (n <= 0) accumulator
    else concatenate(a, n - 1, a + accumulator)
  }

  println(concatenate("a", 3, ""))

  // IsPrime function tail recursion
  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeHelper(t: Int, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeHelper(t - 1, n % t != 0 && isStillPrime)
    }

    isPrimeHelper(n / 2, true)
  }

  println(isPrime(2003))
  println(isPrime(4))

  // Fibonacci function tail recursion
  def fibonacci(n: Int): Int = {
    @tailrec
    def fiboTailrec(i: Int, last: Int, nextToLast: Int): Int = {
      if (i >= n) last
      else fiboTailrec(i + 1, last + nextToLast, last)
    }

    if (n <= 2) 1
    else fiboTailrec(2, 1, 1)
  }
  println(fibonacci(8))
}
