package cn.wuxia.leetcode.zijietiaodong.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: WuXia
 * @Email: wuxia1@szunicom.com
 * @Date: 2020/7/15 15:36
 *
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 说明：不允许修改给定的链表。
 */
public class Solution5 {
    /*public ListNode detectCycle(ListNode head) {
        List<ListNode> path = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            if (path.contains(temp)) {
                break;
            }
            path.add(temp);
            temp = temp.next;
        }
        return temp;
    }*/

    public ListNode detectCycle(ListNode head) {
        // 快慢双指针法
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
