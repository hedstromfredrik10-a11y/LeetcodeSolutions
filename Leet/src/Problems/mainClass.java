package Problems;

import java.util.ArrayList;
import java.util.List;

public class mainClass {
    public static void main(String[] args) {
        myLeetCodeSolutions solutions = new myLeetCodeSolutions();

        int[] s = { 1, 2, 10 };

        List<Integer> list = new ArrayList<>();

        for (int i : s) {
            list.add(i);
        }

        System.out.println(solutions.containsUnique(list));

    }
}
