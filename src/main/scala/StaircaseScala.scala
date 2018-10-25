/**
  * *** 'Amazon' interview question ***
  *
  * Staircase problem
  * Problem statement and more details: https://youtu.be/5o-kdjv7FD0
  */
object StaircaseScala {

  def main(args: Array[String]): Unit = {
    val steps1 = Set(1, 2)
    val steps2 = Set(1, 2, 5)
    val steps3 = Set(1, 3, 5)

    println(0 + " ==> " + numberOfWays(0))
    println(1 + " ==> " + numberOfWays(1))
    println(2 + " ==> " + numberOfWays(2))
    println(3 + " ==> " + numberOfWays(3))
    println(4 + " ==> " + numberOfWays(4))
    println(5 + " ==> " + numberOfWays(5))
    println(6 + " ==> " + numberOfWays(6))
    println(7 + " ==> " + numberOfWays(7))
    println("*******************")
    println(0 + ", " + steps1.mkString("(", ", ", ")") + " ==> " + numberOfWays(0, steps1))
    println(1 + ", " + steps1.mkString("(", ", ", ")") + " ==> " + numberOfWays(1, steps1))
    println(2 + ", " + steps1.mkString("(", ", ", ")") + " ==> " + numberOfWays(2, steps1))
    println(3 + ", " + steps1.mkString("(", ", ", ")") + " ==> " + numberOfWays(3, steps1))
    println(4 + ", " + steps1.mkString("(", ", ", ")") + " ==> " + numberOfWays(4, steps1))
    println(5 + ", " + steps1.mkString("(", ", ", ")") + " ==> " + numberOfWays(5, steps1))
    println(6 + ", " + steps1.mkString("(", ", ", ")") + " ==> " + numberOfWays(6, steps1))
    println(7 + ", " + steps1.mkString("(", ", ", ")") + " ==> " + numberOfWays(7, steps1))
    println("*******************")
    println(0 + ", " + steps2.mkString("(", ", ", ")") + " ==> " + numberOfWays(0, steps2))
    println(1 + ", " + steps2.mkString("(", ", ", ")") + " ==> " + numberOfWays(1, steps2))
    println(2 + ", " + steps2.mkString("(", ", ", ")") + " ==> " + numberOfWays(2, steps2))
    println(3 + ", " + steps2.mkString("(", ", ", ")") + " ==> " + numberOfWays(3, steps2))
    println(4 + ", " + steps2.mkString("(", ", ", ")") + " ==> " + numberOfWays(4, steps2))
    println(5 + ", " + steps2.mkString("(", ", ", ")") + " ==> " + numberOfWays(5, steps2))
    println(6 + ", " + steps2.mkString("(", ", ", ")") + " ==> " + numberOfWays(6, steps2))
    println(7 + ", " + steps2.mkString("(", ", ", ")") + " ==> " + numberOfWays(7, steps2))
    println("*******************")
    println(0 + ", " + steps3.mkString("(", ", ", ")") + " ==> " + numberOfWays(0, steps3))
    println(1 + ", " + steps3.mkString("(", ", ", ")") + " ==> " + numberOfWays(1, steps3))
    println(2 + ", " + steps3.mkString("(", ", ", ")") + " ==> " + numberOfWays(2, steps3))
    println(3 + ", " + steps3.mkString("(", ", ", ")") + " ==> " + numberOfWays(3, steps3))
    println(4 + ", " + steps3.mkString("(", ", ", ")") + " ==> " + numberOfWays(4, steps3))
    println(5 + ", " + steps3.mkString("(", ", ", ")") + " ==> " + numberOfWays(5, steps3))
    println(6 + ", " + steps3.mkString("(", ", ", ")") + " ==> " + numberOfWays(6, steps3))
    println(7 + ", " + steps3.mkString("(", ", ", ")") + " ==> " + numberOfWays(7, steps3))
    println("*******************")
  }

  /**
    * Allowed steps assumed to be either 1 or 2
    */
  private def numberOfWays(n: Int): Int = {
    if (n == 0 || n == 1) return 1

    var result, s1, s2 = 1

    for (_ <- 2 to n) {
      result = s1 + s2
      s1 = s2
      s2 = result
    }

    result
  }

  private def numberOfWays(n: Int, steps: Set[Int]): Int = {
    if (n == 0) return 1

    val nums = new Array[Int](n + 1)
    nums(0) = 1

    for (i <- 1 to n) {
      var total = 0
      for (j <- steps) if (i - j >= 0) total += nums(i - j)
      nums(i) = total
    }

    nums(n)
  }
}