package cn.wuxia.leetcode.zijietiaodong.array;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: WuXia
 * @Email: wuxia1@szunicom.com
 * @Date: 2020/7/9 10:00
 *
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 *
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 */
@Slf4j
public class Solution7 {
    /*public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> used = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(nums, 0, paths, k, used, path);

        StringBuilder result = new StringBuilder();
        for(Integer num : paths.get(paths.size() - 1)) {
            result.append(num);
        }
        return result.toString();
    }

    private void dfs(List<Integer> nums, int depth, List<List<Integer>> paths, int targetIndex, List<Integer> used, List<Integer> path) {
        if (depth == nums.size()) {
            paths.add(new ArrayList<>(path)); // path指向的内存的数据一直被修改，所以需要新建一个对象
            return;
        }

        for (Integer num : nums) {
            if (paths.size() == targetIndex) {
                break;
            }

            if (!used.contains(num)) {
                path.add(num);
                used.add(num);

                dfs(nums, depth + 1, paths, targetIndex, used, path);

                used.remove(used.size() - 1);
                path.remove(path.size() - 1);
            }
        }
    }*/

    public String getPermutation(int n, int k) {
        int factorialN = 1;
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
            factorialN *= i;
        }

        StringBuilder result = new StringBuilder();
        setHighNum(nums, result, n, k, factorialN);
        return result.toString();
    }

    private void setHighNum(List<Integer> nums, StringBuilder result, int n, int k, int factorialN) {
        if (n == 0) {
            return;
        }

        int factorialNMinusOne = factorialN / n;
        int index = (int) Math.ceil((double) k / factorialNMinusOne);
        result.append(nums.get(Math.max(index - 1, 0)));
        nums.remove(Math.max(index - 1, 0));
        int nextK = k % factorialNMinusOne;
        if (nextK == 0) {
            nextK = factorialNMinusOne;
        }
        setHighNum(nums, result, n - 1, nextK, factorialNMinusOne);
    }

    public static void main(String... args) {
        int k = 2;
        int n = 3;
        Solution7 solution7 = new Solution7();
        String result = solution7.getPermutation(n, k);
        log.info(result);
    }
}
