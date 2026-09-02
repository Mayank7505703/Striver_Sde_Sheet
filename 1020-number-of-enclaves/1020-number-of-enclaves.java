class Pair{
    int first;
    int second;
    public Pair(int f , int s){
        this.first=f;
        this.second=s;
    }
}
class Solution {
    public int numEnclaves(int[][] grid) {
         int m= grid.length;
        int n=grid[0].length;
        Queue<Pair>q=new LinkedList<>();
        for(int i =0;i<n;i++){
            if(grid[0][i]==1){
                q.add(new Pair(0,i));
            }
        }
        for(int i =1;i<m;i++){
            if(grid[i][n-1]==1){
                q.add(new Pair(i,n-1));
            }
        }
        for(int i =n-2;i>=0;i--){
            if(grid[m-1][i]==1){
                q.add(new Pair(m-1,i));
            }
        }
        for(int i =m-2;i>0;i--){
            if(grid[i][0]==1){
                q.add(new Pair(i,0));
            }
        }

        while(!q.isEmpty()){
            Pair p =q.remove();
            int r=p.first;
            int c=p.second;
            grid[r][c]=0;
            if(r-1>=0 && grid[r-1][c]==1){
                grid[r-1][c]=0;
                q.add(new Pair(r-1,c));
            }
            if(r+1<m && grid[r+1][c]==1){
                grid[r+1][c]=0;
                q.add(new Pair(r+1,c));
            }
            if(c-1>=0 && grid[r][c-1]==1){
                grid[r][c-1]=0;
                q.add(new Pair(r,c-1));
            }
            if(c+1<n && grid[r][c+1]==1){
                grid[r][c+1]=0;
                q.add(new Pair(r,c+1));
            }
        }
        int count =0;
        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                if(grid[i][j]==1){
                    count++;
                }
            }
        }
        return count;
    }
}