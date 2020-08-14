package cn.wuxia.leetcode.zijietiaodong.linkedlist;

/**
 * @Author: WuXia
 * @Email: wuxia1@szunicom.com
 * @Date: 2020/7/15 11:47
 *
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *
 * 示例 1:
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 */
public class Solution4 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 求链表中点可以用快慢双指针法
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(temp);

        // 开始合并
        ListNode newHead = new ListNode();
        ListNode temp2 = newHead;
        while (left != null && right != null) {
            if (left.val < right.val) {
                temp2.next = left;
                left = left.next;
            } else {
                temp2.next = right;
                right = right.next;
            }
            temp2 = temp2.next;
        }
        temp2.next = left != null ? left : right;

        return newHead.next;
    }

    public static void main(String... args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(1, l1);
        ListNode l3 = new ListNode(2, l2);
        ListNode l4 = new ListNode(4, l3);

        Solution4 solution4 = new Solution4();
        ListNode result = solution4.sortList(l4);
        System.out.println(result.toString());
    }
}
