package Chapter4

object PracticingfoldLeft extends App {

  //Return a sum of all integers in the given list.
  val list1 = List(5, 1, 2, 4, 100)
  val res1 = list1.foldLeft(0)((acc, element) => acc + element)

  println(res1)

  //Return the total length of all the words in the given list.
  val list2 = List("scala", "rust", "ada")
  val res2 = list2.foldLeft(0)((acc, element) => acc + element.length)

  println(res2)

  //Return the number of the letter 's' found in all the words in the given list.
  val list3 = List("scala", "haskell", "rust", "ada")

  def numberOfS(word: String): Int = {
    word.length - word.replaceAll("s", "").length
  }

  val res3 = list3.foldLeft(Int.MinValue)((acc, element) => acc + numberOfS(element))
  println(res3)

  //Return the maximum of all integers in the given list.
  val list4 = List(5, 1, 2, 4, 15)
  val res4 = list4.foldLeft(0)((max, element) => {
    if(element >= max)
      element
    else
      max
  })
  println(res4)

}
