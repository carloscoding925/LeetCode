package Java.Easy;

public class _206_ReverseLinkedList {
    public static void main(String[] args) {
        System.out.println("#206 - Reverse Linked List - Easy");

        ListNode list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode reversed = reverseList(list);

        while (reversed != null) {
            System.out.println(reversed.val);
            reversed = reversed.next;
        }

        ListNode list2 = new ListNode();
        ListNode result = recursiveReverse(list2);
        System.out.println(result);
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    private static ListNode recursiveReverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = recursiveReverse(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }
}
