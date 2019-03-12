package lectures.part3.fp

object Options extends App{

  val option: Option[Int] = Some(4)
  val noOption: Option[Int] = None

  println(option)

  def unsafe(): String = null
//  val res = Some(unsafe()) // WRONG
  val res = Option(unsafe())
  println(res)

  // chained methods
  def backupMethod(): String = "A"
  val chainedResult = Option(unsafe()).orElse(Option(backupMethod()))

  //DESIGN
  def betterUnsafeMethod(): Option[String] = None
  def betterBackupMethod(): Option[String] = Some("A")
  val betterChainedRes = betterUnsafeMethod() orElse betterBackupMethod()
}
