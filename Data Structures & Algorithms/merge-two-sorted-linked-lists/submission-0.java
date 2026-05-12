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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null) return list1;
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        ListNode merg = new ListNode();

        if(list1.val < list2.val){
            merg = list1;
            list1 = list1.next;
        }
        else if(list1.val > list2.val){
            merg = list2;
            list2 = list2.next;
        }
        else{
            merg = list1;
            list1 = list1.next;
        }

        ListNode curr = merg;
        
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                curr.next = list1;
                list1 = list1.next;
            }
            else if(list1.val > list2.val){
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        if(list1 == null) curr.next = list2;
        if(list2 == null) curr.next = list1;

        return merg;
    }
}