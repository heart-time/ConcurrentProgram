package com.hundsun.tbsp.algorithm;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.algorithm
 * @Description
 * @date 2024/1/2 14:36
 */
public class NextGreaterElement {
    /**
     * nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。
     * <p>
     * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，下标从 0 开始计数，其中nums1 是 nums2 的子集。
     * <p>
     * 对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，并
     * 且在 nums2 确定 nums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。
     * <p>
     * 返回一个长度为 nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums1 = [4,1,2], nums2 = [1,3,4,2].
     * 输出：[-1,3,-1]
     * 解释：nums1 中每个值的下一个更大元素如下所述：
     * - 4 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
     * - 1 ，用加粗斜体标识，nums2 = [1,3,4,2]。下一个更大元素是 3 。
     * - 2 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
     * 示例 2：
     * <p>
     * 输入：nums1 = [2,4], nums2 = [1,2,3,4].
     * 输出：[3,-1]
     * 解释：nums1 中每个值的下一个更大元素如下所述：
     * - 2 ，用加粗斜体标识，nums2 = [1,2,3,4]。下一个更大元素是 3 。
     * - 4 ，用加粗斜体标识，nums2 = [1,2,3,4]。不存在下一个更大元素，所以答案是 -1 。
     *
     * @param nums1
     * @param nums2
     * @return
     */
    HashMap<Integer, Integer> hashMap = new HashMap<>();

    public int[] nextGreaterElement(int nums1[], int nums2[]) {
        int[] nextBiggerEle = findNextBiggerEle(nums2);
        int answer[] = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int j = hashMap.get(nums1[i]);
            if (nums2[j] == nums1[i]) {
                    if (nextBiggerEle[j] == 0) {
                        answer[i] = -1;
                    } else {
                        answer[i] = nums2[nextBiggerEle[j] + j];
                    }
            }
        }
        return answer;
    }

    private int[] findNextBiggerEle(int[] nums2) {
        LinkedList<Integer> list = new LinkedList<>();
        list.offer(0);
        int result[] = new int[nums2.length];
        hashMap.put(nums2[0], 0);
        for (int i = 1; i < nums2.length; i++) {
            if (nums2[list.peekLast()] >= nums2[i]) {
                list.offer(i);
                hashMap.put(nums2[i], i);
            } else {
                while (!list.isEmpty() && nums2[list.peekLast()] < nums2[i]) {
                    int index = list.pollLast();
                    result[index] = i - index;
                }
                list.offer(i);
                hashMap.put(nums2[i], i);
            }
        }
        return result;
    }

    @Test
    public void test1() {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] result = nextGreaterElement(nums1, nums2);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
