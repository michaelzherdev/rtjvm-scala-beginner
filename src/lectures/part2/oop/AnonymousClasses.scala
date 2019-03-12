package lectures.part2.oop

object AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }

  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("ahaahah")
  }
  println(funnyAnimal.getClass)

  class Person(name: String) {
    def sayHi: Unit = println("Hi")
  }

  val jim = new Person("Jim") {
    override def sayHi: Unit = println("Hi, I`m Jim")
  }
}
