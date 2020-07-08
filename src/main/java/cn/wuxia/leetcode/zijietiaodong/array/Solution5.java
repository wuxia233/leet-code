package cn.wuxia.leetcode.zijietiaodong.array;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @Author: WuXia
 * @Email: wuxia1@szunicom.com
 * @Date: 2020/7/8 14:57
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 */
@Slf4j
public class Solution5 {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        //fastSort(nums);
        return nums[nums.length - k];
    }

    public void fastSort(int[] nums) {
        sortOnce(nums, 0, nums.length - 1);
    }

    private void sortOnce(int[] nums, int start, int end) {
        int temp = nums[start]; // 为简便选第一个元素作为基准值
        int i = start;
        int j = end;
        while (i < j) {
            while (i < j && nums[j] > temp) {
                j--;
            }
            if (i < j) {
                nums[i] = nums[j];
                i++;
            }
            while (i < j && nums[i] < temp) {
                i++;
            }
            if (i < j) {
                nums[j] = nums[i];
                j--;
            }
        }
        nums[i] = temp;

        if (start < i - 1) {
            sortOnce(nums, start, i - 1);
        }
        if (i + 1 < end) {
            sortOnce(nums, i + 1, end);
        }
    }

    public static void main(String... args) {
        Solution5 solution5 = new Solution5();
        int[] nums = {3,2,1,5,6,4};
        solution5.fastSort(nums);
        log.info(Arrays.toString(nums));
    }
}
