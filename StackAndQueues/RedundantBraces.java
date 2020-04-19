public class Solution {
    public int braces(String A) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<A.length();i++){
            if(A.charAt(i)=='('){
                stack.push(A.charAt(i));
            }else if(A.charAt(i)=='+' || A.charAt(i)=='-' || A.charAt(i)=='*' || A.charAt(i)=='/'){
                stack.push(A.charAt(i));
            }
            else if(A.charAt(i)==')'){
                if(stack.peek()=='('){
                    return 1;
                }else{
                    while(!stack.empty() && stack.peek()!='('){
                        stack.pop();
                    }
                    if(!stack.empty()){
                        stack.pop();
                    }
                }
            }
        }
        return 0;
    }
}
