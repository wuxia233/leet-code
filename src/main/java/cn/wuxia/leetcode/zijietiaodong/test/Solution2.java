package cn.wuxia.leetcode.zijietiaodong.test;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
 * 示例:
 * 输入: [4, 6, 7, 7]
 * 输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 */
@Slf4j
public class Solution2 {
    public List<List<Integer>> findSubsequences(int[] nums) { // 滑动窗口？
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 6, 7, 7};
        Solution2 solution2 = new Solution2();
        List<List<Integer>> result = solution2.findSubsequences(nums);
        log.info("result: {}", result);
    }
}
