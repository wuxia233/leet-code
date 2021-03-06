package cn.wuxia.leetcode.zijietiaodong.array;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @Author: WuXia
 * @Email: wuxia1@szunicom.com
 * @Date: 2020/7/8 15:02
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 */
@Slf4j
public class Solution6 {
    /*public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }

        int result = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            int count = 1;
            while((i + 1) < nums.length && (nums[i + 1] - nums[i] == 1 || nums[i + 1] == nums[i])) {
                if (nums[i + 1] - nums[i] == 1) {
                    count++;
                }
                i++;
            }
            if (count > result) {
                result = count;
            }
        }
        return result;
    }*/

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int result = 1;
        int count;
        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()) {
            count = 1;
            Integer num = iterator.next();
            if (!set.contains(num - 1)) {
                while(set.contains(++num)) {
                    count++;
                }
                if (count > result) {
                    result = count;
                }
            }
        }
        return result;
    }

    public static void main(String... args) {
        Solution6 solution6 = new Solution6();
        int[] nums = {100, 4, 200, 1, 3, 2};
        int result = solution6.longestConsecutive(nums);
        log.info(String.valueOf(result));
    }
}
