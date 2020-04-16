public class Solution {
    
    public ListNode addTwoNumbers(ListNode A, ListNode B) {
        if(A==null){
            return B;
        }
        if(B==null){
            return A;
        }
        
        ListNode node1 = A;
        ListNode node2 = B;
        ListNode head = node1;
        ListNode prev = null;
        int carry = 0;
        while(node1!=null && node2!=null){
            int sum = node1.val+node2.val+carry;
            node1.val = sum%10;
            carry = sum/10;
            prev = node1;
            node1 = node1.next;
            node2 = node2.next;
        }
        
        if(node1==null && node2==null){
            if(carry==1){
                prev.next = new ListNode(1);
            }
        }
        
        if(node1==null && node2!=null){
            prev.next = node2;
            while(node2!=null){
                int sum = node2.val+carry;
                carry = sum/10;
                node2.val = sum%10;
                prev = node2;
                node2=  node2.next;
                if(carry==0){
                    break;
                }
            }
            if(carry==1){
                prev.next = new ListNode(1);
            }
        }
        
        
        if(node1!=null && node2==null){
             while(node1!=null){
                int sum = node1.val+carry;
                carry = sum/10;
                node1.val = sum%10;
                prev = node1;
                node1=  node1.next;
                if(carry==0){
                    break;
                }
            }
            if(carry==1){
                prev.next = new ListNode(1);
            }
        }
        
        return head;
        
    }
}


// partially correct due to time limit exceeded due to big integer
import java.math.BigInteger; 
public class Solution {
    
    public BigInteger calculateVal(ListNode node){
        String val = "";
        ListNode curr = node;
        while(curr!=null){
            val = ""+curr.val+val;
            curr = curr.next;
        }
        return new BigInteger(val);
    }
    
    public ListNode addTwoNumbers(ListNode A, ListNode B) {
        BigInteger val1 = calculateVal(A);
        BigInteger val2 = calculateVal(B);
        BigInteger result = val1.add(val2);
        BigInteger decimal = new BigInteger("10");
        BigInteger zero = new BigInteger("0");
        ListNode head = null;
        ListNode curr = null;
        while(!result.equals(zero)){
            int num = (result.mod(decimal)).intValue();
            result = result.divide(decimal);
            if(head==null){
                head =new ListNode(num);
                curr =head;
            }else{
                curr.next = new ListNode(num);
                curr = curr.next;
            }
        }
        return head;
    }
}


// approach not passed where val passed long limit
public class Solution {
    
    public Long calculateVal(ListNode node){
        String val = "";
        ListNode curr = node;
        while(curr!=null){
            val = ""+curr.val+val;
            curr = curr.next;
        }
        return Long.parseLong(val);
    }
    
    public ListNode addTwoNumbers(ListNode A, ListNode B) {
        Long val1 = calculateVal(A);
        Long val2 = calculateVal(B);
        Long result = val1+val2;
        ListNode head = null;
        ListNode curr = null;
        while(result!=0){
            int num = (int)(result%10);
            result = result/10;
            if(head==null){
                head =new ListNode(num);
                curr =head;
            }else{
                curr.next = new ListNode(num);
                curr = curr.next;
            }
        }
        return head;
    }
}