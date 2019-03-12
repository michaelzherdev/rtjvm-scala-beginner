package lectures.part1.basics

object Functions extends App {

  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("str", 3))

  def aParameterlessFunction(): Int = 42

  println(aParameterlessFunction())
  println(aParameterlessFunction)

  def aRepeatedFunction(a: String, n: Int): String = {
    if (n == 1) a
    else a + aRepeatedFunction(a, n - 1)
  }

  println(aRepeatedFunction("a", 3))

  // When you need loop, use recursion - FUNCTIONAL PROGRAMMING

  def aFunctionWithSideEffects(a: String): Unit = println(a)

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n-1)
  }


}
