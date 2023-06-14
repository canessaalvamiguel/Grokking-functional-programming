package Chapter3;

import java.util.ArrayList;
import java.util.List;

public class PlannerImmutableJava {

    public static void main(String[] args) {
        List<String> plan = new ArrayList<>();
        plan.add("Paris");
        plan.add("Berlin");
        plan.add("Krakow");
        System.out.println(plan);

        List<String> plan2 = replan(plan, "Vienna", "Krakow");
        System.out.println(plan2);
    }

    static List<String> replan(List<String> plan,
                               String newCity,
                               String beforeCity) {
        int newCityIndex = plan.indexOf(beforeCity);
        List<String> replanned = new ArrayList<>(plan);
        replanned.add(newCityIndex, newCity);
        return replanned;
    }
}
