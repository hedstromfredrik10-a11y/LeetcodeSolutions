package Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class myLeetCodeSolutions {

    /**
     * There is a hidden integer array arr that consists of n non-negative integers.
     * 
     * It was encoded into another integer array encoded of length n - 1, such that
     * encoded[i] = arr[i] XOR arr[i + 1]. For example, if arr = [1,0,2,1], then
     * encoded = [1,2,3].
     * 
     * You are given the encoded array. You are also given an integer first, that is
     * the first element of arr, i.e. arr[0].
     * 
     * Return the original array arr. It can be proved that the answer exists and is
     * unique.
     * 
     * @param encoded
     * @param first
     * @return decoded array
     */
    public int[] decode_1720(int[] encoded, int first) {
        int[] arr = new int[encoded.length + 1];
        arr[0] = first;

        for (int i = 0; i < arr.length - 1; i++) {
            arr[i + 1] = arr[i] ^ encoded[i];
        }
        return arr;
    }

    /**
     * You are given a 0-indexed integer array nums, where nums[i] represents the
     * score of the ith student. You are also given an integer k.
     * 
     * Pick the scores of any k students from the array so that the difference
     * between the highest and the lowest of the k scores is minimized.
     * 
     * @param nums
     * @param k
     * @return minimum possible difference
     */
    public int minimumDifference_1984(int[] nums, int k) {
        int min = Integer.MAX_VALUE;

        if (nums.length == 1) {
            return 0;
        }

        for (int i = 0, j = k; j < nums.length; i++, j++) {
            int[] arr = Arrays.copyOfRange(nums, i, j);
            for (int l = 0; l < arr.length; l++) {
                for (int l2 = 0; l2 < arr.length; l2++) {
                    int difference = arr[l] - arr[l2];
                    if (difference < min && difference > 0) {
                        min = difference;
                    }
                }
            }

        }
        return min;

    }

    /**
     * Given two strings s and goal, return true if and only if s can become goal
     * after some number of shifts on s.
     * 
     * A shift on s consists of moving the leftmost character of s to the rightmost
     * position.
     * 
     * For example, if s = "abcde", then it will be "bcdea" after one shift.
     * 
     * @param s
     * @param goal
     * @return
     */
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        return (s + s).contains(goal);

    }

    /**
     * A self-dividing number is a number that is divisible by every digit it
     * contains.
     * 
     * For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 ==
     * 0, and 128 % 8 == 0.
     * A self-dividing number is not allowed to contain the digit zero.
     * 
     * Given two integers left and right, return a gList of all the self-dividing
     * numbers in the range [left, right] (both inclusive).
     * 
     * @param left
     * @param right
     * @return
     */
    public List<Integer> selfDividingNumbers_728(int left, int right) {
        List<Integer> result = new ArrayList<>();

        for (int i = left; i <= right; i++) {
            if (checkDigit(i)) {
                result.add(i);
            }
        }

        return result;
    }

    private boolean checkDigit(int input) {
        String s = String.valueOf(input);
        if (s.contains("0")) {
            return false;
        }

        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (input % Integer.valueOf(arr[i] - '0') != 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * You are given a string s consisting of lowercase English letters.
     * 
     * Return an integer denoting the maximum number of substrings you can split s
     * into such that each substring starts with a distinct character (i.e., no two
     * substrings start with the same character).
     * 
     * @param s
     * @return
     */
    public int maxDistinct_3760(String s) {
        int result = 1;
        char[] arr = s.toCharArray();
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                result++;
            }
        }

        return result;
    }

    /**
     * Given a 2D grid of size m x n and an integer k. You need to shift the grid k
     * times.
     * 
     * In one shift operation:
     * 
     * Element at grid[i][j] moves to grid[i][j + 1].
     * Element at grid[i][n - 1] moves to grid[i + 1][0].
     * Element at grid[m - 1][n - 1] moves to grid[0][0].
     * Return the 2D grid after applying shift operation k times.
     * 
     * @param grid
     * @param k
     * @return
     */
    public List<List<Integer>> shiftGrid_1260(int[][] grid, int k) {
        List<Integer> gList = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                gList.add(grid[i][j]);
            }
        }

        return shiftRight(gList, k);
    }

    private List<List<Integer>> shiftRight(List<Integer> input, int k) {
        List<Integer> shiftList = new ArrayList<>();
        shiftList.addAll(input);

        for (int i = 0; i < k; i++) {
            for (int j = 1, x = 0; j < input.size(); j++, x++) {
                input.set(j, shiftList.get(x));
            }
            input.set(0, shiftList.getLast());
            shiftList.clear();
            shiftList.addAll(input);
        }

        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < (int) Math.sqrt(input.size()); i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < (int) Math.sqrt(input.size()); j++) {
                row.add(0);
            }
            matrix.add(row);
        }

        System.out.println(input.toString());

        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.size(); j++) {
                matrix.get(i).set(j, input.get(j));
            }
        }

        return matrix;
    }

    public void rotate_189(int[] nums, int k) {
        int n = nums.length;
        k %= n;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++;
            r--;
        }
    }

    /**
     * Assume you are an awesome parent and want to give your children some cookies.
     * But, you should give each child at most one cookie.
     * 
     * Each child i has a greed factor g[i], which is the minimum size of a cookie
     * that the child will be content with; and each cookie j has a size s[j]. If
     * s[j] >= g[i], we can assign the cookie j to the child i, and the child i will
     * be content. Your goal is to maximize the number of your content children and
     * output the maximum number.
     * 
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren_455(int[] g, int[] s) {
        Arrays.sort(s);
        Arrays.sort(g);
        List<Integer> listOfG = new ArrayList<>();
        Arrays.stream(g).forEach(listOfG::add);
        int result = 0;

        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < listOfG.size(); j++) {
                if (s[i] >= listOfG.get(j)) {
                    listOfG.remove(j);
                    result++;
                    break;
                }
            }
        }

        return result;

    }

    /**
     * You are given an integer n.
     * 
     * Form a new integer x by concatenating all the non-zero digits of n in their
     * original order. If there are no non-zero digits, x = 0.
     * 
     * Let sum be the sum of digits in x.
     * 
     * Return an integer representing the value of x * sum.
     * 
     * @param n
     * @return
     */
    public long sumAndMultiply(int n) {
        if (n == 0) {
            return 0;
        }

        String num = String.valueOf(n);
        int sum = 0;

        num = num.replaceAll("0", "");

        for (int i = 0; i < num.length(); i++) {
            sum += num.charAt(i) - '0';
        }

        return Math.multiplyFull(sum, Integer.parseInt(num));

    }

    /**
     * You are given an integer array nums.
     * 
     * Choose three elements a, b, and c from nums at distinct indices such that the
     * value of the expression a + b - c is maximized.
     * 
     * Return an integer denoting the maximum possible value of this expression.
     * 
     * @param nums
     * @return
     */
    public int maximizeExpressionOfThree(int[] nums) {
        Arrays.sort(nums);

        return nums[nums.length - 1] + nums[nums.length - 2] - nums[0];
    }

}

// 1114
class Foo {

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
