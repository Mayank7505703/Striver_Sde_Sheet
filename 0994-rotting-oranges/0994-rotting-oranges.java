class Pair{
  int first;
  int second;
  public Pair(int f, int s){
    this.first=f;
    this.second =s;
  }
}
class Solution {
    public int orangesRotting(int[][] grid) {
      Queue<Pair>q= new LinkedList<>();
      int m = grid.length;
      int n = grid[0].length;
      int fresh =0;
      for(int i =0;i<m;i++){
        for(int j=0;j<n;j++){
          if(grid[i][j]==2){
            q.add(new Pair(i,j));
          }
          if(grid[i][j]==1){
            fresh++;
          }
        }
      }
      if(fresh==0){
        return 0;
      }
      int count =0;
      while(!q.isEmpty()){
        int size= q.size();
        while(size-->0){
        Pair front = q.remove();
        int r= front.first;
        int c= front.second;
        if(r-1>=0 && grid[r-1][c]==1){
          grid[r-1][c]=2;
          q.add(new Pair(r-1,c));
        }
        if(r+1<m && grid[r+1][c]==1){
          grid[r+1][c]=2;
          q.add(new Pair(r+1,c));
        }
        if(c-1>=0 && grid[r][c-1]==1){
          grid[r][c-1]=2;
          q.add(new Pair(r,c-1));
        }
        if(c+1<n && grid[r][c+1]==1){
          grid[r][c+1]=2;
          q.add(new Pair(r,c+1 ));
        }
        }
        count++;
      }
      for(int i =0;i<m;i++){
        for(int j=0;j<n;j++){
          if(grid[i][j]==1){
            return -1;
          }
        }
      }
      return count-1;
    }
}


