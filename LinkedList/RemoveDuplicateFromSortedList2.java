public class Solution {
    public ListNode deleteDuplicates(ListNode A) {
        ListNode resultHead = null;
        ListNode resultNode = null;
        
        ListNode prev = null;
        ListNode curr = A;
        while(curr!=null){
            if(curr.next==null && prev ==null){
                return curr;
            }
            else if(curr.next==null && prev!=null){
                if(prev.val!=curr.val){
                    if(resultHead == null){
                        resultHead = curr;
                        resultNode = curr;
                    }else{
                        resultNode.next = curr;
                        resultNode = resultNode.next;
                    }
                }
            }else if(curr.next!=null && prev ==null){
                if(curr.val != curr.next.val){
                    if(resultHead == null){
                        resultHead = curr;
                        resultNode = curr;
                    }else{
                        resultNode.next = curr;
                        resultNode = resultNode.next;
                    }
                }
            }else{
                if(curr.val!=curr.next.val && curr.val!=prev.val){
                    if(resultHead == null){
                        resultHead = curr;
                        resultNode = curr;
                    }else{
                        resultNode.next = curr;
                        resultNode = resultNode.next;
                    }
                }    
            }
            prev = curr;
            curr = curr.next;
        }
        if(resultNode!=null){
             resultNode.next = null;   
        }
        return resultHead;
    }
}