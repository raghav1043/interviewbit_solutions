/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    
    public ListNode removeNthFromEnd(ListNode A, int B) {
        // ListNode node = reverse(A);
        // ListNode prev = null;
        // ListNode curr = node;
        // int count = 1;
        // while(count<B){
        //     System.out.println(curr.val);
        //     prev = curr;
        //     curr = curr.next;
        //     count++;
        // }
        // if(prev == null){
        //     node = reverse(curr.next);
        // }else{
        //     prev.next = curr.next;
        //     node = reverse(node);
        // }
        
        // return node;
        
        if(B==0){return A;}
        int len = 0;
        ListNode curr = A;
        while(curr!=null){
            curr = curr.next;
            len++;
        }
        int count = 0;
        curr = A;
        ListNode prev = null;
        while(count<(len-B)){
            prev = curr;
            curr = curr.next;
            count++;
        }
        if(prev!=null){
            prev.next = curr.next;
            return A;
        }else{
            return curr.next;
        }
    }
}
