package Chapter5

object ForComprehensionForValidations extends App {

  //Rules to validate Event:
  /*
  case class Event(name: String, start: Int, end: Int)
  -  name should be a nonempty String.
  -  end year should be a reasonable number—say, less than 3,000.
  - start should be less than or equal to end.
  * */

  case class Event(name: String, start: Int, end: Int)

  //---------------Method 1: Using if

  def parse_1(name: String, start: Int, end: Int): Event =
    if (name.size > 0 && end < 3000 & start <= end)
      Event(name, start, end)
    else
      null

  val r1 = parse_1("Apollo Program", 1961, 1972)//return Event("Apollo Program", 1961, 1972))
  val r2 = parse_1("", 1939, 1945)//return null

  println(r1)
  println(r2)

  //---------------Method 2: Avoid null

  def parse_2(name: String,
            start: Int, end: Int): Option[Event] = {
    if (name.size > 0 && end < 3000 & start <= end)
      Some(Event(name, start, end))
    else
      None
  }

  val r3 = parse_2("Apollo Program", 1961, 1972) //return Some(Event("Apollo Program", 1961, 1972)))
  val r4 = parse_2("", 1939, 1945) //return None

  println(r3)
  println(r4)

  //---------------Method 3: Parsing as a pipeline

  def validateName(name: String): Option[String] =
    if (name.size > 0) Some(name) else None

  def validateEnd(end: Int): Option[Int] =
    if (end < 3000) Some(end) else None

  def validateStart(start: Int, end: Int): Option[Int] =
    if (start <= end) Some(start) else None

  def parse(name: String, start: Int, end: Int): Option[Event] =
    for {
      validName <- validateName(name)
      validEnd <- validateEnd(end)
      validStart <- validateStart(start, end)
    } yield Event(validName, validStart, validEnd)

  val r5 = parse("Apollo Program", 1961, 1972)//return Some (Event("Apollo Program", 1961, 1972))
  val r6 = parse("", 1939, 1945)//return None

  println(r5)
  println(r6)

}
