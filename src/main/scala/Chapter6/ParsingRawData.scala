package Chapter6

object ParsingRawData extends App {

  case class TvShow(title: String, start: Int, end: Int)

  //We need to return a new list of TV shows, sorted by their running time, descending.
  def sortShows(shows: List[TvShow]): List[TvShow] = {
    shows
      .sortBy(tvShow => tvShow.end - tvShow.start)
      .reverse
  }

  val shows = List(TvShow("Breaking Bad", 2008, 2013),
    TvShow("The Wire", 2002, 2008),
    TvShow("Mad Men", 2007, 2015))

  val res = sortShows(shows)
  println(" sorted by their running time, descending - no validation")
  println(res)
  println()

  /***********************************************************/

    //Basic parsing without error handling
  def parseShow(rawShow: String): TvShow = {
    val bracketOpen = rawShow.indexOf('(')
    val bracketClose = rawShow.indexOf(')')
    val dash = rawShow.indexOf('-')

    val name = rawShow.substring(0, bracketOpen).trim
    val yearStart = Integer.parseInt(rawShow.substring(bracketOpen + 1, dash))
    val yearEnd = Integer.parseInt(rawShow.substring(dash + 1, bracketClose))

    TvShow(name, yearStart, yearEnd)
  }

  def parseShows(rawShows: List[String]): List[TvShow] = {
    rawShows.map(parseShow)
  }

  val rawShows: List[String] = List(
    "Breaking Bad (2008-2013)",
    "The Wire (2002-2008)",
    "Mad Men (2007-2015)")

  println("Basic parsing without error handling")
  val res1 = parseShows(rawShows)
  println(res1)
  println()

  /***********************************************************/

    /*Parsing with error handling */

  def extractName(rawShow: String): Option[String] = {
    val bracketOpen = rawShow.indexOf('(')
    if (bracketOpen > 0)
      Some(rawShow.substring(0, bracketOpen).trim)
    else None
  }

// extractYearStart implemented using flatMap, but this can be improved using for comprehension
//  def extractYearStart(rawShow: String): Option[Int] = {
//    val bracketOpen = rawShow.indexOf('(')
//    val dash = rawShow.indexOf('-')
//    val yearStrOpt = if (bracketOpen != -1 && dash > bracketOpen + 1)
//      Some(rawShow.substring(bracketOpen + 1, dash))
//    else None
//    yearStrOpt.flatMap(yearStr => yearStr.toIntOption)
//  }

  def extractYearStart(rawShow: String): Option[Int] = {
    val bracketOpen = rawShow.indexOf('(')
    val dash = rawShow.indexOf('-')
    for {
      yearStr <- if (bracketOpen != -1 && dash > bracketOpen + 1)
        Some(rawShow.substring(bracketOpen + 1, dash))
      else None
      year <- yearStr.toIntOption
    } yield year
  }

  def extractYearEnd(rawShow: String): Option[Int] = {
    val dash = rawShow.indexOf('-')
    val bracketClose = rawShow.indexOf(')')
    for {
      yearStr <- if (dash != -1 && bracketClose > dash + 1)
        Some(rawShow.substring(dash + 1, bracketClose))
      else None
      year <- yearStr.toIntOption
    } yield year
  }

  def extractSingleYear(rawShow: String): Option[Int] = {
    val dash = rawShow.indexOf('-')
    val bracketOpen = rawShow.indexOf('(')
    val bracketClose = rawShow.indexOf(')')
    for {
      yearStr <- if (dash == -1 && bracketOpen != -1 && bracketClose > bracketOpen + 1)
        Some(rawShow.substring(bracketOpen + 1, bracketClose))
      else None
      year <- yearStr.toIntOption
    } yield year
  }

  //Parsing with basic error handling using Option
  def parseShow_2(rawShow: String): Option[TvShow] = {
    for {
      name <- extractName(rawShow)
      yearStart <- extractYearStart(rawShow).orElse(extractSingleYear(rawShow))
      yearEnd <- extractYearEnd(rawShow).orElse(extractSingleYear(rawShow))
    } yield TvShow(name, yearStart, yearEnd)
  }

  def parseShows_2(rawShows: List[String]): List[TvShow] = {
    rawShows
      .map(parseShow_2)
      .flatMap(_.toList)
  }

  val rawShows2: List[String] = List(
    "Breaking Bad (2008-2013)",
    "The Wire (2002-2008)",
    "Mad Men (2007")

  println("Parsing with error handling")
  val res2 = parseShows_2(rawShows2)
  println(res2)
  println()

}
