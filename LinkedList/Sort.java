public class Solution {
    
    public ListNode getMiddle(ListNode node){
        if(node==null){
            return node;
        }
        ListNode slow = node;
        ListNode fast = node;
        while(slow.next!=null && fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    public ListNode sort(ListNode head){
        if(head==null|| head.next==null){
            return head;
        }
        ListNode mid = getMiddle(head);
        ListNode midNext = mid.next;
        mid.next = null;
        ListNode leftHead = sort(head);
        ListNode rightHead = sort(midNext);    
        ListNode result = mergeSortedList(leftHead,rightHead);
        return result;
    }
    
    public ListNode mergeSortedList(ListNode left,ListNode right){
        ListNode result = null;
        if(left==null){
            return right;
        }
        if(right==null){
            return left;
        }
        if(left.val<=right.val){
            result = left;
            result.next = mergeSortedList(left.next,right);
        }else{
            result = right;
            result.next = mergeSortedList(left,right.next);
        }
        return result;
    }
    
    public ListNode insertionSortList(ListNode A) {
        return sort(A);
    }
}