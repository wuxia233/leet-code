package cn.wuxia.leetcode.zijietiaodong.test;

import java.util.Arrays;

/**
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 */
public class Solution1 {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return false;
        }

        Arrays.sort(nums);
        int i = 0;
        while (i + 1 < nums.length && nums[i] != nums[i + 1]) {
            i++;
        }
        return i != nums.length - 1;
    }

    public static void main(String... args) {
        int[] nums = new int[]{1,2,3,1};
        Solution1 solution1 = new Solution1();
        boolean result = solution1.containsDuplicate(nums);
        System.out.println(result);
    }
}
