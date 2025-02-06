public class AddTwoNum_2 {
    // Given ListNode Class
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static ListNode solutionOne(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode tail = head;
        int carry = 0;

        while(l1 != null || l2 != null || carry != 0) {
            int numberOne = l1 != null ? l1.val : 0;
            int numberTwo = l2 != null ? l2.val : 0;

            int sum = numberOne + numberTwo + carry;
            int value = sum % 10;
            carry = sum / 10;

            ListNode nextNode = new ListNode(value);
            tail.next = nextNode;
            tail = tail.next;

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        ListNode result = head.next;
        head.next = null;

        return result;
    }

    public static void main(String[] args) {
        System.out.println("#2 - Add Two Numbers - Medium");
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode result = solutionOne(l1, l2);

        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
