package com.shika.leetcode;

/**
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 */
class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (right - left > 0 && left > 0) {
            ListNode section1Tail = null;
            ListNode section3Head = null;
            int pos = 1;
            ListNode temp = head;
            while (temp != null && pos < left - 1) {
                temp = temp.next;
                pos++;
            }
            section1Tail = temp;
            while (temp != null && pos < right) {
                temp = temp.next;
                pos++;
            }
            section3Head = temp.next;

            ListNode section2Head = section1Tail.next;
            int section2Length = right - left + 1;
            ListNode reversed = reverseInsideList(
                    section2Head, section2Length, section3Head);
            section1Tail.next = reversed;
            return head;
        }
        return head;
    }

    public static ListNode reverseInsideList(
            ListNode head, int length, ListNode nextSectionHead) {
        // 这里prev初始化为下一段首节点，而不是null
        ListNode prev = nextSectionHead;
        ListNode current = head;
        ListNode temp = null;
        int count = 0;
        while (current != null && count < length) {
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
            count++;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
//        listNode.next = new ListNode(2);
//        listNode.next.next = new ListNode(3);
//        listNode.next.next.next = new ListNode(4);
//        listNode.next.next.next.next = new ListNode(5);
//        ListNode node = reverseBetween(listNode, 2, 4);
        listNode.next = new ListNode(3);
        listNode.next.next = new ListNode(5);
        ListNode node = reverseBetween(listNode, 1, 2);
        System.out.println(node);
    }
}