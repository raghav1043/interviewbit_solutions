public class Solution {
    public ListNode swapPairs(ListNode A) {
        ListNode curr = A;
        while(curr!=null && curr.next!=null){
            if(curr.next!=null){
                int temp = curr.next.val;
                curr.next.val = curr.val;
                curr.val = temp;
                curr = curr.next.next;
            }
        }
        return A;
    }
}