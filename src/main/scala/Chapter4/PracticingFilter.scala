package Chapter4

object PracticingFilter extends App {

  //Return words that are shorter than five characters.
  val list1 = List("scala", "rust", "ada")
  val res1 = list1.filter(x => x.size < 5)
  println(res1)

  //Return a new List with only odd numbers
  val list2 = List(5, 1, 2, 4, 0)
  val res2 = list2.filter(x => x % 2 != 0)
  println(res2)

  //Return a new List with all numbers larger than 4.
  def largerThan4(i: Int): Boolean = i > 4
  val list3 = List(5, 1, 2, 4, 0)
  val res3 = list3.filter(largerThan4)
  println(res3)

}
