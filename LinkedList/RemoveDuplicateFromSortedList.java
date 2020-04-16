public class Solution {
    public ListNode deleteDuplicates(ListNode A) {
        ListNode node = A;
        while(node.next!=null){
            if(node.next.val == node.val){
                node.next = node.next.next;
            }else{
                node = node.next;
            }
        }
        return A;
    }
}