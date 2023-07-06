package Chapter4

object PracticingMap extends App {

  ///Return lengths of the given Strings.
  def len(s: String): Int = s.length

  val list1 = List("scala", "rust", "ada")
  val res1 = list1.map(len)
  println(res1)

  ///Return the number of the letter 's' inside the given Strings.
  def numbersOfS(s: String): Int = s.count(x => x.toUpper.equals('S'))

  val list2 = List("rust", "ada")
  val res2 = list2.map(numbersOfS)
  println(res2)

  ///Double all the given Ints, and return them as a new List.
  def doubleValue(x: Int) : Int = x * 2

  val list3 = List(5, 1, 2, 4, 0)
  val res3 = list3.map(doubleValue)
  println(res3)

}
