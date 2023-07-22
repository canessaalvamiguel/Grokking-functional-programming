package Chapter5

object CoffeeBreak2_filteringTechniques extends App {

  case class Point(x: Int, y: Int)

  val points = List(Point(5, 2), Point(1, 1))
  val riskyRadiuses = List(-10, 0, 2)

  //-------------------- Method 1: Using filter

  def isInside(point: Point, radius: Int): Boolean = {
    radius * radius >= point.x * point.x + point.y * point.y
  }

  val res1 =
    for {
      r <- riskyRadiuses.filter(r => r > 0)
      point <- points.filter(p => isInside(p, r))
    } yield s"$point is within a radius of $r"

  println(res1)

  //-------------------- Method 2: Using guard inside the for comprehension

  val res2 =
    for {
      r <- riskyRadiuses
      if r > 0
      point <- points
      if isInside(point, r)
    } yield s"$point is within a radius of $r"

  println(res2)

  //-------------------- Method 3: Using a method inside the for comprehension
  /*
  * You may feel that the last solution is a bit overcomplicated, but it has its
  benefits. All the core logic is defined inside small functions, which are
  used to build a bigger algorithm inside the for comprehension.
  * */

  def insideFilter(point: Point, radius: Int): List[Point] =
    if (isInside(point, radius)) List(point) else List.empty

  def validateRadius(radius: Int): List[Int] =
    if (radius > 0) List(radius) else List.empty

  val res3 =
    for {
      r <- riskyRadiuses
      validRadius <- validateRadius(r)
      point <- points
      inPoint <- insideFilter(point, validRadius)
    } yield s"$inPoint is within a radius of $r"

  println(res3)

}
