package Chapter4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CoffeBreak1_functionsAsParameter {

    public static void main(String[] args) {

        List<String> words = new ArrayList<>();
        words.add("haskell");
        words.add("rust");
        words.add("scala");
        words.add("java");
        words.add("ada");

        System.out.println("Score:");
        rankedWords(w -> score(w), words)
                .forEach(System.out::println);

        System.out.println();

        System.out.println("ScoreWithBonus:");
        rankedWords(w -> scoreWithBonus(w), words)
                .forEach(System.out::println);

        System.out.println();

        System.out.println("ScoreWithBonusAndPenalty:");
        rankedWords(w -> scoreWithBonusAndPenalty(w), words)
                .forEach(System.out::println);

        System.out.println();
        System.out.println("ScoreWithBonusAndPenalty2:");
        rankedWords(w -> score(w) + bonus(w) - penalty(w), words)
                .forEach(System.out::println);
    }

    static List<String> rankedWords(Function<String, Integer> wordScore, List<String> words){
        Comparator<String> wordComparator =
                (w1, w2) -> Integer.compare(
                        wordScore.apply(w2),
                        wordScore.apply(w1)
                );
        return words
                .stream()
                .sorted(wordComparator)
                .collect(Collectors.toList());
    }

    static int score(String word){
        return word.replaceAll("a", "").length();
    }

    static int scoreWithBonus(String word){
        int base = score(word);
        if(word.contains("c"))
            return base + 5;
        else return base;
    }

    static int bonus(String word){
        return word.contains("c") ? 5 : 0;
    }

    static int penalty(String word){
        return word.contains("s") ? 7 : 0;
    }

    static int scoreWithBonusAndPenalty(String word){
        int base = score(word);
        int bonus = word.contains("c") ? 5 : 0;
        int penaly = word.contains("s") ? 7 : 0;
        return base + bonus - penaly;
    }
}
