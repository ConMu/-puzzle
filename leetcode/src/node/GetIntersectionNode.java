package node;

public class GetIntersectionNode {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode node1 = headA;
        ListNode node2 = headB;
        while (node1 != null) {
            node1 = node1.next;
            lenA++;
        }
        while (node2 != null) {
            node2 = node2.next;
            lenB++;
        }
        ListNode loNode, shoNode;
        if (lenA > lenB) {
            loNode = headA;
            shoNode = headB;
        } else {
            loNode = headB;
            shoNode = headA;
        }
        int count = Math.abs(lenA - lenB);
        while (count > 0) {
            loNode = loNode.next;
            count--;
        }
        while (loNode != shoNode) {
            loNode = loNode.next;
            shoNode = shoNode.next;
        }
        return loNode;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node4.next = node5;
        node5.next = node6;
        node6.next = node2;
        getIntersectionNode(node1, node4);



    }
}
