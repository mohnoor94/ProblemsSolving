/**
  * Find the farthest (last) letter of the alphabet in a given string
  */
object LastOfAlphabet {

  def main(args: Array[String]): Unit = {
    println(lastOfAlphabet("abcdefgZZ"))
    println(lastOfAlphabet("xzy"))
    println(lastOfAlphabet("xzY"))
    println(lastOfAlphabet("XyxxX"))
  }

  def lastOfAlphabet(text: String): Char = text.map(_.toLower).max
}
