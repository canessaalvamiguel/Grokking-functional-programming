package Chapter3;

import java.util.ArrayList;
import java.util.List;

public class CoffeBreak1_inmutability {

    public static void main(String[] args) {
        ArrayList<Double> lapTimes = new ArrayList<>();
        lapTimes.add(31.0); // warm-up lap (not taken into calculations)
        lapTimes.add(20.9);
        lapTimes.add(21.1);
        lapTimes.add(21.3);
        System.out.printf("Total: %.1fs\n", totalTime(lapTimes));
        System.out.printf("Avg: %.1fs", avgTime(lapTimes));
    }

    static double totalTime(List<Double> lapTimes) {
        List<Double> withoutWarmUp = new ArrayList<>(lapTimes);
        withoutWarmUp.remove(0); // remove warm-up lap
        double sum = 0;
        for (double x : withoutWarmUp) {
            sum += x;
        }
        return sum;
    }
    static double avgTime(List<Double> lapTimes) {
        double time = totalTime(lapTimes);
        List<Double> withoutWarmUp = new ArrayList<>(lapTimes);
        withoutWarmUp.remove(0); // remove warm-up lap
        int laps = withoutWarmUp.size();
        return time / laps;
    }
}
