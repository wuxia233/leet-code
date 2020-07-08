package cn.wuxia.leetcode.zijietiaodong.array;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: WuXia
 * @Email: wuxia1@szunicom.com
 * @Date: 2020/7/8 9:49
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 示例：
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 */
@Slf4j
public class Solution3 {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        AtomicInteger index = new AtomicInteger(-1);
        midSearch(nums, 0, nums.length - 1, index, target);
        return index.get();
    }

    private void midSearch(int[] nums, int left, int right, AtomicInteger index, int target) {
        if (left >= right) {
            if (nums[left] == target) {
                index.set(left);
            }
            return;
        }

        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            index.set(mid);
        } else if (nums[mid] > target) {
            midSearch(nums, left, Math.max(0, mid - 1), index, target);
            midSearch(nums, Math.min(nums.length - 1, mid + 1), right, index, target);
        } else if (nums[mid] < target) {
            midSearch(nums, Math.min(nums.length - 1, mid + 1), right, index, target);
            midSearch(nums, left, Math.max(0, mid - 1), index, target);
        }
    }

    public static void main(String... args) {
        Solution3 solution3 = new Solution3();
        int[] nums = {5,1,2,3,4};
        int index = solution3.search(nums, 4);
        log.info(String.valueOf(index));
    }
}
