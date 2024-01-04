package com.hundsun.tbsp.algorithm;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.algorithm
 * @Description
 * @date 2024/1/2 15:30
 */
public class nextGreaterElements {
    /**
     * 给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0]），
     * 返回 nums 中每个元素的 下一个更大元素 。
     * <p>
     * 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，
     * 这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。
     * <p>
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [1,2,1]
     * 输出: [2,-1,2]
     * 解释: 第一个 1 的下一个更大的数是 2；
     * 数字 2 找不到下一个更大的数；
     * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
     * 示例 2:
     * <p>
     * 输入: nums = [1,2,3,4,3]
     * 输出: [2,3,4,-1,4]
     * <p>
     * <p>
     * 提示:
     * <p>
     * 1 <= nums.length <= 104
     * -109 <= nums[i] <= 109
     *
     * @param nums
     * @return
     */
    public int[] nextGreaterElements(int nums[]) {
        int result[] = new int[nums.length];
        Arrays.fill(result,-1);
        for (int i = 0; i < nums.length; i++) {
            int count = nums.length - 1;
            int index = 1;
            while (count > 0) {
                int j = 0;
                if (i + index > nums.length - 1) {
                    j = i + index - nums.length;
                } else {
                    j = i + index;
                }
                if (nums[i] < nums[j]) {
                    result[i] = nums[j];
                    break;
                }
                index++;
                count--;
            }

        }
        return result;
    }

    @Test
    public void test1() {
        int nums[] = {1,2,3,4,3};
        int[] result = nextGreaterElements(nums);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
