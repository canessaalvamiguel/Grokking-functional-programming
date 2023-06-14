package Chapter3

object PlannerImmutableScala extends App {

  def replan(plan: List[String],
             newCity: String,
             beforeCity: String): List[String] = {
    val beforeCityIndex = plan.indexOf(beforeCity)
    val citiesBefore = plan.slice(0, beforeCityIndex)
    val citiesAfter = plan.slice(beforeCityIndex, plan.size)
    citiesBefore.appended(newCity).appendedAll(citiesAfter)
  }

  val plan: List[String] = List("Paris", "Berlin", "Krakow")
  println(plan)

  val plan2: List[String] = replan(plan, "Vienna", "Krakow")
  println(plan2)

}
