package Chapter2;

import java.util.ArrayList;
import java.util.List;

public class CoffeeBreak1_declarative {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        TipCalculator2 tipCalculator = new TipCalculator2();

        names = tipCalculator.addPerson(names,"Miguel");
        names = tipCalculator.addPerson(names,"Jose");
        names = tipCalculator.addPerson(names,"Carlos");
        names = tipCalculator.addPerson(names,"Roberto");

        System.out.println("TipPercentage: " + TipCalculator2.getTipPercentage(names));

        names = tipCalculator.addPerson(names,"Diego");
        names = tipCalculator.addPerson(names,"Max");

        System.out.println("TipPercentage: " + TipCalculator2.getTipPercentage(names));
    }
}

class TipCalculator2{
    public List<String> addPerson(List<String> names, String name){
        List<String> updated = new ArrayList<>(names);
        updated.add(name);

        return updated;
    }

    public static int getTipPercentage(List<String> names){
        if (names.size() >  5){
            return 20;
        }else if(names.size() > 0){
            return 10;
        }else return 0;
    }
}
