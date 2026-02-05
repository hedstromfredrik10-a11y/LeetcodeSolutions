package Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.IntStream;

import javax.swing.tree.TreeNode;

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
     * Given two integers left and right, return a list of all the self-dividing
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

}
