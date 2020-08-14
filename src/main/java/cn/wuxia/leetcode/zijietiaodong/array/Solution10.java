package cn.wuxia.leetcode.zijietiaodong.array;

/**
 * @Author: WuXia
 * @Email: wuxia1@szunicom.com
 * @Date: 2020/7/10 16:34
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
public class Solution10 {
    public int trap(int[] height) {
        int rainArea = 0;
        int i = 0;
        while (i < height.length - 1) { // 需要找到一段区间内最高的两个柱子来计算之间的雨水面积
            int maxHeight = 0;
            int maxHeightIndex = 0;
            if (height[i] > 0) {
                int j = i + 1;
                while(j < height.length && height[j] < height[i]) {
                    if (height[j] > maxHeight) {
                        maxHeight = height[j];
                        maxHeightIndex = j;
                    }
                    j++;
                }
                if (j == height.length) {
                    if (i < maxHeightIndex) {
                        rainArea += countArea(height, i, maxHeightIndex);
                        i = maxHeightIndex;
                    } else {
                        i++;
                    }
                } else {
                    rainArea += countArea(height, i, j);
                    i = j;
                }
            } else {
                i++;
            }
        }
        return rainArea;
    }

    /**
     * 计算两个柱子间的雨水面积
     * @param height
     * @param left
     * @param right
     * @return
     */
    private int countArea(int[] height, int left, int right) {
        int bucketHeight = Math.min(height[left], height[right]);
        int totalArea = bucketHeight * (right - left + 1);
        int bucketArea = 0;
        for (int i = left; i <= right; i++) {
            if (height[i] > 0) {
                int tempHeight = Math.min(bucketHeight, height[i]);
                bucketArea += tempHeight;
            }
        }
        return totalArea - bucketArea;
    }

    public static void main(String... args) {
        Solution10 solution10 = new Solution10();
        // int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] height = {5,4,1,2};
        int count = solution10.trap(height);
        System.out.println(count);
    }
}
