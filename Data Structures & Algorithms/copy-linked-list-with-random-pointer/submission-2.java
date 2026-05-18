/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // if(head == null) return null;
        
        // HashMap<Node , Node> map = new HashMap<>();

        // Node n = head;

        // Node newHead = new Node(n.val);
        // map.put(head , newHead);
        
        // Node curr = newHead;

        // while(n.next != null){
        //     Node newNode = new Node(n.next.val);
        //     curr.next = newNode;
        //     map.put(n.next , newNode);

        //     n = n.next;
        //     curr = curr.next;
        // }

        // curr = newHead;
        // n = head;
        
        // while(n != null){
        //     if(n.random != null) curr.random = map.get(n.random);
        //     n = n.next;
        //     curr = curr.next;
        // }

        // return newHead;

        if(head == null) return null;

        Node curr = head;

        while(curr != null){
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = curr.next.next;
        }

        curr = head;

        while(curr != null){
            if(curr.random != null) curr.next.random = curr.random.next;
            curr = curr.next.next;
        }

        Node original = head;
        Node copyHead = head.next;
        Node copied = copyHead;

        while(original != null){
            original.next = original.next.next;

            if(copied.next != null) copied.next = copied.next.next;

            original = original.next;
            copied = copied.next;
        }

        return copyHead;
    }
}
