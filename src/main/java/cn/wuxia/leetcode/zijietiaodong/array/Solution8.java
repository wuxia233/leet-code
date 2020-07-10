package cn.wuxia.leetcode.zijietiaodong.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: WuXia
 * @Email: wuxia1@szunicom.com
 * @Date: 2020/7/9 16:52
 * <p>
 * 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。
 * <p>
 * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [[1,1,0],
 * [1,1,0],
 * [0,0,1]]
 * 输出: 2
 * 说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
 * 第2个学生自己在一个朋友圈。所以返回2。
 */
public class Solution8 {
    public int findCircleNum(int[][] M) {
        int length = M.length;
        List<Set<Integer>> friendCircles = new ArrayList<>();
        Set<Integer> circle = new HashSet<>();
        for (int x = 0; x < length; x++) {
            findFriend(M, x, friendCircles, circle); // 找x的朋友
        }
        return friendCircles.size();
    }

    private void findFriend(int[][] M, int x, List<Set<Integer>> friendCircles, Set<Integer> circle) {
        for (int y = 0; y < M.length; y++) {
            if (M[x][y] > 0) {
                M[x][y] = 0;
                if (!circle.isEmpty() && !circle.contains(x) && !circle.contains(y)) {
                    friendCircles.add(new HashSet<>(circle));
                    circle.clear();
                }
                circle.add(x);
                circle.add(y);
                if (y == M.length - 1 && x == y) {
                    friendCircles.add(new HashSet<>(circle));
                }
                if (x != y) { // 说明x，y是朋友
                    if (M[y][x] > 0) {
                        findFriend(M, y, friendCircles, circle); // 递归的找y的朋友，y的朋友就是x的朋友
                    }
                }
            }
        }
    }

    public static void main(String... args) {
        Solution8 solution8 = new Solution8();
        /*int[][] M = {{1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 0, 1, 1}};*/
        /*int [][] M = {{1, 1, 0},
                      {1, 1, 0},
                      {0, 0 ,1}};*/
        int[][] M = {{1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                     {0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                     {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                     {0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0},
                     {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                     {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                     {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                     {0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                     {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                     {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                     {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                     {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                     {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}};
        int circleNum = solution8.findCircleNum(M);
        System.out.println(circleNum);
    }
}
