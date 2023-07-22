package Chapter5

object PracticingNestedFlatMaps extends App {

  case class Point(x: Int, y: Int)

  val res1 = List(1).flatMap(x =>
    List(-2, 7).map(y =>
      Point(x, y)
    )
  )

  println(res1)
  //List(Point(1,-2), Point(1,7))

  val res2 = List(1).flatMap(x =>
    List(-2, 7, 10).map(y =>
      Point(x, y)
    )
  )

  println(res2)
  //List(Point(1,-2), Point(1,7), Point(1,10))

  val res3 = List(1, 2).flatMap(x =>
    List(-2, 7).map(y =>
      Point(x, y)
    )
  )

  println(res3)
  //List(Point(1,-2), Point(1,7), Point(2,-2), Point(2,7))

  val res4 = List.empty[Int].flatMap(x =>
    List(-2, 7).map(y =>
      Point(x, y)
    )
  )

  println(res4)
  //List()

  val res5 = List(1).flatMap(x =>
    List.empty[Int].map(y =>
      Point(x, y)
    )
  )
  println(res5)
}
