package Chapter6

import Chapter6.ParsingRawData.TvShow

object CoffeBreackErrorHandlingStrategies extends App {

  //All-or-nothing error-handling strategy
  def addOrResign(
                   parsedShows: Option[List[TvShow]],
                   newParsedShow: Option[TvShow]
                 ): Option[List[TvShow]] = {
    for {
      shows <- parsedShows
      parsedShow <- newParsedShow
    } yield shows.appended(parsedShow)
  }

  val r1 = addOrResign(Some(List.empty), Some(TvShow("Chernobyl", 2019, 2019)))
  val r2 = addOrResign(
    Some(
      List(TvShow("Chernobyl", 2019, 2019))
    ),
    Some(
      TvShow("The Wire", 2002, 2008)
    )
  )
  val r3 = addOrResign(Some(List(TvShow("Chernobyl", 2019, 2019))), None)
  val r4 = addOrResign(None, Some(TvShow("Chernobyl", 2019, 2019)))
  val r5 = addOrResign(None, None)

  println(r1)
  println(r2)
  println(r3)
  println(r4)
  println(r5)

  val t1 = r3.map(_.map(y => y)).toList.flatten
  val t2 = r3.map( x => x.map(y => y)).toList.flatten

}
