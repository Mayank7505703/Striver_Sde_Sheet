class Pair{
    int first;
    int second;
    public Pair(int f , int s){
        this.first=f;
        this.second=s;
    }
}
class Solution {
    public void bfs(Pair p , boolean[][] vis , char[][] grid , int m , int n){
        Queue<Pair>q=new LinkedList<>();
        q.add(p);
        vis[p.first][p.second]=true;
        while(!q.isEmpty()){
            Pair p1 = q.remove();
            int r=p1.first;
            int c=p1.second;
            if(r-1>=0 && vis[r-1][c]==false && grid[r-1][c]=='1'){
                vis[r-1][c]=true;
                q.add(new Pair(r-1 ,c));
            }
            if(r+1<m && vis[r+1][c]==false && grid[r+1][c]=='1'){
                vis[r+1][c]=true;
                q.add(new Pair(r+1 ,c));
            }
            if(c-1>=0 && vis[r][c-1]==false && grid[r][c-1]=='1'){
                vis[r][c-1]=true;
                q.add(new Pair(r ,c-1));
            }
            if(c+1<n && vis[r][c+1]==false && grid[r][c+1]=='1'){
                vis[r][c+1]=true;
                q.add(new Pair(r ,c+1));
            }
        }
    }
    public int numIslands(char[][] grid) {
        int m =grid.length;
        int n = grid[0].length;
        boolean[][] vis= new boolean[m][n];
        int count =0;
        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                if(vis[i][j]==false && grid[i][j]=='1'){
                    Pair p = new Pair(i,j);
                    count++;
                    bfs(p , vis , grid , m ,n);
                }
            }
        }
        return count;
    }
}