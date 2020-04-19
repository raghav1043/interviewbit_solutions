public class Solution {
    public int evalRPN(ArrayList<String> A) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<A.size();i++){
            String str = A.get(i);
            if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")){
                int num2 = stack.pop();
                int num1 = stack.pop();
                int result = 0;
                if(str.equals("+")){
                    result = num1+num2;
                }else if(str.equals("-")){
                    result = num1-num2;
                }if(str.equals("*")){
                    result = num1*num2;
                }if(str.equals("/")){
                    result = num1/num2;
                }
                stack.push(result);
            }else{
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }
}