public class Solution {
    
    public int calculateLength(ListNode A){
        ListNode curr = A;
        int len = 0;
        while(curr!=null){
            curr = curr.next;
            len++;
        }
        return len;
    }
    
    public ListNode rotateRight(ListNode A, int B) {
        if(B==0){return A;}
        int count = 0;
        int len = calculateLength(A);
        ListNode curr = A;
        ListNode prev = null;
        ListNode nhead = null;
        while(count<len-(B%len)){
            prev = curr;
            curr = curr.next;
            count++;
        }
        nhead = curr;
        if(prev!=null){
            prev.next = null;    
        }
        if(curr == null){
            return A;
        }
        while(curr.next!=null){
            curr = curr.next;
        }
        curr.next = A;
        return nhead;
    }
}