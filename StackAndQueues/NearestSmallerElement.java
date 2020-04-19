public class Solution {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        int n=A.size();
        int array[]=new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=n-1;i>=0;i--){
            if(stack.empty() || A.get(stack.peek())<=A.get(i)){
                stack.push(i);
            }else{
                while(!stack.empty() && A.get(stack.peek())>A.get(i)){
                    array[stack.pop()] = A.get(i);
                }
                stack.push(i);
            }
            
        }
        
        while(!stack.empty()){
            array[stack.pop()] = -1;
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0;i<n;i++){
            result.add(array[i]);
        }
        
        return result;
        
    }
}
