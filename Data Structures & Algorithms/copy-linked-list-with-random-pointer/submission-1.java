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
        if(head == null) return head;
        
        HashMap<Node , Node> map = new HashMap<>();

        Node n = head;

        Node newHead = new Node(n.val);
        map.put(head , newHead);
        
        Node curr = newHead;

        while(n.next != null){
            Node newNode = new Node(n.next.val);
            curr.next = newNode;
            map.put(n.next , newNode);

            n = n.next;
            curr = curr.next;
        }

        curr = newHead;
        n = head;
        
        while(n != null){
            if(n.random != null) curr.random = map.get(n.random);
            n = n.next;
            curr = curr.next;
        }

        return newHead;
    }
}
