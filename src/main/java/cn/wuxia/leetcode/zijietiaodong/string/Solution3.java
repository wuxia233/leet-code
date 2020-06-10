package cn.wuxia.leetcode.zijietiaodong.string;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @Author: WuXia
 * @Email: wuxia1@szunicom.com
 * @Date: 2020/4/17 16:55
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 */
@Slf4j
public class Solution3 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() == 0 || s2.length() == 0) {
            return false;
        }

        char[] charArr = s1.toCharArray();
        // 排序，方便剪枝
        Arrays.sort(charArr);
        String sortedStr = new String(charArr);

        int length = s1.length();
        boolean[] used = new boolean[length]; // 布尔数组，用于遍历过程中判断字符串当前位置字符是否使用过
        Deque<Character> path = new ArrayDeque<>(length);
        try {
            dfs(sortedStr, s2, length, used, path, 0);
        } catch (Exception e) {
            return true;
        }
        return false;
    }

    // 深度优先遍历
    private void dfs(String s1, String s2, int length, boolean[] used, Deque<Character> path, int deep) throws Exception {
        if (deep == length) {
            StringBuilder result = new StringBuilder(length);
            path.forEach(result::append);
            if (s2.contains(result)) {
                throw new Exception("find");
            }
            return;
        }

        for (int i = 0; i < length; i++) {
            if (!used[i]) {
                // 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
                // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
                if (i > 0 && s1.charAt(i) == s1.charAt(i - 1) && !used[i - 1]) {
                    continue;
                }

                path.addLast(s1.charAt(i));
                used[i] = true;

                dfs(s1, s2, length, used, path, deep + 1);

                // 回溯
                used[i] = false;
                path.removeLast();
            }
        }
    }

    public static void main(String... args) {
        Solution3 solution3 = new Solution3();
        String s1 = "dinitrophenylhydrazine";
        String s2 = "acetylphenylhydrazine";
        log.info("result: {}", solution3.checkInclusion(s1, s2));
    }
}