package cn.wuxia.leetcode.zijietiaodong.string;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: WuXia
 * @Email: wuxia1@szunicom.com
 * @Date: 2020/4/22 15:49
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 */
@Slf4j
public class Solution4 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }
        for (int i = s1.length(); i < s2.length(); i++) {
            if (!equal(s1Count, s2Count)) {
                s2Count[s2.charAt(i - s1.length()) - 'a']--;
                s2Count[s2.charAt(i) - 'a']++;
            } else {
                return true;
            }
        }
        return equal(s1Count, s2Count);
    }

    private boolean equal(int[] s1Count, int[] s2Count) {
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] != s2Count[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String... args) {
        Solution4 solution4 = new Solution4();
        String s1 = "dinitrophenylhydrazine";
        String s2 = "acetylphenylhydrazine";
        log.info("result: {}", solution4.checkInclusion(s1, s2));
    }
}
