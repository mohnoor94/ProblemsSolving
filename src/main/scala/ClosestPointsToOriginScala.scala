
/**
  * *** 'Amazon' interview question ***
  *
  * Find K closest points to the origin (0,0).
  * Problem statement and more details: https://youtu.be/eaYX0Ee0Kcg
  */
object ClosestPointsToOriginScala {

  def main(args: Array[String]): Unit = {
    val points = List((-2, 4), (0, -2), (-1, 0), (3, 5), (-2, -3), (3, 2))
    println(firstSolution(points, 0))
    println(firstSolution(points, 2))
    println(firstSolution(points, 4))
    println(firstSolution(points, 6))
    println(firstSolution(points, 8))

    println("*" * 54)

    println(secondSolution(points, 0))
    println(secondSolution(points, 2))
    println(secondSolution(points, 4))
    println(secondSolution(points, 6))
    //    println(secondSolution(points, 8))
  }

  private def firstSolution(points: List[(Int, Int)], k: Int): List[(Int, Int)] =
    points
      .map(p => (p._1, p._2, math.sqrt(math.pow(p._1, 2) + math.pow(p._2, 2))))
      .sortWith((x, y) => x._3 < y._3)
      .take(k)
      .map(p => (p._1, p._2))

  // faster
  private def secondSolution(points: List[(Int, Int)], k: Int): Seq[(Int, Int)] = {
    require(k <= points.length, "K should be <= number of given points")

    object MinOrder extends Ordering[(Int, Int, Double)] {
      override def compare(x: (Int, Int, Double), y: (Int, Int, Double)): Int = y._3 compare x._3
    }

    val heap = scala.collection.mutable.PriorityQueue.empty(MinOrder)
    points.foreach(p => heap += ((p._1, p._2, math.sqrt(math.pow(p._1, 2) + math.pow(p._2, 2)))))

    val kPoints = for (_ <- 0 until k) yield heap.dequeue
    kPoints.map(p => (p._1, p._2))
  }
}
