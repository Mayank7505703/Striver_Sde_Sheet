class Pair{
    int first;
    int second;
    public Pair(int f , int s){
        this.first=f;
        this.second=s;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int fresh =0;
        Queue<Pair>q =new LinkedList<>();
        for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j));
                }
                else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if(fresh==0) return 0;
        int count =0;
        while(!q.isEmpty()){
            int size=q.size();
            while(size>0){
                Pair p = q.remove();
                int r=p.first;
                int c=p.second;

                if(r-1>=0 && vis[r-1][c]==false && grid[r-1][c]==1){
                    q.add(new Pair(r-1 , c));
                    vis[r-1][c]=true;
                    fresh--;
                }

                if(r+1<m && vis[r+1][c]==false && grid[r+1][c]==1){
                    q.add(new Pair(r+1 , c));
                    vis[r+1][c]=true;
                    fresh--;
                }

                if(c-1>=0 && vis[r][c-1]==false && grid[r][c-1]==1){
                    q.add(new Pair(r , c-1));
                    vis[r][c-1]=true;
                    fresh--;
                }

                if(c+1<n && vis[r][c+1]==false && grid[r][c+1]==1){
                    q.add(new Pair(r , c+1));
                    vis[r][c+1]=true;
                    fresh--;
                }

                size--;
            }
            count++;
        }
        if(fresh>0){
            return -1;
        }
        return count-1;
    }
}