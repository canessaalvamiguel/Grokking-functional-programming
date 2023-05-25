package Chapter1;

public class CoffeeBreak1 {
    public static void main(String[] args) {
        /**
         * The new requirement says that the
         * score of the word should now be equal to the number of characters that
         * are different than 'a'.
         */

        int score1 = calculateScore_imperative("imperative / declarative");
        System.out.println(score1);

        int score = calculateScore_declarative("imperative / declarative");
        System.out.println(score);

    }

    public static int calculateScore_imperative(String word){
        int score = 0;
       for (char c : word.toCharArray() ){
           if(c != 'a')
               score++;
       }
       return score;
    }

    public static int calculateScore_declarative(String word){
        return stringWithoutChar(word, 'a').length();
    }

    public static String stringWithoutChar(String word, char c) {
        return word.replace(Character.toString(c), "");
    }
}