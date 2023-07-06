package Chapter4

object MultipleParametersListInFunctions extends App {

  def score(word: String): Int = {
    word.replace("a", "").length
  }

  def highScoringWords_1(wordScore: String => Int): Int => List[String] => List[String] = {
    higherThan =>
      words =>
        words.filter(word => wordScore(word) > higherThan)
  }

  def highScoringWords_2(wordScore: String => Int)(higherThan: Int)(words: List[String]): List[String] = {
    words.filter(word => wordScore(word) > higherThan)
  }

  ///
  val words = List("scala", "ada")

  val res1 = highScoringWords_2(wordScore = score)(higherThan = 2)(words = words)
  val res2 = highScoringWords_2(score)(2)(words)

  println(res1)
  println(res2)
}
