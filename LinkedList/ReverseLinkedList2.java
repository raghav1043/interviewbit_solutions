public class Solution {
    
    public void reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }
    
    public ListNode reverseBetween(ListNode A, int B, int C) {
        if(B==C){return A;}
        ListNode head = null;
        ListNode curr = A;
        ListNode prev = null;
        int count = 1;
        while(count<B){
            prev = curr;
            curr = curr.next;
            count++;
        }
        ListNode midStart = curr;
        ListNode midEnd = curr;
        while(count<=C){
            midEnd = curr;
            curr = curr.next;
            count++;
        }
        midEnd.next = null;
        reverse(midStart);
        if(prev!=null){
            head = A;
            prev.next = midEnd;
            midStart.next = curr;
        }else{
            head = midEnd;
            midStart.next = curr;
        }
        return head;
    }
}