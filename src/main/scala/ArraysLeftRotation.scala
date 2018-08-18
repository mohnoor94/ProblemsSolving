
/**
  * Arrays: Left Rotation
  * Problem Statement: https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem
  */
object ArraysLeftRotation {

  def main(args: Array[String]): Unit = {
    println(rotateLeft(Array(1, 2, 3, 4, 5), 4).mkString(", "))
  }

  def rotateLeft(a: Array[Int], d: Int): Array[Int] = {
    val aLength = a.length
    val b = new Array[Int](aLength)
    for (i <- a.indices) b((aLength - d + i).abs % aLength) = a(i)
    b
  }
}