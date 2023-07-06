package Chapter4

object PracticingCurrying extends App {

  //Return a new List with all numbers larger than 4 (pass 4 as an argument).
  val list1 = List(5, 1, 2, 4, 0)
  def largerThan(i: Int)(n: Int): Boolean = n > i

  val res1 = list1.filter(largerThan(4))
  println(res1)

  //Return a new List that contains numbers divisible by 5 (pass 5 as an
  //argument).
  val list2 = List(5, 1, 2, 4, 15)
  def divisibleBy(i: Int)(n: Int): Boolean = n % i == 0

  val res2 = list2.filter(divisibleBy(5))
  println(res2)

  //Return words that are shorter than four characters (pass 4 as an argument).
  val list3 = List("scala", "ada")
  def shorterThan(i: Int)(word: String): Boolean = word.length < i

  val  res3 = list3.filter(shorterThan(4))
  println(res3)

  //Return words that have more than two of the letter 's' inside (pass 2 as an
  //argument).
  val list4 = List("rust", "ada")

  def numberOfS(word: String): Int = {
    word.length - word.replaceAll("s", "").length
  }

  def containsS(moreThan: Int)(s: String): Boolean = numberOfS(s) > moreThan

  val res4 = list4.filter(containsS(2))
  println(res4)

}
