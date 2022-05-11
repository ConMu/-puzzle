package node;

public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        ListNode cur = new ListNode(0);
        ListNode node = cur;
        int count = 0, num = 0;
        while (l1 != null && l2 != null) {
            num = (l1.val + l2.val + count) % 10;
            count = (l1.val + l2.val + count) / 10;
            cur.next = new ListNode(num);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode leftNode = l1 == null ? l2 : l1;
        while (leftNode != null) {
            num = (leftNode.val + count) % 10;
            count = (leftNode.val + count) / 10;
            cur.next = new ListNode(num);
            cur = cur.next;
            leftNode = leftNode.next;
        }
        if (count == 1) {
            cur.next = new ListNode(1);
        }
        return node.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(9);
        node1.next = new ListNode(9);
//        node1.next.next = new ListNode(3);
        ListNode node2 = new ListNode(9);
        node2.next = new ListNode(9);
        node2.next.next = new ListNode(9);
        node2.next.next.next = new ListNode(9);
        addTwoNumbers(node1, node2);

    }
}

