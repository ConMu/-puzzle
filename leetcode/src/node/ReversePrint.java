package node;

import java.util.LinkedList;

public class ReversePrint {
    public static int[] reversePrint(ListNode head) {
        LinkedList<Integer> listNodes = new LinkedList<>();
        recur(head, listNodes);
        int[] res = new int[listNodes.size()];
        for (int i = 0; i < listNodes.size(); i++) {
            res[i] = listNodes.get(i);
        }
        return res;
    }

    private static void recur(ListNode head, LinkedList<Integer> listNodes) {
        if (head == null) {
            return;
        }
        recur(head.next, listNodes);
        listNodes.add(head.val);
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        reversePrint(listNode);
    }
}
