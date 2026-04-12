package Problems;

public class mainClass {
    public static void main(String[] args) {
        myLeetCodeSolutions solutions = new myLeetCodeSolutions();

        int[] s = { 1, 2, 5, 2, 3 };

        String text = "Leet code";
        String brokenLetters = "e";

        System.out.println(solutions.canBeTypedWords(text, brokenLetters));
    }
}
