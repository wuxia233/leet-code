package cn.wuxia.leetcode.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

class ListNode {
    int value;
    ListNode next = null;

    public ListNode(int value) {
        this.value = value;
    }

    public ListNode() {
    }
}

public class Test4 {

    public ListNode findKthToTail(ListNode head, int k) {
        Deque<ListNode> temp = new ArrayDeque<>();
        while (head.next != null) {
            temp.push(head);
            head = head.next;
        }
        ListNode result = null;
        while (!temp.isEmpty() && k-- > 0) {
            result = temp.pop();
        }
        if (k > 0) {
            return null;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            int nodeNum = Integer.parseInt(line);
            String[] values = br.readLine().split(" ");
            int k = Integer.parseInt(br.readLine());

            ListNode head = new ListNode();
            ListNode temp = head;
            for (String str : values) {
                temp.value = Integer.parseInt(str);
                temp.next = new ListNode();
                temp = temp.next;
            }

            Test4 test4 = new Test4();
            ListNode result = test4.findKthToTail(head, k);
            System.out.println(result == null ? 0 : result.value);
        }
    }
}
