package cn.wuxia.leetcode.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            char[] charArr = line.toCharArray();
            int[] counts = new int[150];
            for (char c : charArr) {
                counts[c]++;
            }

            int max = 0;
            for (int count : counts) {
                if (count > max) {
                    max = count;
                }
            }

            StringBuilder sb = new StringBuilder();
            while (max != 0) {
                for (int i = 0; i < counts.length; i++) {
                    if (counts[i] == max) {
                        sb.append((char) i);
                    }
                }
                max--;
            }

            System.out.println(sb.toString());
        }
    }
}
