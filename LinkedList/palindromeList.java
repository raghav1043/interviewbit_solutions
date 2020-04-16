public class Solution {
    
    public ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    
    public int lPalin(ListNode A) {
        if(A==null || A.next==null){
            return 1;
        }
        ListNode slow = A;
        ListNode fast = A;
        while(slow.next!=null && fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode node1 = A;
        ListNode node2 = reverse(slow.next);
        slow.next = null;
        
        while(node1!=null && node2!=null){
            if(node1.val!=node2.val){
                return 0;
            }
            node1 = node1.next;
            node2 = node2.next;
        }
        return 1;
    }
}