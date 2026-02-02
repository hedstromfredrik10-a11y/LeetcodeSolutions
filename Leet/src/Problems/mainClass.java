package Problems;

import java.util.Arrays;

public class mainClass {
    public static void main(String[] args) {
        myLeetCodeSolutions solutions = new myLeetCodeSolutions();

        String s = "abcde";
        String goal = "bcdea";

        System.out.println(solutions.rotateString(s, goal));

    }
}
