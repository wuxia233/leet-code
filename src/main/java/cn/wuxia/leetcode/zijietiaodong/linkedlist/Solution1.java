package cn.wuxia.leetcode.zijietiaodong.linkedlist;

/**
 * @Author: WuXia
 * @Email: wuxia1@szunicom.com
 * @Date: 2020/7/13 16:30
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Solution1 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode temp = head;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                temp.next = l2;
                l2 = l2.next;
            } else {
                temp.next = l1;
                temp = temp.next;
                l1 = l1.next;
            }
            temp = temp.next;
        }
        if (l1 != null) {
            temp.next = l1;
        }
        if (l2 != null) {
            temp.next = l2;
        }

        return head.next;
    }

    public static void main(String... args) {
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(2, l1);
        ListNode l3 = new ListNode(1, l2);
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(3, l4);
        ListNode l6 = new ListNode(1, l5);

        Solution1 solution1 = new Solution1();
        ListNode result = solution1.mergeTwoLists(l3, l6);
        System.out.println(result.toString());
    }
}
