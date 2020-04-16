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
    
    public ListNode reorderList(ListNode A) {
        ListNode slow = A;
        ListNode fast  = A;
        while(slow.next!=null && fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode node1 = A;
        ListNode node2 = slow.next;
        slow.next = null;
        node2 = reverse(node2);
        
        while(node1!=null && node2!=null){
            ListNode temp1 = node1.next;
            ListNode temp2 = node2.next;
            node1.next = node2;
            node2.next = temp1;
            node1 = temp1;
            node2 = temp2;
        }
        return A;
    }
}