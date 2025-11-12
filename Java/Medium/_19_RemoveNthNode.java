package Java.Medium;

public class _19_RemoveNthNode {
    public static void main(String[] args) {
        System.out.println("#19 - Remove Nth Node From End of List - Medium");

        ListNode root = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode newList = removeNthFromEnd(root, 2);

        while (newList != null) {
            System.out.println(newList.val);
            newList = newList.next;
        }

        return;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }
}
