package lectures.part3.fp

object AnonymousFunctions extends App {

  val doubler: Int => Int = (x: Int) => x * 2

  val niceIncrementer: Int => Int = _ + 1 // === x => x +1
  val niceAdder: (Int, Int) => Int = _ + _ // === (a,b) => a+b



}
