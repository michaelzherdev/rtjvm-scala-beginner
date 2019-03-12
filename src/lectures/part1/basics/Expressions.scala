package lectures.part1.basics
//Instruction (do something) or Expression (give me the vale of something)
object Expressions extends App {

  val x = 1 + 2
  println(x)

  println(1 == x)

  val aCondition = true
  val aConditionValue = if (aCondition) 5 else 3
  println(aConditionValue)

  // everything in Scala is an expression

  var aVar: Int = 1
  val aWeird = (aVar = 3)
  println(aWeird)


  // code blocks
  // value of block is the value of last expression
  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "more" else "less"
  }


}
