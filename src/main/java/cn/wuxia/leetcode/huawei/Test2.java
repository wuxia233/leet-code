package cn.wuxia.leetcode.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (i < str.length()) {
                char ch = str.charAt(i);
                if ('0' <= ch && ch <= '9') {
                    sb.append('*');
                    sb.append(ch);
                    while (++i < str.length() && '0' <= (ch = str.charAt(i)) && ch <= '9') {
                        sb.append(ch);
                    }
                    sb.append('*');
                } else {
                    sb.append(ch);
                    i++;
                }
            }
            System.out.println(sb.toString());
        }
    }
}
