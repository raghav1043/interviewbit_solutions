public class Solution {
    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode node1 = A;
        ListNode node2 = B;
        ListNode resultHead = null;
        ListNode resultIter = null;
        while(node1!=null && node2!=null){
            if(node1.val <= node2.val){
                if(resultHead == null){
                    resultHead = node1;
                    resultIter = node1;
                }else{
                    resultIter.next = node1;
                    resultIter = resultIter.next;
                }
                node1 = node1.next;
            }else{
                if(resultHead == null){
                    resultHead = node2;
                    resultIter = node2;
                }else{
                    resultIter.next = node2;
                    resultIter = resultIter.next;
                }
                node2 = node2.next;
            }
        }
        
        if(node1!=null && node2==null){
            resultIter.next = node1;
        }else if(node1==null && node2!=null){
            resultIter.next = node2;
        }
        
        return resultHead;
    }
}