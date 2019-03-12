package lectures.part2.oop

object Exceptions extends App {

//  val weirdValue = throw new NullPointerException

  def getInt(withException: Boolean): Int =
    if(withException) throw new RuntimeException("No!")
    else 42

  val potentialFail = try {
    getInt(true)
  } catch {
    case e: RuntimeException => println("caught")
  } finally {
    println("finally")
  }

  // define own exception
  class MyException extends Exception
  val exception = new MyException
//  throw exception

  //OutOfMemmoryError
//  val array = Array.ofDim(Int.MaxValue)

  // StackOverFlowError
//  def infinite: Int = 1 + infinite
//  val noLimit = infinite

  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException
  class MathCalculationException extends RuntimeException("Division by 0")

  object PocketCalculator {
    def add(x: Int, y: Int) = {
      val result = x + y
      if(x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }

    def substract(x: Int, y: Int) = {
      val result = x - y
      if(x > 0 && y < 0 && result < 0) throw new OverflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def multiply(x: Int, y: Int) = {
      val result = x * y
      if(x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result < 0) throw new OverflowException
      else if (x > 0 && y < 0 && result > 0) throw new UnderflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def divide(x: Int, y: Int) = {
      if(y == 0) throw new MathCalculationException
      x / y
    }
  }

  println(PocketCalculator.add(Int.MaxValue, 10))
  println(PocketCalculator.divide(2, 0))
}
