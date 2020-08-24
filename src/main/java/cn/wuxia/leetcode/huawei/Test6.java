package cn.wuxia.leetcode.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Test6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            String[] nums = line.split(" ");
            int row = Integer.parseInt(nums[0]);
            int column = Integer.parseInt(nums[1]);
            int[][] maze = new int[row][column];
            for (int i = 0; i < row; i++) {
                line = br.readLine();
                String[] tempRow = line.split(" ");
                for (int j = 0; j < column; j++) {
                    maze[i][j] = Integer.parseInt(tempRow[j]);
                }
            }

            List<List<Couple>> result = new ArrayList<>();
            List<Couple> path = new ArrayList<>();
            Test6 test6 = new Test6();
            test6.dfs(path, result, maze, 0, 0);
            StringBuilder sb = new StringBuilder();
            path = result.get(0);
            for (List<Couple> list : result) {
                if (list.size() < path.size()) {
                    path.clear();
                    path.addAll(list);
                }
            }
            path.forEach(it -> sb.append("(").append(it.getFirst()).append(",").append(it.getSecond()).append(")").append("\n"));
            System.out.println(sb.toString().trim());
        }
    }

    private void dfs(List<Couple> path, List<List<Couple>> result, int[][] maze, int x, int y) {
        if (x == maze.length - 1 && y == maze[0].length - 1) {
            path.add(new Couple(x, y));
            result.add(new ArrayList<>(path));
            return;
        }

        path.add(new Couple(x, y));
        maze[x][y] = 1;

        if (x < maze.length - 1 && maze[x + 1][y] == 0) {//下
            dfs(path, result, maze, x + 1, y);
            maze[x][y] = 0;
            path.remove(path.size() - 1);
        }
        if (y < maze[0].length - 1 && maze[x][y + 1] == 0) {//右
            dfs(path, result, maze, x, y + 1);
            maze[x][y] = 0;
            path.remove(path.size() - 1);
        }
        if (x > 0 && maze[x - 1][y] == 0) {//上
            dfs(path, result, maze, x - 1, y);
            maze[x][y] = 0;
            path.remove(path.size() - 1);
        }
        if (y > 0 && maze[x][y - 1] == 0) {//左
            dfs(path, result, maze, x, y - 1);
            maze[x][y] = 0;
            path.remove(path.size() - 1);
        }
    }
}

class Couple<A, B> {
    private A first;
    private B second;

    public Couple(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public A getFirst() {
        return first;
    }

    public void setFirst(A first) {
        this.first = first;
    }

    public B getSecond() {
        return second;
    }

    public void setSecond(B second) {
        this.second = second;
    }
}
