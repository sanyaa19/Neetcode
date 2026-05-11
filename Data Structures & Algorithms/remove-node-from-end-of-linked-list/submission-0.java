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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null && n==1){      //no need to check for n==1 as per constrain it will be 1 only
            head = null;                    // line 29 can check for this also but this just reduces the work
            return head;
        }

        int size = 0;

        ListNode curr = head;
        while(curr != null){
            size++;
            curr = curr.next;
        }

        // nth node from end == size - n + 1 node from beginning <- node to be deleted

        if(size - n + 1 == 1){      //head has to be changed in other cases head won't change.
            head = head.next;
            return head;        
        }

        curr = head;
        int pos = 1;

        while(pos < size-n){  //loop until we reach 2 pos before the node to be deleted, it will break when we reach 1 pos before
            curr = curr.next;   //current position inc so pos also increase
            pos++;
        }

        curr.next = curr.next.next;   //we will point 1 pos before n(th) node's next to n(th) node's next, hence deleted 

        return head;
    }
}
