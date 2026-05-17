/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        if(head.next == null) return;
        ListNode slow = head;
        ListNode fast = head;

        //find mid point
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newHead = slow.next;

        ListNode prev = newHead;
        ListNode curr = prev.next;

        newHead.next = null;
        
        while(curr != null){
            ListNode next = curr.next;

            curr.next = prev;

            prev = curr;
            curr = next;
        }

        newHead = prev;
        slow.next = newHead;

        curr = head;
        ListNode curr2 = newHead;
        ListNode next = null;

        while(curr.next != newHead){
            next = curr.next;       //prestore 1st half's next element
            curr.next = curr2;      //insert 
            if(curr2 != null)curr2 = curr2.next;        //move 2nd half's pointer to next element
            curr.next.next = next;      //inserted elements next is 1st halves next
            curr = next;            //move 1st half pointer to next element
        }

        if(curr2 != null) curr.next = curr2;
        else curr.next = null;

        return;

    }
}