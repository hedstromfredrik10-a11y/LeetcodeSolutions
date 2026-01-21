package Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.IntStream;

public class myLeetCodeSolutions {

    /**
     * Input: encoded = [1,2,3], first = 1
     * Output: [1,0,2,1]
     * Explanation: If arr = [1,0,2,1], then first = 1 and encoded = [1 XOR 0, 0 XOR
     * 2, 2 XOR 1] = [1,2,3]
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
     * Example 1:
     * 
     * Input: nums = [90], k = 1
     * Output: 0
     * Explanation: There is one way to pick score(s) of one student:
     * - [90]. The difference between the highest and lowest score is 90 - 90 = 0.
     * The minimum possible difference is 0.
     * 
     * @param nums
     * @param k
     * @return
     */
    public int minimumDifference(int[] nums, int k) {
        

    }

}
