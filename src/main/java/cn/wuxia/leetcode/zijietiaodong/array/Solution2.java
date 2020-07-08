package cn.wuxia.leetcode.zijietiaodong.array;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: WuXia
 * @Email: wuxia1@szunicom.com
 * @Date: 2020/7/7 15:18
 * 给定一个包含了一些 0 和 1 的非空二维数组 grid 。
 * 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,1,1,0,1,0,0,0,0,0,0,0,0],
 * [0,1,0,0,1,1,0,0,1,0,1,0,0],
 * [0,1,0,0,1,1,0,0,1,1,1,0,0],
 * [0,0,0,0,0,0,0,0,0,0,1,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。
 */
@Slf4j
public class Solution2 {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int rowLength = grid.length;
        int columnLength = grid[0].length;
        for (int x = 0; x < rowLength; x++) {
            for (int y = 0; y < columnLength; y++) {
                if (grid[x][y] > 0) {
                    AtomicInteger count = new AtomicInteger(1);
                    searchAndCount(x, y, grid, count);
                    if (count.get() > maxArea) {
                        maxArea = count.get();
                    }
                }
            }
        }
        return maxArea;
    }

    private void searchAndCount(int x, int y, int[][] grid, AtomicInteger count) {
        grid[x][y] = 0; // 保证递归时不重复
        if ((x - 1) >= 0 && grid[x - 1][y] > 0) {
            count.set(count.get() + 1);
            searchAndCount(x - 1, y, grid, count);
        }
        if ((x + 1) < grid.length && grid[x + 1][y] > 0) {
            count.set(count.get() + 1);
            searchAndCount(x + 1, y, grid, count);
        }
        if ((y + 1) < grid[0].length && grid[x][y + 1] > 0) {
            count.set(count.get() + 1);
            searchAndCount(x, y + 1, grid, count);
        }
        if ((y - 1) >= 0 && grid[x][y - 1] > 0) {
            count.set(count.get() + 1);
            searchAndCount(x, y - 1, grid, count);
        }
    }

    public static void main(String... args) {
        Solution2 solution2 = new Solution2();
        int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                        {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                        {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        int maxArea = solution2.maxAreaOfIsland(grid);
        log.info(String.valueOf(maxArea));
    }
}
