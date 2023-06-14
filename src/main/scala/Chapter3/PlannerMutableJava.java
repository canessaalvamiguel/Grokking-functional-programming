package Chapter3;

import java.util.ArrayList;
import java.util.List;

public class PlannerMutableJava {

    public static void main(String[] args) {
        List<String> plan = new ArrayList<>();
        plan.add("Paris");
        plan.add("Berlin");
        plan.add("Krakow");
        System.out.println(plan);

        replan(plan, "Vienna", "Krakow");
        System.out.println(plan);
    }

    static void replan(List<String> plan,
                               String newCity,
                               String beforeCity) {
        int newCityIndex = plan.indexOf(beforeCity);
        plan.add(newCityIndex, newCity);
    }
}
