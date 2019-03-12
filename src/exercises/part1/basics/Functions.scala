package exercises.part1.basics

object Functions extends App {

  // a greeting function
  def aGreetingFunction(name: String, age: Int): String = {
    "Hello, my name is " + name + " and I`m " + age + " years old"
  }

  println(aGreetingFunction("Mikhail", 31))

  // factorial
  def factorial(n: Int): Int = {
    if (n <= 0) 1
    else n * factorial(n - 1)
  }

  println(factorial(4))

  // Fibonacci
  def fibonacci(n: Int): Int = {
    if (n <= 2) 1
    else fibonacci(n - 1) + fibonacci(n - 2)
  }

  println(fibonacci(4))

  // test if number is prime
  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean = {
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t - 1)
    }

    isPrimeUntil(n / 2)
  }

  println(isPrime(3))
  println(isPrime(6))
}
