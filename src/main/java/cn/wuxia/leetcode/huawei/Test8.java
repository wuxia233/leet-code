package cn.wuxia.leetcode.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Test8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            String[] qujians = line.split(" ");
            List<int[]> list = new ArrayList<>();
            for (int i = 0; i < qujians.length; i++) {
                int[] temp = new int[2];
                String[] qujian = qujians[i].split(",");
                int left = Integer.parseInt(qujian[0]);
                int right = Integer.parseInt(qujian[1]);
                temp[0] = left;
                temp[1] = right;
                list.add(temp);
            }

            list.sort((o1, o2) -> {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            });

            List<int[]> result = new ArrayList<>();
            result.add(list.get(0));
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i)[0] > result.get(result.size() - 1)[1]) {
                    result.add(list.get(i));
                } else {
                    result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], list.get(i)[1]);
                }
            }

            StringBuilder sb = new StringBuilder();
            result.forEach(it -> sb.append(it[0]).append(",").append(it[1]).append(" "));
            System.out.println(sb.toString().trim());
        }
    }
}
