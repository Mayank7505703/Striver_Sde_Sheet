class Solution {
    public boolean dfs(int start , boolean vis[], boolean path[], int check[], int[][]graph){
        vis[start]=true;
        path[start]=true;
        check[start]=0;
        for(int i : graph[start]){
            if(vis[i]==false){
                if(dfs(i , vis ,path , check , graph)){
                    return true;
                }
            }
            else{
                if(path[i]==true){
                    return true;
                }
            }
        }
        path[start]=false;
        check[start]=1;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean vis[]=new boolean[n];
        boolean path[]=new boolean[n];
        int check[]=new int[n];
        for(int i =0;i<n;i++){
            if(vis[i]==false){
                dfs(i , vis ,path , check , graph);
            }
        }
        List<Integer>list =new ArrayList<>();
        for(int i =0;i<graph.length;i++){
            if(check[i]==1){
                list.add(i);
            }
        }
        return list;
    }
}