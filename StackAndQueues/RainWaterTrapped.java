public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int trap(final List<Integer> A) {
        int n = A.size();
        if(n==0){
            return 0;
        }
        int rightWall[] =  new int[n];
        int leftWall[] = new int[n];
        
        leftWall[0] = A.get(0);
        rightWall[n-1] = A.get(n-1);
        
        for(int i=n-2;i>=0;i--){
            rightWall[i] = Math.max(A.get(i),rightWall[i+1]);
        }
        
        for(int i=1;i<n;i++){
            leftWall[i] = Math.max(A.get(i),leftWall[i-1]);
        }
        
    
        int water = 0;
        for(int i=0;i<n;i++){
            //System.out.print(leftWall[i]+" "+rightWall[i]+" ");
            water = water + Math.max(0,Math.min(leftWall[i],rightWall[i])-A.get(i));
        }
        return water;
    }
}