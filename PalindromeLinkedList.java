// https://leetcode.com/problems/palindrome-linked-list/submissions/1455212409/

import java.util.*;

class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if (head == null && head.next == null) {
            return true;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode current = head;
        while (current != null) {
            stack.push(current);
            current = current.next;
        }
        current = head;
        while (current != null) {
            if (current.val != stack.pop().val) {
                return false;
            }
            current = current.next;
        }
        return true;

    }
}
