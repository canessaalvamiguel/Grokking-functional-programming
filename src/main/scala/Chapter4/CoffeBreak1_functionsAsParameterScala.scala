package Chapter4

object CoffeBreak1_functionsAsParameterScala extends App {

  val words: List[String] = List("haskell", "rust", "scala", "java", "ada")

  rankedWords(w => score(w) + bonus(w) - penalty(w), words)
    .foreach(println)

  def rankedWords(wordScore: String => Int, words: List[String]) : List[String] = {
    words
      .sortBy(wordScore)
      .reverse
  }

  def score(word: String): Int = {
    word.replace("a", "").length
  }

  def bonus(word: String): Int = {
    if (word.contains("a")) 5 else 0
  }

  def penalty(word: String): Int = {
    if(word.contains("s")) 7 else 0
  }
}
