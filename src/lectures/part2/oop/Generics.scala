package lectures.part2.oop

object Generics extends App {

  class MyList[A] {

    def add[B >: A](element: B): MyList[B] = ???
    /*
    A = Cat
    B = Animal
     */
  }

  val listOfInt = new MyList[Int]
  val listOfString = new MyList[String]

  //generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyList = MyList.empty[Int]

  // variance problem
  class Animal

  class Cat extends Animal

  class Dog extends Animal

  //1. List[Cat] extends List[Animal] - covariance
  class CovariantList[+A]

  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]

  // 2. NO = INVARIANCE
  class InvariantList[A]

  val invariantList: InvariantList[Animal] = new InvariantList[Animal]

  // 3. CONTRACARIANCE
  class ContravarianceList[-A]

  val contravarianceList: ContravarianceList[Cat] = new ContravarianceList[Animal]

  // bounded types
  class Cage[A <: Animal] //subtypes of Animal
}
