package cn.wuxia.leetcode.huawei;

import lombok.extern.slf4j.Slf4j;

/**
 * 题目说明
 * 蛇形矩阵是由1开始的自然数依次排列成的一个矩阵上三角形。
 *
 * 样例输入
 * 5
 *
 * 样例输出
 * 1 3 6 10 15
 * 2 5 9 14
 * 4 8 13
 * 7 12
 * 11
 * 
 * 接口说明
 * 原型
 * void GetResult(int Num, char * pResult);
 * 
 * 输入参数：
 * int Num：输入的正整数N
 * 
 * 输出参数：
 * int * pResult：指向存放蛇形矩阵的字符串指针
 * 
 * 指针指向的内存区域保证有效
 * 返回值：
 * void
 */

@Slf4j
public class Test1 {
    public String getResult(int num) {
        int[][] temp = new int[num][num];
        int count = 0;
        for (int i = 0; i < num; i++) {
            int x = i;
            int y = 0;
            while (x >= 0 && y <= num) {
                temp[x][y] = ++count;
                x--;
                y++;
            }
        }
        StringBuilder result = new StringBuilder();
        for(int x = 0; x < num; x++) {
            for (int y = 0; y < num; y++) {
                if (temp[x][y] == 0) {
                    result.append(" ");
                } else {
                    result.append(temp[x][y]).append(" ");
                }
            }
            result.append("\n");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        String result = test1.getResult(41);
        log.info(result);
    }
}
