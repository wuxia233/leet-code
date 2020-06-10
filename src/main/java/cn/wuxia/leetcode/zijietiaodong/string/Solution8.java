package cn.wuxia.leetcode.zijietiaodong.string;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: WuXia
 * @Email: wuxia1@szunicom.com
 * @Date: 2020/6/9 15:46
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。
 */
@Slf4j
public class Solution8 {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        dfs(s, 4, result, path);
        return result;
    }

    private void dfs(String s, int depth, List<String> result, List<String> path) {
        if (depth == 0) {
            StringBuilder ip = new StringBuilder();
            for (String ipQuarter : path) {
                ip.append(ipQuarter).append(".");
            }
            String ipStr = ip.toString();
            result.add(ipStr.substring(0, ipStr.length() - 1));
            return;
        }

        for (int i = 1; i <= Math.min(3, s.length()); i++) {
            if (depth == 1) {
                if (i == s.length()) {
                    doJob(s, i, path, depth, result);
                }
            } else {
                int restLength = s.length() - i;
                if (restLength / (double) (depth - 1) <= 3) { // 剪枝，IP每部分至多3位数字
                    doJob(s, i, path, depth, result);
                }
            }
        }
    }

    private void doJob(String s, int i, List<String> path, int depth, List<String> result) {
        String ipQuarterStr = s.substring(0, i);
        if (ipQuarterStr.length() > 1 && ipQuarterStr.substring(0, 1).equals("0")) {
            return;
        }
        int ipQuarter = Integer.parseInt(ipQuarterStr);
        if (ipQuarter >= 0 && ipQuarter <= 255) {
            path.add(ipQuarterStr);

            dfs(s.substring(i), depth - 1, result, path);

            // 回溯
            path.remove(path.size() - 1);
        }
    }

    public static void main(String... args) {
        String s = "101023";
        Solution8 solution8 = new Solution8();
        List<String> result = solution8.restoreIpAddresses(s);
        log.info(result.toString());
    }
}
