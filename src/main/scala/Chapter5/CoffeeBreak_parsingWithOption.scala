package Chapter5

object CoffeeBreak_parsingWithOption extends App {

  case class Event(name: String, start: Int, end: Int)

  def validateName(name: String): Option[String] =
    if (name.size > 0) Some(name) else None

  def validateEnd(end: Int): Option[Int] =
    if (end < 3000) Some(end) else None

  def validateStart(start: Int, end: Int): Option[Int] =
    if (start <= end) Some(start) else None

  def validateLength(start: Int,
                     end: Int,
                     minLength: Int): Option[Int] =
    if (end - start >= minLength) Some(end - start) else None

  def parseLongEvent(name: String,
                     start: Int, end: Int,
                     minLength: Int): Option[Event] =
    for {
      validName <- validateName(name)
      validEnd <- validateEnd(end)
      validStart <- validateStart(start, end)
      validLength <- validateLength(start, end, minLength)
    } yield Event(validName, validStart, validEnd)

  val r5 = parseLongEvent("Apollo Program", 1961, 1972, 5) //Some(Event(Apollo Program,1961,1972))
  val r6 = parseLongEvent("", 1939, 1945, 5) //return None

  println(r5)
  println(r6)

}
