package Chapter4

object CoffeBreak2_returningFunctions extends App {

  //Return a new List with all numbers larger than 4.
  //Change: Now return a new List with all numbers larger than 1.
  val list1 = List(5, 1, 2, 4, 0)

  def largerThan(list: List[Int]): Int => List[Int] = {
    largerThan => list.filter(x => x > largerThan)
  }

  val largerThanFinal: Int => List[Int] = largerThan(list1)

  val res1 = largerThanFinal(4)
  val res2 = largerThanFinal(1)

  println(res1)
  println(res2)

  //Return a new List that contains only numbers divisible by 5.
  //Change: Now return a new List that contains only number divisible by 2.
  val list2 = List(5, 1, 2, 4, 15)

  def divisibleBy(list: List[Int]): Int => List[Int] = {
    divisibleBy => list.filter(x => x % divisibleBy == 0)
  }

  val divisibleByFinal: Int => List[Int] = divisibleBy(list2)

  val res3 = divisibleByFinal(5)
  val res4 = divisibleByFinal(2)

  println(res3)
  println(res4)

  //Return words that are shorter than four characters.
  //Change: Now return words that are shorter than seven characters.
  val list3 = List("scala", "ada")

  def shorterThan(list: List[String]): Int => List[String] = {
    shorterThan => list.filter(x => x.length < shorterThan)
  }

  val shorterThanFinal: Int => List[String] = shorterThan(list3)

  val res5 = shorterThanFinal(4)
  val res6 = shorterThanFinal(7)

  println(res5)
  println(res6)

  //Return words that have more than two of the letter 's' inside.
  //Change: Now return words that have more than zero of the letter 's' inside.

  val list4 = List("rust", "ada")

  def numberOfS(word: String): Int = {
    word.length - word.replaceAll("s", "").length
  }

  def containsMoreThanS(list: List[String]): Int => List[String] = {
    containsMoreThanS => list.filter(x => numberOfS(x) > containsMoreThanS)
  }

  val containsMoreThanSFinal: Int => List[String] = containsMoreThanS(list4)

  val res7 = containsMoreThanSFinal(2)
  val res8 = containsMoreThanSFinal(0)

  println(res7)
  println(res8)

}
