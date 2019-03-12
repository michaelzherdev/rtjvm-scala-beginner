package exercises.part3.fp

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

  //HOFs
  def map[B](transformer: A => B): MyList[B]

  def flatMap[B](transformer: A => MyList[B]): MyList[B]

  def filter(predicate: A => Boolean): MyList[A]

  //concatenation
  def ++[B >: A](list: MyList[B]): MyList[B]

  // new methods from Functional programming section
  def foreach(f: A => Unit): Unit

  def sort(compare: (A, A) => Int): MyList[A]

  def zipWith[B, C](list: MyList[B], zip: (A, B) => C): MyList[C]

  def fold[B](start: B)(operator: (B, A) => B): B
}

case object Empty extends MyList[Nothing] {
  override def head: Nothing = throw new NoSuchElementException

  override def tail: MyList[Nothing] = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)

  override def printElements: String = ""

  override def map[B](transformer: Nothing => B) = Empty

  override def flatMap[B](transformer: Nothing => MyList[B]) = Empty

  override def filter(predicate: Nothing => Boolean) = Empty

  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list

  def foreach(f: Nothing => Unit): Unit = ()

  def sort(compare: (Nothing, Nothing) => Int): MyList[Nothing] = Empty

  def zipWith[B, C](list: MyList[B], zip: (Nothing, B) => C): MyList[C] = {
    if (!list.isEmpty) throw new RuntimeException("List do not have the same length")
    else Empty
  }

  def fold[B](start: B)(operator: (B, Nothing) => B): B = start
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

  override def filter(predicate: A => Boolean): MyList[A] =
    if (predicate(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)

  override def map[B](transformer: A => B): MyList[B] =
    new Cons(transformer(h), t.map(transformer))

  override def flatMap[B](transformer: A => MyList[B]) =
    transformer(h) ++ t.flatMap(transformer)

  //concatenation
  def ++[B >: A](list: MyList[B]): MyList[B] = new Cons[B](h, t ++ list)

  def foreach(f: A => Unit): Unit = {
    f(h)
    t.foreach(f)
  }

  def sort(compare: (A, A) => Int): MyList[A] = {
    def insert(x: A, sortedList: MyList[A]): MyList[A] =
      if (sortedList.isEmpty) new Cons(x, Empty)
      else if (compare(x, sortedList.head) <= 0) new Cons(x, sortedList)
      else new Cons(sortedList.head, insert(x, sortedList.tail))

    val sortedTail = t.sort(compare)
    insert(h, sortedTail)
  }

  def zipWith[B, C](list: MyList[B], zip: (A, B) => C): MyList[C] = {
    if (list.isEmpty) throw new RuntimeException("List do not have the same length")
    else new Cons(zip(h, list.head), t.zipWith(list.tail, zip))
  }

  /*
  [1,2,3].fold(0)(+) ==> 6
   */
  def fold[B](start: B)(operator: (B, A) => B): B = {
//    val newStart = operator(start, h)
//    t.fold(newStart)(operator)
    t.fold(operator(start, h))(operator)
  }
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
  val anotherListOfInts = new Cons(4, new Cons(5, new Cons(6, Empty)))
  val listOfStrings = new Cons("Hello", new Cons("Scala", new Cons("!", Empty)))

  println(listOfInts.map((element: Int) => element * 2).toString)

  println(listOfInts.filter((element: Int) => element % 2 == 0).toString)

  println((listOfInts ++ anotherListOfInts).toString)

  println(listOfInts.flatMap((element: Int) => new Cons(element, new Cons(element + 1, Empty))).toString)

  println(listOfInts == listOfIntsClone)

  listOfInts.foreach(x => println(x))

  println(listOfInts.sort((x, y) => y - x))

  println(anotherListOfInts.zipWith[String, String](listOfStrings, _ + "-" + _))

  println(listOfInts.fold(0)(_ + _))
}
