/**
  * Reverse words and remove any unneeded spaces.
  */
object ReverseWordsScala {

  val reverseWords: String => String = (sentence: String) => sentence.trim.split("\\s+").map(_.reverse).mkString(" ")

  def main(args: Array[String]): Unit = {
    println(reverseWords("  Hello my    world!    "))
  }
}
