class Solution {
    public void bfs(int start , boolean[] vis , List<List<Integer>>adj){
        Queue<Integer>q= new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            int front = q.remove();
            for(int i : adj.get(front)){
                if(vis[i]==false){
                    vis[i]=true;
                    q.add(i);
                }
            }
        }
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] vis = new boolean[n];
        List<List<Integer>>adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i =0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        for(int i=0;i<n;i++){
            if(vis[i]==false){
                bfs(i , vis , adj);
                if(vis[source]==true && vis[destination]==false){
                    return false;
                }
                else if(vis[source]==false && vis[destination]==true){
                    return false;
                }
            }
        }
        return true;
    }
}