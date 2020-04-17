package cn.wuxia.leetcode.zijietiaodong.string;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: WuXia
 * @Email: wuxia1@szunicom.com
 * @Date: 2020/4/17 15:20
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
@Slf4j
public class Solution1 {

    public int lengthOfLongestSubstring(String s) {
        StringBuilder result = new StringBuilder();
        int longest = 0;
        for (int i = 0; i < s.length(); i++) {
            int repeatIndex = result.toString().indexOf(s.charAt(i));
            if (repeatIndex >= 0) {
                if (result.length() > longest) {
                    longest = result.length();
                }
                result.delete(0, repeatIndex + 1);
            }
            result.append(s.charAt(i));
        }

        int length = result.length();
        if (length > longest) {
            longest = result.length();
        }

        return longest;
    }

    public static void main(String... args) {
        Solution1 solution1 = new Solution1();
        String testStr = "";
        log.info("test string length: {}", testStr.length());
        int result = solution1.lengthOfLongestSubstring(testStr);
        log.info("无重复最长子串长度为：{}", result);
    }
}
