class Solution {
    public boolean dfs(int start , boolean[] vis , boolean[] path , List<List<Integer>>adj){
        vis[start]=true;
        path[start]=true;

        for(int i: adj.get(start)){
            if(vis[i]==false){
                if(dfs(i , vis , path , adj)) return true;
            }
            else{
                if(path[i]==true){
                    return true;
                }
            }

        }
        path[start]=false;
        return false;
    }
    public boolean canFinish(int V, int[][] edges) {
        List<List<Integer>>adj =new ArrayList<>();
        for(int i =0;i<V;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(v).add(u);
        }
        boolean[] vis =new boolean[V];
        boolean[] path =new boolean[V];

        for(int i=0;i<V;i++){
            if(vis[i]==false){
                if(dfs(i , vis, path , adj)) return false;
            }
        }
        return true;
    }
}