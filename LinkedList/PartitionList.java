public class Solution {
    public ListNode partition(ListNode A, int B) {
        if(A==null || A.next==null){
            return A;
        }
        ListNode curr = A;
        ListNode prev = null;
        ListNode prevCurr = null;
        ListNode shead = null;
        ListNode ghead = null;
        while(curr!=null){
            if(curr.val<B){
                if(shead == null){
                    shead = curr;
                    prev = curr;
                }else{
                    prev.next = curr;
                    prev = prev.next;
                }
                if(prevCurr!=null){
                    prevCurr.next = curr.next;
                }
            }else{
                if(ghead == null){
                    ghead = curr;
                }
                 prevCurr = curr;
            }
            curr =curr.next;
        }
        if(shead==null){
            return ghead;
        }else{
            prev.next = ghead;
            return shead;
        }
    }
}