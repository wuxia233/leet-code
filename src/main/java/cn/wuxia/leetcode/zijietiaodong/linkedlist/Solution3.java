package cn.wuxia.leetcode.zijietiaodong.linkedlist;

import java.util.regex.Pattern;

/**
 * @Author: WuXia
 * @Email: wuxia1@szunicom.com
 * @Date: 2020/7/14 16:18
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class Solution3 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = new ListNode();
        ListNode temp = head;
        int sum;
        while(l1 != null && l2 != null) {
            sum = (l1.val + l2.val + carry) % 10;
            temp.next = new ListNode(sum);
            carry = (l1.val + l2.val + carry) / 10;
            temp = temp.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            sum = (l1.val + carry) % 10;
            carry = (l1.val + carry) / 10;
            temp.next = new ListNode(sum);
            temp = temp.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            sum = (l2.val + carry) % 10;
            carry = (l2.val + carry) / 10;
            temp.next = new ListNode(sum);
            temp = temp.next;
            l2 = l2.next;
        }
        if (carry > 0) {
            temp.next = new ListNode(carry);
        }
        return head.next;
    }

    public static void main(String... args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(4, l1);
        ListNode l3 = new ListNode(2, l2);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(6, l4);
        ListNode l6 = new ListNode(5, l5);

        Solution3 solution3 = new Solution3();
        ListNode result = solution3.addTwoNumbers(l3, l6);
        System.out.println(result.toString());
    }
}
