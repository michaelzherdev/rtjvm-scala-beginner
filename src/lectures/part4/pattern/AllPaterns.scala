package lectures.part4.pattern

import exercises.part3.fp.{Cons, Empty, MyList}


class AllPaterns extends App {

  //1 constants
  val x: Any = "Scala"
  val constans = x match {
    case 1 => "a number"
    case "" => "The Scala"
    case true => "Truth"
  }

  // 2 match anything
  val matching = x match {
    case _ =>
  }

  // 3 tuples
  val aTuple = (1, 2)
  val matchTuple = aTuple match {
    case (1, 1) =>
    case (1, 2) => "something"
  }

  // 4 case classes - constructor pattern - can be nestes with CCs as well
  val aList: MyList[Int] = Cons(1, Cons(2, Empty))
  val matchAList = aList match  {
    case Empty =>
    case Cons(head, Cons(subhead, subtail)) =>
  }
  //...

  // 7 name binding
  val nameBinding = aList match {
    case nonEmptyList @ Cons(_, _) => // name binding - use name later (here)
    case Cons(1, rest @ Cons(2, _)) => //inside nested pattern
  }
}
