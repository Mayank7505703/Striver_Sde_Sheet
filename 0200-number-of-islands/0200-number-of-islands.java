class Pair{
    int first;
    int second;
    public Pair(int first , int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public void bfs(Pair start , char[][]grid, int m, int n ){
        Queue<Pair>q=new LinkedList<>();
        q.add(start);
        grid[start.first][start.second]='0';
        while(!q.isEmpty()){
            Pair front=q.remove();
            int r=front.first;
            int c=front.second;
            if(r-1>=0 && grid[r-1][c]=='1'){
                grid[r-1][c]='0';
                q.add(new Pair(r-1,c));
            }
            if(r+1<m && grid[r+1][c]=='1'){
                grid[r+1][c]='0';
                q.add(new Pair(r+1,c));
            }
            if(c-1>=0 && grid[r][c-1]=='1'){
                grid[r][c-1]='0';
                q.add(new Pair(r,c-1));
            }
            if(c+1<n && grid[r][c+1]=='1'){
                grid[r][c+1]='0';
                q.add(new Pair(r,c+1));
            }
        }
    }
    public int numIslands(char[][] grid) {
       int m = grid.length;
       int n= grid[0].length;
       int count=0;
       for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(grid[i][j]=='1'){
                count++;
                Pair p = new Pair(i,j);
                bfs(p , grid ,m ,n);
            }
        }
       }
       return count;
    }
}