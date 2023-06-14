package Chapter3

object PracticingImmutableSlicingAndAppending extends App {

  val res1 = firstTwo(List("a", "b", "c")) == List("a", "b")
  val res2 = lastTwo(List("a", "b", "c")) == List("b", "c")
  val res3 = movedFirstTwoToTheEnd(List("a", "b", "c")) == List("c", "a", "b")
  val res4 = insertedBeforeLast(List("a", "b"), "c") == List("a", "c", "b")

  println(res1)
  println(res2)
  println(res3)
  println(res4)

  def firstTwo(list: List[String]): List[String] =
    list.slice(0, 2)

  def lastTwo(list: List[String]): List[String] =
    list.slice(list.size - 2, list.size)

  def movedFirstTwoToTheEnd(list: List[String]): List[String] = {
    val firstTwo = list.slice(0, 2)
    val withoutFirstTwo = list.slice(2, list.size)
    withoutFirstTwo.appendedAll(firstTwo)
  }

  def insertedBeforeLast(list: List[String], element: String): List[String] = {
    val last = list.slice(list.size - 1, list.size)
    val withoutLast = list.slice(0, list.size - 1)
    withoutLast.appended(element).appendedAll(last)
  }

}
