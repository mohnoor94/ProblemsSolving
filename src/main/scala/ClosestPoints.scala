import scala.collection.mutable

/**
  * *** 'Microsoft' interview question ***
  * Find K closest points to a point (could be any point).
  * Problem statement and more details: https://youtu.be/jdY7PUSlxQE
  */

object ClosestPoints {

  type Point = (Int, Int)
  type DPoint = (Double, Int, Int)

  //  implicit val ordering: Ordering[DPoint] = (x: DPoint, y: DPoint) => x._1.compareTo(y._1)

  def main(args: Array[String]): Unit = {
    val points = List((-2, 4), (0, -2), (-1, 0), (3, 5), (-2, -3), (3, 2))
    println(kclosest(points, (0, 0), 3))
    println(kclosest(points, (5, 2), 3))
    println(kclosest(points, (0, 0), 10))

    println(kclosest(List((1, 2), (0, 0), (1, 0), (2, 1), (3, 4), (4, 5)), (0, 0), 3))
  }

  def kclosest(points: List[Point], origin: Point, k: Int): List[DPoint] = {
    def addDistance(p: Point): DPoint = {
      (Math.sqrt(Math.pow(origin._1 - p._1, 2) + Math.pow(origin._2 - p._2, 2)), p._1, p._2)
    }

    if (points.size <= k) points map addDistance
    else {
      val heap: mutable.PriorityQueue[(Double, Int, Int)] = mutable.PriorityQueue()

      (0 until k).foreach(i => {
        val p = points(i)
        heap += addDistance(p)
      })

      (k until points.size).foreach(i => {
        val p = addDistance(points(i))
        if (p._1 < heap.head._1) {
          heap.dequeue()
          heap += p
        }
      })

      heap.dequeueAll
    }
  }
}
