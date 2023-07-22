package Chapter5

object ForComprehension extends App {

  case class Book(title: String, authors: List[String])
  case class Movie(title: String)

  def bookAdaptations(author: String ): List[Movie] = {
    if(author == "Tolkien")
      List(Movie("The Hobbit: The Battle of the Five Armies"))
    else
      List.empty
  }

  val books = List(
    Book("FP in Scala", List("Chiusano", "Bjarnason")),
    Book("The Hobbit", List("Tolkien")))

  val res =
    for {
      book <- books
      author <- book.authors
      movie <- bookAdaptations(author)
    } yield
      s"You may like ${movie.title}, " + s"because you liked $author's ${book.title}"

  println(res)


  //--------------------------
  //Filtering inside a for comprehension

  case class Point(x: Int, y: Int)

  def isInside(point: Point, radius: Int): Boolean = {
    radius * radius >= point.x * point.x + point.y * point.y
  }

  val points = List(Point(5, 2), Point(1, 1))
  val radiuses = List(2, 1)

  val res1 =
    for {
      r <- radiuses
      point <- points.filter(p => isInside(p, r))
    } yield s"$point is within a radius of $r"

  println(res1)


}
