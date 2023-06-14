package Chapter2;

import java.util.ArrayList;
import java.util.List;

public class CoffeeBreak1_imperative {

    public static void main(String[] args) {
        TipCalculator tipCalculator = new TipCalculator();

        tipCalculator.addPerson("Miguel");
        tipCalculator.addPerson("Jose");
        tipCalculator.addPerson("Carlos");
        tipCalculator.addPerson("Roberto");

        System.out.println("TipPercentage: " + tipCalculator.getTipPercentage());

        tipCalculator.addPerson("Diego");
        tipCalculator.addPerson("Max");

        System.out.println("TipPercentage: " + tipCalculator.getTipPercentage());
    }
}

class TipCalculator {
    private List<String> names = new ArrayList<>();
    private int tipPercentage = 0;
    public void addPerson(String name) {
        names.add(name);
        if(names.size() > 5) {
            tipPercentage = 20;
        } else if(names.size() > 0) {
            tipPercentage = 10;
        }
    }
    public List<String> getNames() {
        return names;
    }
    public int getTipPercentage() {
        return tipPercentage;
    }
}


