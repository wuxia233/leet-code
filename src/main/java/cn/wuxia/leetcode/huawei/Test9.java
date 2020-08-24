package cn.wuxia.leetcode.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test9 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            String[] firstStrNums = line.split(" ");
            line = br.readLine();
            String[] secondStrNums = line.split(" ");

            ListNode firstHead = buildLinkedList(firstStrNums);
            ListNode secondHead = buildLinkedList(secondStrNums);

            ListNode first = firstHead;
            ListNode second = secondHead;
            ListNode newHead = new ListNode();
            ListNode temp = newHead;
            while (first != null && second != null) {
                if (first.value < second.value) {
                    temp.next = first;
                    first = first.next;
                } else {
                    temp.next = second;
                    second = second.next;
                }
                temp = temp.next;
            }
            if (first != null) {
                temp.next = first;
            }
            if (second != null) {
                temp.next = second;
            }

            newHead = newHead.next;
            StringBuilder sb = new StringBuilder();
            while (newHead != null) {
                sb.append(newHead.value).append(" ");
                newHead = newHead.next;
            }
            System.out.println(sb.toString().trim());
        }
    }

    private static ListNode buildLinkedList(String[] strNums) {
        ListNode head = new ListNode();
        ListNode temp = head;
        for (String strNum : strNums) {
            temp.next = new ListNode(Integer.parseInt(strNum));
            temp = temp.next;
        }
        return head.next;
    }
}
