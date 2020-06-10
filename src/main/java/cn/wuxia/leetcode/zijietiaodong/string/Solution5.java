package cn.wuxia.leetcode.zijietiaodong.string;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: WuXia
 * @Email: wuxia1@szunicom.com
 * @Date: 2020/4/23 15:21
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 */
@Slf4j
public class Solution5 {
    public String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int num1Length = num1.length();
        int num2Length = num2.length();

        StringBuilder result = new StringBuilder();
        for (int i = num2Length - 1; i >= 0; i--) {
            int carryMultiply = 0; // 存储每一位与每一位乘积的进位

            StringBuilder addNum = new StringBuilder(); // 存储num1与num2的某一位的乘积
            for (int j = num1Length - 1; j >= 0; j--) {
                int product = (num1.charAt(j) - '0') * (num2.charAt(i) - '0') + carryMultiply;
                String productStr = String.valueOf(product);
                if (productStr.length() > 1) {
                    carryMultiply = productStr.charAt(0) - '0';
                } else {
                    carryMultiply = 0;
                }
                addNum.insert(0, product % 10);
            }
            addNum.insert(0, carryMultiply == 0 ? "" : carryMultiply);

            // 给addNum末尾补0
            int di = num2Length - i - 1;
            for (int j = 0; j < di; j++) {
                addNum.append('0');
            }

            // 将乘积累加
            int carryPlus = 0; // 加法进位
            StringBuilder temp = new StringBuilder(result); // 临时变量，用于遍历
            int k = addNum.length() - 1;
            for (int j = temp.length() - 1; j >= 0; j--) {
                int sum = temp.charAt(j) - '0' + addNum.charAt(k--) - '0' + carryPlus;
                String sumStr = String.valueOf(sum);
                if (sumStr.length() > 1) {
                    carryPlus = sumStr.charAt(0) - '0';
                } else {
                    carryPlus = 0;
                }
                result.replace(j, j + 1, String.valueOf(sum % 10));
            }

            for(int j = addNum.length() - temp.length() - 1; j >= 0; j--) {
                int sum = addNum.charAt(j) - '0' + carryPlus;
                String sumStr = String.valueOf(sum);
                if (sumStr.length() > 1) {
                    carryPlus = sumStr.charAt(0) - '0';
                } else {
                    carryPlus = 0;
                }
                result.insert(0, sum % 10);
            }
            result.insert(0, carryPlus == 0 ? "" : carryPlus);
        }

        return result.toString();
    }

    public static void main(String... args) {
        String num1 = "123456789987654321123456789987654321";
        String num2 = "98765432112345678998765432123456567899";
        Solution5 solution5 = new Solution5();
        log.info(solution5.multiply(num1, num2));
    }
}
