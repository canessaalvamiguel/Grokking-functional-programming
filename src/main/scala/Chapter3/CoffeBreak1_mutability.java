package Chapter3;

import java.util.ArrayList;
import java.util.List;

public class CoffeBreak1_mutability {

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
        lapTimes.remove(0);
        double sum = 0;
        for (double x : lapTimes) {
            sum += x;
        }
        return sum;
    }
    static double avgTime(List<Double> lapTimes) {
        double time = totalTime(lapTimes);
        int laps = lapTimes.size();
        return time / laps;
    }
}
