package lectures.part2.oop

object OOBasics extends App {

val person = new Person("John", 33)
  println(person)
  println(person.age)
  person.greet("Daniel")

}

//class Person(name: String, age: Int)
class Person(name: String, val age: Int) {
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  //multiple constructors
  def this(name: String) = this(name, 0)
}
// class parameters are not fields