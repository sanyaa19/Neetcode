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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode curr1 = l1;
        int size1 = 0;
        while(curr1 != null){
            curr1 = curr1.next;
            size1++;
        }

        ListNode curr2 = l2;
        int size2 = 0;
        while(curr2 != null){
            curr2 = curr2.next;
            size2++;
        }

        if(size1 > size2){
            curr1 = l1;
            curr2 = l2;
        }
        else{
            curr1 = l2;
            curr2 = l1;
        }

        ListNode ans = curr1;

        while(curr2 != null){
            int sum = curr1.val + curr2.val;

            if(sum > 9 && curr1.next != null){
                curr1.next.val += sum / 10;
                curr1.val = sum % 10; 
            }
            else if (sum > 9 && curr1.next == null){
                ListNode newNode = new ListNode(sum / 10 , null);
                curr1.val = sum % 10;
                curr1.next = newNode;
            }
            else curr1.val = sum;

            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        while(curr1 != null && curr1.val > 9){
            if(curr1.next != null){
                curr1.next.val += curr1.val / 10;
                curr1.val = curr1.val % 10; 
            }
            else{
                ListNode newNode = new ListNode(curr1.val / 10 , null);
                curr1.val = curr1.val % 10;
                curr1.next = newNode;
            }
            curr1 = curr1.next;
        } 
        
        return ans;
    }
}
