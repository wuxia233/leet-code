package cn.wuxia.leetcode.zijietiaodong.string;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: WuXia
 * @Email: wuxia1@szunicom.com
 * @Date: 2020/4/17 16:22
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 */
@Slf4j
public class Solution2 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int minLength = strs[0].length();
        for (String str : strs) {
            if (str.length() < minLength) {
                minLength = str.length();
            }
        }

        StringBuilder result = new StringBuilder();
        char temp;
        for (int i = 0; i < minLength; i++) {
            temp = strs[0].charAt(i);
            for (String str : strs) {
                if (str.charAt(i) != temp) {
                    return result.toString();
                }
            }
            result.append(temp);
        }

        return result.toString();
    }

    public static void main(String... args) {
        Solution2 solution2 = new Solution2();
        String[] test = new String[] {"dog","racecar","car"};
        String result = solution2.longestCommonPrefix(test);
        log.info("最长公共前缀为：{}", result);
    }
}
