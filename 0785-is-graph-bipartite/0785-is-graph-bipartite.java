class Solution {
    public boolean bfs(int start , boolean[] vis , int[][] graph, int[] color){
        Queue<Integer>q=new LinkedList<>();
        q.add(start);
        vis[start]=true;
        color[start]=0;
        while(!q.isEmpty()){
            int front=q.remove();
            for(int i : graph[front]){
                if(vis[i]==false){
                    vis[i]=true;
                    color[i]=(color[front]+1)%2;
                    q.add(i);
                }
                else{
                    if(color[front]==color[i]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        boolean[] vis = new boolean[n];
        int color[] =new int[n];
        for(int i =0;i<n;i++){
            color[i]=-1;
        }
        for(int i=0;i<n;i++){
            if(vis[i]==false){
                if(!bfs(i , vis , graph , color)) return false;
            }
        }
         return true;

    }
}