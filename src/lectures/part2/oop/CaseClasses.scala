package lectures.part2.oop

object CaseClasses extends App {

  /*
  equals, hashCode, toString
   */

  case class Person(name: String, age: Int)

  //1. class parameters are fields
  val jim = new Person("jim", 23)
  println(jim.name)

  //2. sensible toString
  println(jim.toString) // == println(jim)

  //3. equals & hashCode implemented already
  val jim2 = new Person("jim", 23)
  println(jim == jim2)

  //4. case classes have handy copy method
  val jim3 = jim.copy(age = 45)
  println(jim3)

  //5. CCs have companion objects
  val thePerson = Person
  val mary = Person("Mary", 23)

  //6. case classes are serializable

  //7. CCs have extractor patterns = can be used in pattern matching

  case object UnitedKingdom {
    def name: String = "The UK"
  }
}
