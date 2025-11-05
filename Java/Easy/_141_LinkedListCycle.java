package Java.Easy;

public class _141_LinkedListCycle {
    public static void main(String[] args) {
        System.out.println("#141 - Linked List Cycle - Easy");

        ListNode list = new ListNode(0, new ListNode(1, new ListNode(3)));
        list.next.next.next = list;

        boolean cycle = hasCycle(list);
        System.out.println("Has Cycle: " + cycle);

        return;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; this.next = null; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    private static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}
