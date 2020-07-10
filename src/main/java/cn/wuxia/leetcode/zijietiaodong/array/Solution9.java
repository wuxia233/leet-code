package cn.wuxia.leetcode.zijietiaodong.array;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: WuXia
 * @Email: wuxia1@szunicom.com
 * @Date: 2020/7/10 11:02
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * <p>
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
@Slf4j
public class Solution9 {
    /*public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });
        for (int i = 0; i < intervals.length; i++) {
            int j = i + 1;
            while (j < intervals.length && intervals[i][1] < intervals[j][0]) {
                j++;
            }
            if (j < intervals.length) {
                if (intervals[i][1] > intervals[j][1]) {
                    intervals[j][0] = intervals[i][0];
                    intervals[j][1] = intervals[i][1];
                } else {
                    intervals[j][0] = intervals[i][0];
                }
                // 替换后删除不需要的区间
                System.arraycopy(intervals, i + 1, intervals, i, intervals.length - 1 - i);
                int[][] temp = new int[intervals.length - 1][];
                System.arraycopy(intervals, 0, temp, 0, intervals.length - 1);
                intervals = temp;
                i--;
            }
        }
        return intervals;
    }*/

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0 || intervals.length == 1) {
            return intervals;
        }

        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });

        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > result.get(result.size() - 1)[1]) {
                result.add(intervals[i]);
            } else {
                result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], intervals[i][1]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String... args) {
        int[][] intervals = {{1, 4}, {0, 2}, {3, 5}};
        Solution9 solution9 = new Solution9();
        int[][] result = solution9.merge(intervals);
        log.info(Arrays.deepToString(result));
    }
}
