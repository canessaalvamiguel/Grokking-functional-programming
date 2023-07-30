package Chapter6

object PracticingFunctionalErrorHandling extends App {

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

  def extractName(rawShow: String): Option[String] = {
    val bracketOpen = rawShow.indexOf('(')
    if (bracketOpen > 0)
      Some(rawShow.substring(0, bracketOpen).trim)
    else None
  }

  def extractSingleYearOrYearEnd(rawShow: String): Option[Int] =
    extractSingleYear(rawShow).orElse(extractYearEnd(rawShow))

  def extractAnyYear(rawShow: String): Option[Int] =
    extractYearStart(rawShow)
      .orElse(extractYearEnd(rawShow))
      .orElse(extractSingleYear(rawShow))

  def extractSingleYearIfNameExists(rawShow: String): Option[Int] =
    extractName(rawShow).flatMap(name => extractSingleYear(rawShow))

  def extractAnyYearIfNameExists(rawShow: String): Option[Int] =
    extractName(rawShow).flatMap(name => extractAnyYear(rawShow))

}
