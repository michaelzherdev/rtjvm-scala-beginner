package exercises.part2.oop

import lectures.part2.oop.Generics.MyList

abstract class MyList[+A] {
  /*
    head = first element of the list
    tail = remainder of the list
    isEmpty
    add(int) => new list with added element
    toString
   */

  def head: A

  def tail: MyList[A]

  def isEmpty: Boolean

  def add[B >: A](element: B): MyList[B]

  def printElements: String

  override def toString: String = "[" + printElements + "]  "

  def map[B](transformer: MyTransformer[A, B]): MyList[B]

  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B]

  def filter(predicate: MyPredicate[A]): MyList[A]

  //concatenation
  def ++[B >: A](list: MyList[B]): MyList[B]
}

case object Empty extends MyList[Nothing] {
  override def head: Nothing = throw new NoSuchElementException

  override def tail: MyList[Nothing] = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)

  override def printElements: String = ""

  override def map[B](transformer: MyTransformer[Nothing, B]) = Empty

  override def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]) = Empty

  override def filter(predicate: MyPredicate[Nothing]) = Empty

  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  override def head: A = h

  override def tail: MyList[A] = t

  override def isEmpty: Boolean = false

  override def add[B >: A](element: B): MyList[B] = new Cons(element, this)

  override def printElements: String = {
    if (t.isEmpty) "" + h
    else h + " " + t.printElements
  }

  override def filter(predicate: MyPredicate[A]): MyList[A] =
    if (predicate.test(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)

  override def map[B](transformer: MyTransformer[A, B]): MyList[B] =
    new Cons(transformer.transform(h), t.map(transformer))

  override def flatMap[B](transformer: MyTransformer[A, MyList[B]]) =
    transformer.transform(h) ++ t.flatMap(transformer)

  //concatenation
  def ++[B >: A](list: MyList[B]): MyList[B] = new Cons[B](h, t ++ list)
}

trait MyPredicate[-T] {
  def test(element: T): Boolean
}

trait MyTransformer[-A, B] {
  def transform(element: A): B
}

object ListTest extends App {
  val list = new Cons(1, Empty)
  println(list.head)
  val list2 = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println(list2.tail.head)
  println(list2.add(4).head)
  println(list2.isEmpty)
  println(list2.toString)

  val listOfInts = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val listOfIntsClone = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val anotherListOfInts = new Cons(4, new Cons(4, new Cons(6, Empty)))

    println(listOfInts.map(new MyTransformer[Int, Int] {
      override def transform(element: Int): Int = element * 2
    }).toString)

    println(listOfInts.filter(new MyPredicate[Int] {
      override def test(element: Int): Boolean = element % 2 == 0
    }).toString)

  println((listOfInts ++ anotherListOfInts).toString)

  println(listOfInts.flatMap(new MyTransformer[Int, MyList[Int]] {
    override def transform(element: Int): MyList[Int] = new Cons(element, new Cons(element + 1, Empty))
  }).toString)

  println(listOfInts == listOfIntsClone)
}
