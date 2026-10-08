class Pair{
    int first;
    int second;
    public Pair(int f , int s){
        this.first=f;
        this.second=s;
    }
}
class Solution {
    public void solve(char[][] boards) {
        int m = boards.length;
        int n = boards[0].length;
        Queue<Pair>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(boards[0][i]=='O'){
                q.add(new Pair(0,i));
            }
        }
        for(int i =1;i<m;i++){
            if(boards[i][n-1]=='O'){
                q.add(new Pair(i,n-1));
            }
        }
        for(int i=n-2;i>=0;i--){
            if(boards[m-1][i]=='O'){
                q.add(new Pair(m-1,i));
            }
        }
        for(int i=m-2;i>0;i--){
            if(boards[i][0]=='O'){
                q.add(new Pair(i,0));
            }
        }

        while(!q.isEmpty()){
            Pair front = q.remove();
            int r= front.first;
            int c= front.second;
            boards[r][c]='y';

            if(r-1>=0 && boards[r-1][c]=='O'){
                q.add(new Pair(r-1,c));
                boards[r-1][c]='y';
            }
            if(r+1<m && boards[r+1][c]=='O'){
                q.add(new Pair(r+1,c));
                boards[r+1][c]='y';
            }
            if(c-1>=0 && boards[r][c-1]=='O'){
                q.add(new Pair(r,c-1));
                boards[r][c-1]='y';
            }
            if(c+1<n && boards[r][c+1]=='O'){
                q.add(new Pair(r,c+1));
                boards[r][c+1]='y';
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(boards[i][j]=='y'){
                    boards[i][j]='O';
                }
                else if(boards[i][j]=='O'){
                    boards[i][j]='X';
                }
            }
        }
    }
}