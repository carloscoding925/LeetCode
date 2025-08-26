package Java.Medium;

public class _2_AddTwoNums {
    public static void main(String[] args) {
        System.out.println("#2 - Add Two Numbers - Medium");

        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode (9, new ListNode(9)))))));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));

        ListNode result = addTwoNumbers(l1, l2);

        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }

        return;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode head = result;
        int carry = 0;

        while(l1 != null || l2 != null || carry != 0) {
            int firstValue = l1 != null ? l1.val : 0;
            int secondValue = l2 != null ? l2.val : 0;

            int value = firstValue + secondValue + carry;
            carry = value / 10;
            value = value % 10;
            
            result.val = value;

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;

            if (l1 == null && l2 == null && carry == 0) {
                continue;
            }

            ListNode newNode = new ListNode();
            result.next = newNode;
            result = result.next;
        }

        return head;
    }
}
