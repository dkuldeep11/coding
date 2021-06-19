package leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *
 * Constraints:
 *
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Only one valid answer exists.
 */
public class TwoSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter input array");

        String arrayString = scanner.nextLine();  // Read input
        int[] nums = Arrays.stream(arrayString.substring(1, arrayString.length() - 1).split(","))
                .map(String::trim).mapToInt(Integer::parseInt).toArray();
        System.out.println("input = " + Arrays.toString(nums));

        System.out.println("Enter target");
        int target = Integer.parseInt(scanner.nextLine());
        System.out.println("target = " + target);

        System.out.println("solution1 = " + Arrays.toString(solution1(nums, target)));
        System.out.println("solution2 = " + Arrays.toString(solution2(nums, target)));

    }

    private static int[] solution1(int[] nums, int target) {

        for (int i=0; i < nums.length-1; i++) {
            for (int j=i+1; j<nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    private static int[] solution2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0; i < nums.length; i++) {
            int other = target - nums[i];
            if (map.containsKey(other)) {
                return new int[]{i, map.get(other)};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
