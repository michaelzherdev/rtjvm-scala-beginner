package exercises.part2.oop

object OOBasics extends App {

  /*
  Novel and Writer
   */

  class Writer(firstName: String, surname: String, val year: Int) {
    def fullname() = {
      s"$firstName $surname"
    }
  }

  class Novel(name: String, releaseYear: Int, author: Writer) {
    def authorAge(): Int = releaseYear - author.year

    def isWrittenBy(author: Writer): Boolean = author == this.author

    def copy(newReleaseYear: Int): Novel = new Novel(name, newReleaseYear, author)
  }

  val author = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectations", 1861, author)

  println(novel.authorAge())
  println(novel.isWrittenBy(author))


  /*
  Counter
   */
  class Counter(val count: Int = 0) {
    def inc = new Counter(count + 1) //immutability
    def dec = new Counter(count - 1)

    //    def inc(n: Int) = new Counter(count + n)
    def inc(n: Int): Counter = {
      if (n <= 0) this
      else inc.inc(n - 1)
    }

//    def dec(n: Int) = new Counter(count - n)
    def dec(n: Int): Counter = {
      if (n <= 0) this
      else dec.dec(n - 1)
    }

    def print = println(count)
  }

  val counter = new Counter
  counter.inc.print
  counter.inc(5).print
}
