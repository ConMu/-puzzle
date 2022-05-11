package node;
/*https://leetcode-cn.com/problems/merge-k-sorted-lists/*/
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeList(lists, 0, lists.length - 1);
    }

    private ListNode mergeList(ListNode[] lists, int l, int r) {
        if (l > r) {
            return null;
        } else if (l == r) {
            return lists[l];
        } else {
            int mid = (l + r) >> 1;
            return merge(mergeList(lists, l, mid), mergeList(lists, mid + 1, r));
        }
    }

    private ListNode merge(ListNode node1, ListNode node2) {
        if (node1 == null && node2 == null) {
            return null;
        }
        if (node1 == null || node2 == null) {
            return node1 == null ? node2 : node1;
        }
        ListNode root = new ListNode(0);
        ListNode node = root;
        while (node1 != null && node2 != null) {
            if (node1.val > node2.val) {
                node.next = node2;
                node2 = node2.next;
            } else {
                node.next = node1;
                node1 = node1.next;
            }
            node = node.next;
        }
        if (node1 != null) {
            node.next = node1;
        } else {
            node.next = node2;
        }
        return root.next;
    }
}
