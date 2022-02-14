package solutions;

import java.util.HashMap;
import java.util.Map;

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
public class CopyLinkedList {

    public Node copyRandomList(Node head) {

        if (head == null) {
            return head;
        }

        Map<Integer, Node> map1 = new HashMap<>();
        Map<Node, Integer> map2 = new HashMap<>();
        Node p = head;
        int i = 0;
        while (p != null) {

            Node temp = new Node(p.val);
            map1.put(i, temp);
            map2.put(p, i);
            p = p.next;
            ++i;
        }

        for (Node item : map2.keySet()) {

            int cur = map2.get(item);
            if (map2.get(item.next) != null) {

                int next = map2.get(item.next);
                map1.get(cur).next = map1.get(next);
            }
            if (map2.get(item.random) != null) {

                int random = map2.get(item.random);
                map1.get(cur).random = map1.get(random);
            }
        }

        return map1.get(0);
    }

    public static void main(String[] args) {

        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);

        Node head = node1;

        node1.next = node2;
        node1.random = null;

        node2.next = node3;
        node2.random = node1;

        node3.next = node4;
        node3.random = node5;

        node4.next = node5;
        node4.random = node3;

        node5.next = null;
        node5.random = node1;

        CopyLinkedList copy = new CopyLinkedList();
        copy.copyRandomList(head);
    }
}
