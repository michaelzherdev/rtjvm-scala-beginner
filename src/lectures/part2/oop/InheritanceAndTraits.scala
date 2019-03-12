package lectures.part2.oop

object InheritanceAndTraits extends App {

  class Person(name: String, age: Int) {}

  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)

  // sealed - 3rd way (after final keyword) to prevent overriding.
  // Possible to extend class only in this file
  sealed class Animal {
    val creatureType = "wild"

    def eat = println("nomnom")
  }

  //  class Dog extends Animal {
  //    override val creatureType: String = "domestic"
  //    override def eat = println("crunch crunch")
  //  }
  class Dog(dogType: String) extends Animal {
    override val creatureType: String = dogType

    override def eat = println("crunch crunch")
  }

  val dog = new Dog("domestic")
  dog.eat

  //type substitution (broad:polymorhism)
  val unknown: Animal = new Dog("K9")
  unknown.eat


}
