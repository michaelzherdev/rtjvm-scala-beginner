package lectures.part3.fp

import scala.util.Random

object SequensesAndLists extends App {
  // Sequences
  val aSeq = Seq(1,3,2,4)
  print(aSeq)
  print(aSeq.reverse)
  print(aSeq(2))
  print(aSeq ++ Seq(7,5,6))
  print(aSeq.sorted)

  // Ranges
  val aRange: Seq[Int] = 1 until 10
  aRange.foreach(print)

  (1 to 10).foreach(x => println("A"))

  // Lists
  val aList = List(1,2,3)
  val prepended = 42 :: aList
  val prepended2 = 42 +: aList :+ 43
  println(prepended2)

  val apples5 = List.fill(5)("apple")
  println(apples5)
  println(aList.mkString("-"))

  // Arrays
  val numbers = Array(1,2,3,4)
  val threeElems = Array.ofDim[String](3)
  threeElems.foreach(println)

  //mutation
  numbers(2) = 0
  println(numbers.mkString(" "))

  // arrays and sequences
  val numberSeq: Seq[Int] = numbers
  println(numberSeq)

  // Vector
  val vector: Vector[Int] = Vector(1,2,3)

  //vectors vs lists
  val maxRuns = 1000
  val maxCapacity = 100000
  def getWriteTime(collection: Seq[Int]): Double = {
    val r = new Random
    val times = for {
      it <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity), 0)
      System.nanoTime() - currentTime
    }
    times.sum * 1.0 / maxRuns
  }

  val numbersList = (1 to maxCapacity).toList
  val numbersVector = (1 to maxCapacity).toVector
  println(getWriteTime(numbersList))
  println(getWriteTime(numbersVector))
}
