package lectures.part4.pattern

import scala.util.Random

object PatternMatching extends App {

  val random = new Random
  val x = random.nextInt(10)

  val desc = x match {
    case 1 => "1"
    case 2 => "2"
    case 3 => "3"
    case _ => "something else"
  }

  println(x)
  println(desc)

  // Decompose values
  case class Person(name: String, age: Int)
  val bob = Person("Bob", 20)
  val greeting = bob match {
    case Person(n,y) /*if a < 21*/ => s"Hi I`m a $n and I`m $y years old"
    case _ => "Who am I?"
  }
  println(greeting)

  // sealed
  sealed class Animal
  case class Dog(breed: String) extends Animal
  case class Parrot(greeting: String) extends Animal

  val animal: Animal = Dog("Terra nova")
  animal match  {
    case Dog(someBreed) => println(s"My breed is $someBreed")
  }
}
