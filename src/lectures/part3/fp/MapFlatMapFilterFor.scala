package lectures.part3.fp

object MapFlatMapFilterFor extends App {

  val list = List(1, 2, 3)
  println(list)
  println(list.head)
  println(list.tail)

  println(list.map(_ + 1))
  println(list.filter(_ % 2 == 0))

  val toPair = (x: Int) => List(x, x + 1)
  println(list.flatMap(toPair))

  // all combinations between 2 lists
  val nums = List(1, 2, 3, 4)
  val chars = List('a', 'b', 'c', 'd')
  val combinations = nums.flatMap(n => chars.map(c => "" + c + n))
  println(combinations)

  list.foreach(println)

  //for-comprehensions
  var forCombinations = for {
    n <- nums
    c <- chars
  } yield "" + c + n
  println(forCombinations)


  forCombinations = for {
    n <- nums if n % 2 == 0
    c <- chars
  } yield "" + c + n
  println(forCombinations)

  for {
    n <- nums
  } println(n)

  abstract class Maybe[+T] {
    def map[B](f: T => B): Maybe[B]

    def flatMap[B](f: T => Maybe[B]): Maybe[B]

    def filter(p: T => Boolean): Maybe[T]
  }

  case object MaybeNot extends Maybe[Nothing] {
    override def map[B](f: Nothing => B): Maybe[B] = MaybeNot

    override def flatMap[B](f: Nothing => Maybe[B]): Maybe[B] = MaybeNot

    override def filter(p: Nothing => Boolean): Maybe[Nothing] = MaybeNot
  }

  case class Just[+T](value: T) extends Maybe[T] {
    override def map[B](f: T => B): Maybe[B] = Just(f(value))

    override def flatMap[B](f: T => Maybe[B]): Maybe[B] = f(value)

    override def filter(p: T => Boolean): Maybe[T] = {
      if (p(value)) this
      else MaybeNot
    }
  }

  val just3 = Just(3)
  println(just3)
  println(just3.map(_ * 2))
  println(just3.flatMap(x => Just(x % 2 == 0)))
  println(just3.filter(_ % 2 == 0))
}
