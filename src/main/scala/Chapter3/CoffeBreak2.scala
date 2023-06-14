package Chapter3

object CoffeBreak2 extends App {

  val r1 = abbreviate("Alonzo Church")
  println(r1)

  val r2 = abbreviate("A. Church")
  println(r2)

  val r3 = abbreviate("A Church")
  println(r3)

  def abbreviate(name: String) : String = {
    val parts: Array[String] = name.split(" ")
    parts(0).head + ". " + parts(1)
  }

  def abbreviate_fromBook(name: String): String = {
    val initial = name.substring(0, 1)
    val separator = name.indexOf(' ')
    val lastName = name.substring(separator + 1)
    initial + ". " + lastName
  }
}
