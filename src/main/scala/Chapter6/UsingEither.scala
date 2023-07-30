package Chapter6

import Chapter6.CoffeBreackErrorHandlingStrategies.addOrResign
import Chapter6.ParsingRawData.TvShow

object UsingEither extends App {

  def extractName(show: String): Either[String, String] = {
    val bracketOpen = show.indexOf('(')
    if (bracketOpen > 0)
      Right(show.substring(0, bracketOpen).trim)
    else
      Left(s"Can't extract name from $show")
  }

//Have you noticed that we used map and flatten again? That means we can simplify the whole thing into a flatMap call
//  def extractYearStart(rawShow: String): Either[String, Int] = {
//    val bracketOpen = rawShow.indexOf('(')
//    val dash = rawShow.indexOf('-')
//    val yearStrEither =
//      if (bracketOpen != -1 && dash > bracketOpen + 1)
//        Right(rawShow.substring(bracketOpen + 1, dash))
//      else
//        Left(s"Can't extract start year from $rawShow")
//
//    yearStrEither.map(yearStr =>
//      yearStr.toIntOption.toRight(s"Can't parse $yearStr")
//    ).flatten
//  }

  def extractYearStart(rawShow: String): Either[String, Int] = {
    val bracketOpen = rawShow.indexOf('(')
    val dash = rawShow.indexOf('-')
    for {
      yearStr <- if (bracketOpen != -1 && dash > bracketOpen + 1)
        Right(rawShow.substring(bracketOpen + 1, dash))
      else Left(s"Can't extract start year from $rawShow")
      year <- yearStr.toIntOption.toRight(s"Can't parse $yearStr")
    } yield year
  }

  def extractYearEnd(rawShow: String): Either[String, Int] = {
    val dash = rawShow.indexOf('-')
    val bracketClose = rawShow.indexOf(')')
    for {
      yearStr <- if (dash != -1 && bracketClose > dash + 1)
        Right(rawShow.substring(dash + 1, bracketClose))
      else Left(s"Can't extract end year from $rawShow")
      year <- yearStr.toIntOption.toRight(s"Can't parse $yearStr")
    } yield year
  }

  def extractSingleYear(rawShow: String): Either[String, Int] = {
    val dash = rawShow.indexOf('-')
    val bracketOpen = rawShow.indexOf('(')
    val bracketClose = rawShow.indexOf(')')
    for {
      yearStr <- if (dash == -1 && bracketOpen != -1 &&
        bracketClose > bracketOpen + 1)
        Right(rawShow.substring(bracketOpen + 1, bracketClose))
      else Left(s"Can't extract single year from $rawShow")
      year <- yearStr.toIntOption.toRight(s"Can't parse $yearStr")
    } yield year
  }

  def addOrResign( parsedShows: Either[String, List[TvShow]],
                   newParsedShow: Either[String, TvShow]
                 ): Either[String, List[TvShow]] = {
    for {
      shows <- parsedShows
      parsedShow <- newParsedShow
    } yield shows.appended(parsedShow)
  }

  def parseShow(rawShow: String): Either[String, TvShow] = {
    for {
      name <- extractName(rawShow)
      yearStart <- extractYearStart(rawShow).orElse(extractSingleYear(rawShow))
      yearEnd <- extractYearEnd(rawShow).orElse(extractSingleYear(rawShow))
    } yield TvShow(name, yearStart, yearEnd)
  }

  def parseShows(rawShows: List[String]): Either[String, List[TvShow]] = {
    val initialResult: Either[String, List[TvShow]] = Right(List.empty)

    rawShows
      .map(parseShow)
      .foldLeft(initialResult)(addOrResign)
  }

  val r1 = parseShows(List("Chernobyl (2019)", "Breaking Bad"))
  val r2 = parseShows(List("Chernobyl (2019)"))
  val r3 = parseShows(List())

  println(r1)
  println(r2)
  println(r3)


}
