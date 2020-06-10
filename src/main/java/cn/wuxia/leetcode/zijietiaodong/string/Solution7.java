package cn.wuxia.leetcode.zijietiaodong.string;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: WuXia
 * @Email: wuxia1@szunicom.com
 * @Date: 2020/6/9 14:08
 * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
 */
@Slf4j
public class Solution7 {
    public String simplifyPath(String path) {
        String[] words = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        for (String word : words) {
            switch (word) {
                case "":
                case ".":
                    continue;
                case "..":
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    break;
                default:
                    stack.push(word);
            }
        }

        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append("/").append(stack.pollLast());
        }
        return result.toString();
    }

    public static void main(String... args) {
        String path = "/home/";
        Solution7 solution7 = new Solution7();
        String result = solution7.simplifyPath(path);
        log.info(result);
    }
}
