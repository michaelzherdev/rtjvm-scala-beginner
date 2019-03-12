package lectures.part2.oop

object MethodNotations extends App{

  class Person(val name: String, favoriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def unary_! : String = s"$name, what the heck?"
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name and i like $favoriteMovie"

    def +(nickname: String): Person = new Person(s"$name ($nickname)", favoriteMovie)
    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)
    def learns(thing: String) = s"$name is learning $thing"
    def learnsScala = this learns "Scala"
    def apply(n: Int): String = s"$name watched $favoriteMovie $n times"
  }

  val alice = new Person("Mary", "Inception")
  println(alice.likes("Inception"))
  println(alice likes "Inception") // equivalent

  // prefix notation
  val x = -1 // equivalent with 1.unary_-
  val y = 1.unary_-
  // unary_ prefix only works with - + ! ~
  println(!alice)

  // postfix notation
  println(alice.isAlive)
  println(alice isAlive)

  //apply
  println(alice.apply())
  println(alice())

  //exercises
  println((alice + "the Rockstar")())
  println((+alice).age)
  println(alice learns "Scala")
  println(alice learnsScala)
  println(alice(2))
}
