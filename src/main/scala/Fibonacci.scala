/**
  * Find nth number of the fibonacci series: (1, 1, 2, 3, 5, 8, 13, 21, 34, 55, ...)
  */
object Fibonacci {

  def main(args: Array[String]): Unit = {
    for (n <- 1 to 30) print(s"${findNthFibonacciRecursively(n)}, ")
    println()
    for (n <- 1 to 30) print(s"${findNthFibonacciIteratively(n)}, ")
  }

  def findNthFibonacciRecursively(pos: Int): Int = {
    val memo = new Array[Int](pos + 1)
    if (pos > 2) {
      memo(1) = 1
      memo(2) = 1
    }

    def f(n: Int): Int =
      if (memo(n) != 0) memo(n)
      else {
        memo(n) = f(n - 2) + f(n - 1)
        memo(n)
      }

    if (pos < 1) -1 else if (pos < 3) 1 else f(pos)
  }

  def findNthFibonacciIteratively(pos: Int): Int = {
    if (pos < 1) -1
    else if (pos < 3) 1
    else {
      var last, secondLast, result = 1

      for (_ <- 3 to pos) {
        result = last + secondLast
        last = secondLast
        secondLast = result
      }

      result
    }
  }
}
