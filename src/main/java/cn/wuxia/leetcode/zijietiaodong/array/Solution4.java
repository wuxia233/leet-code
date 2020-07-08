package cn.wuxia.leetcode.zijietiaodong.array;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: WuXia
 * @Email: wuxia1@szunicom.com
 * @Date: 2020/7/8 14:41
 * 给定一个未经排序的整数数组，找到最长且连续的的递增序列，并返回该序列的长度。
 */
@Slf4j
public class Solution4 {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }

        int ascLength = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            while((i + 1) < nums.length && nums[i + 1] > nums[i]) {
                i++;
                count++;
            }
            if (count > ascLength) {
                ascLength = count;
            }
        }

        return ascLength;
    }

    public static void main(String... args) {
        Solution4 solution4 = new Solution4();
        int[] nums = {1,3,5,4,7};
        int ascLength = solution4.findLengthOfLCIS(nums);
        log.info(String.valueOf(ascLength));
    }
}
