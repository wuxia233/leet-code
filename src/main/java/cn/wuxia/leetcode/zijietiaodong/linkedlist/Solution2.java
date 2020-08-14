package cn.wuxia.leetcode.zijietiaodong.linkedlist;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: WuXia
 * @Email: wuxia1@szunicom.com
 * @Date: 2020/7/14 14:43
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class Solution2 {
    // 迭代
    /*public ListNode reverseList(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        head = new ListNode();
        temp = head;
        while (!stack.isEmpty()) {
            temp.next = stack.pop();
            temp = temp.next;
        }
        temp.next = null;
        return head.next;
    }*/

    // 递归
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static void main(String... args) {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(4, l1);
        ListNode l3 = new ListNode(3, l2);
        ListNode l4 = new ListNode(2, l3);
        ListNode l5 = new ListNode(1, l4);

        Solution2 solution2 = new Solution2();
        ListNode result = solution2.reverseList(l5);
        System.out.println(result.toString());
    }
}
