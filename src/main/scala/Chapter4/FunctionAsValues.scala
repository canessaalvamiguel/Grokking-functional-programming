package Chapter4

object FunctionAsValues extends App {

  val words: List[String] = List("haskell", "rust", "scala", "java", "ada")

  def score(word: String): Int = {
    word.replace("a", "").length
  }

  /////////////Don’t repeat yourself? - FAILED

  def highScoringWords_old(wordScore: String => Int,
                       words: List[String],
                       higherThan: Int): List[String] = {
    words.filter(word => wordScore(word) > higherThan)
  }
  highScoringWords_old(score, words, 1)
  highScoringWords_old(score, words, 0)
  highScoringWords_old(score, words, 5)

  /////////////Don’t repeat yourself? - SUCCESS

  def highScoringWordsImproved(wordScore: String => Int,
                               words: List[String]): Int => List[String] = {
    higherThan: Int => words.filter(word => wordScore(word) > higherThan)
  }

  val highScoringWords: Int => List[String] = highScoringWordsImproved(score, words)

  highScoringWords(1)
  highScoringWords(0)
  highScoringWords(5)

}
