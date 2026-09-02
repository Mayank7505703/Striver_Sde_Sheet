class Pair{
    int first;
    int second;
    public Pair(int f , int s){
        this.first=f;
        this.second=s;
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m =image.length;
        int n = image[0].length;
        int original = image[sr][sc];
        if (original == color) {
            return image;
        }
        Queue<Pair>q=new LinkedList<>();
        image[sr][sc]=color;
        q.add(new Pair(sr,sc));
        while(!q.isEmpty()){
            Pair front = q.remove();
            int r= front.first;
            int c= front.second;
            if(r-1>=0 && image[r-1][c]==original){
                image[r-1][c]=color;
                q.add(new Pair(r-1 , c));
            }
            if(r+1<m && image[r+1][c]==original){
                image[r+1][c]=color;
                q.add(new Pair(r+1 , c));
            }
            if(c-1>=0 && image[r][c-1]==original){
                image[r][c-1]=color;
                q.add(new Pair(r , c-1));
            }
            if(c+1<n && image[r][c+1]==original){
                image[r][c+1]=color;
                q.add(new Pair(r , c+1));
            }
        }
        return image;
    }
}