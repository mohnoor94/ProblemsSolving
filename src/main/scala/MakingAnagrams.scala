/**
  * Strings: Making Anagrams
  * Problem Statement: https://www.hackerrank.com/challenges/ctci-making-anagrams/problem
  */
object MakingAnagrams {

  def main(args: Array[String]): Unit = {
    val stdin = scala.io.StdIn
    val a = stdin.readLine
    val b = stdin.readLine

    println(a.length + b.length - 2 * a.intersect(b).length)
  }
}