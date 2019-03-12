package lectures.part3.fp

import scala.util.{Failure, Success, Try}

object Failures extends App {

  //create success and failure
  val aSuccess = Success(3)
  val aFailure = Failure(new RuntimeException("FAIL"))

  println(aSuccess)
  println(aFailure)

  def unsafe() :String = throw new RuntimeException("FAIL!")
  val potentialFailure = Try(unsafe())
  println(potentialFailure)

}
