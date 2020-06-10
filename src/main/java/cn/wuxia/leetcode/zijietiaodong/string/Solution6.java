package cn.wuxia.leetcode.zijietiaodong.string;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: WuXia
 * @Email: wuxia1@szunicom.com
 * @Date: 2020/6/4 15:53
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 */
@Slf4j
public class Solution6 {
    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder result = new StringBuilder();
        int left;
        int right = 0;
        String word;
        int length = s.length();
        for (int i = length - 1; i >= 0; i--) {
            // 单词开始标志
            if ((i == length - 1 && s.charAt(i) != ' ') || (s.charAt(i) != ' ' && s.charAt(i + 1) == ' ')) {
                right = i;
            }
            // 单词结束标志
            if (s.charAt(i) == ' ' && s.charAt(i + 1) != ' ') {
                left = i;
                if (left < right) {
                    word = s.substring(left + 1, right + 1);
                    result.append(word).append(" ");
                }
            }
            if (i == 0 && s.charAt(0) !=   ' ') {
                word = s.substring(0, right + 1);
                result.append(word);
            }
        }
        return result.toString().trim();
    }

    public static void main(String... args) {
        String str = "a good   example";
        Solution6 solution6 = new Solution6();
        String result = solution6.reverseWords(str);
        log.info(result);
    }
}
