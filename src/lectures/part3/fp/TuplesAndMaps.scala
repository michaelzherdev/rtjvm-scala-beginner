package lectures.part3.fp

object TuplesAndMaps extends App {

  // tuples = finite ordered "lists"
  val aTuple = Tuple2(2, "hello, Scala")

  println(aTuple._1)
  println(aTuple._2)
  println(aTuple.copy(_2 = "goodbye Java"))
  println(aTuple.swap)

  // Maps
  val aMap: Map[String, Int] = Map()

  val phonebook = Map(("Jim", 555), ("Dan", 777)).withDefaultValue(-1) // withDefaultValue(-1) - to prevent exception
  println(phonebook)
  println(phonebook.contains("Jim"))
  println(phonebook("Jim"))
  //  println(phonebook("jim")) // NoSuchElementException

  val newPair = "Mary" -> 667
  val newPhonebook = phonebook + newPair
  println(newPhonebook)

  println(phonebook.map(pair => pair._1.toLowerCase -> pair._2))
  println(phonebook.filterKeys(x => x.startsWith("J")))
  println(phonebook.mapValues(x => x * 10))

  // conversions
  println(phonebook.toList)
  println(List(("Dan", 555)).toMap)

}
