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
    public ListNode reverse(ListNode head, int k, int itr){
        if(itr == 0) return head;

        itr--;
        ListNode first = head;
        ListNode prev = head;
        ListNode curr = prev.next;

        for(int i = 1; i < k; i++){
            ListNode next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        head = prev;
        first.next = reverse(curr , k , itr);
        
        return head;
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        if(head == null || head.next == null || k == 1) return head;

        ListNode curr = head;
        int size = 0;
        while(curr != null){
            size++;
            curr = curr.next;
        }

        if(k > size) return head;

        int itr = size / k;

        curr = head;

        head = reverse(curr, k, itr);

        return head;
    }
}
