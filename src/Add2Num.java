
public class Add2Num {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = null, curRN = null, cur1 = null, cur2 = null;


        int v4 = 0;

        ListNode lastNode = null;
        while (l1 != null || l2 != null) {


            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            int v3 = (v1 + v2 + v4);
            v4 = v3 / 10;
            v3 = v3 % 10;


            ListNode curNode = new ListNode(v3);
            if (res == null) {
                res = curNode;
            }
            if (lastNode != null) {
                lastNode.next = curNode;
            }

            lastNode = curNode;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;

        }
        if (v4 > 0) {
            lastNode.next = new ListNode(v4);

        }
        return res;
    }
}
