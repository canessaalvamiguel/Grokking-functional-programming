package Chapter6

import Chapter6.CoffeBreackErrorHandlingStrategies.addOrResign
import Chapter6.ParsingRawData.{TvShow, parseShow_2}

object FoldingListOfOptions extends App {

  //Implementing all-or-nothing strategy in parseShows
  def parseShows(rawShows: List[String]): Option[List[TvShow]] = {
    val initialResult: Option[List[TvShow]] = Some(List.empty)

    rawShows
      .map(parseShow_2)
      .foldLeft(initialResult)(addOrResign)
  }

  val r1 = parseShows(List("Chernobyl (2019)", "Breaking Bad"))
  val r2 = parseShows(List("Chernobyl (2019)"))
  val r3 = parseShows(List())

  println(r1)
  println(r2)
  println(r3)
}
