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
        /*
         Map<Node, Node> map = new HashMap<>();
        map.put(null, null);

        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            map.put(curr, copy);
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            Node copy = map.get(curr);
            copy.next = map.get(curr.next);
            copy.random = map.get(curr.random);
            curr = curr.next;
        }
        return map.get(head);
        */
        if (head == null) {
            return null;
        }
        Node l1 = head;
        while (l1 != null) {
            Node l2 = new Node(l1.val);
            l2.next = l1.next;
            l1.next = l2;
            l1 = l2.next;
        }
        Node newHead = head.next;

        l1 = head;
        while (l1 != null) {
            if (l1.random != null) {
                l1.next.random = l1.random.next;
            }
            l1 = l1.next.next;
        }
        l1 = head;
        while (l1 != null) {
            Node l2 = l1.next;
            l1.next = l2.next;
            if (l2.next != null) {
                l2.next = l2.next.next;
            }
            l1 = l1.next;
        }
        return newHead;
    }
}
