package Java.Easy;

public class _21_MergeTwoLists {
    public static void main(String[] args) {
        System.out.println("#21 - Merge Two Sorted Lists - Easy");

        ListNode listOne = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode listTwo = new ListNode(1, new ListNode(3, new ListNode(4)));

        ListNode result = mergeTwoLists(listOne, listTwo);
        System.out.println("Printing Lists");

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
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

    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode mergedList = new ListNode();
        ListNode head = mergedList;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                head.next = list1;
                list1 = list1.next;
            }
            else {
                head.next = list2;
                list2 = list2.next;
            }

            head = head.next;
        }

        if (list1 != null) {
            head.next = list1;
        }
        else {
            head.next = list2;
        }

        return mergedList.next;
    }
}
