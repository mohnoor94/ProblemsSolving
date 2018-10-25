/**
  * Problem statement: https://youtu.be/86CQq3pKSUw
  */
object MaximumSumSubArray {

  def main(args: Array[String]): Unit = {
    println(findMaxSumSubArray(List()))
    println(findMaxSumSubArray(List(5)))
    println(findMaxSumSubArray(List(-2, 3, 2, -1)))
    println(findMaxSumSubArray(List(1, -3, 2, 1, -1)))
    println(findMaxSumSubArray(List(-1, 1, 3, 2, 1, -1)))
    println(findMaxSumSubArray(List(1, 1, 3, 2, 1, 1)))
  }

  private def findMaxSumSubArray(list: List[Int]): List[Int] = {
    if (list.length < 1) return Nil

    var max = (List(list.head), list.head)
    var localMax = max

    for (i <- 1 until list.length) {
      val lst = localMax._1 :+ list(i)
      val currList = (lst, lst.sum)
      localMax = if (list(i) > currList._2) (List(list(i)), list(i)) else currList
      max = if (localMax._2 > max._2) localMax else max
    }

    max._1
  }
}