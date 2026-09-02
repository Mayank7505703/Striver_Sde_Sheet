class Pair{
    int first;
    int second;
    public Pair(int f , int s){
        this.first=f;
        this.second=s;
    }
}
class Solution {
    public void solve(char[][] board) {
        int m= board.length;
        int n=board[0].length;
        Queue<Pair>q=new LinkedList<>();
        for(int i =0;i<n;i++){
            if(board[0][i]=='O'){
                q.add(new Pair(0,i));
            }
        }
        for(int i =1;i<m;i++){
            if(board[i][n-1]=='O'){
                q.add(new Pair(i,n-1));
            }
        }
        for(int i =n-2;i>=0;i--){
            if(board[m-1][i]=='O'){
                q.add(new Pair(m-1,i));
            }
        }
        for(int i =m-2;i>0;i--){
            if(board[i][0]=='O'){
                q.add(new Pair(i,0));
            }
        }
        while(!q.isEmpty()){
            Pair front = q.remove();
            int r = front.first;
            int c=front.second;
            board[r][c]='y';
            if(r-1>=0 && board[r-1][c]=='O'){
                board[r-1][c]='y';
                q.add(new Pair(r-1,c));
            }
            if(r+1<m && board[r+1][c]=='O'){
                board[r+1][c]='y';
                q.add(new Pair(r+1,c));
            }
            if(c-1>=0 && board[r][c-1]=='O'){
                board[r][c-1]='y';
                q.add(new Pair(r,c-1));
            }
            if(c+1<n && board[r][c+1]=='O'){
                board[r][c+1]='y';
                q.add(new Pair(r,c+1));
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                else if(board[i][j]=='y'){
                    board[i][j]='O';
                }
            }
        }
    }
}