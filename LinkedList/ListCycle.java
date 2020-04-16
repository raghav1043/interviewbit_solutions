public class Solution {
    public ListNode detectCycle(ListNode a) {
        Set<ListNode> set = new HashSet<ListNode>();
        ListNode curr = a;
        while(curr!=null){
            if(set.contains(curr)){
                return curr;
            }else{
                set.add(curr);
                curr = curr.next;
            }
        }
        return null;
    }
}
