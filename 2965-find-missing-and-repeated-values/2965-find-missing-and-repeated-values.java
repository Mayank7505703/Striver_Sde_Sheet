class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int m = grid.length;
        int n= grid[0].length;
        int k =0;
        int c[]=new int[n*n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                c[k++]=grid[i][j];
            }
        }
       int[] ans={-1,-1};
       Arrays.sort(c);
       for(int i =0;i<c.length-1;i++){
            if(c[i]==c[i+1]){
                ans[0] =c[i];
                break;
            }
       }
       int count =1;
       HashSet<Integer>set=new HashSet<>();
       for(int i =0;i<c.length;i++){
            set.add(c[i]);
       }
       for(int i : set){
            if(count==i){
                count++;
            }
            else{
                break;
            }
       }
       ans[1]=count;
       return ans;
    }
    
}